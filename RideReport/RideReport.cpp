#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
using namespace std;

class RideReport {
public:
    explicit RideReport(const char *fileName);
    ~RideReport();

    bool readData();
    bool processData();
    int getSpeedUpCount() const;
    int getSlowDownCount() const;
    int getLeftTurnCount() const;
    int getRightTurnCount() const;
    bool saveCleanedData(const char *fileName);
    bool saveAsText(const char *fileName);
    bool saveAsXML(const char *fileName);

private:
    string fileName;
    string data;
    int speedUpCount;
    int slowDownCount;
    int leftTurnCount;
    int rightTurnCount;
};

RideReport::RideReport(const char *fileName) : fileName(fileName), speedUpCount(0), slowDownCount(0), leftTurnCount(0), rightTurnCount(0) {
    if (fileName == nullptr || std::string(fileName).empty()) {
        throw std::invalid_argument("Wprowadzono zla nazwe pliku");
    }
    std::ifstream file(fileName);
    if (!file.is_open()) {
        throw std::runtime_error("Nie mozna otworzyc pliku: " + std::string(fileName));
    }
}

RideReport::~RideReport() = default;

bool RideReport::readData() {
    ifstream file(fileName);
    if (!file.is_open()) {
        cerr << "Nie mozna otworzyc pliku " << fileName << endl;
        return false;
    }

    getline(file, data, '\0');
    file.close();
    return true;
}

bool RideReport::processData() {
    for (char event : data) {
        switch (event) {
            case 'a':
                speedUpCount++;
                break;
            case 'b':
                slowDownCount++;
                break;
            case 'l':
                leftTurnCount++;
                break;
            case 'r':
                rightTurnCount++;
                break;
            default:
                cerr << "Wybrano niepoprawna opcje" << event << "z pliku" << endl;
        }
    }
    return true;
}

int RideReport::getSpeedUpCount() const {
    return speedUpCount;
}

int RideReport::getSlowDownCount() const {
    return slowDownCount;
}

int RideReport::getLeftTurnCount() const {
    return leftTurnCount;
}

int RideReport::getRightTurnCount() const {
    return rightTurnCount;
}

bool RideReport::saveCleanedData(const char *fileName) {
    ofstream file(fileName);
    if (!file.is_open()) {
        cerr << "Error: Nie mozna otworzyc pliku " << fileName << endl;
        return false;
    }
    for (char event : data) {
        if (event == 'a' || event == 'b' || event == 'l' || event == 'r') {
            file << event;
        }
    }
    file.close();
    return true;
}

bool RideReport::saveAsText(const char *fileName) {
    ofstream file(fileName);
    if (!file.is_open()) {
        cerr << "Error: Nie mozna otworzyc pliku " << fileName << endl;
        return false;
    }
    time_t now = time(nullptr);
    tm *ltm = localtime(&now);

    file << "Raport dla pliku: " << this->fileName << "\n";
    file << "Data utworzenia: " << 1900 + ltm->tm_year << "-" << 1 + ltm->tm_mon << "-" << ltm->tm_mday << "\n";
    file << "Czas utworzenia: " << ltm->tm_hour << ":" << ltm->tm_min << ":" << ltm->tm_sec << "\n";
    file << "Przyspieszenia: " << getSpeedUpCount() << "\n";
    file << "Zwolnienia: " << getSlowDownCount() << "\n";
    file << "Lewo: " << getLeftTurnCount() << "\n";
    file << "Prawo: " << getRightTurnCount() << "\n";
    file.close();
    return true;
}

bool RideReport::saveAsXML(const char *fileName) {
    ofstream file(fileName);
    if (!file.is_open()) {
        cerr << "Error: Nie mozna otworzyc pliku " << fileName << endl;
        return false;
    }
    time_t now = time(0);
    tm *ltm = localtime(&now);

    file << "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    file << "<report file=\"" << this->fileName << "\" date=\"" << 1900 + ltm->tm_year << "-" << 1 + ltm->tm_mon << "-" << ltm->tm_mday << "\">\n";
    file << "    <report-file>" << this->fileName << "</report-file>\n";
    file << "    <creation-date>" << 1900 + ltm->tm_year << "-" << 1 + ltm->tm_mon << "-" << ltm->tm_mday << "</creation-date>\n";
    file << "    <creation-time>" << ltm->tm_hour << ":" << ltm->tm_min << ":" << ltm->tm_sec << "</creation-time>\n";
    file << "    <speed-up-count>" << getSpeedUpCount() << "</speed-up-count>\n";
    file << "    <slow-down-count>" << getSlowDownCount() << "</slow-down-count>\n";
    file << "    <left-turn-count>" << getLeftTurnCount() << "</left-turn-count>\n";
    file << "    <right-turn-count>" << getRightTurnCount() << "</right-turn-count>\n";
    file << "</report>\n";
    file.close();
    return true;
}

int main() {
    try {
        RideReport report("dane.txt");

        if (!report.readData()) {
            return EXIT_FAILURE;
        }

        if (!report.processData()) {
            return EXIT_FAILURE;
        }

        cout << "Przyspieszenia: " << report.getSpeedUpCount() << endl;
        cout << "Zwolnienia: " << report.getSlowDownCount() << endl;
        cout << "Skrety w lewo: " << report.getLeftTurnCount() << endl;
        cout << "Skrety w prawo: " << report.getRightTurnCount() << endl;

        if (!report.saveCleanedData("dane_cleaned.txt")) {
            return EXIT_FAILURE;
        }

        if (!report.saveAsText("dane.txt")) {
            return EXIT_FAILURE;
        }

        if (!report.saveAsXML("dane.xml")) {
            return EXIT_FAILURE;
        }

        return EXIT_SUCCESS;
    } catch (const std::exception &e) {
        cerr << "Error: " << e.what() << endl;
        return EXIT_FAILURE;
    }
    try {
        RideReport report("inne.txt");

        if (!report.readData()) {
            return EXIT_FAILURE;
        }

        if (!report.processData()) {
            return EXIT_FAILURE;
        }

        cout << "Przyspieszenia: " << report.getSpeedUpCount() << endl;
        cout << "Zwolnienia: " << report.getSlowDownCount() << endl;
        cout << "Skrety w lewo: " << report.getLeftTurnCount() << endl;
        cout << "Skrety w prawo: " << report.getRightTurnCount() << endl;

        if (!report.saveCleanedData("inne_cleaned.txt")) {
            return EXIT_FAILURE;
        }

        if (!report.saveAsText("inne.txt")) {
            return EXIT_FAILURE;
        }

        if (!report.saveAsXML("inne.xml")) {
            return EXIT_FAILURE;
        }

        return EXIT_SUCCESS;
    } catch (const std::exception &e) {
        cerr << "Error: " << e.what() << endl;
        return EXIT_FAILURE;
    }
}
// Klasa reprezentująca liczby wymierne jako pary liczb całkowitych wraz z podstawowymi działaniami arytmetycznymi i porównaniem. 


import java.util.Scanner;

public class Rational {
    private int licznik;
    private int mianownik;

    public Rational(int licznik, int mianownik) {
        if (mianownik == 0) {
            System.out.println("Mianownik musi być różny od 0!");
            System.exit(0);
        }

        int NWD = NWD(Math.abs(licznik), Math.abs(mianownik));
        this.licznik = licznik / NWD;
        this.mianownik = mianownik / NWD;

        if (mianownik < 0) {
            this.licznik = -this.licznik;
            this.mianownik = -this.mianownik;
        }
    }
    private static int NWD(int a, int b) {
        while (b != 0) {
            int bufor = b;
            b = a % b;
            a = bufor;
        }
        return a;
    }

    public Rational add(Rational arg) {
        int nLicznik = this.licznik * arg.mianownik + arg.licznik * this.mianownik;
        int nMianownik = this.mianownik * arg.mianownik;
        return new Rational(nLicznik, nMianownik);
    }

    public Rational mul(Rational arg) {
        int nLicznik = this.licznik * arg.licznik;
        int nMianownik = this.mianownik * arg.mianownik;
        return new Rational(nLicznik, nMianownik);
    }


    public Rational sub(Rational arg) {
        int nLicznik = this.licznik * arg.mianownik - arg.licznik * this.mianownik;
        int nMianownik = this.mianownik * arg.mianownik;
        return new Rational(nLicznik, nMianownik);
    }

    public Rational div(Rational arg) {
        if (arg.licznik == 0) {
            System.out.println("Nie można dzielić przez 0!");
        }

        int nLicznik = this.licznik * arg.mianownik;
        int nMianownik = this.mianownik * arg.licznik;
        return new Rational(nLicznik, nMianownik);
    }

    public boolean equals(Rational arg) {
        return this.licznik == arg.licznik && this.mianownik == arg.mianownik;
    }
    
// metoda zwracająca 0, gdy this = arg; 1 (np. 1/2 = 2/4), gdy this < arg; -1, gdy this > arg
    
    public int compareTo(Rational arg) {
        int wartość1 = this.licznik * arg.mianownik;
        int wartość2 = arg.licznik * this.mianownik;

        return Integer.compare(wartość1, wartość2);
    }

    public String toString() {
        return licznik + "/" + mianownik;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj licznik oraz mianownik pierwszego ułamka: ");
        Rational Ułamek1 = new Rational(sc.nextInt(), sc.nextInt());
        System.out.println("Podaj licznik oraz mianownik drugiego ułamka: ");
        Rational Ułamek2 = new Rational(sc.nextInt(), sc.nextInt());


        System.out.println("Ułamek nr 1 toString: " + Ułamek1.toString());
        System.out.println("Ułamek nr 2 toString: " + Ułamek2.toString());
        System.out.println("Ułamek nr 1 + Ułamek nr 2 = " + Ułamek1.add(Ułamek2));
        System.out.println("Ułamek nr 1 * Ułamek nr 2 = " + Ułamek1.mul (Ułamek2));
        System.out.println("Ułamek nr 1 - Ułamek nr 2 = " + Ułamek1.sub(Ułamek2));
        System.out.println("Ułamek nr 1 / Ułamek nr 2 = " + Ułamek1.div(Ułamek2));
        System.out.println("Ułamek nr 1 = Ułamek nr 2 : " + Ułamek1.equals(Ułamek2));
        System.out.println("Ułamek nr 1 w porównaniu do Ułamka nr 2: " + Ułamek1.compareTo(Ułamek2));
    }
}

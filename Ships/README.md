Celem programu jest zarządzanie flotą statków.
Klasa Main tworzy obiekt odpowiedniego statku, ustawia wartości i zwraca szczegółowy opis statku i wypisuje go
Klasa Ship - abstrakcyjna klasa bazowa dla klas Ferry i Cruise. Przechowuje wspólne właściwości statku (ID, Name, Capacity), weryfikuje ID.
Klasa Ferry dziedziczy właściwości klasy Ship oraz udostępnia specyficzne metody dla promu. 
Klasa Cruise dziedziczy właściwości klasy Ship oraz udostępnia specyficzne metody dla wycieczkowca
Klasa Fleet przechowuje listę obiektów, umożliwia ich dodawanie, usuwanie, sprawdazanie czy statek o danym ID znajduje się w liście oraz zwraca kopię listy

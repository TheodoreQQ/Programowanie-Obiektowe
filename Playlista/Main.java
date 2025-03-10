import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlista playlista = new Playlista();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Playlisty:");
            System.out.println("1. Dodaj piosenkę");
            System.out.println("2. Usuń piosenkę");
            System.out.println("3. Wyświetl wszystkie piosenki");
            System.out.println("4. Wyświetl wybraną piosenkę");
            System.out.println("5. Wyjdź");
            System.out.print("Wybierz opcję: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                 case 1 -> {
                    System.out.print("Podaj autora: ");
                    String author = sc.nextLine();
                    System.out.print("Podaj tytuł: ");
                    String title = sc.nextLine();
                    System.out.print("Podaj długość (w sekundach): ");
                    int duration = sc.nextInt();
                    sc.nextLine();
                    playlista.addSong(author, title, duration);
                }
                 case 2 -> {
                    System.out.print("Podaj tytuł piosenki, którą chcesz usunąć: ");
                    String title = sc.nextLine();
                    playlista.removeSong(title);
                    System.out.println("Piosenka usunięta pomyślnie (jeżeli istniała).");
                } case 3 -> playlista.displaySongs();
                  case 4 -> {
                    System.out.print("Podaj numer piosenki, którą chcesz wyświetlić (indeksowane od 1)");
                    int index = sc.nextInt();
                    sc.nextLine();
                    Song song = playlista.getSong(index - 1);
                    if (song != null) {
                        System.out.println(song.toString());
                    }
                } case 5 -> System.out.println("Opuszczam menu playlisty. Do zobaczenia!");
                default -> System.out.println("Niepoprawny wybór! Spróbuj ponownie!");
            }
        }while (choice != 5);
        sc.close();
    }
}
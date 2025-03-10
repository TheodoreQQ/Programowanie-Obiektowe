import java.util.ArrayList;

public class Playlista {
    private ArrayList<Song> songs;
    public Playlista() {
        songs = new ArrayList<>();
    }
    public void addSong(String author, String name, int duration){
        try {
            songs.add(new Song(author, name, duration));
            System.out.println("Piosenka dodana pomyślnie.");
        } catch (IllegalArgumentException e){
            System.out.println("Błąd przy dodawaniu piosenki");
        }
    }
    public void removeSong(String name){
        songs.removeIf(song -> song.getName().equalsIgnoreCase(name));
    }
    public void displaySongs(){
        if(songs.isEmpty()){
            System.out.println("playlista jest pusta");
        } else {
            for(int i = 0; i < songs.size(); i++){
                System.out.println((i + 1) + ", " + songs.get(i).toString());
            }
        }
    }
    public Song getSong(int index){
        if (index >= 0 && index < songs.size()){
            return songs.get(index);
        } else {
            System.out.println("Nieprawidłowy indeks piosenki");
            return null;
        }
    }
}


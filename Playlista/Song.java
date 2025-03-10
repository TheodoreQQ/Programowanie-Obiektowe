public class Song {
    final private String author;
    final private String name;
    final private int duration;

    public  Song(String author, String name, int duration){
        if(!author.matches("^[A-Za-z0-9].{2,}$")){
            throw new IllegalArgumentException("Niepoprawna nazwa");
        }
        if(duration > 500){
            throw new IllegalArgumentException("Niepoprawna długość");
        }
        this.author = author;
        this.name = name;
        this.duration = duration;
    }

    public String getAuthor(){
        return author;
    }
    public String getName(){
        return name;
    }
    public int getDuration(){
        return duration;
    }
@Override
    public String toString(){
        return "Autor: " + author + ", Tytuł: " + name + ", Długość: " + duration;
}



}

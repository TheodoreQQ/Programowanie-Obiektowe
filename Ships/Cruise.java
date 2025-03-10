public class Cruise extends Ship {
    private int numberOfPools;
    public Cruise(String ID, int numberOfPools ) {
        super(ID);
        this.numberOfPools = numberOfPools;
    }
    public Cruise(String ID) {
        this(ID, 1);
    }
    public String describe(){
        return getID() +"\n"+ "nazwa:"+getName() + "\n" + "typ : wycieczkowiec \n"+ "liczba pasażerów:"+ getCapacity()+"\nliczba basenów:"+numberOfPools+"";
    }

}

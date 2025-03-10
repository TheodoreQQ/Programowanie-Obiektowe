public class Ferry extends Ship {
    public Ferry(String ID) {
        super(ID);
    }



    public String describe(){
        return getID() +"\n"+ "nazwa:"+getName() + "\n" + "typ : pasażerski \n"+"liczba pasażerów:"+ getCapacity()+"\n";

    }
    public boolean matchesID(String ID){
        return this.getID().equals(ID);
    }
    public boolean canFit(int numberOfPassengers){
        return numberOfPassengers <= getCapacity();
    }

}

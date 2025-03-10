public abstract class Ship {

    private String name;
    private final String ID;
    private int capacity = 600;

    public Ship(String ID) {
        if (!isValidIMO(ID)) {
                throw new IllegalArgumentException("Niepoprawny format identyfikatora IMO");
        }
        this.ID = ID.toUpperCase();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getID() {
        return ID;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public abstract String describe();

    private static boolean isValidIMO(String ID) {
        if (ID == null || !ID.matches("IMO \\d{7}")) {
            return false;
        }
        String numericPart = ID.substring(4);
        int checksum = 0;
        for (int i = 0; i < 6; i++) {
            checksum += Character.getNumericValue(numericPart.charAt(i)) * (7 - i);
        }
        int controlDigit = Character.getNumericValue(numericPart.charAt(6));
        return checksum % 10 == controlDigit;
    }

}

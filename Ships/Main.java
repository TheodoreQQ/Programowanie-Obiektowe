public class Main {
    public static void main(String[] args) {
        int type = 2;
        try {
            Ship ferry;
            if (type == 2) {
                ferry = new Cruise("IMO 9876543");
            } else if (type == 1) {
                ferry = new Ferry("IMO 1234567");
            } else {
                System.out.println("Nierozpoznany typ");
                return;
            }
            System.out.println(ferry.describe());
        } catch (IllegalArgumentException e) {

// sprawdzenie czy ID jest poprawne (czy zawiera prefiks IMO oraz 7 cyfr po spacji)            
            String invalidNumber = e.getMessage().contains("IMO") ? e.getMessage().split(": ")[1] : "";
            System.out.println("Niepoprawny numer IMO: " + invalidNumber);
        }


    }
}

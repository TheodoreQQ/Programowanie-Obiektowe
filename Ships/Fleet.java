import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private final List<Ship> ships;

    public Fleet() {
        this.ships = new ArrayList<>();
    }

    public void addShip(Ship newShip) {
        if (containsShip(newShip.getID())) {
            throw new IllegalArgumentException("Statek juz istnieje");
        }
        ships.add(newShip);
    }

    public void removeShip(String ID) {
        boolean removed = ships.removeIf(ship -> ship.getID().equals(ID));
        if (!removed) {
            throw new IllegalArgumentException("Nie ma takiego statku");
        }
    }

    public boolean containsShip(String ID) {
        return ships.stream().anyMatch(ship -> ship.getID().equals(ID));
    }

    public List<Ship> getAllShips() {
        return new ArrayList<>(ships);
    }

    public List<Ship> getShipsWithMinCapacity(int capacity) {
        List<Ship> suitableShips = new ArrayList<>();
        for (Ship ship : ships) {
            if (ship.getCapacity() >= capacity) {
                suitableShips.add(ship);
            }
        }
        return suitableShips;
    }
}

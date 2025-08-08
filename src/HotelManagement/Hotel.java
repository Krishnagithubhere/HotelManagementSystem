package HotelManagement;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;

    public Hotel(int totalRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room getRoomByNumber(int number) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == number) {
                return room;
            }
        }
        return null;
    }
}

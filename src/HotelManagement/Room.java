package HotelManagement;

public class Room {
    private int roomNumber;
    private boolean isBooked;
    private String customerName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.customerName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void bookRoom(String customerName) {
        this.isBooked = true;
        this.customerName = customerName;
    }

    public void vacateRoom() {
        this.isBooked = false;
        this.customerName = "";
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - " + (isBooked ? "Booked by " + customerName : "Available");
    }
}

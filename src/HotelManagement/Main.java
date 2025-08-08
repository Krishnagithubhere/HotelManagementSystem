package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private Hotel hotel;
    private JTextArea displayArea;
    private JTextField roomField, nameField;

    public Main() {
        hotel = new Hotel(10); // 10 rooms

        setTitle("Hotel Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Room Number:"));
        roomField = new JTextField();
        inputPanel.add(roomField);

        inputPanel.add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        add(inputPanel, BorderLayout.NORTH);

        // Center display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Bottom button panel
        JPanel buttonPanel = new JPanel();

        JButton bookBtn = new JButton("Book Room");
        JButton vacateBtn = new JButton("Vacate Room");
        JButton viewBtn = new JButton("View Rooms");

        buttonPanel.add(bookBtn);
        buttonPanel.add(vacateBtn);
        buttonPanel.add(viewBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        bookBtn.addActionListener(e -> bookRoom());
        vacateBtn.addActionListener(e -> vacateRoom());
        viewBtn.addActionListener(e -> showRooms());

        setVisible(true);
    }

    private void bookRoom() {
        try {
            int roomNum = Integer.parseInt(roomField.getText());
            String name = nameField.getText();
            Room room = hotel.getRoomByNumber(roomNum);

            if (room != null && !room.isBooked()) {
                room.bookRoom(name);
                showMessage("Room " + roomNum + " booked for " + name);
            } else {
                showMessage("Room is already booked or doesn't exist.");
            }
        } catch (NumberFormatException ex) {
            showMessage("Invalid room number.");
        }
    }

    private void vacateRoom() {
        try {
            int roomNum = Integer.parseInt(roomField.getText());
            Room room = hotel.getRoomByNumber(roomNum);

            if (room != null && room.isBooked()) {
                room.vacateRoom();
                showMessage("Room " + roomNum + " vacated.");
            } else {
                showMessage("Room is not booked or doesn't exist.");
            }
        } catch (NumberFormatException ex) {
            showMessage("Invalid room number.");
        }
    }

    private void showRooms() {
        StringBuilder sb = new StringBuilder();
        for (Room room : hotel.getRooms()) {
            sb.append(room.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        showRooms();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

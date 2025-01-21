package HotelManagementSystemGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HotelManagementSystemGUI {
    private static final int TOTAL_ROOMS = 10;
    private static final int SINGLE_ROOMS = 5;
    private static final int DOUBLE_ROOMS = 5;
    private static final double SINGLE_ROOM_PRICE = 50.0;
    private static final double DOUBLE_ROOM_PRICE = 80.0;
    private static final int TOTAL_CARS = 5;
    private static HashMap<Integer, String> bookedRooms = new HashMap<>();
    private static HashMap<String, Boolean> bookedCars = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton reserveRoomButton = new JButton("Reserve Room");
        reserveRoomButton.setBounds(10, 20, 150, 25);
        panel.add(reserveRoomButton);

        JButton viewBookedRoomsButton = new JButton("View Booked Rooms");
        viewBookedRoomsButton.setBounds(10, 60, 150, 25);
        panel.add(viewBookedRoomsButton);

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.setBounds(10, 100, 150, 25);
        panel.add(generateBillButton);

        reserveRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(panel, "Enter your name:");
                int days = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter number of days:"));
                String[] roomTypes = {"Single", "Double"};
                String roomType = (String) JOptionPane.showInputDialog(panel, "Select room type:",
                        "Room Type", JOptionPane.QUESTION_MESSAGE, null, roomTypes, roomTypes[0]);

                int roomId = findAvailableRoom(roomType);
                if (roomId != -1) {
                    bookedRooms.put(roomId, name);
                    JOptionPane.showMessageDialog(panel, "Room reserved successfully!\nRoom ID: " + roomId);
                    boolean useCar = JOptionPane.showConfirmDialog(panel, "Do you want to use a car?", "Car", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    if (useCar) {
                        String car = selectCar();
                        if (car != null) {
                            JOptionPane.showMessageDialog(panel, "Car reserved: " + car);
                        } else {
                            JOptionPane.showMessageDialog(panel, "Car is already reserved.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "No available " + roomType + " room.");
                }
            }
        });

        viewBookedRoomsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookedRoomsInfo = new StringBuilder("Booked Rooms:\n");
                for (int roomId : bookedRooms.keySet()) {
                    bookedRoomsInfo.append("Room ID: ").append(roomId).append(", Guest: ").append(bookedRooms.get(roomId)).append("\n");
                }
                JOptionPane.showMessageDialog(panel, bookedRoomsInfo.toString());
            }
        });

        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int roomId = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter room ID:"));
                String guest = bookedRooms.get(roomId);
                if (guest != null) {
                    int days = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter number of days:"));
                    double price = (roomId <= SINGLE_ROOMS) ? SINGLE_ROOM_PRICE : DOUBLE_ROOM_PRICE;
                    double bill = (price * days);
                    JOptionPane.showMessageDialog(panel, "Guest: " + guest + "\nRoom ID: " + roomId + "\nTotal Bill: $" + bill);
                } else {
                    JOptionPane.showMessageDialog(panel, "Room not found or not booked.");
                }
            }
        });
    }

    private static int findAvailableRoom(String roomType) {
        int startId = (roomType.equals("Single")) ? 1 : SINGLE_ROOMS + 1;
        int endId = (roomType.equals("Single")) ? SINGLE_ROOMS : TOTAL_ROOMS;
        for (int i = startId; i <= endId; i++) {
            if (!bookedRooms.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    private static String selectCar() {
        String[] cars = new String[]{"Crolla", "Civic", "Cultus", "Alto", "Haval"};
        String selectedCar = (String) JOptionPane.showInputDialog(null, "Select a car:", "Car Selection",
                JOptionPane.QUESTION_MESSAGE, null, cars, cars[0]);
        
        if (selectedCar != null && !bookedCars.containsKey(selectedCar)) {
            bookedCars.put(selectedCar, true); // Mark the selected car as reserved
            return selectedCar;
        }
        return null; // Car is already reserved or user canceled
    }
}


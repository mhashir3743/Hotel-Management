# Hotel Management System

## Overview

The **Hotel Management System** is a simple Java-based application designed to handle room bookings, car reservations, and bill generation for a hotel. It uses Object-Oriented Programming (OOP) principles to structure the code and manage data efficiently. The system includes a basic graphical user interface (GUI) built with Java Swing, allowing users to reserve rooms, view booked rooms, and generate bills based on room type and duration of stay.

This project is an excellent opportunity to explore and understand core **OOP concepts** like **Encapsulation**, **Abstraction**, **Inheritance**, and **Polymorphism** through a practical example.

---

## OOP Concepts Covered

### 1. **Encapsulation**

Encapsulation is the mechanism of restricting access to certain details and only exposing essential functionalities to the outside world. In this system:

- The class `HotelManagementSystemGUI` encapsulates all the logic related to room reservation, car booking, and bill generation.
- **Private fields** and **methods** are used to ensure data integrity and restrict unauthorized access. For example, `bookedRooms` and `bookedCars` are private fields that store the state of the system but are only modified through specific methods.

### 2. **Abstraction**

Abstraction simplifies complex systems by modeling only the essential details. In this system:

- The user interacts with simple methods like `reserveRoom()`, `generateBill()`, and `viewBookedRooms()`. The underlying complexity of room reservations, price calculations, and car reservations is hidden from the user.
- Classes and methods are abstracted in a way that provides only the necessary interface for interaction without exposing internal details.

### 3. **Inheritance**

Inheritance allows one class to inherit properties and behaviors (methods) from another class. Although the current system doesn't have multiple classes directly inheriting from each other, we can still consider **class hierarchy** concepts:

- Future extensions could include creating different types of rooms or cars by inheriting from a base class, allowing for code reuse and enhanced flexibility.
  
  Example: 
  - A **LuxuryRoom** class could inherit from a **Room** class to add special features (e.g., additional services or higher pricing).

### 4. **Polymorphism**

Polymorphism allows methods to behave differently based on the object they are acting upon. This is often achieved through method overloading or overriding. While the current system doesn't have method overriding yet, polymorphism can be added in future enhancements, such as:

- Overloading methods like `reserveRoom()` to handle different input types (e.g., reserving rooms for different numbers of days or handling different customer types).

---

## Features

- **Reserve Room**: Select between Single or Double rooms, check availability, and reserve a room.
- **View Booked Rooms**: Displays a list of booked rooms along with the guest’s name.
- **Generate Bill**: Generate a bill based on the room ID and number of days the room is booked.
- **Car Reservation**: Reserve a car for transport along with the room booking.

---

## Data Structures Used

The application uses the following **Data Structures and Algorithms (DSA)** to manage data:

- **HashMap**:
  - `bookedRooms`: A `HashMap<Integer, String>` is used to store room bookings, where the room ID (Integer) is the key, and the guest’s name (String) is the value.
  - `bookedCars`: A `HashMap<String, Boolean>` stores car reservations, where the car's name (String) is the key, and the value (Boolean) indicates whether the car is reserved.

- **Arrays**:
  - **Room types** (Single, Double) are stored in an array to facilitate selection.
  - **Car options** are stored in an array to allow users to select a car for reservation.

---

## Classes and Methods

### Main Class: `HotelManagementSystemGUI`

#### Key OOP Concepts in Methods:
- **Method Encapsulation**: Methods like `reserveRoom()` and `generateBill()` encapsulate the logic for room reservations and bill generation.
- **Polymorphism Potential**: Overloaded methods (e.g., `reserveRoom()` can be enhanced for different inputs or guest types in the future).
  
#### Methods:
- **`main(String[] args)`**: The entry point of the program that initializes the GUI.
- **`createAndShowGUI()`**: Initializes the JFrame, adds the panel, and sets the layout and components. It abstracts the setup of the GUI from the user.
- **`placeComponents(JPanel panel)`**: Defines the layout for buttons and their respective event listeners. It demonstrates how different functionalities (button clicks) can interact with the system.
- **`reserveRoom()`**: This method handles the booking of rooms. The user provides input (name, number of days, room type), and the method processes this input to reserve a room.
- **`viewBookedRooms()`**: This method is responsible for listing all the booked rooms along with guest names.
- **`generateBill()`**: It calculates and generates a bill based on the room ID and number of days booked.
- **`findAvailableRoom(String roomType)`**: This method checks if a room of the selected type (Single or Double) is available and returns its ID.
- **`selectCar()`**: Allows users to select and reserve a car. If the car is already reserved, the system notifies the user.

---

## Requirements

- **Java**: JDK 8 or higher
- **Swing**: Java Swing for GUI (comes with the standard Java library)

---

## Running the Application

To run the **Hotel Management System**, follow these steps:

### Clone the Repository
```bash
git clone https://github.com/mhashir3743/Hotel-Management
cd HotelManagementSystem

```
##  Contact
Feel free to reach out to me for any questions or suggestions:

- Email: Hashirch3743@gmail.com
- GitHub: github.com/mhashir3743

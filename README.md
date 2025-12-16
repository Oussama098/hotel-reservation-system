🏨 Hotel Reservation System

This repository contains the complete Java implementation for a simplified Hotel Reservation System..

The solution is structured to manage Users, Rooms, and Bookings, while strictly adhering to all transactional, data integrity, and reporting requirements.

✨ Implemented Features and Technical Compliance

The solution successfully implements and validates the following core requirements:

Requirement

Status

Implementation Detail

Transactional Booking

✅ Complete

bookRoom checks user balance and room availability (no date overlap). Updates user balance upon success.

Historical Integrity

✅ Complete

The BookingRoom entity uses Snapshotting to record the price and type at the time of booking. Changing a Room's price via setRoom does not affect previous bookings.

Date Precision

✅ Complete

setRoom and setUser both check for existence (by ID). If found, they update attributes (price/balance); otherwise, they create new entities.

Reporting Order

✅ Complete

printAll() and printAllUsers() use reverse iteration (for (int i = size - 1; i >= 0; i--)) to print data from the latest created to the oldest created.

Exception Handling

✅ Complete

Includes try-catch blocks and specific if checks for invalid dates, insufficient funds, room conflicts, and entity not found errors.

📐 Project Structure

The code is organized into standard Java packages:

hotel_reservation_system/
├── Entity/
│   ├── BookingRoom.java  // Stores reservation details
│   ├── Room.java         // Stores room ID, type, and price
│   └── User.java         // Stores user ID and balance
├── Service/
│   └── Service.java      // Central class containing all business logic and state management
├── enums/
│   └── RoomType.java     // Enum for STANDART_SUITE, JUNIOR_SUITE, MASTER_SUITE
└── Hotel_Reservation_SystemMain.java // Main class for executing the test case


🔑 Key Architectural Decisions

1. Handling Immutability: Snapshotting for History

To ensure that the function setRoom(...) does not impact previous bookings, the BookingRoom entity was designed to store snapshot data:

The BookingRoom constructor captures and stores the bookedPrice and bookedType directly from the Room object at the time of reservation.

This decouples the historical booking record from any future changes to the global Room inventory data.

2. Date and Time Handling

To comply with the constraint of only considering the Year, Month, and Day for booking logic, the following methods are used:

Normalization: The normalizeDate(Date date) private method is used at the start of bookRoom to set the hours, minutes, seconds, and milliseconds of both the check-in and check-out dates to zero.

Calculation: The duration is reliably calculated by finding the absolute difference in milliseconds (checkOut.getTime() - checkIn.getTime()) and then using the robust Java utility TimeUnit.DAYS.convert() to convert the milliseconds into whole nights.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_reservation_system.Service;

import hotel_reservation_system.Entity.BookingRoom;
import hotel_reservation_system.Entity.Room;
import hotel_reservation_system.Entity.User;
import hotel_reservation_system.enums.RoomType;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author oussa
 */
public class Service {
    
    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    private ArrayList<BookingRoom> bookingRooms;
    
    public Service (){
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
        this.bookingRooms = new ArrayList<>();
    }
    /*
    this method allows us to store the rooms in the arraylist "rooms",
    we check before we save te room of the room is already exist and also the price if it is valid
    @param roomNumber : the number of the room
    @param roomtype : the type of the room
    @param roomPricePerNight : the price of the booking room in one night
    */
    public void setRoom(int roomNumber , RoomType roomType ,  int roomPricePerNight){
        
        if(roomPricePerNight <= 0){
            System.out.println("the price is invalid");
            return;
        }
        
        for (Room room : rooms) {
            if(room.getID() == roomNumber){
                System.out.println("this room is already exist, we will update its informations");
                room.setPrice(roomPricePerNight);
                room.setType(roomType);
                return;
            }
        }
        
        
        
        Room newRoom = new Room(roomNumber, roomType, roomPricePerNight);
        rooms.add(newRoom);
        System.out.println("the room is added succesfully :)");
    }
    /*
    this method allows us to store the new users in the arraylist "users",
    we check before we store the user, the balance if it s valid ,alse the existing user
    @param userId : the unique identifier of the user
    @param balance : the balance of the user
    */
    public void setUser(int userId , int balance){
        
        if(balance<0){
            System.out.println("the balance is in valid");
            return;
        }
        
        for (User user : users) {
            if(user.getUserId() == userId){
                System.out.println("this user with id "+userId+" is already exist, we will update his informations");
                user.setBalance(balance);
                return;
            }   
        }
        
        User newUser = new User(userId, balance);
        
        users.add(newUser);
        System.out.println("the user "+ newUser.getUserId() +" added succesfully");
    }
    
    
    /*
        using this method we can print rooms data also the booking data from the latest created to the oldest
    */
    public void printAll(){
        
        System.out.println("Rooms Data :\n");
        for(int i = rooms.size() - 1 ; i >=0 ; i-- ){
            System.out.println(rooms.get(i));
        }
        System.out.println("\n");
        System.out.println("Booking Data : \n");
        
        for(int j = bookingRooms.size() -1 ;j >= 0 ; j--){
            System.out.println(bookingRooms.get(j));
        }
        System.out.println("\n");
    }
    
    /*
        this method is for printing the all users that we have in the arraylist "users" from the latest added
        to the oldest added
    */
    public void printAllUsers(){
        System.out.println("Users from the latest to the oldest created : \n");
        for (int i = users.size() - 1 ; i >= 0; i--) {
            System.out.println(users.get(i));
        }
        System.out.println("\n");
    }
    
    /*
        this method is for booking a room, before that it checks if the dates was valid,
        the checkIn date should be before the checkOut date,
        also check the if the user and room is already exist or not
        and check if the room is occupied or not before the booking
        after that it calculates the total costs of booking,
        and compare it with the balance of user if it's enough or not
        if yes it reduce the balance and the booking will create
        @param userId : the unique identfier of the user making the booking
        @param roomNumber : the number of the room requested for the booking
        @param checkIn : the date of the check in
        @param checkOut : the date of the check out
    */
    public void bookRoom(int userId , int roomNumber , Date checkIn , Date checkOut){
        try {
            if(!checkOut.after(checkIn)){
                System.out.println("the checkout must be after the checkin");
                return;
            }
            
            User existedUser = null;
            Room existedRoom = null;
            
            for (Room room : rooms) {
                if (room.getID() == roomNumber) {
                    existedRoom = room;
                }
            }
            
            for (User user : users) {
                if (user.getUserId()== userId) {
                    existedUser = user;
                }
            }
            
            if(existedUser == null || existedRoom == null){
                System.out.println("Booking Failed :( : the user or the room not found");
                return;
            }
            
            for (BookingRoom booking : bookingRooms) {
                if (booking.getRoomId() == roomNumber) {
                    if(checkIn.before(booking.getCheckOut()) || checkOut.after(booking.getCheckIn())){
                        System.out.println("Booking Failed :( : Room is occupied during this period");
                        return;
                    }
                }
            }
            
            long diffInMillies = Math.abs(checkOut.getTime() - checkIn.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
            int nights = (int) diff ;
            
            int totalCost = nights * existedRoom.getPrice();
            
            if(existedUser.getBalance() < totalCost){
                System.out.println("Booking Failed :( : the user has not enough balance, required :"+totalCost);
                return;
            }
            
            existedUser.setBalance(existedUser.getBalance() - totalCost);
            BookingRoom newBooking = new BookingRoom( userId,roomNumber, checkIn, checkOut, totalCost, existedRoom.getPrice(), existedRoom.getType().toString());
            bookingRooms.add(newBooking);
            System.out.println("Succes:) :Booking seccesfully created for user:"+existedUser.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
   
    
}

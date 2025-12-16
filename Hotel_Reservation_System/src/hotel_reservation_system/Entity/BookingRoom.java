/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_reservation_system.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author oussa
 */
public class BookingRoom {
    private int userId;
    private int roomId;
    private Date checkIn;
    private Date checkOut;
    private int cost;

    private int bookedPrice; 
    private String bookedType;
    
    
    public BookingRoom(int userId, int roomId, Date checkIn, Date checkOut, int cost , int bookedPrice , String bookedType) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cost = cost;
        
        this.bookedPrice = bookedPrice;
        this.bookedType = bookedType;
    }

    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "BookingRoom{" + "userId=" + userId + ", roomId=" + roomId + ", checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + ", cost=" + cost + ", bookedPrice=" + bookedPrice + ", bookedType=" + bookedType + '}';
    }

    
    
    

    
    
    
    
}

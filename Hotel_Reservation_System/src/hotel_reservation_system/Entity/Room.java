/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_reservation_system.Entity;

import hotel_reservation_system.enums.RoomType;

/**
 *
 * @author oussa
 */
public class Room {
    private int ID;
    private RoomType Type;
    private int price;

    public Room(int ID, RoomType Type, int price) {
        this.ID = ID;
        this.Type = Type;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public RoomType getType() {
        return Type;
    }

    public void setType(RoomType Type) {
        this.Type = Type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    @Override
    public String toString() {
        return "Room{" + "ID=" + ID + ", Type=" + Type + ", price=" + price + '}';
    }
    
    
}

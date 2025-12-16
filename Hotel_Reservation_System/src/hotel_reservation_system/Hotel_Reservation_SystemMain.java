/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel_reservation_system;

import hotel_reservation_system.Entity.Room;
import hotel_reservation_system.Entity.User;
import hotel_reservation_system.Service.Service;
import hotel_reservation_system.enums.RoomType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author oussa
 */
public class Hotel_Reservation_SystemMain {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Room room1 = new Room(1, RoomType.STANDART_SUITE, 1000);
        Room room2 = new Room(2, RoomType.JUNIOR_SUITE, 2000);
        Room room3 = new Room(3, RoomType.MASTER_SUITE, 3000);
        User oussama = new User(1, 5000);
        User khalid = new User(2, 10000);
        Service service = new Service();
        System.out.println("--------- adding 3 rooms ----------"); 
        try {
            service.setRoom(1, RoomType.STANDART_SUITE, 1000);
            service.setRoom(2, RoomType.JUNIOR_SUITE, 2000);
            service.setRoom(3, RoomType.MASTER_SUITE, 3000);
            System.out.println("-------------------------------------");
            System.out.println("----------adding 2 users ------------");
            service.setUser(oussama.getUserId(), oussama.getBalance());
            service.setUser(khalid.getUserId(), khalid.getBalance());
            System.out.println("----------------------------------------");

            service.bookRoom(oussama.getUserId(), room2.getID(),
                    sdf.parse("30/06/2026"), sdf.parse("07/07/2026"));

            System.out.println("\n");

            service.bookRoom(oussama.getUserId(), room2.getID(),
                    sdf.parse("07/07/2026"), sdf.parse("30/06/2026"));

            System.out.println("\n");

            service.bookRoom(oussama.getUserId(), room1.getID(),
                    sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

            System.out.println("\n");

            service.bookRoom(khalid.getUserId(), room1.getID(),
                    sdf.parse("07/07/2026"), sdf.parse("09/07/2026"));

            service.bookRoom(khalid.getUserId(), room3.getID(),
                    sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));


            service.setRoom(1, RoomType.STANDART_SUITE, 10000);
            service.printAll(); 
            service.printAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}

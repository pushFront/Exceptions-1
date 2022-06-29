package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Versão v1.0 - Utilizando uma solução ruim */

/**
 * @author Rian Lima
 * @date 28.6.22
 */
public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if(checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }
        sc.close();
    }
}

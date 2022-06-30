package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Versão v2.0 - Utilizando uma solução um pouco ruim
*
* Dessa vez delegando as etapas de verificação à classe Reservation
* e não ao programa principal, porém, ainda sem o tratamento correto
* das exceções.
* */

/**
 * @author Rian Lima
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

            /*
             * String para receber os erros, se seu valor for != null
             * quer dizer que houve algum erro, caso contrario, podemos
             * assumir que as datas seguem as regras e podem ser exibidas
             */

            String error = reservation.updateDates(checkIn, checkOut);

            if(error != null) {
                System.out.println(error);
            }
            else {
                System.out.println(reservation);
            }
        }
        sc.close();
    }
}

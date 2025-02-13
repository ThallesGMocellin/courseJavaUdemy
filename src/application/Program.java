package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;
public class Program {
	public static void main(String[] args) {
		//Solu��o 3 - boa -  exerc�cio exce��es. 
				
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date updCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date updCheckOut = sdf.parse(sc.next());
			
			reservation.updateDates(updCheckIn, updCheckOut);
			System.out.println("Reservation: " + reservation);
		}
		
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		//Tratamento de exce��o gen�rico para qualquer outra exce��o que possa ocorrer na execu��o do programa.
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
			
		sc.close();
	}
}

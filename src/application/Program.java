package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
public class Program {
	public static void main(String[] args) throws ParseException {
		//Solução 1 - Ruim -  exercício exceções. 
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		System.out.println("\nEnter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date updCheckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date updCheckOut = sdf.parse(sc.next());
		
		Date now = new Date();
		if (updCheckIn.before(now) || updCheckOut.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		}else if (!updCheckOut.after(updCheckIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date"); 
		}else {
			reservation.updateDates(updCheckIn, updCheckOut);
			System.out.println("Reservation: " + reservation);
		}
		
		}
		
	}
}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
// quando o metodo pode dar erro tem que tratar ou colocar throws com o nome da excecao pois pode dar erro e assim propaga ela
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// melhor coisa desta forma é que nada precisa ser mudado pois se der erro no try logo cai na minha excessao
		try {
			System.out.print("Room Number: ");
			int room = sc.nextInt();
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserv = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			System.out.println("Update na reserva: ");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
		    reserv.updateDays(checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) { // Pega o argumento que demos na classe reservation
			System.out.println("Invalid in reservation " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Tem algo errado ai");
		}
		
		sc.close();
	}

}

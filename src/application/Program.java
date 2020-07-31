package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

import model.entities.Reservation;

public class Program {
// quando o metodo pode dar erro tem que tratar ou colocar throws com o nome da excecao pois pode dar erro e assim propaga ela
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int room = sc.nextInt();
		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		// after mostra se uma data é depois da outra
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro data de check out depois de check in");
		} 
		else {
			Reservation reserv = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);

			System.out.println("Update na reserva: ");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			// aqui atribuimos este update caso der erro a uma string error
			String error = reserv.updateDays(checkIn, checkOut);
			if(error != null) {
				System.out.println("erro: " + error);
			}
			else {
				System.out.println("Reservation: " + reserv);
			}
		}

		sc.close();
	}

}

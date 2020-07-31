package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// duração em dias da estadia
	public long duration() {
		// macete para pegar a distancia entre duas datas em milesegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// transformando em dias esse resultado a cima
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDays(Date checkIn, Date checkOut) {

		// Serve para não deixar atualizar datas que não sejam futuras
		Date now = new Date();
		if (checkIn.before(now) && checkOut.before(now)) {
			return "Erro não pode aceitar tem que ser datas futuras";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro data de check out depois de check in";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		// não deu erro
		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", Check-in " + sdf.format(checkIn) + ", Check-out " + sdf.format(checkOut)
				+ duration() + " Nights";
	}

}

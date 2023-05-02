package prog4;

import java.sql.Date;

public class Booking {
	
	public String clientId;
	public String hotelId;
	public String roomId;
	public Date startDate;
	public Date endDate;
	
	public Booking (String clientId, String hotelId, String roomId, Date startDate, Date endDate) {
		this.clientId = clientId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String toString() {
	    return clientId + ", " + hotelId + ", " + roomId + ", " + startDate + ", " + endDate;
	}

	
	public static String GetFields() {
		return "clientId, hotelId, roomId, startDate, endDate";
	}

}

import java.lang.reflect.Field;
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
	
	public String GetFields() {
		
	    StringBuilder sb = new StringBuilder();
	    Field[] fields = this.getClass().getDeclaredFields();
	    for (Field field : fields) {
	    	sb.append(field.getName()).append(", ");
	    }
	    sb.delete(sb.length() - 2, sb.length()); // remove the last ", "
	    return sb.toString();
	}

}

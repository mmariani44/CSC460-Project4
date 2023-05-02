import java.lang.reflect.Field;
import java.util.UUID;

public class Room {
	
	public String roomId;
	public String hotelId;
	public float amenitiesTotal;
	public float roomRate;
	
    public Room(String hotelId, float roomRate) {
    	this.roomId = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.amenitiesTotal = 0;
        this.roomRate = roomRate;
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

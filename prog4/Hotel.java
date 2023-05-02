import java.lang.reflect.Field;
import java.util.UUID;

public class Hotel {
	
	public String hotelId;
	public String name;

    public Hotel(String name) {
    	this.hotelId = UUID.randomUUID().toString();
        this.name = name;
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
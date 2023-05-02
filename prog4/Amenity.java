package prog4;

import java.lang.reflect.Field;
import java.util.UUID;

public class Amenity {
	
	public String amenityId;
	public String hotelId;
	public String amenityName;
	public int ratingId;

    public Amenity(String hotelId, String amenityName) {
    	this.amenityId = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.amenityName = amenityName;
    }
    
    @Override
    public String toString() {
        return amenityId + ", " + hotelId + ", " + amenityName + ", " + ratingId;
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






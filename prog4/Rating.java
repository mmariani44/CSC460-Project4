import java.lang.reflect.Field;
import java.util.UUID;

public class Rating {
	
	public String ratingId;
	public int rating;
	public String comments;
	public String amenityId;
	
	public Rating(int rating, String comments, String amenityId) {
		this.ratingId = UUID.randomUUID().toString();
		this.rating = rating;
		this.comments = comments;
		this.amenityId = amenityId;
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

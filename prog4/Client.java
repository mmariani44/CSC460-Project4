package prog4;

import java.lang.reflect.Field;
import java.util.UUID;

public class Client {
	
	public String clientId;
	public String firstName;
	public String lastName;
	public float studentDiscount;
	public float membershipDiscount;
	public float creditDiscount;
	public int points;
	public boolean isStudent;
	public String membershipType;		// none, bronze, silver, gold
	
	public Client(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    
	    // Set default values for the other fields
	    this.clientId = UUID.randomUUID().toString();
	    this.isStudent = false;
	    this.membershipType = "none";
	    this.studentDiscount = 0;
	    this.membershipDiscount = 0;
	    this.creditDiscount = 0;
	    this.points = 0;
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
	
	@Override
	public String toString() {
	    return clientId + "," + firstName + "," + lastName + "," + studentDiscount + "," + membershipDiscount + "," + 
	creditDiscount + "," + points + "," + isStudent + "," + membershipType;
	}	
	
}



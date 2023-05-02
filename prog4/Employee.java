import java.lang.reflect.Field;
import java.util.UUID;

public class Employee {
	
	public String employeeId;
	public String hotelId;
	public String firstName;
	public String lastName;
	public String duty;
	public float wage;
	
	public Employee(String hotelId, String firstName, String lastName, String duty, float wage) {
		this.employeeId = UUID.randomUUID().toString();
		this.hotelId = hotelId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.duty = duty;
		this.wage = wage;
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

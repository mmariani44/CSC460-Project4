package prog4;

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
	
	@Override
	public String toString() {
	    return employeeId + ", " + hotelId + ", " + firstName + ", " + lastName + ", " + duty + ", " + wage;
	}

	
	public static String GetFields() {
		return "employeeId, hotelId, firstName, lastName, duty, wage";
	}

}

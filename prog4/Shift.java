package prog4;

import java.sql.Timestamp;

public class Shift {
	
	public String employeeId;
	public Timestamp dateStart;
	public Timestamp dateEnd;
	
	public Shift(String employeeId, Timestamp dateStart, Timestamp dateEnd) {
		this.employeeId = employeeId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
    @Override
    public String toString() {
    	return employeeId + ", " + dateStart + ", " + dateEnd;
    }
	
	public static String GetFields() {
		return "employeeId, dateStart, dateEnd";
	}
	
}

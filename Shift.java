import java.lang.reflect.Field;
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

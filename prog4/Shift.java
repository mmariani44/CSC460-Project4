/*
 * Shift.java -- Object containing all the data necessary for a single Shift record for Prog4.java
 * 		   		-- This represents the data required for Shift table (employee's shift).
 *             	-- Also contains toString() and GetFields() methods.
 *
 * Author: Mauricio Brooks, Mason Mariani, Arnav Popat
 *
 * First Version: 2023-05-02.
 */

package prog4;

import java.lang.reflect.Field;
import java.sql.Timestamp;

/*+----------------------------------------------------------------------
 ||
 ||  Class Shift 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Shift in the shift company DB for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||      Fields:  
 ||                 public String employeeId -- unique id of employee
 ||                 public Timestamp dateStart -- start datetime of shift
 ||                 public Timestamp dateEnd -- end datetime of shift
 ||                 
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Shift(String employeeId, Timestamp dateStart, Timestamp dateEnd)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
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

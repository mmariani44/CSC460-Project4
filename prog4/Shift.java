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

import java.sql.Date;
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
	public Date dateStart;
	public Date dateEnd;
	

	/*---------------------------------------------------------------------
	|  Constructor Shift(String employeeId, Timestamp dateStart, Timestamp dateEnd)
	|
	|  Purpose:  Creates Shift object to represent a single Shift for the chain.
	|
	|  Pre-condition:  employeeId, dateStart, and dateEnd are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		String employeeId -- unique id of employee
	|       		date dateStart -- start datetime of shift
	|       		date dateEnd -- end datetime of shift
	|
	|
	|  Returns: Shift object with given field values.
	*-------------------------------------------------------------------*/
	public Shift(String employeeId, Date dateStart, Date dateEnd) {
		this.employeeId = employeeId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Shift object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Shift vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Shift's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "'" + employeeId + "', TO_DATE('" + dateStart + "', 'yyyy-mm-dd'), TO_DATE('" + dateEnd + "', 'yyyy-mm-dd')";
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Shift column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Shift column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Shift's column names.
	*-------------------------------------------------------------------*/
	public String GetFields() {
		return "employeeId, dateStart, dateEnd";
	}
	
}

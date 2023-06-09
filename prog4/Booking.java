/*
 * Booking.java -- Object containing all the data necessary for a single Booking record for Prog4.java
 * 		   		-- This represents the data required for Booking table.
 *             	-- Also contains toString() and GetFields() methods.
 *
 * Author: Mauricio Brooks, Mason Mariani, Arnav Popat
 *
 * First Version: 2023-05-02.
 */

package prog4;

import java.sql.Date;

/*+----------------------------------------------------------------------
 ||
 ||  Class Booking 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Booking in a hotel for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||		
 ||      Fields:  
 ||                 public String clientId -- unique id of booking,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public String hotelId -- unique id of hotel for
 ||						 this booking
 ||                 public String roomId; -- id of the room for  
 ||						this booking
 ||                 public Date startDate -- start date of 
 ||						this booking
 ||                 public Date endDate -- end date of
 ||						this booking
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Booking (String clientId, String hotelId, 
 ||						String roomId, Date startDate, Date endDate)
 ||
 ||  Inst. Methods:  public String toString() -- returns fields vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Booking {

	public String clientId;
	public String hotelId;
	public String roomId;
	public Date startDate;
	public Date endDate;

	/*---------------------------------------------------------------------
	|  Constructor Booking(String clientId, String hotelId, String roomId, Date startDate, Date endDate)
	|
	|  Purpose:  Creates Booking object to represent a single Booking for hotels.
	|
	|  Pre-condition:  clientId, hotelId, roomId, startDate, and endDate are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		String clientId -- unique id of booking,
	| 					 generated by UUID.randomUUID().toString()
	|              	String hotelId -- unique id of hotel for
	|					this booking
	|               String roomId; -- id of the room for
	|					this booking
	|               Date startDate -- start date of
	|					this booking
	|               Date endDate -- end date of
	|					this booking
	|
	|
	|  Returns: Booking object with given field values.
	*-------------------------------------------------------------------*/
	public Booking(String clientId, String hotelId, String roomId, Date startDate, Date endDate) {
		this.clientId = clientId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Booking object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Booking vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Booking's field vals.
	*-------------------------------------------------------------------*/
	public String toString() {
		return "'" + clientId + "', '" + hotelId + "', '" + roomId + "', TO_DATE('" + startDate + "', 'yyyy-mm-dd'), TO_DATE('" + endDate + "', 'yyyy-mm-dd')";
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Booking column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Booking column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Booking's column names.
	*-------------------------------------------------------------------*/
	public static String GetFields() {
		return "clientId, hotelId, roomId, startDate, endDate";
	}

}

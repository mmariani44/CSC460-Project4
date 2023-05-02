/*
 * Room.java -- Object containing all the data necessary for a single Room record for Prog4.java
 * 		   		-- This represents the data required for Room table.
 *             	-- Also contains toString() and GetFields() methods.
 *
 * Author: Mauricio Brooks, Mason Mariani, Arnav Popat
 *
 * First Version: 2023-05-02.
 */

package prog4;

import java.util.UUID;

/*+----------------------------------------------------------------------
 ||
 ||  Class Room 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Room in the room company DB for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||      Fields:  
 ||                 public String roomId -- unique id of room,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public String hotelId -- unique id of hotel for this room
 ||				 	public float amenitiesTotal -- total cost of amenities for this room
 ||                 public float roomRate -- cost of room per night
 ||                 
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Room(String hotelId, float roomRate)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Room {

	public String roomId;
	public String hotelId;
	public float amenitiesTotal;
	public float roomRate;

	/*---------------------------------------------------------------------
	|  Constructor Room(String hotelId, float roomRate)
	|
	|  Purpose:  Creates Room object to represent a single Room for the chain.
	|
	|  Pre-condition:  hotelId and roomRate are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		String hotelId -- unique id of hotel for this room
	|				float roomRate -- cost of room per night
	|
	|
	|  Returns: Room object with given field values.
	*-------------------------------------------------------------------*/
	public Room(String hotelId, float roomRate) {
		this.roomId = UUID.randomUUID().toString();
		this.hotelId = hotelId;
		this.amenitiesTotal = 0;
		this.roomRate = roomRate;
	}

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Room object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Room vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Room's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return roomId + ", " + hotelId + ", " + amenitiesTotal + ", " + roomRate;
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Room column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Room column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Room's column names.
	*-------------------------------------------------------------------*/
	public String GetFields() {
		return "roomId, hotelId, amenitiesTotal, roomRate";
	}

}

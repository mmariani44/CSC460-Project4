/*
 * Hotel.java -- Object containing all the data necessary for a single Hotel record for Prog4.java
 * 		   		-- This represents the data required for Hotel table.
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
 ||  Class Hotel 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Hotel in the hotel company DB for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||      Fields:  
 ||                 public String hotelId -- unique id of hotel,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public String name -- hotel's name
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Hotel(String name)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Hotel {

	public String hotelId;
	public String name;

	/*---------------------------------------------------------------------
	|  Constructor Hotel(String name)
	|
	|  Purpose:  Creates Hotel object to represent a single Hotel for the chain.
	|
	|  Pre-condition:  hotel name is passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		String name -- name of hotel
	|
	|
	|  Returns: Hotel object with given field values.
	*-------------------------------------------------------------------*/
	public Hotel(String name) {
		this.hotelId = UUID.randomUUID().toString();
		System.out.println("Hotel ID: " + this.hotelId);
		this.name = name;
	}

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Hotel object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Hotel vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Hotel's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "'" + hotelId + "', '" + name + "'";
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Hotel column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Hotel column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Hotel's column names.
	*-------------------------------------------------------------------*/
	public static String GetFields() {
		return "hotelId, name";
	}

}
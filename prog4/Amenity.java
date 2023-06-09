/*
 * Amenity.java -- Object containing all the data necessary for a single Amenity record for Prog4.java
 * 		   		-- This represents the amenities that a hotel offers.
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
 ||  Class Amenity 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Amenity in a hotel for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||	
 ||      Fields:  
 ||                 public String amenityId -- unique id of amenity,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public String hotelId -- unique id of hotel offering
 ||						 this amenity
 ||                 public String amenityName -- name of the amenity 
 ||						i.e. "pool"
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Amenity(String hotelId, String amenityName)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Amenity {
	
	public String amenityId;
	public String hotelId;
	public String amenityName;
	public float price;
    

	/*---------------------------------------------------------------------
	|  Constructor Amenity(String hotelId, String amenityName)
	|
	|  Purpose:  Creates Amenity object to represent a single Amenity for hotels.
	|
	|  Pre-condition:  hotelId and amenityName are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       String hotelId -- unique id of hotel offering this amenity
	|		String amenityName  -- name of the amenity i.e. "pool"
	|
	|
	|  Returns: Amenity object with given field values..
	*-------------------------------------------------------------------*/
	public Amenity(String hotelId, String amenityName, float price) {
		this.amenityId = UUID.randomUUID().toString();
		System.out.println("AmenityId ID: " + this.amenityId);
		this.hotelId = hotelId;
		this.amenityName = amenityName;
		this.price = price;
	}

    
	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Amenity object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Amenity vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Amenity's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "'" + amenityId + "', '" + hotelId + "', '" + amenityName + "'";
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Amenity column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Amenity column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Amenity's column names.
	*-------------------------------------------------------------------*/
	public static String GetFields() {
		return "amenityId, hotelId, amenityName";
	}

}






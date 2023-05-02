/*
 * Client.java -- Object containing all the data necessary for a single Client record for Prog4.java
 * 		   		-- This represents the data required for Client table.
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
 ||  Class Client 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Client in the hotel company DB for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||			
 ||      Fields:  
 ||                 public String clientId -- unique id of client,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public String firstName -- client first name
 ||					public String lastName -- client last name
 ||                 public bool membershipDiscount -- true or false
 ||                 public bool creditDiscount -- true or false
 ||					public int points -- number of rewards points
 ||					public bool isStudent -- true or false
 ||                 public String membershipType -- none, bronze,
 ||						silver, gold
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Client(String firstName, String lastName)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Client {

	public String clientId;
	public String firstName;
	public String lastName;
	public int membershipDiscount;
	public int creditDiscount;
	public int points;
	public int isStudent;
	public String membershipType; // none, bronze, silver, gold

	/*---------------------------------------------------------------------
	|  Constructor Client(String firstName, String lastName)
	|
	|  Purpose:  Creates Client object to represent a single Client for hotels.
	|
	|  Pre-condition:  firstName and lastName are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		String firstName -- client first name
	|				String lastName -- client last name
	|
	|
	|  Returns: Client object with given field values.
	*-------------------------------------------------------------------*/
	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// Set default values for the other fields
		this.clientId = UUID.randomUUID().toString();
		System.out.println("Client ID: " + this.clientId);
		this.isStudent = 0;
		this.membershipType = "none";
		this.membershipDiscount = 0;
		this.creditDiscount = 0;
		this.points = 0;
	}

	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Client column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Client column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Client's column names.
	*-------------------------------------------------------------------*/
	public static String GetFields() {
		return "clientId, firstName, lastName, membershipDiscount, creditDiscount, points, isStudent, membershipType";
	}

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Client object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Client vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Client's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "'" + clientId + "', '" + firstName + "', '" + lastName + "', " + membershipDiscount + ", " +
				creditDiscount + ", " + points + ", " + isStudent + ", " + "'" + membershipType + "'";
	}

}

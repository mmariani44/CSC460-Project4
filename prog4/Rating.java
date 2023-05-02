/*
 * Rating.java -- Object containing all the data necessary for a single Rating record for Prog4.java
 * 		   		-- This represents the data required for Rating table.
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
 ||  Class Rating 
 ||
 ||         Author:  Mauricio Brooks, Mason Mariani, Arnav Popat
 ||        Purpose:  Object containing all the data necessary for a single 
 ||						Rating in the rating company DB for Prog4.java
 ||                   
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||      Fields:  
 ||                 public String ratingId -- unique id of rating,
 || 					 generated by UUID.randomUUID().toString()
 ||                 public int rating -- rating for the amenity
 ||                 public String comments -- comments for the amenity rating
 ||                 public String amenityId -- unique id of amenity being rated
 ||                 
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Rating(int rating, String comments, String amenityId)
 ||
 ||  Inst. Methods:  public String toString() -- returns field vals as a comma-separated string
 ||                  String getFields() -- returns field names matching DB columns
 ||                  
 ++-----------------------------------------------------------------------*/
public class Rating {
	
	public String ratingId;
	public int rating;
	public String comments;
	public String amenityId;
	

	/*---------------------------------------------------------------------
	|  Constructor Rating(int rating, String comments, String amenityId)
	|
	|  Purpose:  Creates Rating object to represent a single Rating for the chain.
	|
	|  Pre-condition:  rating, comments, and amenityId are passed in.
	|
	|  Post-condition: Columns and values are stored in this object. Easy getters.
	|
	|  Parameters:
	|       		int rating -- rating for the amenity
	|       		String comments -- comments for the amenity rating
	|       		String amenityId -- unique id of amenity being rated
	|
	|
	|  Returns: Rating object with given field values.
	*-------------------------------------------------------------------*/
	public Rating(int rating, String comments, String amenityId) {
		this.ratingId = UUID.randomUUID().toString();
		this.rating = rating;
		this.comments = comments;
		this.amenityId = amenityId;
	}
	

	/*---------------------------------------------------------------------
	|  Method toString()
	|
	|  Purpose:  Turns Rating object field vals into a comma-separated string
	|
	|  Pre-condition:  fields are set.
	|
	|  Post-condition: converts Rating vals to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Rating's field vals.
	*-------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "'" + ratingId + "', '" + rating + "', '" + comments + "', '" + amenityId + "'";
	}

	
	/*---------------------------------------------------------------------
	|  Method GetFields()
	|
	|  Purpose: Turns Rating column names into a comma-separated string
	|
	|  Pre-condition:  None.
	|
	|  Post-condition: converts Rating column names to string and returns it.
	|
	|  Parameters: None.
	|
	|
	|  Returns: String. Comma-separated string of Rating's column names.
	*-------------------------------------------------------------------*/
	public String GetFields() {
		return "ratingId, rating, comments, amenityId";
	}

}

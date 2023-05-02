package prog4;

import java.util.UUID;

public class Rating {
	
	public String ratingId;
	public int rating;
	public String comments;
	public String amenityId;
	
	public Rating(int rating, String comments, String amenityId) {
		this.ratingId = UUID.randomUUID().toString();
		this.rating = rating;
		this.comments = comments;
		this.amenityId = amenityId;
	}
	
	@Override
	public String toString() {
	    return ratingId + "," + rating + "," + comments + "," + amenityId;
	}

	
	public static String GetFields() {
		return "ratingId, rating, comments, amenityId";
	}

}

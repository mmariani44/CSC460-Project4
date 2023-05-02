package prog4;

import java.util.UUID;

public class Amenity {
	
	public String amenityId;
	public String hotelId;
	public String amenityName;
	public int ratingId;

    public Amenity(String hotelId, String amenityName) {
    	this.amenityId = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.amenityName = amenityName;
    }
    
    @Override
    public String toString() {
        return amenityId + ", " + hotelId + ", " + amenityName + ", " + ratingId;
    }

    
	public String GetFields() {
		return "amenityId, hotelId, amenityName, ratingId";
	}

}






package prog4;

import java.util.UUID;

public class Amenity {
	
	public String amenityId;
	public String hotelId;
	public String amenityName;
	public int ratingId;
	public float price;

    public Amenity(String hotelId, String amenityName, float price) {
    	this.amenityId = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.amenityName = amenityName;
	this.price = price;
    }
    
    @Override
    public String toString() {
        return amenityId + ", " + hotelId + ", " + amenityName + ", " + ratingId;
    }

    
	public String GetFields() {
		return "amenityId, hotelId, amenityName, ratingId";
	}

}






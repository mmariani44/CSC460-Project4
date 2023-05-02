package prog4;

import java.util.UUID;

public class Hotel {
	
	public String hotelId;
	public String name;

    public Hotel(String name) {
    	this.hotelId = UUID.randomUUID().toString();
        this.name = name;
    }
    
	@Override
	public String toString() {
	    return hotelId + ", " + name;
	}
    
	public static String GetFields() {
		return "hotelId, name";
	}

}
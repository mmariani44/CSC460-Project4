package prog4;

import java.util.UUID;

public class Room {
	
	public String roomId;
	public String hotelId;
	public float amenitiesTotal;
	public float roomRate;
	
    public Room(String hotelId, float roomRate) {
    	this.roomId = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.amenitiesTotal = 0;
        this.roomRate = roomRate;
    }
    
    @Override
    public String toString() {
    	return roomId + ", " + hotelId + ", " + amenitiesTotal + ", " + roomRate;
    }
    
	public static String GetFields() {
		return "roomId, hotelId, amenitiesTotal, roomRate";
	}

}

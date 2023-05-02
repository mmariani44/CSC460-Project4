package queries;

public class Queries {
	public static final String query1 = // parameter(s): clientId

			
"""
SELECT SUM(rb.roomRate) + COALESCE(SUM(a.amenityCost),0) AS totalBill
FROM HotelBooking b
INNER JOIN HotelRoom r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
INNER JOIN HotelClient c ON b.clientId = c.clientId
INNER JOIN (
    SELECT roomId, hotelId, roomRate
    FROM HotelRoom
) rb ON b.roomId = rb.roomId AND b.hotelId = rb.hotelId
LEFT JOIN (
    SELECT amenityId, hotelId, amenityCost
    FROM HotelAmenity
    WHERE isPaid = 0
) a ON b.hotelId = a.hotelId AND r.roomId = a.roomId
WHERE b.clientId = %s
GROUP BY b.clientId;
			
""";
	
	public static final String query2 = // parameter(s): date 
			
"""
SELECT c.firstName, c.lastName, r.roomId, CASE WHEN c.membershipType IS NULL THEN 'Non-Member' ELSE c.membershipType END AS category
FROM HotelClient c
INNER JOIN HotelBooking b ON c.clientId = b.clientId
INNER JOIN HotelRoom r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
WHERE TO_DATE('%s', 'YYYY-MM-DD') BETWEEN b.startDate AND b.endDate
ORDER BY r.roomId, category;
		
""";

	public static final String query3 = // parameters(s): startdate

"""
SELECT e.firstName, e.lastName, s.dateStart, s.dateEnd, s.dateEnd - s.dateStart AS hoursWorked
FROM HotelEmployee e
INNER JOIN HotelShift s ON e.employeeId = s.employeeId
WHERE s.dateStart >= TO_DATE('%s', 'YYYY-MM-DD') AND s.dateStart < TO_DATE('%s', 'YYYY-MM-DD') + 7
ORDER BY e.lastName, e.firstName, s.dateStart;

""";

	
	public static final String query4 = // parameters(s): startdate end date

			
"""
SELECT a.amenityName, AVG(r.rating) AS avgRating
FROM HotelAmenity a
INNER JOIN HotelRating r ON a.amenityId = r.amenityId
WHERE r.dateRecorded BETWEEN TO_DATE('%s', 'YYYY-MM-DD')  AND TO_DATE('%s', 'YYYY-MM-DD') 
GROUP BY a.amenityName
ORDER BY avgRating DESC;
		
""";
	
	// Print the top 5 amenities by the average rating over a specified date range for a specific hotel.
	// Allow the user to input the hotel ID, start date, and end date.
	public static final String query5 =
"""
SELECT c.firstName, c.lastName, r.roomId, b.startDate, b.endDate
FROM HotelClient c
INNER JOIN HotelBooking b ON c.clientId = b.clientId
INNER JOIN HotelRoom r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
WHERE c.isStudent = %s
ORDER BY r.roomId;

""";	
			
}

package queries;

public class Queries {
	public static final String query1 = // parameter(s): clientId

			
"""
WITH BookingCost AS (
	SELECT
		hb.clientId,
		hr.roomRate * (hb.endDate - hb.startDate) AS stayCost
	FROM
		HotelBooking hb
		JOIN HotelRoom hr ON hb.roomId = hr.roomId AND hb.hotelId = hr.hotelId
	WHERE
		hb.clientId = %s
),
AmenityCost AS (
	SELECT
		hc.clientId,
		SUM(ha.price) AS totalAmenitiesCost
	FROM
		HotelClient hc
		JOIN HotelBooking hb ON hc.clientId = hb.clientId
		JOIN HotelAmenity ha ON hb.hotelId = ha.hotelId
	WHERE
		hc.clientId = %s AND
		NOT EXISTS (
			SELECT
				1
			FROM
				HotelRating hr
			WHERE
				hr.amenityId = ha.amenityId
		)
	GROUP BY
		hc.clientId
)
SELECT
	bc.clientId,
	bc.stayCost + COALESCE(ac.totalAmenitiesCost, 0) AS currentBill
FROM
	BookingCost bc
	LEFT JOIN AmenityCost ac ON bc.clientId = ac.clientId;

			
""";
	
	public static final String query2 = // parameter(s): date 
			
"""
SELECT
    hc.membershipType,
    hc.clientId,
    hc.firstName,
    hc.lastName,
    hr.roomId
FROM
    HotelClient hc
    JOIN HotelBooking hb ON hc.clientId = hb.clientId
    JOIN HotelRoom hr ON hb.roomId = hr.roomId AND hb.hotelId = hr.hotelId
WHERE
    TO_DATE('%s', 'yyyy-mm-dd') BETWEEN hb.startDate AND hb.endDate
ORDER BY
    hc.membershipType,
    hr.roomId;
		
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

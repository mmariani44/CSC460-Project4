package queries;

public class Queries {
	public static final String query1 = // parameter(s): clientId

			
"""
SELECT c.firstName, c.lastName, 
SUM(DATEDIFF(d, b.startDate, b.endDate) * r.roomRate) + 
SUM(a.amenityCost) AS TotalCost
FROM Hotel.Client c
INNER JOIN Hotel.Booking b ON c.clientId = b.clientId
INNER JOIN Hotel.Room r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
LEFT JOIN (
  SELECT amenityId, hotelId, SUM(amenityCost) AS amenityCost
  FROM (
    SELECT a.amenityId, a.hotelId, a.amenityName, a.ratingId, 
           a.costPerUse * COUNT(*) AS amenityCost
    FROM Hotel.Amenity a
    LEFT JOIN Hotel.Rating r ON a.ratingId = r.ratingId
    INNER JOIN Hotel.Booking b ON a.hotelId = b.hotelId
    WHERE b.clientId = %s AND r.rating < 3
    GROUP BY a.amenityId, a.hotelId, a.costPerUse
  ) AS subquery
  GROUP BY amenityId, hotelId
) AS a ON b.hotelId = a.hotelId
WHERE c.clientId = %s
GROUP BY c.firstName, c.lastName;
							
""";
	
	public static final String query2 = // parameter(s): date 
			
"""
SELECT c.firstName, c.lastName, r.roomId, 
CASE WHEN c.isStudent = 1 THEN 'Student'
     WHEN c.membershipType = 'Gold' THEN 'Gold Member'
     WHEN c.membershipType = 'Silver' THEN 'Silver Member'
     ELSE 'Regular' END AS CustomerCategory
FROM Hotel.Client c
INNER JOIN Hotel.Booking b ON c.clientId = b.clientId
INNER JOIN Hotel.Room r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
WHERE b.startDate <= TO_DATE('%s','YYYY-MM-DD') AND b.endDate >= TO_DATE('%s','YYYY-MM-DD')
ORDER BY r.roomId, CustomerCategory;		
""";

	public static final String query3 = // parameters(s): startdate

"""
SELECT c.firstName, c.lastName, r.roomId, 
CASE WHEN c.isStudent = 1 THEN 'Student'
     WHEN c.membershipType = 'Gold' THEN 'Gold Member'
     WHEN c.membershipType = 'Silver' THEN 'Silver Member'
     ELSE 'Regular' END AS CustomerCategory
FROM Hotel.Client c
INNER JOIN Hotel.Booking b ON c.clientId = b.clientId
INNER JOIN Hotel.Room r ON b.roomId = r.roomId AND b.hotelId = r.hotelId
WHERE b.startDate <= TO_DATE('%s','YYYY-MM-DD') AND b.endDate >= TO_DATE('%s','YYYY-MM-DD')
ORDER BY r.roomId, CustomerCategory;
		
""";

	
	public static final String query4 = // parameters(s): startdate end date

			
"""
SELECT a.amenityName, AVG(r.rating) AS AverageRating
FROM Hotel.Amenity a
INNER JOIN Hotel.Rating r ON a.amenityId = r.amenityId AND r.dateStart >= TO_DATE('%s','YYYY-MM-DD') AND r.dateStart <= TO_DATE('%s','YYYY-MM-DD')
GROUP BY a.amenityName
ORDER BY AverageRating DESC;
				
""";
	
	public static final String query5 ="";
			
}

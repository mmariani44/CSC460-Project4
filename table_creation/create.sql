CREATE TABLE Hotel.Client (
	clientId VARCHAR2(50),
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	membershipDiscount BOOL,
	creditDiscount BOOL,
	points INT,
	isStudent BOOL,
	membershipType VARCHAR2(10), // silver, gold 
	PRIMARY KEY(clientId)
);

CREATE TABLE Hotel.Booking (
	clientId VARCHAR2(50),
	hotelId VARCHAR2(50),
	roomId VARCHAR2(50),
	startDate DATE,
	endDate DATE,
	PRIMARY KEY(clientId, hotelId, roomId, startDate)
);

CREATE TABLE Hotel.Hotel (
	hotelId VARCHAR2(50),
	name VARCHAR2(75),
	PRIMARY KEY(hotelId)
);

CREATE TABLE Hotel.Room (
	roomId VARCHAR2(50),
	hotelId VARCHAR2(50),
	amenitiesTotal FLOAT,
	roomRate FLOAT,
	PRIMARY KEY(roomId, hotelId)
);

CREATE TABLE Hotel.Amenity (
	amenityId VARCHAR2(50),
	hotelId VARCHAR2(50),
	amenityName VARCHAR2(50),
	PRIMARY KEY(amenityId, hotelId)
);

CREATE TABLE Hotel.Rating (
	ratingId VARCHAR2(50),
	rating INT,
	comments VARCHAR2(250),
	amenityId VARCHAR2(50),
	PRIMARY KEY(ratingId)
);

CREATE TABLE Hotel.Employee (
	employeeId VARCHAR2(50),
	hotelId VARCHAR2(50),
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	duty VARCHAR2(50),
	wage FLOAT,
	PRIMARY KEY(employeeId, hotelId)
);

CREATE TABLE Hotel.Shift (
	employeeId INT,
	dateStart DATETIME,
	dateEnd DATETIME,
	PRIMARY KEY(employeeId, dateStart)
);

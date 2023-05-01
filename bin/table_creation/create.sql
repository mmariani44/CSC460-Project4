CREATE TABLE Hotel.Client (
	clientId INT,
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	studentDiscount FLOAT,
	membershipDiscount FLOAT,
	creditDiscount FLOAT,
	points INT,
	isStudent BOOL,
	membershipType VARCHAR2(10),
	PRIMARY KEY(clientId)
);

CREATE TABLE Hotel.Booking (
	clientId INT,
	hotelId INT,
	roomId INT,
	startDate DATE,
	endDate DATE,
	PRIMARY KEY(clientId, hotelId, roomId, startDate)
);

CREATE TABLE Hotel.Hotel (
	hotelId INT,
	name VARCHAR2(75),
	PRIMARY KEY(hotelId)
);

CREATE TABLE Hotel.Room (
	roomId INT,
	hotelId INT,
	amenitiesTotal MONEY,
	roomRate MONEY,
	PRIMARY KEY(roomId, hotelId)
);

CREATE TABLE Hotel.Amenity (
	amenityId INT,
	hotelId INT,
	amenityName VARCHAR2(50),
	ratingId INT,
	PRIMARY KEY(amenityId, hotelId)
);

CREATE TABLE Hotel.Rating (
	ratingId INT,
	rating INT,
	comments VARCHAR2(250),
	amenityId INT,
	PRIMARY KEY(ratingId)
);

CREATE TABLE Hotel.Employee (
	employeeId INT,
	hotelId INT,
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	duty VARCHAR2(50),
	wage MONEY,
	PRIMARY KEY(employeeId, hotelId)
);

CREATE TABLE Hotel.Shift (
	employeeId INT,
	dateStart DATETIME,
	dateEnd DATETIME,
	PRIMARY KEY(employeeId, dateStart)
);
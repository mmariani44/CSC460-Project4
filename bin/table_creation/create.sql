CREATE TABLE Hotel.Client (
SET pagesize 500
SET linesize 500

DROP TABLE HotelClient;
DROP TABLE HotelBooking;
DROP TABLE HotelHotel;
DROP TABLE HotelRoom;
DROP TABLE HotelAmenity;
DROP TABLE HotelRating;
DROP TABLE HotelEmployee;
DROP TABLE HotelShift;


CREATE TABLE HotelClient (
	clientId VARCHAR2(50),
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	membershipDiscount BOOL,
	creditDiscount BOOL,
	membershipDiscount INT,
	creditDiscount INT,
	points INT,
	isStudent BOOL,
	membershipType VARCHAR2(10), // silver, gold 
	isStudent INT,
	membershipType VARCHAR2(10), 
	PRIMARY KEY(clientId)
);

CREATE TABLE Hotel.Booking (
CREATE TABLE HotelBooking (
	clientId VARCHAR2(50),
	hotelId VARCHAR2(50),
	roomId VARCHAR2(50),
	startDate DATE,
	endDate DATE,
	PRIMARY KEY(clientId, hotelId, roomId, startDate)
);

CREATE TABLE Hotel.Hotel (
CREATE TABLE HotelHotel (
	hotelId VARCHAR2(50),
	name VARCHAR2(75),
	PRIMARY KEY(hotelId)
);

CREATE TABLE Hotel.Room (
CREATE TABLE HotelRoom (
	roomId VARCHAR2(50),
	hotelId VARCHAR2(50),
	amenitiesTotal FLOAT,
	roomRate FLOAT,
	PRIMARY KEY(roomId, hotelId)
);

CREATE TABLE Hotel.Amenity (
CREATE TABLE HotelAmenity (
	amenityId VARCHAR2(50),
	hotelId VARCHAR2(50),
	amenityName VARCHAR2(50),
	price FLOAT,
	PRIMARY KEY(amenityId, hotelId)
);

CREATE TABLE Hotel.Rating (
CREATE TABLE HotelRating (
	ratingId VARCHAR2(50),
	rating INT,
	comments VARCHAR2(250),
	amenityId VARCHAR2(50),
	PRIMARY KEY(ratingId)
);

CREATE TABLE Hotel.Employee (
CREATE TABLE HotelEmployee (
	employeeId VARCHAR2(50),
	hotelId VARCHAR2(50),
	firstName VARCHAR2(50),
	lastName VARCHAR2(50),
	duty VARCHAR2(50),
	wage FLOAT,
	PRIMARY KEY(employeeId, hotelId)
);

CREATE TABLE Hotel.Shift (
CREATE TABLE HotelShift (
	employeeId VARCHAR2(50),
	dateStart DATETIME,
	dateEnd DATETIME,
	dateStart DATE,
	dateEnd DATE,
	PRIMARY KEY(employeeId, dateStart)
);

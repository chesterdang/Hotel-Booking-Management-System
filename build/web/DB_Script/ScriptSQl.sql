

create database BookingHotel
go

use BookingHotel
go

create table [Role]
(code varchar(10),
name varchar(20),
PRIMARY KEY (code));
go

create table RoomType
(roomTypeId bigint identity(1,1),
roomType varchar(30),
roomDesc text,
PRIMARY KEY (roomTypeId))
go

Create table Customer
(id bigint identity(1,1),
fullname varchar(100),
password varchar(100),
dob Date,
role varchar(10),
email varchar(50),
phone varchar(10),
status smallInt,
address varchar(100),
modifiedBy bigint,
modifiedDate datetime,
createdDate datetime,
avatar text,
capcha varchar(10),
validCapchaTime datetime,
PRIMARY KEY (ID),
FOREIGN KEY (role) REFERENCES role(code));
go

create table Hotel
(id bigint identity(1,1),
name varchar(50),
address varchar(100),
postcode varchar(10),
numRooms int,
phone varchar(10),
starRating float,
avatar text,
PRIMARY KEY (ID));
go

create table Room
(roomNo bigint identity(1,1),
hotelID bigint,
roomTypeId bigint,
occupancy int,
priceIncludes Text,
status smallint,
avatar text,
price money,
PRIMARY KEY (roomNo),
FOREIGN KEY (hotelID) REFERENCES hotel(id),
FOREIGN KEY (roomTypeId) REFERENCES roomType(roomTypeId));
go


create table Supplier
(id bigint identity(1,1),
fullName nvarchar(50),
password varchar(100),
dob Date,
role varchar(10),
email varchar(50),
phone varchar(10),
status smallInt,
address varchar(50),
hotelId bigint,
modifiedBy bigint,
modifiedDate datetime,
createdDate datetime,
avatar text,
capcha varchar(10),
validCapchaTime datetime,
PRIMARY KEY (ID),
FOREIGN KEY (role) REFERENCES role(code),
FOREIGN KEY (hotelId) REFERENCES Hotel(id));
go

CREATE TABLE [Admin] (
    id bigint IDENTITY(1,1),
    fullname VARCHAR(100),
    password varchar(100),
    dob DATE,
    [role] VARCHAR(10),
    email VARCHAR(50),
    phone VARCHAR(10),
    status SMALLINT,
    address VARCHAR(100),
    modifiedBy bigint,
    modifiedDate DATETIME,
    createdDate DATETIME,
    avatar text,
	capcha varchar(10),
	validCapchaTime datetime,
    PRIMARY KEY (ID),
    FOREIGN KEY ([role]) REFERENCES [role](code)
);
go

create table Booking 
(id bigint identity(1,1),
hotelID bigint,
customerID bigint,
roomNo bigInt,
bookingTime datetime,
arrivalTime datetime,
departureTime datetime,
numAdults int,
numChilds int,
specialReq text,
status smallint,
PRIMARY KEY (ID),
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (roomNO) REFERENCES room(roomNo),
FOREIGN KEY (hotelId) REFERENCES hotel(id));
go


create table Invoice
(id bigint identity(1,1),
bookingID bigint,
customerID bigint,
roomCharge money,
roomService text,
paymentDate datetime,
paymentMode varchar(10),
creditCardNo varchar(20),
PRIMARY KEY (ID),
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (bookingID) REFERENCES Booking(id));

go



create table CancelBooking
(id bigint identity(1,1),
customerID bigint,
bookingid bigint,
content text,
createdDate datetime,
status smallint,
PRIMARY KEY (ID),
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (bookingID) REFERENCES Booking(id));
go

create table manageFavRoom
(id bigint identity(1,1),
roomNo bigint,
customerId bigint,
PRIMARY KEY (ID),
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (roomNO) REFERENCES room(roomNo));
go


create table Report
(id bigint identity(1,1),
customerId bigInt,
roomNo bigint,
createdDate datetime,
content text,
PRIMARY KEY (ID),
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (roomNO) REFERENCES room(roomNo));
go


create table feedback
(id bigint identity(1,1),
customerID bigint,
roomNo bigint,
createdDate datetime,
content text,
status smallint,
FOREIGN KEY (customerID) REFERENCES customer(id),
FOREIGN KEY (roomNo) REFERENCES room(roomNo));



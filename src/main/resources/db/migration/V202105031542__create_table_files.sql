CREATE TABLE files(
	ID varchar(255) NOT NULL,
	DATA LONGBLOB,
    NAME varchar(255),
    TYPE varchar(255),
    PRIMARY KEY (ID)
);
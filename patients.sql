CREATE TABLE IF NOT EXISTS PatientAddresses(
	AddressID int NOT NULL AUTO_INCREMENT,
    PatientID int NOT NULL,
	PostCode int,
    City varchar(50),
    Street varchar(50),
    HouseNumber int,
    PRIMARY KEY(AddressID)
);

CREATE TABLE IF NOT EXISTS Patients(
	PatientID int NOT NULL AUTO_INCREMENT,
    FirstName varchar(50) NOT NULL,
    LastName varchar(50) NOT NULL,
    MotherName varchar(100),
    Sex varchar(10),
    DateOfBirth DATE,
    DateOfDeath DATE,
    PlaceOfBirth varchar(50),
    PhoneNumber varchar(20),
    AddressID int,
    PRIMARY KEY(PatientID), 
    FOREIGN KEY(AddressID) REFERENCES PatientAddresses(AddressID)
);

ALTER TABLE PatientAddresses
ADD FOREIGN KEY(PatientID) REFERENCES Patients(PatientID);

CREATE TABLE IF NOT EXISTS Relationships(
	Patient1 int NOT NULL,
    Patient2 int NOT NULL,
    ConnectionType varchar(50) NOT NULL,
    ConnectionQuality varchar(20),
    ConnectionDistance int,
    StartDateOfConnection DATE,
    EndDateOfConnection DATE,
    FOREIGN KEY(Patient1) REFERENCES Patients(PatientID),
    FOREIGN KEY(Patient2) REFERENCES Patients(PatientID)
);

DROP TRIGGER IF EXISTS checkStartOfConnection;

DELIMITER //

CREATE TRIGGER checkStartOfConnection
BEFORE INSERT ON Relationships FOR EACH ROW
	BEGIN 
        IF (ISNULL(NEW.StartDateOfConnection) 
			OR NEW.StartDateOfConnection < (SELECT MAX(DateOfBirth) FROM Patients 
				WHERE PatientID = NEW.Patient1 OR PatientID = NEW.Patient2)) 
        THEN
			SET NEW.StartDateOfConnection = (SELECT MAX(DateOfBirth) FROM Patients 
				WHERE PatientID = NEW.Patient1 OR PatientID = NEW.Patient2);
		END IF;
    END; //

DELIMITER ;

DROP TRIGGER IF EXISTS checkEndOfConnection;

DELIMITER //

CREATE TRIGGER checkEndOfConnection
AFTER UPDATE ON Patients FOR EACH ROW
	BEGIN 
		IF( ! ISNULL(NEW.DateOfDeath) ) THEN
			UPDATE Relationships
			SET EndDateOfConnection = NEW.DateOfDeath
			WHERE (Patient1 = NEW.PatientID OR Patient2 = NEW.PatientID) 
				AND (EndDateOfConnection IS NULL
				OR NEW.DateOfDeath < EndDateOfConnection);
		END IF;
    END; //

DELIMITER ;
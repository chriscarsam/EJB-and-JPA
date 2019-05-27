CREATE DATABASE dbappwebschedule;
USE dbappwebschedule;

CREATE TABLE tuser
(
	idUser INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(70) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    birthdate DATE NOT NULL,
    email VARCHAR(700) NOT NULL,
    password VARCHAR(700) NOT NULL,
    registrationDate DATETIME NOT NULL,
    modificaionDate DATETIME NOT NULL,
    PRIMARY KEY (idUser)    
);

CREATE TABLE tactivity
(
	idActivity INT AUTO_INCREMENT NOT NULL,
    idUser INT NOT NULL,
    firstName VARCHAR(700) NOT NULL,
    description TEXT NOT NULL,
    place VARCHAR(700) NOT NULL,
    dateStartTime DATETIME NOT NULL,
    endTimeDate DATETIME NOT NULL,
    state BIT NOT NULL,
    registrationDate DATETIME NOT NULL,
    modificationDate DATETIME NOT NULL,
    FOREIGN KEY (idUser) REFERENCES tuser(idUser),
    PRIMARY KEY (idActivity)
);

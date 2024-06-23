CREATE DATABASE AnimalsDB;

USE AnimalsDB;

CREATE TABLE Dog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    animalType VARCHAR(20) NOT NULL,
    gender VARCHAR(10),
    age VARCHAR(10),
    weight VARCHAR(10),
    acquisitionDate DATE,
    acquisitionCountry VARCHAR(50),
    trainingStatus VARCHAR(50),
    reserved BOOLEAN,
    inServiceCountry VARCHAR(50),
    breed VARCHAR(50)
);

CREATE TABLE Monkey (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    animalType VARCHAR(20) NOT NULL,
    gender VARCHAR(10),
    age VARCHAR(10),
    weight VARCHAR(10),
    acquisitionDate DATE,
    acquisitionCountry VARCHAR(50),
    trainingStatus VARCHAR(50),
    reserved BOOLEAN,
    inServiceCountry VARCHAR(50),
    species VARCHAR(50),
    height VARCHAR(10),
    tailLength VARCHAR(10),
    bodyLength VARCHAR(10)
);

-- recording the details for dog table
INSERT INTO Dog (name, animalType, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, breed)
VALUES
('Spot', 'German Shepherd', 'male', '3 years', '25.6 lbs', '2019-05-12', 'United States', 'Phase I', false, 'United States', 'German Shepherd'),
('Rex', 'Great Dane', 'male', '2 years', '35.2 lbs', '2020-02-03', 'United States', 'Phase II', false, 'United States', 'Great Dane'),
('Bella', 'Chihuahua', 'female', '4 years', '15.5 lbs', '2018-12-12', 'Canada', 'In Service', true, 'Canada', 'Chihuahua'),
('Luna', 'Labrador Retriever', 'female', '2 years', '18.2 lbs', '2021-04-25', 'Australia', 'Phase I', false, 'Australia', 'Labrador Retriever'),
('Max', 'Poodle', 'male', '5 years', '28.7 lbs', '2017-08-19', 'United Kingdom', 'In Service', false, 'United Kingdom', 'Poodle');

-- recording the details for monkey table
INSERT INTO Monkey (name, animalType, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, species, height, tailLength, bodyLength)
VALUES
('Cappy', 'Capuchin', 'male', '5 years', '10.2 lbs', '2020-07-15', 'Brazil', 'Phase I', false, 'United States', 'Capuchin', '12 inches', '15 inches', '18 inches'),
('Max', 'Macaque', 'male', '4 years', '15.8 lbs', '2019-09-22', 'Australia', 'In Service', false, 'Australia', 'Macaque', '14 inches', '16 inches', '20 inches'),
('Tammy', 'Tamarin', 'female', '3 years', '8.5 lbs', '2021-01-10', 'India', 'Phase I', false, 'India', 'Tamarin', '10 inches', '12 inches', '15 inches'),
('Simba', 'Baboon', 'male', '6 years', '12.3 lbs', '2018-03-05', 'South Africa', 'In Service', false, 'South Africa', 'Baboon', '16 inches', '20 inches', '24 inches'),
('Milo', 'Spider Monkey', 'male', '2 years', '9.6 lbs', '2022-02-18', 'Canada', 'Intake', false, 'Canada', 'Spider Monkey', '13 inches', '14 inches', '17 inches');
-- drop database if exists
DROP DATABASE IF EXISTS quanlyfresher;
CREATE DATABASE IF NOT EXISTS quanlyfresher;
USE quanlyfresher;

-- question 1: create table Trainee with constraint and datatype
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee
( Trainee_ID				TINYINT AUTO_INCREMENT PRIMARY KEY,
  Full_Name					NVARCHAR (30) NOT NULL,
  Birth_Date				DATE NOT NULL,
  Gender					ENUM('male','female','unknown'),
  ET_IQ						TINYINT CHECK ((ET_IQ >=0) AND (ET_IQ <=20)),
  ET_Gmath					TINYINT CHECK ((ET_Gmath >=0) AND (ET_Gmath <=20)),
  ET_English				TINYINT CHECK ((ET_English >=0) AND (ET_English <=50)),
  Training_Class			CHAR(10) NOT NULL,
  Evaluation_Notes			NVARCHAR(200) 
);

-- question 2: them truong VTI_Account voi dieu kien not null vaf unique
ALTER TABLE Trainee
	ADD VTI_Account			CHAR(10) UNIQUE NOT NULL;


-- Exercise 1: Design a table 
-- drop database if exists
DROP DATABASE IF EXISTS TraineeManager;
CREATE DATABASE IF NOT EXISTS TraineeManager;
USE TraineeManager;

-- question 1: create table Manager with constraint and datatype
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee
(	userName					VARCHAR (30) NOT NULL,
	passWord					VARCHAR (30) NOT NULL,
	firstName					VARCHAR (30) NOT NULL,
	lastName					VARCHAR (30) NOT NULL,
	email						VARCHAR (50) NOT NULL PRIMARY KEY
);

INSERT INTO 
	Trainee (	userName,	passWord,		firstName,		lastName,			email				)
VALUES
			(	'thaoctt',	'123456A',		'Cao',			'Thu Thao',			'thao@vti.com.vn'	),		
            (	'nnhung',	'123457A',		'Nguyen',		'Hong Nhung',		'nhung@vti.com.vn'	),
            (	'caotrang',	'123458A',		'Cao',			'Thi Trang',		'trang@vti.com.vn'	),
            (	'haihung',	'111111A',		'Nguyen',		'Hai Hung',			'Hung@vti.com.vn'	);
            


















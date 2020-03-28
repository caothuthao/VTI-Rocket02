-- Exercise 1: Design a table 
-- drop database if exists
DROP DATABASE IF EXISTS QuanLyUngVien;
CREATE DATABASE IF NOT EXISTS QuanLyUngVien;
USE QuanLyUngVien;

-- question 1: create table Manager with constraint and datatype
DROP TABLE IF EXISTS Manager;
CREATE TABLE IF NOT EXISTS Manager
( id						TINYINT AUTO_INCREMENT PRIMARY KEY,
  passWord					VARCHAR (30) NOT NULL,
  firstName					VARCHAR (30) NOT NULL,
  lastName					VARCHAR (30) NOT NULL,
  email						VARCHAR (50) NOT NULL,
  expInYear					TINYINT NOT NULL,
  phone						CHAR(10) NOT NULL
);

INSERT INTO 
	Manager ( passWord,		firstName,		lastName,		email,				expInYear,		phone			)
VALUES
			( '123456A',	'Cao',			'Thu Thao',		'thao@vti.com.vn',		1,			'0123456789'	),
            ( '123457A',	'Nguyen',		'Hong Nhung',	'nhung@vti.com.vn',		2,			'0123456790'	),
            ( '123458A',	'Cao',			'Thi Trang',	'trang@vti.com.vn',		1,			'0123456791'	),
            ( '111111A',	'Nguyen',		'Hai Hung',		'Hung@vti.com.vn',		1,			'0123456792'	);
            
-- question 1: create table Employee with constraint and datatype
DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee
( id						TINYINT AUTO_INCREMENT PRIMARY KEY,
  passWord					VARCHAR (30) NOT NULL,
  firstName					VARCHAR (30) NOT NULL,
  lastName					VARCHAR (30) NOT NULL,
  email						VARCHAR (50) NOT NULL,
  phone						CHAR(10) NOT NULL,
  projectName				VARCHAR (30) NOT NULL,
  ProSkill					VARCHAR (30) NOT NULL
);

INSERT INTO 
	Employee ( passWord,		firstName,		lastName,		email,					phone,			projectName,		ProSkill	)
VALUES
			( '111111A',		'Cao',			'Thu Huong',	'huong@vti.com.vn',		'0123456789',	'CRM',				'java'		),
            ( '111111A',		'Nguyen',		'Hong Nhung',	'nhung@vti.com.vn',		'0123456790',	'Testing System',	'php'		),
            ( '111111A',		'Cao',			'Thi Trang',	'trang@vti.com.vn',		'0123456791',	'TimeSheet',		'JS'		),
            ( '111111A',		'Cao',			'Thi Hai',		'Hai@vti.com.vn',		'0123456795',	'CRM',				'JS'		);




















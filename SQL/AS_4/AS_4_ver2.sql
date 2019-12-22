-- drop database if exists
DROP DATABASE IF EXISTS bai4;
CREATE DATABASE IF NOT EXISTS bai4;
USE bai4;

-- question 1: create table with constraint and datatype
-- bang Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department
( Department_Number					TINYINT AUTO_INCREMENT PRIMARY KEY,
  Department_Name					NVARCHAR(30) NOT NULL
);

-- bang Employee_Table
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE IF NOT EXISTS Employee_Table
( Employee_Number					TINYINT AUTO_INCREMENT PRIMARY KEY,
  Employee_Name						NVARCHAR(30) NOT NULL,
  Department_Number					TINYINT NOT NULL,
  FOREIGN KEY (Department_Number)	REFERENCES Department (Department_Number)
);

-- bang Employee_Skill_Table
DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE IF NOT EXISTS Employee_Skill_Table
( Employee_Number					TINYINT NOT NULL,
  Skill_Code 						CHAR(10) NOT NULL,
  Date_Registered					DATE NOT NULL,
  FOREIGN KEY (Employee_Number) 	REFERENCES Employee_Table (Employee_Number)
);

-- Question 2: them it nhat 10 ban ghi vao table
-- table Department
INSERT INTO 
	Department	( Department_Name )
VALUES
				('Ke toan 1'),
                ('IT'),
                ('Nhan su'),
                ('Marketing'),
                ('Tai chinh'),
                ('Tong hop'),
                ('Ke toan 2'),
                ('IT 2'),
                ('Nhan su 2'),
                ('Tai chinh 2');
                
-- bang Employee_Table
INSERT INTO 
	Employee_Table 	(Employee_Name, 		Department_Number)
VALUES
					('Cao Thu Thao',		1),
					('Cao Thi Trang',		2),
					('Nguyen Hong Nhung',	3),
					('Dinh Thi Nguyet',		4),
					('Bui Van Tien',		5),
					('Nguyen Viet Anh',		6),
					('Ngo Trung Nhat',		7),
					('Nguyen Tat Thanh',	8),
					('Nguyen Dinh Minh', 	9),
					('Pham Tien Dat',		10),
					('Nguyen Hong Tham',	1),
					('Ha Thu Tra',			1),
					('Nguyen Van Thanh',	1);
                
-- table Employee_Skill_Table
INSERT INTO 
	Employee_Skill_Table 	(Employee_Number, 	Skill_code, 	Date_Registered)
VALUES
							(1,					'Java',			'2000/02/01'),
							(1,					'JS',			'2000/02/01'),
							(1,					'PHP',			'2000/02/01'),
							(2,					'PHP',			'2000/01/01'),
							(3,					'Java',			'2000/03/01'),
							(4,					'PHP',			'2000/01/01'),
							(5,					'Java',			'2000/04/01'),
							(5,					'JS',			'2000/04/01'),
							(6,					'JS',			'2000/01/01'),
							(7,					'Java',			'2000/05/01'),
							(8,					'JS',			'2000/01/01'),
							(9,					'Java',			'2000/06/01'),
							(10,				'PHP',			'2000/01/01'),
							(11,				'Java',			'2000/02/01'),
							(12,				'Java',			'2000/02/01'),
							(13,				'Java',			'2000/02/01');
                    
-- Q3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT 
    Employee_Name
FROM
    Employee_Table,
    Employee_Skill_Table
WHERE
    Employee_Table.Employee_number = Employee_Skill_Table.Employee_number
        AND Skill_Code = 'Java';
        
-- Q4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 
    d.Department_Number, d.Department_Name
FROM
    Department d
        JOIN
    Employee_Table et ON d.Department_Number = et.Department_Number
GROUP BY Department_Number
HAVING COUNT(Employee_Number) > 3;

-- Q5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban
SELECT 
    et.Employee_Number,
    GROUP_CONCAT(et.Employee_Name) AS 'Ho ten nhan vien',
    et.Department_Number
FROM
    Employee_Table et
        JOIN
    Department d ON d.Department_Number = et.Department_Number
GROUP BY Department_Number;

-- Q6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills
SELECT 
    et.Employee_Number, et.Employee_Name, et.Department_Number
FROM
    Employee_Table et
        JOIN
    Employee_Skill_Table est ON et.Employee_Number = est.Employee_Number
GROUP BY Employee_Number
HAVING COUNT(Skill_Code) > 1;

					
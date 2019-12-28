-- Exercise 1:

-- drop database if exists
DROP DATABASE IF EXISTS Project;
-- create database if not exisits
CREATE DATABASE IF NOT EXISTS Project;
USE Project;

-- drop table Employee if exists
DROP TABLE IF EXISTS Employee;
-- drop table if not exists
CREATE TABLE IF NOT EXISTS Employee
(	EmployeeID						CHAR(10) PRIMARY KEY,
	EmployeeLastName				VARCHAR(30) NOT NULL,
    EmployeeFirstName				VARCHAR(30) NOT NULL,
    EmployeeHireDate				DATE NOT NULL,
    EmployeeStatus					NVARCHAR(50),
    SupervisorID					CHAR(10) NOT NULl,
    SocialSecurityNumber			MEDIUMINT
);
-- insert du lieu vao bang
INSERT INTO 
		Employee(EmployeeID,	EmployeeLastName,	EmployeeFirstName,	EmployeeHireDate,	EmployeeStatus,		SupervisorID,	SocialSecurityNumber)
VALUES
				('E1',			'Thu Thao',			'Cao',				'2000/09/08',		'Dang lam',				'E5',				100			),
                ('E2',			'Trang',			'Cao',				'2000/11/15',		'Dang lam',				'E5',				101			),
                ('E3',			'Hong Nhung',		'Nguyen',			'2000/11/24',		'Dang lam',				'E5',				102			),
                ('E4',			'Nguyet',			'Dinh',				'2000/12/23',		'Dang lam',				'E5',				103			),
                ('E5',			'Tien',				'Bui',				'2000/12/12',		'Dang lam',				'E5',				104			),
                ('E6',			'Tuan',				'Pham',				'2000/12/10',		'Dang lam',				'E5',				105			);
  		
-- drop table Projects if exists
DROP TABLE IF EXISTS Projects;
-- drop table Projects if not exists
CREATE TABLE IF NOT EXISTS Projects
(	ProjectID						CHAR(10) PRIMARY KEY,
	EmployeeID						CHAR(10) NOT NULL,
    ProjectName						VARCHAR(30) NOT NULL,
    ProjectStartDate				DATE NOT NULL,
    ProjectDescription				NVARCHAR(100),
    ProjectDetailt					NVARCHAR(255),
    ProjectCompletedOn				DATE,					-- ngay hoan thanh project
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE CASCADE
);

INSERT INTO 
		Projects(ProjectID,		EmployeeID,		ProjectName,		ProjectStartDate,	ProjectDescription,		ProjectDetailt,		ProjectCompletedOn	)
VALUES
				('P1',			'E1',			'QL du an',			'2019/01/01',		'Done',					'abc',				'2019/01/30'		),
                ('P2',			'E1',			'QL can ho',		'2019/02/01',		'Done',					'abc',				'2019/09/20'		),
                ('P3',			'E1',			'QL giang duong',	'2019/03/01',		'Done',					'abc',				'2019/03/30'		),
                ('P4',			'E1',			'QL thu vien',		'2019/04/02',		'Done',					'abc',				'2019/07/01'		),
                ('P5',			'E5',			'QL ban hang',		'2019/05/02',		'Working',				'abc',				 null				);

-- drop table Project_Modules if exists
DROP TABLE IF EXISTS Project_Modules;
-- drop table Project_Modules if not exists
CREATE TABLE IF NOT EXISTS Project_Modules
(	ModuleID					CHAR(10) PRIMARY KEY,
	ProjectID					CHAR(10) NOT NULL,
    EmployeeID					CHAR(10) NOT NULL,
    ProjectModulesDate			DATE NOT NULL,				-- ngay nhan vien hoan thanh module theo ke hoach
    ProjectModulesCompledOn		DATE,						-- ngày thực tế nhân viên hoàn thành module
    ProjectModulesDescription	NVARCHAR(200),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE CASCADE, 
    FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID) ON DELETE CASCADE
);

INSERT INTO 
		Project_Modules (ModuleID,	ProjectID,	EmployeeID,		ProjectModulesDate,		ProjectModulesCompledOn,	ProjectModulesDescription	)
VALUES
						('M1',		'P1',		'E2',			'2019/01/10',			'2019/01/11',				'bcd'						),
                        ('M2',		'P1',		'E3',			'2019/01/30',			'2019/01/30',				'bcd'						),
                        ('M3',		'P2',		'E3',			'2019/02/10',			'2019/02/15',				'bce'						),
                        ('M4',		'P2',		'E4',			'2019/09/18',			'2019/09/20',				'bce'						),
                        ('M5',		'P3',		'E2',			'2019/03/30',			'2019/03/30',				'bcf'						),
                        ('M6',		'P4',		'E1',			'2019/07/01',			'2019/07/01',				'bcf'						),
                        ('M7',		'P5',		'E6',			'2019/08/05',			 null,						'bcf'						);

-- drop table Work_Done if exists
DROP TABLE IF EXISTS Work_Done;
-- drop table Work_Done if not exists
CREATE TABLE IF NOT EXISTS Work_Done
(	WorkDoneID					CHAR(10) PRIMARY KEY,
	ModuleID					CHAR(10) NOT NULL,
    EmployeeID					CHAR(10) NOT NULL,
    WorkDoneDate				DATE,						--  ngày nhân viên hoàn thành work, (date = null nếu work chưa hoàn thành)
    WorkDoneDescription			NVARCHAR(200),
    WorkDoneStatus				NVARCHAR(100),
    FOREIGN KEY (EmployeeID)	REFERENCES Employee(EmployeeID) ON DELETE CASCADE,
    FOREIGN KEY (ModuleID)		REFERENCES Project_Modules (ModuleID) ON DELETE CASCADE
);

INSERT INTO 
		Work_Done	(WorkDoneID,	ModuleID,	EmployeeID,		WorkDoneDate,		WorkDoneDescription,	WorkDoneStatus	)
VALUES
					('W1',			'M1',		'E2',			'2019/01/11',		'123abc',				'Done'			),
                    ('W2',			'M2',		'E3',			'2019/01/30',		'123abc',				'Done'			),
                    ('W3',			'M3',		'E3',			'2019/02/15',		'123abc',				'Done'			),
                    ('W4',			'M4',		'E4',			'2019/09/20',		'123abc',				'Done'			),
                    ('W5',			'M5',		'E2',			'2019/03/30',		'123abc',				'Done'			),
                    ('W6',			'M6',		'E1',			'2019/07/01',		'123abc',				'Done'			),
					('W7',          'M7',		'E6',			 null,				'123abc',				'Working'		);				
                    
-- Question b: b) 	Viết stored procedure (không có parameter) để Remove tất cả thông tin
-- 					project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
-- 					remove từ các table liên quan trong khi removing (dùng lệnh print)

DROP PROCEDURE IF EXISTS P_remove_project_info;
DELIMITER $$
CREATE PROCEDURE P_remove_project_info()
BEGIN
        DELETE
        FROM Projects
        WHERE SUBDATE(current_date(), INTERVAL 90 DAY) > ProjectCompletedOn;
        
        SELECT ROW_COUNT();
END$$

delimiter ;

-- use:
CALL P_remove_project_info;

-- Question c: Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
DROP PROCEDURE IF EXISTS P_modules_working;
DELIMITER $$
CREATE PROCEDURE P_modules_working()
BEGIN
		SELECT ModuleID, ProjectID, EmployeeID, ProjectModulesDate, ProjectModulesCompledOn, ProjectModulesDescription
        FROM Project_Modules
        WHERE ProjectModulesCompledOn IS NULL;
END$$

delimiter ;
-- use
call P_modules_working();

-- Question d: Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)
DROP PROCEDURE IF EXISTS P_employees_notin_workdone;
DELIMITER $$
CREATE PROCEDURE P_employees_notin_workdone()
BEGIN
        SELECT EmployeeID, EmployeeLastName, EmployeeFirstName, EmployeeHireDate, SupervisorID
        FROM Employee
        WHERE EmployeeID NOT IN ( SELECT EmployeeID FROM Work_Done);
END$$

delimiter ;

CALL P_employees_notin_workdone();

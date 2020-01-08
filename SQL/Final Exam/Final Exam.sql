DROP DATABASE IF EXISTS Quanlydiem;
CREATE DATABASE IF NOT EXISTS Quanlydiem;
USE Quanlydiem;

-- Create tables:
-- table Student
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student
(	RN						INT AUTO_INCREMENT PRIMARY KEY,
	Name					NVARCHAR(30) NOT NULL,
    Age						TINYINT,
    Gender					ENUM('Male','Female','Unknow')
);
INSERT INTO
	Student	(Name,					Age,		Gender	)
VALUES		('Cao Thu Thao',		20,			'Female'),
			('Cao Thi Trang',		20,			'Female'),
			('Nguyen Hong Nhung',	20,			'Female');

-- table Subject
DROP TABLE IF EXISTS Subject;
CREATE TABLE IF NOT EXISTS Subject
(	sID						CHAR(5) PRIMARY KEY, 
	sName					NVARCHAR(10) NOT NULL
);
INSERT INTO
	Subject	(sID,		sName		)
VALUES		('S1',		'Toan'		),
			('S2',		'Ngoai ngu'	),
			('S3',		'Van'		);
            
-- table StudentSubject
DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE IF NOT EXISTS StudentSubject
(	RN						CHAR(5),
	sID						CHAR(5),
    Mark					DECIMAL(3,1) NOT NULL,
    Date					DATE,
    PRIMARY KEY (RN, sID)
);
INSERT INTO
	StudentSubject	(RN,	sID,		Mark,		Date		)
VALUES				(1,		'S1',		9,			'2019/01/01'),
					(1,		'S2',		9.5,		'2019/01/10'),
                    (2,		'S1',		9,			'2019/01/01'),
                    (2,		'S2',		8.5,		'2019/01/10'),
                    (3,		'S1',		9,			'2019/01/01'),
                    (3,		'S2',		9,			'2019/01/10');
                    
-- Question b: b) Viết lệnh để
-- a. Lấy tất cả các môn học không có bất kì điểm nào
SELECT 
    *
FROM
    Subject
WHERE
    sID NOT IN (SELECT 
					sID
				FROM
					StudentSubject);

-- b. Lấy danh sách các môn học có ít nhất 2 điểm				
SELECT 
    s.sName, s.sID
FROM
    subject s
        JOIN
    studentsubject ss ON s.sID = ss.sID
GROUP BY s.sID
HAVING COUNT(Mark) >= 2; 

-- Question c: 	Tạo "StudentInfo" view có các thông tin về học sinh bao gồm: RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
-- 				Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho null
CREATE OR REPLACE VIEW StudentInfo AS
    SELECT 
        st.RN, sb.sID, st.Name, st.Age, st.Gender, sb.sName, ss.Mark, ss.Date
    FROM
        studentsubject ss
            JOIN
        subject sb ON ss.sID = sb.sID
            JOIN
        student st ON ss.RN = st.RN;
    
SELECT * FROM StudentInfo;

-- Question d: Tạo trigger cho table Subject:
-- a. Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của cột sID của table StudentSubject cũng thay đổi theo
DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
CREATE TRIGGER CasUpdate
AFTER UPDATE ON subject
FOR EACH ROW
BEGIN
		UPDATE StudentSubject
        SET sID = NEW.sID
        WHERE sID = OLD.sID;
        
END$$
DELIMITER ;

-- update data:
UPDATE subject
	SET sID = 'S4'
	WHERE sID = 'S1';
    
-- b. Trigger casDel: Khi xóa 1 student, các dữ liệu của table StudentSubject cũng sẽ bị xóa theo
DROP TRIGGER IF EXISTS casDel;
DELIMITER $$
CREATE TRIGGER casDel
AFTER DELETE ON student
FOR EACH ROW
BEGIN
		DELETE FROM StudentSubject
        WHERE RN = OLD.RN;
END$$
DELIMITER ;

-- delete:
DELETE FROM student
WHERE RN = 2;


-- Question e: 	Viết 1 thủ tục (có 2 parameters: student name, mark). Thủ tục sẽ xóa tất cả các thông tin liên quan tới học sinh 
-- 				có cùng tên như parameter và tất cả các điểm nhỏ hơn của các học sinh đó.
-- 				Trong trường hợp nhập vào "*" thì thủ tục sẽ xóa tất cả các học sinh

DROP PROCEDURE IF EXISTS p_delete_student;
DELIMITER $$
CREATE PROCEDURE p_delete_student(IN p_student_name NVARCHAR(30), IN p_mark DECIMAL(3,1) )
BEGIN
		IF (p_student_name = '*') THEN
				DELETE 
                FROM student;
		END IF;
		IF (p_student_name = '*') THEN
				DELETE
				FROM studentsubject
                WHERE Mark < p_mark;
		END IF;
        
        IF (p_student_name != '*' AND p_mark != '*') THEN
			DELETE 
			FROM student
			WHERE Name = p_student_name;
		END IF;
        IF (p_student_name != '*' AND p_mark != '*') THEN
			DELETE
			FROM studentsubject
			WHERE Mark < p_mark AND RN IN (	SELECT RN 
											FROM student 
											WHERE Name = p_student_name );
		END IF;
                                        
END$$
DELIMITER ;

CALL p_delete_student('Cao Thu Thao',10);
CALL p_delete_student('*',2);
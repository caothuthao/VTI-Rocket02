USE project;

-- Exercise 1: Tiếp tục với Database ở buổi 6
-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)

DROP TRIGGER IF EXISTS trig_module_project;
DELIMITER $$
CREATE TRIGGER trig_module_project
BEFORE INSERT ON project_modules
FOR EACH ROW
BEGIN
	DECLARE v_ProjectStartDate DATE;
    DECLARE v_ProjectCompletedOn DATE; 
   
	SELECT ProjectStartDate INTO v_ProjectStartDate
    FROM projects
    WHERE ProjectID = NEW.ProjectID;
    
    SELECT ProjectCompletedOn INTO v_ProjectCompletedOn
    FROM projects 
    WHERE ProjectID = NEW.ProjectID;
    
    IF ((NEW.ProjectModulesDate < v_ProjectStartDate) OR (NEW.ProjectModulesCompledOn > v_ProjectCompletedOn)) THEN
		 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Can not insert!';
	END IF;
END$$
DELIMITER ;

-- insert module M10 co Project_Modules.ProjectModulesDate(2019/04/20)< Projects.ProjectStartDate(2019/05/02)
INSERT INTO project_modules 
	VALUES ('M10', 'P5','E6', '2019/04/20', null,null);  
   
-- insert module M9 co Project_Modules.ProjectModulesCompletedOn(2019/07/02) > Projects.ProjectCompletedOn(2019/07/01)
 INSERT INTO project_modules 
	VALUES ('M9', 'P4','E2', '2019/04/05','2019/07/02',null);  

-- insert module M8 co Project_Modules.ProjectModulesDate(2019/08/10)< Projects.ProjectStartDate(2019/05/02)
INSERT INTO project_modules 
	VALUES ('M8', 'P5','E3', '2019/08/10',null,null);     
    
-- Exercise 2: View
-- Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
-- ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- 				ET_IQ + ET_Gmath>=20
-- 				ET_IQ>=8
-- 				ET_Gmath>=8
-- 				ET_English>=18

USE quanlyfresher;

CREATE OR REPLACE VIEW v_fresher_ET_info AS
	SELECT Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes, VTI_Account
    FROM trainee
    WHERE (ET_IQ + ET_Gmath>=20) AND (ET_IQ>=8) AND (ET_Gmath>=8) AND (ET_English>=18);

SELECT * FROM v_fresher_ET_info;

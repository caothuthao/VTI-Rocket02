-- Question 1: Them it nhat 10 ban ghi vao table
INSERT INTO 
	Trainee ( Full_Name, 			Birth_Date, 	Gender, 	ET_IQ, 	ET_Gmath, 	ET_English, 	Training_Class, 	Evaluation_Notes, 	VTI_Account )
VALUES 		('Cao Thu Thao',		'1999/09/08',	'female', 	12,		15,			25,				'ABC123',			'ABCD1234',			'abc123'),
			('Cao Thi Trang',		'1999/11/15',	'female', 	12,		12,			25,				'ABC124',			'ABCD1234',			'abc124'),
            ('Nguyen Hong Nhung',	'1999/11/24',	'female', 	12,		12,			25,				'ABC125',			'ABCD1234',			'abc125'),
            ('Dinh Thi Nguyet',		'1999/12/23',	'female', 	12,		12,			25,				'ABC126',			'ABCD1234',			'abc126'),
            ('Bui van Tien',		'1999/12/18',	'male', 	12,		12,			25,				'ABC127',			'ABCD1234',			'abc127'),
            ('Ngo Trung Nhat',		'1000/10/01',	'male', 	12,		12,			25,				'ABC128',			'ABCD1234',			'abc128'),
            ('Nguyen Tat Thanh',	'1999/12/15',	'male', 	12,		12,			25,				'ABC129',			'ABCD1234',			'abc129'),
            ('Nguyen Viet Anh',		'1000/02/15',	'male', 	12,		12,			25,				'ABC130',			'ABCD1234',			'abc130'),
            ('Nguyen Dinh Minh',	'1999/04/01',	'male', 	10,		10,			25,				'ABC131',			'ABCD1234',			'abc131'),
            ('Pham Tien Dat',		'1999/05/15',	'male', 	12,		12,			25,				'ABC132',			'ABCD1234',			'abc132');
            
-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT 
	month(Birth_Date) as 'Thang sinh', group_concat(Full_Name) as 'Ho ten'
FROM 
	Trainee
GROUP BY 
	month(Birth_Date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: 
-- 			   tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT 
    *
FROM
    Trainee
WHERE
    LENGTH(Full_Name) = (SELECT 
            MAX(LENGTH(Full_Name))
        FROM
            Trainee);
   
-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là 
-- 				những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- 				ET_IQ + ET_Gmath>=20
-- 				ET_IQ>=8
-- 				ET_Gmath>=8
-- 				ET_English>=18

SELECT 
    *
FROM
    Trainee
WHERE
    ((ET_IQ + ET_Gmath) >= 20)
        AND (ET_IQ >= 8)
        AND (ET_Gmath >= 8)
        AND (ET_English >= 18);

-- Question 5: xóa thực tập sinh có TraineeID = 3          
DELETE FROM Trainee WHERE Trainee_ID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee 
SET 
    Training_Class = 2
WHERE
    Trainee_ID = 5;
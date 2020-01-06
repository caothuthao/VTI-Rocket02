DROP DATABASE IF EXISTS CUSTOMER;
CREATE DATABASE IF NOT EXISTS CUSTOMER;

USE CUSTOMER;

-- create tables:
-- table CUSTOMER
DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE IF NOT EXISTS CUSTOMER
(	CustomerID 					INT AUTO_INCREMENT PRIMARY KEY,
	Name						NVARCHAR(30) NOT NULL,
    Phone						CHAR(10),
    Email						CHAR(30),
    Address						NVARCHAR(50),
    Note						NVARCHAR(100)
);

INSERT INTO 
		CUSTOMER (Name,					Phone,				Email,						Address,		Note)
VALUES
				 ('Cao Thu Thao',		'0123456789',		'thaoctt0809@gmail.com',	'Ha Noi',		null),
                 ('Cao Thi Trang',		'0123456790',		'trangct0809@gmail.com',	'Hai Duong',	null),
                 ('Nguyen Hong Nhung',	'0123456791',		'nhungnt@gmail.com',		'Bac Ninh',		null),
                 ('Dinh Thi Nguyet',	'0123456792',		'nguyetdt9@gmail.com',		'Bac Ninh',		null),
                 ('Bui Van Tien',		'0123456793',		'tienbv@gmail.com',			'Thai Binh',	null),
                 ('Nguyen Viet Anh',	'0123456794',		'Vietanh@gmail.com',		'Ha Nam',		null),
                 ('Nguyen Dinh Minh',	'0123456795',		'dinhminhn9@gmail.com',		'Ha Noi',		null),
                 ('Nguyen Hong Tham',	'0123456796',		'thamnh@gmail.com',			'Ha Noi',		null),
                 ('Pham Tien Dat',		'0123456797',		'datpt@gmail.com',			'Nam Dinh',		null),
                 ('Ha Thu tra',			'0123456798',		'traht@gmail.com',	'		Ha Noi',		null);

-- table CAR
DROP TABLE IF EXISTS CAR;
CREATE TABLE IF NOT EXISTS CAR
(	CarID						CHAR(10) PRIMARY KEY,
	Maker						ENUM('HONDA','TOYOTA','NISSAN'),
    Model						VARCHAR(30) NOT NULL,
    Year						CHAR(5) NOT NULL,
    Color						VARCHAR(10) NOT NULL,
    Note						NVARCHAR(100)
);

INSERT INTO
		CAR (CarID,		Maker,		Model,		Year,		Color,		Note )
VALUES
			('C1',		'HONDA',	'HonDa1',	'2002',		'black',	null),
            ('C2',		'TOYOTA',	'Toyota1',	'2003',		'white',	null),
            ('C3',		'NISSAN',	'Nissan1',	'2004',		'yellow',	null),
            ('C4',		'HONDA',	'HonDa2',	'2005',		'black',	null),
            ('C5',		'TOYOTA',	'Toyota2',	'2006',		'yellow',	null),
            ('C6',		'NISSAN',	'Nissan2',	'2002',		'black',	null),
            ('C7',		'HONDA',	'HonDa3',	'2003',		'black',	null),
            ('C8',		'TOYOTA',	'Toyota3',	'2004',		'yellow',	null),
            ('C9',		'NISSAN',	'Nissan2',	'2005',		'black',	null),
            ('C10',		'HONDA',	'HonDa4',	'2003',		'yellow',	null);
-- table CAR_ORDER
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE IF NOT EXISTS CAR_ORDER
(	OrderID						INT AUTO_INCREMENT PRIMARY KEY,
	CustomerID					INT NOT NULL,
    CarID						CHAR(10) NOT NULL,
    Amount						INT DEFAULT 1,
    SalePrice					DECIMAL(8,2),
    OrderDate					DATETIME NOT NULL,
    DeliveryDate				DATETIME NOT NULL,
    DeliveryAddress				NVARCHAR(50) NOT NULL,
    Status						ENUM('0','1','2') DEFAULT '0',
    Note						NVARCHAR(100),
    FOREIGN KEY(CustomerID) REFERENCES CUSTOMER(CustomerID),
	FOREIGN KEY(CarID) REFERENCES CAR(CarID)
);

INSERT INTO
		CAR_ORDER	(CustomerID,		CarID,	Amount,		SalePrice,		OrderDate,		DeliveryDate,		DeliveryAddress,	Status,	Note)
VALUES
					(1,					'C1',	1,			800000,			'2019/01/01',	'2019/01/02',		'Ha Noi',			'1',	null),
                    (2,					'C2',	1,			500000.12,		'2019/02/01',	'2019/02/02',		'Ha Noi',			'0',	null),
                    (3,					'C1',	1,			800000,			'2019/01/15',	'2019/01/17',		'Ha Noi',			'1',	null),
                    (4,					'C2',	1,			500000.12,		'2019/03/01',	'2019/03/02',		'Ha Noi',			'0',	null),
                    (5,					'C3',	1,			900000,			'2019/01/20',	'2019/01/22',		'Thai Binh',		'2',	null),
                    (6,					'C4',	1,			700000,			'2019/04/01',	'2019/04/02',		'Ha Noi',			'2',	null),
                    (7,					'C5',	1,			600000,			'2019/01/22',	'2019/01/25',		'Ha Noi',			'1',	null),
                    (8,					'C5',	1,			600000,			'2019/02/20',	'2019/02/25',		'Ha Noi',			'0',	null),
                    (9,					'C8',	1,			800000,			'2019/02/21',	'2019/02/22',		'Ha Noi',			'0',	null),
                    (10,				'C9',	1,			550000,			'2019/01/10',	'2019/01/12',		'Ha Noi',			'1',	null),
                    (1,					'C5',	1,			600000,			'2019/05/01',	'2019/05/02',		'Ha Noi',			'0',	null),
                    (2,					'C5',	1,			600000,			'2019/03/01',	'2019/03/02',		'Ha Noi',			'0',	null),
                    (3,					'C5',	1,			600000,			'2019/01/20',	'2019/01/20',		'Ha Noi',			'1',	null),
                    (1,					'C8',	1,			800000,			'2019/05/15',	'2019/05/20',		'Ha Noi',			'0',	null),
                    (2,					'C8',	1,			800000,			'2019/02/23',	'2019/02/25',		'Ha Noi',			'2',	null);


-- Question b: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
			-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT 
    c.CustomerID, c.name, SUM(Amount) AS 'so luong oto da mua'
FROM
    CUSTOMER c
        JOIN
    CAR_ORDER co ON c.CustomerID = co.CustomerID
WHERE co.Status = '1'
GROUP BY CustomerID
ORDER BY SUM(Amount) ASC;

-- Question c: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
DROP FUNCTION IF EXISTS f_return_makername;
DELIMITER $$
CREATE FUNCTION f_return_makername() RETURNS CHAR(6)
BEGIN
	DECLARE MakerName CHAR(6);
    SELECT c.Maker INTO MakerName
    FROM CAR c
		JOIN CAR_ORDER co ON c.CarID = co.CarID
    GROUP BY c.Maker
    HAVING (year(co.DeliveryDate) = year(current_date())) AND (co.Status = '1') AND (sum(co.Amount) = (SELECT max(sum(co.Amount))
																					FROM CAR c 
																							JOIN CAR_ORDER co ON c.CarID = co.CarID
																					GROUP BY (c.Maker)
																					HAVING (year(co.DeliveryDate) = year(current_date())) AND (co.Status = '1')));
	RETURN MakerName;

END$$
DELIMITER ;

SELECT f_return_makername();


-- Khi ve nha em lam them theo procedure a
DROP PROCEDURE IF EXISTS p_return_makername;
DELIMITER $$
CREATE PROCEDURE p_return_makername()
BEGIN
	SELECT c.Maker, sum(co.Amount)
    FROM car c 
		JOIN car_order co ON c.CarID = co.CarID
    WHERE year(co.DeliveryDate) = year(current_date()) AND co.Status = '1'
    ORDER BY sum(co.Amount) DESC
    LIMIT 1;

END$$
DELIMITER ;

CALL p_return_makername();

-- Question d: Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS p_delete_order;
DELIMITER $$
CREATE PROCEDURE p_delete_order()
BEGIN
	DELETE FROM CAR_ORDER
    WHERE Status = '2' AND year(OrderDate) < year(current_date());
    
    SELECT row_count();
    
END$$
DELIMITER ;

CALL p_delete_order();

-- Question e: Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- 				hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất
DROP PROCEDURE IF EXISTS p_order_info;
DELIMITER $$
CREATE PROCEDURE p_order_info(IN P_CustomerID INT)
BEGIN
	SELECT c.Name, co.OrderID, co.Amount as'so luong oto', ca.Maker as 'ten hang san xuat'
    FROM CAR_ORDER co
			JOIN customer c ON co.CustomerID = c.CustomerID
            JOIN CAR ca	ON co.CarID = ca.CarID
	WHERE co.CustomerID = P_CustomerID;
    
END$$
DELIMITER ;

CALL p_order_info(1);

-- Question f: Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS trig_invalid_info;
DELIMITER $$
CREATE TRIGGER trig_invalid_info
BEFORE INSERT ON CAR_ORDER
FOR EACH ROW
BEGIN
	IF (NEW.DeliveryDate > (NEW.OrderDate + 15 )) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Can not insert!';
	END IF;
END$$
DELIMITER ;

-- insert data
INSERT INTO
	CAR_ORDER 	(CustomerID,	CarID,	Amount,		SalePrice,		OrderDate,		DeliveryDate,		DeliveryAddress,	Status,	Note)
VALUES
				(1,				'C5',	1,			300000,			'2019/02/01',	'2019/02/20',		'Ha Noi',			null, null );

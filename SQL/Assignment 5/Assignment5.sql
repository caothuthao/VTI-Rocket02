USE adventureworks;
-- Exercise 1: Subquery
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.
-- C1: Dung Join
SELECT 
    p.Name
FROM
    product p
        JOIN
    productsubcategory ps ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE
    ps.name = 'Saddles';
 
-- C2: Dung subquery
SELECT 
    p.Name
FROM
    product p
WHERE ProductSubcategoryID IN 		-- vi ket qua cua subquery ben duoi tra ve 1 bang chua ID cua ten Saddles
		(SELECT 
            ps.ProductSubcategoryID
        FROM
            productsubcategory ps
        WHERE
            ps.Name = 'Saddles');
          
-- Q2:  Thay đổi câu Query 1 để lấy được kết quả sau: 
/* Name
----------------------------
Water Bottle - 30 oz.
Mountain Bottle Cage
2
Road Bottle Cage
LL Bottom Bracket
ML Bottom Bracket
HL Bottom Bracket
(6 row(s) affected) */

SELECT 
    p.Name
FROM
    product p
WHERE ProductSubcategoryID IN 		-- vi ket qua cua subquery ben duoi tra ve 1 bang chua ID cua ten Saddles
		(SELECT 
            ps.ProductSubcategoryID
        FROM
            productsubcategory ps
        WHERE
            ps.Name LIKE 'Bo%')
ORDER BY p.name DESC;

-- Q3: Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3)        
SELECT name
FROM
    product
WHERE
	ProductSubcategoryID = (SELECT 
								ProductSubcategoryID
							FROM
								productsubcategory
							WHERE
								Name LIKE 'Touring Bikes')
    AND ListPrice = (	SELECT 
						MIN(ListPrice)
					FROM
						product
					WHERE
						ProductSubcategoryID = (SELECT 
													ProductSubcategoryID
												FROM
													productsubcategory
												WHERE
													Name LIKE 'Touring Bikes'));
           
-- Exercise 2: JOIN nhiều bảng
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database.
SELECT 
    cr.Name AS 'Country', sp.Name AS 'Province'
FROM
    countryregion cr
        JOIN
    stateprovince sp ON sp.CountryRegionCode = cr.CountryRegionCode;
    
-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT 
    cr.Name AS 'Country', sp.Name AS 'Province'
FROM
    countryregion cr
        JOIN
    stateprovince sp ON sp.CountryRegionCode = cr.CountryRegionCode
WHERE
    cr.Name IN ('Germany' , 'Canada')
ORDER BY cr.Name;

/* Question 3: We want information about orders. From the Sales.SalesOrderHeader table we want the SalesOrderID, OrderDate and 
SalesPersonIDcolums. From the Sales.SalesPerson table we want the BusinessEntityID (which identifies the sales person), Bonus and 
 the SalesYTD (how much this person sold for yet this year) columns. */
SELECT 
    soh.SalesOrderID, soh.OrderDate, soh.SalesPersonID, sp.SalesPersonID AS 'BusinessEntityID', sp.Bonus, sp.SalesYTD
FROM
    salesorderheader soh
        JOIN
    salesperson sp ON soh.SalesPersonID = sp.SalesPersonID;
  
-- Question 4: Sử dụng câu query, thêm cột JobTitle va xóa cột SalesPersonID và BusinessEntityID.
SELECT 
    soh.SalesOrderID, soh.OrderDate, e.Title, sp.Bonus, sp.SalesYTD
FROM
    salesperson sp
        JOIN
    salesorderheader soh ON soh.SalesPersonID = sp.SalesPersonID
        JOIN
    employee e ON sp.SalesPersonID = e.EmployeeID;
   
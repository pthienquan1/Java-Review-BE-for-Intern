create database DepartmentManagement;
use DepartmentManagement;

-- Create table Group
DROP TABLE IF EXISTS 	`Department`;
CREATE TABLE IF NOT EXISTS `Department` (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 			NVARCHAR(50) NOT NULL UNIQUE
);

-- =============================================
-- INSERT DATA 
-- =============================================

INSERT INTO `Department` (`name`)

VALUE				('Sale'),			
					('Marketting'),			
					('BOD');

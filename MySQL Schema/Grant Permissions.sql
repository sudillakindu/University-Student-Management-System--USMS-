-- Use the database
USE usms;

-- Create a User
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin@123';

-- Grant Permissions on specific tables to the user
GRANT INSERT, UPDATE, DELETE, SELECT ON usms.Students TO 'admin'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON usms.Courses TO 'admin'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON usms.Enrollments TO 'admin'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON usms.Grades TO 'admin'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON usms.Attendance TO 'admin'@'localhost';

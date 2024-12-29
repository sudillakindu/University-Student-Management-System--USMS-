-- Create the database
CREATE DATABASE usms;
USE usms;

-- Table for storing student details
CREATE TABLE students (
                          studentID           CHAR(5)         PRIMARY KEY,
                          name                VARCHAR(100)    NOT NULL,
                          dob                 DATE            NOT NULL,
                          address             VARCHAR(255)    NOT NULL,
                          contactNumber       VARCHAR(15)     NOT NULL,
                          enrollmentYear      YEAR            NOT NULL
);

-- Table for storing course details
CREATE TABLE courses (
                         courseID            CHAR(5)         PRIMARY KEY,
                         courseName          VARCHAR(100)    NOT NULL,
                         credits             INT             NOT NULL,
                         duration            VARCHAR(25)     NOT NULL,
                         faculty             VARCHAR(100)    NOT NULL
);

-- Table for managing student enrollments in courses
CREATE TABLE enrollments (
                             enrollmentID        CHAR(5)         PRIMARY KEY,
                             studentID           CHAR(5)         NOT NULL,
                             courseID            CHAR(5)         NOT NULL,
                             enrollmentDate      DATE            NOT NULL,
                             FOREIGN KEY (studentID)     REFERENCES students(studentID),
                             FOREIGN KEY (courseID)      REFERENCES courses(courseID)
);

-- Table for managing student grades for courses
CREATE TABLE grades (
                        gradeID             CHAR(5)         PRIMARY KEY,
                        studentID           CHAR(5)         NOT NULL,
                        courseID            CHAR(5)         NOT NULL,
                        gpa                 DECIMAL(3,2)    NOT NULL,
                        FOREIGN KEY (studentID)     REFERENCES Students(studentID),
                        FOREIGN KEY (courseID)      REFERENCES Courses(courseID)
);

-- Table for managing student attendance in courses
CREATE TABLE attendance (
                            attendanceID        CHAR(5)         PRIMARY KEY,
                            studentID           CHAR(5)         NOT NULL,
                            courseID            CHAR(5)         NOT NULL,
                            date                DATE            NOT NULL,
                            status              VARCHAR(7)      NOT NULL CHECK (status in ('Present', 'Absent')),
                            FOREIGN KEY (studentID)     REFERENCES Students(studentID),
                            FOREIGN KEY (courseID)      REFERENCES Courses(courseID)
);



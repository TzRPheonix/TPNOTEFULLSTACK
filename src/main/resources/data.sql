-- Create Employee table
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    num_Id VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_Of_Birth DATE NOT NULL,
    phone VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    salary DOUBLE NOT NULL CHECK (salary >= 1),
    date_Of_Start_Job DATE NOT NULL,
    date_Of_End_Job DATE NOT NULL,
    observation TEXT NOT NULL
    );

-- Create Candidate table
CREATE TABLE IF NOT EXISTS candidate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    num_Id VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_Of_Birth DATE NOT NULL,
    phone VARCHAR(255) NOT NULL,
    domain VARCHAR(255) NOT NULL,
    grade INT NOT NULL CHECK (grade >= 1 AND grade <= 10),
    date_Of_Job_Meeting DATE NOT NULL,
    observation TEXT NOT NULL
    );

-- Create Absence table
CREATE TABLE IF NOT EXISTS absence (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     absence_Date DATE NOT NULL,
     employee_id BIGINT,
     FOREIGN KEY (employee_id) REFERENCES employee(id)
    );

-- Create Leave table
CREATE TABLE IF NOT EXISTS leave (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     start_Date DATE NOT NULL,
     end_Date DATE NOT NULL,
     employee_id BIGINT,
     FOREIGN KEY (employee_id) REFERENCES employee(id)
    );

-- Insert an employee
INSERT INTO employee (name, num_Id, address, email, date_Of_Birth, phone, position, salary, date_Of_Start_Job, date_Of_End_Job, observation)
VALUES ('John Doe', '123456', '123 Main St', 'johndoe@example.com', '1980-01-01', '123-456-7890', 'Manager', 50000, '2020-01-01', '2025-01-01', 'Bon employé');

-- Insert a leave for the employee
INSERT INTO leave (start_Date, end_Date, employee_id)
VALUES ('2023-01-01', '2023-01-31', 1);

-- Insert a leave for the employee
INSERT INTO absence (absence_Date, employee_id)
VALUES ('2023-01-31', 1);

-- Insert a candidate
INSERT INTO candidate (name, num_Id, address, email, date_Of_Birth, phone, domain, grade, date_Of_Job_Meeting, observation)
VALUES ('Jane Doe', '654321', '456 Main St', 'janedoe@example.com', '1985-01-01', '987-654-3210', 'Java', 8, '2023-01-01', 'Bon candidat');
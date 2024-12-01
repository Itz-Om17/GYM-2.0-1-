USE  GYM;
CREATE TABLE trainers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    experience INT NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(255)
);
ALTER TABLE trainers
ADD COLUMN specialization VARCHAR(100), -- Adds the specialization column
ADD COLUMN shift_timing VARCHAR(50);    -- Adds the shift timing column
UPDATE trainers
SET specialization = 'Weight Loss',
    shift_timing = '6am-10am'
WHERE id = 2;

SELECT * FROM trainers;
DROP TABLE trainers;

INSERT INTO trainers (username, password, name, age, gender, experience, phone, email, address, specialization, shift_timing) VALUES
-- Shift: 6:00 AM - 10:00 AM
('u1', 'p1', 'John Doe', 28, 'Male', 5, '123-456-7890', 'johndoe@example.com', '123 Main St, City', 'Weight Loss', '6:00 AM - 10:00 AM'),
('u2', 'p2', 'Jane Smith', 34, 'Female', 8, '123-456-7891', 'janesmith@example.com', '456 Elm St, City', 'General Workout', '6:00 AM - 10:00 AM'),
('u3', 'p3', 'Mike Brown', 29, 'Male', 3, '123-456-7892', 'mikebrown@example.com', '789 Oak St, City', 'Improve Endurance', '6:00 AM - 10:00 AM'),
('u4', 'p4', 'Emily Davis', 40, 'Female', 10, '123-456-7893', 'emilydavis@example.com', '321 Pine St, City', 'Enhanced Flexibility', '6:00 AM - 10:00 AM'),
('u5', 'p5', 'David Wilson', 37, 'Male', 7, '123-456-7894', 'davidwilson@example.com', '654 Cedar St, City', 'Muscle Gain', '6:00 AM - 10:00 AM'),

-- Shift: 10:00 AM - 2:00 PM
('u6', 'p6', 'Sarah Johnson', 25, 'Female', 2, '123-456-7895', 'sarahjohnson@example.com', '987 Maple St, City', 'Weight Loss', '10:00 AM - 2:00 PM'),
('u7', 'p7', 'Chris Lee', 31, 'Male', 4, '123-456-7896', 'chrislee@example.com', '159 Birch St, City', 'General Workout', '10:00 AM - 2:00 PM'),
('u8', 'p8', 'Jessica Taylor', 45, 'Female', 12, '123-456-7897', 'jessicataylor@example.com', '753 Spruce St, City', 'Improve Endurance', '10:00 AM - 2:00 PM'),
('u9', 'p9', 'Matthew Clark', 26, 'Male', 6, '123-456-7898', 'matthewclark@example.com', '951 Walnut St, City', 'Enhanced Flexibility', '10:00 AM - 2:00 PM'),
('u10', 'p10', 'Ashley Thompson', 33, 'Female', 5, '123-456-7899', 'ashleythompson@example.com', '369 Fir St, City', 'Muscle Gain', '10:00 AM - 2:00 PM'),

-- Shift: 2:00 PM - 6:00 PM
('u11', 'p11', 'Joshua Harris', 24, 'Male', 1, '123-456-7900', 'joshharris@example.com', '159 Poplar St, City', 'Weight Loss', '2:00 PM - 6:00 PM'),
('u12', 'p12', 'Megan Hall', 39, 'Female', 11, '123-456-7901', 'meganhall@example.com', '951 Ash St, City', 'General Workout', '2:00 PM - 6:00 PM'),
('u13', 'p13', 'Brian Young', 30, 'Male', 4, '123-456-7902', 'brianyoung@example.com', '258 Maple St, City', 'Improve Endurance', '2:00 PM - 6:00 PM'),
('u14', 'p14', 'Laura Allen', 27, 'Female', 3, '123-456-7903', 'lauraallen@example.com', '654 Walnut St, City', 'Enhanced Flexibility', '2:00 PM - 6:00 PM'),
('u15', 'p15', 'Daniel King', 44, 'Male', 8, '123-456-7904', 'danielking@example.com', '753 Birch St, City', 'Muscle Gain', '2:00 PM - 6:00 PM'),

-- Shift: 6:00 PM - 10:00 PM
('u16', 'p16', 'Sara Wright', 32, 'Female', 6, '123-456-7905', 'sarawright@example.com', '369 Fir St, City', 'Weight Loss', '6:00 PM - 10:00 PM'),
('u17', 'p17', 'Charles Scott', 35, 'Male', 10, '123-456-7906', 'charlesscott@example.com', '159 Pine St, City', 'General Workout', '6:00 PM - 10:00 PM'),
('u18', 'p18', 'Emily Green', 41, 'Female', 9, '123-456-7907', 'emilygreen@example.com', '951 Oak St, City', 'Improve Endurance', '6:00 PM - 10:00 PM'),
('u19', 'p19', 'Brian Baker', 38, 'Male', 5, '123-456-7908', 'brianbaker@example.com', '753 Maple St, City', 'Enhanced Flexibility', '6:00 PM - 10:00 PM'),
('u20', 'p20', 'Anna Martinez', 26, 'Female', 3, '123-456-7909', 'annamartinez@example.com', '321 Cedar St, City', 'Muscle Gain', '6:00 PM - 10:00 PM');

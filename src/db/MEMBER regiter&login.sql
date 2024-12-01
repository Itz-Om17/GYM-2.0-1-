CREATE DATABASE GYM;  
USE GYM;
CREATE TABLE members (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    weight DECIMAL(5,2),
    height_ft INT,
    height_inch INT,
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100),
    goal VARCHAR(100),
    daysperweek INT(1),
    timing VARCHAR(50),
    membership_plan VARCHAR(50),   -- New column for the membership plan type
    membership_duration INT        -- New column for the membership duration in months
);


-- Insert members for Trainer with username 'u1'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m1', 'p1', 'Alice Walker', 30, 'Female', 65.5, 5, 4, '123 Oak St', '987-654-3210', 'alice@example.com', 'Weight Loss', 4, '6:00 AM - 10:00 AM'),
('m2', 'p2', 'Michael Lee', 29, 'Male', 78.0, 6, 0, '456 Elm St', '987-654-3211', 'michael@example.com', 'Weight Loss', 4, '6:00 AM - 10:00 AM');

-- Insert members for Trainer with username 'u2'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m3', 'p3', 'Jessica Williams', 25, 'Female', 58.0, 5, 2, '789 Maple St', '987-654-3212', 'jessica@example.com', 'General Workout', 5, '6:00 AM - 10:00 AM'),
('m4', 'p4', 'Robert Brown', 32, 'Male', 85.3, 5, 10, '159 Pine St', '987-654-3213', 'robert@example.com', 'General Workout', 5, '6:00 AM - 10:00 AM');

-- Insert members for Trainer with username 'u3'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m5', 'p5', 'Kevin Adams', 40, 'Male', 92.1, 6, 1, '951 Birch St', '987-654-3214', 'kevin@example.com', 'Improve Endurance', 5, '6:00 AM - 10:00 AM'),
('m6', 'p6', 'Nancy Harris', 33, 'Female', 72.0, 5, 7, '753 Cedar St', '987-654-3215', 'nancy@example.com', 'Improve Endurance', 4, '6:00 AM - 10:00 AM');

-- Insert members for Trainer with username 'u4'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m7', 'p7', 'Emily Scott', 27, 'Female', 55.0, 5, 5, '654 Fir St', '987-654-3216', 'emilyscott@example.com', 'Enhanced Flexibility', 6, '6:00 AM - 10:00 AM'),
('m8', 'p8', 'David Johnson', 31, 'Male', 82.5, 5, 11, '321 Walnut St', '987-654-3217', 'davidj@example.com', 'Enhanced Flexibility', 4, '6:00 AM - 10:00 AM');

-- Insert members for Trainer with username 'u5'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m9', 'p9', 'Brian Taylor', 34, 'Male', 88.5, 6, 2, '159 Ash St', '987-654-3218', 'brian.t@example.com', 'Muscle Gain', 5, '6:00 AM - 10:00 AM'),
('m10', 'p10', 'Sandra Parker', 29, 'Female', 63.4, 5, 6, '753 Maple St', '987-654-3219', 'sandra.p@example.com', 'Muscle Gain', 4, '6:00 AM - 10:00 AM');

-- Insert members for Trainer with username 'u6'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m11', 'p11', 'Lily Brooks', 26, 'Female', 60.0, 5, 3, '951 Oak St', '987-654-3220', 'lilyb@example.com', 'Weight Loss', 6, '10:00 AM - 2:00 PM'),
('m12', 'p12', 'Jack Nelson', 28, 'Male', 80.0, 6, 1, '654 Cedar St', '987-654-3221', 'jackn@example.com', 'Weight Loss', 5, '10:00 AM - 2:00 PM');

-- Insert members for Trainer with username 'u7'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m13', 'p13', 'Megan Carter', 33, 'Female', 68.0, 5, 6, '123 Pine St', '987-654-3222', 'meganc@example.com', 'General Workout', 4, '10:00 AM - 2:00 PM'),
('m14', 'p14', 'Charles Davis', 35, 'Male', 90.0, 6, 2, '987 Maple St', '987-654-3223', 'charlesd@example.com', 'General Workout', 5, '10:00 AM - 2:00 PM');

-- Insert members for Trainer with username 'u8'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m15', 'p15', 'Linda White', 29, 'Female', 66.0, 5, 4, '321 Birch St', '987-654-3224', 'lindaw@example.com', 'Improve Endurance', 5, '10:00 AM - 2:00 PM'),
('m16', 'p16', 'George Miller', 38, 'Male', 85.0, 6, 0, '654 Oak St', '987-654-3225', 'georgem@example.com', 'Improve Endurance', 4, '10:00 AM - 2:00 PM');

-- Insert members for Trainer with username 'u9'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m17', 'p17', 'Laura Bell', 32, 'Female', 70.0, 5, 7, '951 Elm St', '987-654-3226', 'laurab@example.com', 'Enhanced Flexibility', 6, '10:00 AM - 2:00 PM'),
('m18', 'p18', 'Samuel Cooper', 40, 'Male', 89.0, 6, 1, '753 Maple St', '987-654-3227', 'samuelc@example.com', 'Enhanced Flexibility', 4, '10:00 AM - 2:00 PM');

-- Insert members for Trainer with username 'u10'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m19', 'p19', 'Betty Adams', 37, 'Female', 75.5, 5, 8, '159 Fir St', '987-654-3228', 'bettya@example.com', 'Muscle Gain', 5, '10:00 AM - 2:00 PM'),
('m20', 'p20', 'Henry Lee', 41, 'Male', 92.0, 6, 3, '321 Oak St', '987-654-3229', 'henryl@example.com', 'Muscle Gain', 5, '10:00 AM - 2:00 PM');

-- Insert members for Trainer with username 'u11'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m21', 'p21', 'Oliver Green', 29, 'Male', 82.5, 5, 11, '753 Walnut St', '987-654-3230', 'oliverg@example.com', 'Weight Loss', 4, '2:00 PM - 6:00 PM'),
('m22', 'p22', 'Charlotte Young', 34, 'Female', 69.2, 5, 5, '456 Oak St', '987-654-3231', 'charlottey@example.com', 'Weight Loss', 5, '2:00 PM - 6:00 PM');

-- Insert members for Trainer with username 'u12'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m23', 'p23', 'Sophia Hill', 30, 'Female', 68.0, 5, 6, '951 Elm St', '987-654-3232', 'sophiah@example.com', 'General Workout', 6, '2:00 PM - 6:00 PM'),
('m24', 'p24', 'Liam Brooks', 39, 'Male', 85.4, 6, 1, '654 Fir St', '987-654-3233', 'liamb@example.com', 'General Workout', 5, '2:00 PM - 6:00 PM');

-- Insert members for Trainer with username 'u13'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m25', 'p25', 'Isabella Baker', 35, 'Female', 67.0, 5, 7, '123 Maple St', '987-654-3234', 'isabellab@example.com', 'Improve Endurance', 4, '2:00 PM - 6:00 PM'),
('m26', 'p26', 'James Turner', 42, 'Male', 93.0, 6, 2, '159 Pine St', '987-654-3235', 'jamest@example.com', 'Improve Endurance', 4, '2:00 PM - 6:00 PM');

-- Insert members for Trainer with username 'u14'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m27', 'p27', 'Grace White', 28, 'Female', 63.0, 5, 4, '951 Fir St', '987-654-3236', 'gracew@example.com', 'Enhanced Flexibility', 6, '2:00 PM - 6:00 PM'),
('m28', 'p28', 'William Morgan', 31, 'Male', 88.0, 6, 0, '753 Elm St', '987-654-3237', 'williamm@example.com', 'Enhanced Flexibility', 4, '2:00 PM - 6:00 PM');

-- Insert members for Trainer with username 'u15'
INSERT INTO members (username, password, name, age, gender, weight, height_ft, height_inch, address, phone, email, goal, daysperweek, timing)
VALUES 
('m29', 'p29', 'Emily Evans', 24, 'Female', 57.5, 5, 3, '456 Oak St', '987-654-3238', 'emilye@example.com', 'Muscle Gain', 4, '2:00 PM - 6:00 PM'),
('m30', 'p30', 'Jacob Harris', 27, 'Male', 80.0, 6, 0, '951 Birch St', '987-654-3239', 'jacobh@example.com', 'Muscle Gain', 5, '2:00 PM - 6:00 PM');




---------------session table 



CREATE TABLE Sessions (
    SessionID INT AUTO_INCREMENT PRIMARY KEY,
    MemberID INT NOT NULL,
    TrainerID INT NOT NULL,
    SessionDate TIMESTAMP NOT NULL,
    FOREIGN KEY (MemberID) REFERENCES members(id),
    FOREIGN KEY (TrainerID) REFERENCES trainers(id)
);

select * from Sessions;
drop table Sessions;


USE GYM;
CREATE TABLE Membership (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plan_name VARCHAR(50),
    price DECIMAL(10, 2),
    duration_months INT,
    free_classes INT,
    consultations INT,
    discount_percent DECIMAL(5, 2),
    additional_benefits TEXT
);
INSERT INTO Membership (plan_name, price, duration_months, free_classes, consultations, discount_percent, additional_benefits)
VALUES 
('Basic', 1500, 1, 1, 0, 0, 'Full access to gym facilities'),
('Standard', 3000, 3, 3, 1, 5, 'Full access, 1 free consultation, 5% discount'),
('Premium', 5000, 6, 6, 3, 10, 'Priority booking, locker service, 3 free training sessions'),
('Yearly', 8000, 12, -1, 6, 15, 'Unlimited classes, 6 training sessions, VIP access, free guest pass');


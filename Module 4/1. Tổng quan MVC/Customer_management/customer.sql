create database demo_customer;
use demo_customer;

create table customer_info (
	id INT auto_increment primary key,
    name varchar(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL
);

INSERT INTO customer_info (Name, Email, Address) VALUES
('Nguyen Khac Nhat', 'nhat@codegym.vn', 'Hà Nội'),
('Dang Huy Hoa', 'hoa.dang@codegym.vn', 'Đà Nẵng'),
('Le Thi Chau', 'chau.le@codegym.vn', 'Hà Nội'),
('Nguyen Thuy Duong', 'duong.nguyen@codegym.vn', 'Sài Gòn'),
('CodeGym', 'codegym@codegym.vn', 'Việt Nam');
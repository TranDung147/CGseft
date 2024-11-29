Create database Room_management;
use Room_management;

CREATE TABLE PaymentMethod (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenant_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    start_date DATE NOT NULL,
    payment_method_id INT NOT NULL,
    notes TEXT,
    FOREIGN KEY (payment_method_id) REFERENCES PaymentMethod(id)
);

-- Thêm các phương thức thanh toán mẫu
INSERT INTO PaymentMethod (name) VALUES ('Theo tháng');
INSERT INTO PaymentMethod (name) VALUES ('Theo quý');
INSERT INTO PaymentMethod (name) VALUES ('Theo năm');

-- Thêm các phòng mẫu
INSERT INTO Room (tenant_name, phone_number, start_date, payment_method_id, notes)
VALUES ('Nguyễn Văn A', '0123456789', '2023-08-01', 1, 'Phòng có điều hòa');

INSERT INTO Room (tenant_name, phone_number, start_date, payment_method_id, notes)
VALUES ('Nguyễn Văn B', '0987654321', '2023-09-15', 2, 'Phòng không có điều hòa');

INSERT INTO Room (tenant_name, phone_number, start_date, payment_method_id, notes)
VALUES ('Nguyễn Văn C', '0123344556', '2023-10-01', 3, 'Phòng có điều hòa');

select * from PaymentMethod;
select * from Room;
-- Lấy tất cả các phòng---------------------------------------------------
SELECT r.id, r.tenant_name, r.phone_number, r.start_date, r.payment_method_id, p.name, r.notes FROM Room r INNER JOIN PaymentMethod p ON r.payment_method_id = p.id Order by r.id;
-- Xóa một phòng theo ID

DELETE FROM Room WHERE id = 1;
-- Tìm kiếm phòng theo tên người thuê hoặc số điện thoại
SELECT Room.id, tenant_name, phone_number, start_date, PaymentMethod.name AS payment_method, notes
FROM Room
JOIN PaymentMethod ON Room.payment_method_id = PaymentMethod.id
WHERE tenant_name LIKE '%Nguyen%' OR phone_number LIKE '%0123%';
-- Cập nhật thông tin một phòng
UPDATE Room
SET tenant_name = 'Nguyễn Văn D', phone_number = '0987111222', notes = 'Cập nhật ghi chú'
WHERE id = 2;
-- Thêm một phương thức thanh toán mới
INSERT INTO PaymentMethod (name) VALUES ('Theo tuần');


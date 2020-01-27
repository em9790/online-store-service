CREATE TABLE category (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) ,
description VARCHAR(250) ,
image_url VARCHAR(50),
is_active BOOLEAN,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO category (name,description,image_url,is_active)
VALUES ('Laptop', 'This is description for Laptop category','Laptop.jpeg',true);

INSERT INTO category (name,description,image_url,is_active)
VALUES ('Television', 'This is description for Television category','Television.jpeg',true);

INSERT INTO category (name,description,image_url,is_active)
VALUES ('Mobile', 'This is description for Mobile category','Mobile.jpeg',true);

CREATE TABLE user_detail (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) ,
last_name VARCHAR(50) ,
role VARCHAR(50) ,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
is_active BOOLEAN,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO user_detail
(first_name,last_name,role, enabled,password,email,contact_number)
VALUES ('Elnaz', 'Mansouri','ADMIN',true,'admin','EM@gmail.com','09124444444');

INSERT INTO user_detail
(first_name,last_name,role, enabled,password,email,contact_number)
VALUES ('Sara', 'Sameti','SUPPLIER',true,'123456','SS@gmail.com','09125555555');

INSERT INTO user_detail
(first_name,last_name,role, enabled,password,email,contact_number)
VALUES ('Arash', 'Farahani','SUPPLIER',true,'123456','AF@gmail.com','09127777777');

CREATE TABLE product (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
code VARCHAR(20) ,
name VARCHAR(50) ,
brand VARCHAR(50) ,
description VARCHAR(250) ,
unit_price DECIMAL (10,2),
quantity INT,
category_id INT UNSIGNED,
supplier_id INT UNSIGNED,
is_active BOOLEAN,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PUSLDIIDOSOKX', 'Google Pixel','qoogle','This is one of the best android smart phone available in the market right now!',57000,5,true,3,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PUSLDIIDOSWDX', 'Macbook Pro','apple','This is one of the best android smart phone available in the market right now!',54000,5,true,3,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PUSLDIIDOSOPX', 'Dell Latitude E6510','dell','This is one of the best android smart phone available in the market right now!',48000,5,true,3,2);
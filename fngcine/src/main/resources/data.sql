INSERT INTO fng_db.roles (name) VALUES ('ADMIN');
INSERT INTO fng_db.roles (name) VALUES ('USER');

INSERT INTO fng_db.deliveries (label, shipping_fee) VALUES ('STANDART', 2.5);
INSERT INTO fng_db.deliveries (label, shipping_fee) VALUES ('EXPRESS', 7.5);

INSERT INTO fng_db.users (email, first_name, last_name, password, roles_id) VALUES ('johndoe@mail.com', 'Doe', 'John', 'JohnD22@', '1');
INSERT INTO fng_db.users (email, first_name, last_name, password, roles_id) VALUES ('johndoeUser@mail.com', 'DoeUser', 'JohnUser', 'JohnD22User@', '2');

INSERT INTO fng_db.products (description, genre, label, qty_stock, unit_price, url_img) VALUES ('blablabla', 'drame', 'film qui fait pleurer', '2', '8', NULL);
INSERT INTO fng_db.products (description, genre, label, qty_stock, unit_price, url_img) VALUES ('blablabla', 'comedie', 'film qui fait rire', '10', '5', NULL);

INSERT INTO fng_db.orders (delivery_address, order_date, receiver, total_price, delivery_id, user_id) VALUES ('5 rue des roses\r\n75016 Paris', '2022-01-05', 'Doe John', '30', '1', '1');
INSERT INTO fng_db.orders (delivery_address, order_date, receiver, total_price, delivery_id, user_id) VALUES ('5 rue des roses\r\n75016 Paris', '2022-01-07', 'Doe John', '250', '1', '1');
INSERT INTO fng_db.orders (delivery_address, order_date, receiver, total_price, delivery_id, user_id) VALUES ('7 rue des paquerettes\r\n75008 Paris', '2022-01-07', 'DoeUser JohnUser', '50', '1', '2');
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO deliveries (id, label, shipping_fee) VALUES (1, 'STANDART', 2.5);
INSERT INTO deliveries (id, label, shipping_fee) VALUES (2, 'EXPRESS', 7.5);

INSERT INTO users (id, email, first_name, last_name, password, roles_id) VALUES (1, 'johndoe@mail.com', 'Doe', 'John', 'JohnAdmin22@', 1);
INSERT INTO users (id, email, first_name, last_name, password, roles_id) VALUES (2, 'alice@mail.com', 'Jim', 'alice', 'ALiceUser22@', 2);
INSERT INTO users (id, email, first_name, last_name, password, roles_id) VALUES (3, 'ctommen0@cdbaby.com', 'Cloé', 'Tommen', '0KjYaR3hz6', 2);
INSERT INTO users (id, email, first_name, last_name, password, roles_id) VALUES (4, 'bstclair1@smh.com.au', 'Uò', 'St. Clair', 'QGa0haQm', 2);
INSERT INTO users (id, email, first_name, last_name, password, roles_id) VALUES (5, 'rbiagini2@oaic.gov.au', 'Loïc', 'Biagini', 'J55Zsh5yE', 2);

insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (1, 'Al Franken: God Spoke', 'Replacement or repair of thoracic unit of (total) replacement heart system', 'Sci-Fi', 44.25, 35, 'http://dummyimage.com/192x100.png/ff4444/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (2, 'Nightmare in Las Cruces, A', 'Other operations on bladder', 'Documentary', 13.10, 26, 'http://dummyimage.com/145x100.png/dddddd/000000');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (3, 'Papa''s Delicate Condition', 'Revision rhinoplasty', 'Comedy', 20.28, 1, 'http://dummyimage.com/199x100.png/5fa2dd/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (4, 'Evil Roy Slade', 'Other nonoperative measurements and examinations', 'Horror', 3.63, 40, 'http://dummyimage.com/148x100.png/5fa2dd/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (5, 'How Bruce Lee Changed the World', 'Revision of gastric anastomosis', 'Horror', 31, 19, 'http://dummyimage.com/232x100.png/5fa2dd/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (6, 'Cold Souls', 'Division of joint capsule, ligament, or cartilage, elbow', 'Drama', 69, 34, 'http://dummyimage.com/138x100.png/cc0000/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (7, 'The Auction', 'Bursectomy', 'Drama', 7.35, 22, 'http://dummyimage.com/174x100.png/ff4444/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (8, 'Dans la peau d''une grande', 'Amputation of cervix', 'Comedy', 33.79, 28, 'http://dummyimage.com/145x100.png/dddddd/000000');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (9, 'Forest of the Gods (Dievu miskas)', 'Percutaneous angioplasty of intracranial vessel(s)', 'Drama', 66.21, 5, 'http://dummyimage.com/108x100.png/5fa2dd/ffffff');
insert into products (id, label, description, genre, unit_price, qty_stock, url_img) values (10, 'Piranhaconda', 'Open biopsy of bronchus', 'Sci-Fi', 26.95, 34, 'http://dummyimage.com/250x100.png/dddddd/000000');

insert into orders (id, delivery_address, order_date, receiver, total_price, delivery_id) values (1, '68885 Loeprich Lane', '2021-11-05', 'Finlayson', 22.5, 1);
insert into orders (id, delivery_address, order_date, receiver, total_price, delivery_id) values (2, '838 Hermina Hill', '2021-10-24', 'Mulqueeny', 26.5, 1);
insert into orders (id, delivery_address, order_date, receiver, total_price, delivery_id) values (3, '6206 Clove Road', '2021-01-07', 'Nanetti', 18.5, 1);
insert into orders (id, delivery_address, order_date, receiver, total_price, delivery_id) values (4, '00464 Derek Pass', '2021-05-15', 'Brok', 67.5, 2);
insert into orders (id, delivery_address, order_date, receiver, total_price, delivery_id) values (5, '427 Oriole Road', '2021-02-12', 'Petric', 19.5, 2);

insert into order_detail (id, price_by_qty, quantity, unit_price, order_id, product_id) values (1, 20, 4, 5, 1, 1);
insert into order_detail (id, price_by_qty, quantity, unit_price, order_id, product_id) values (2, 24, 1, 24, 2, 2);
insert into order_detail (id, price_by_qty, quantity, unit_price, order_id, product_id) values (3, 16, 2, 8, 3, 3);
insert into order_detail (id, price_by_qty, quantity, unit_price, order_id, product_id) values (4, 60, 2, 30, 4, 4);
insert into order_detail (id, price_by_qty, quantity, unit_price, order_id, product_id) values (5, 12, 3, 4, 5, 5);

insert into users_orders_list (user_id, orders_list_id) values (2, 1);
insert into users_orders_list (user_id, orders_list_id) values (2, 2);
insert into users_orders_list (user_id, orders_list_id) values (3, 3);
insert into users_orders_list (user_id, orders_list_id) values (4, 4);
insert into users_orders_list (user_id, orders_list_id) values (5, 5);
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO deliveries (id, label, shipping_fee) VALUES (1, 'STANDARD', 2.99);
INSERT INTO deliveries (id, label, shipping_fee) VALUES (2, 'EXPRESS', 7.99);

INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (1, 'johndoe@mail.com', 'John', 'Doe', 'johnD', 'JohnAdmin22@');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (2, 'alice@mail.com', 'Alice', 'Jim', 'AliceJ', 'ALiceUser22@');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (3, 'ctommen0@cdbaby.com', 'Chloé', 'Tommen', 'Cloclo', '0KjYaR3hz6');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (4, 'bstclair1@smh.com.au', 'Bob', 'St. Clair', 'Bobby', 'QGa0haQm');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (5, 'rbiagini2@oaic.gov.au', 'Loïc', 'Biagini', 'Lolo', 'J55Zsh5yE');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (6, 'admin@mail.com', 'gaelleadmin', 'admin', 'admin', '$2a$10$vMl7RJBDNKhakLvL5H6whuB986ciAX8z.xTgQxhlC.93x/CMstIti');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (7, 'user@mail.com', 'gaelleUser', 'user', 'user', '$2a$10$vMl7RJBDNKhakLvL5H6whuB986ciAX8z.xTgQxhlC.93x/CMstIti');
-- Gaga1701@
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (8, 'flora@mail.com', 'Flora', 'Laf', 'Yulan56AdminUser', '$2a$10$wH.5m0TtAwARnZ0eGG4IVel3DJuKCygVQ7C72wJZiL.fMUFnPRBzy');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (9, 'floraadmin@mail.com', 'FloraAdmin', 'LafAdmin', 'Yulan56Admin', '$2a$10$wH.5m0TtAwARnZ0eGG4IVel3DJuKCygVQ7C72wJZiL.fMUFnPRBzy');
INSERT INTO users (id, email, first_name, last_name, username, password) VALUES (10, 'florauser@mail.com', 'FloraUser', 'LafUser', 'Yulan56User', '$2a$10$ZK03jLr0xiAxa9glJB.VvOMCLMLPvgA5uVFtrbmai5Dkh/YogCUGW');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (4, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (5, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (6, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (7, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (8, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (8, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (9, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (10, 2);

insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (2, 'Black Widow', 'Natasha Romanoff, alias Black Widow, voit resurgir la part la plus sombre de son passé pour faire face à une redoutable conspiration liée à sa vie d’autrefois.', '2021-01-01', 'Action', 19.99, 26, 'https://static.fnac-static.com/multimedia/Images/FR/NR/67/81/d0/13664615/1540-1/tsp20210901084440/Black-Widow-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (1, 'Joker', 'Le film, qui relate une histoire originale inédite sur grand écran, se focalise sur la figure emblématique de l’ennemi juré de Batman. Il brosse le portrait d’Arthur Fleck, un homme sans concession méprisé par la société.', '2021-02-01', 'Thriller', 10.99, 15, 'https://static.fnac-static.com/multimedia/Images/FR/NR/b9/b3/ae/11449273/1540-1/tsp20200106160132/Joker-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (3, 'La Reine des Neiges', 'Pourquoi Elsa est-elle née avec des pouvoirs magiques ? La jeune fille rêve de l’apprendre, mais la réponse met son royaume en danger. Avec l’aide d’Anna, Kristoff, Olaf et Sven, Elsa entreprend un voyage extraordinaire.', '2021-03-01', 'Dessin Animé', 14.99, 12, 'https://static.fnac-static.com/multimedia/Images/FR/NR/a2/6a/b0/11561634/1540-1/tsp20200120180031/La-Reine-des-Neiges-2-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (4, 'Wonder Woman', 'Après la Première guerre mondiale, direction les années 80 ! Cette fois, Wonder Woman doit affronter un nouvel ennemi, particulièrement redoutable : Cheetah.', '2020-08-23', 'Action', 13.99, 10, 'https://static.fnac-static.com/multimedia/Images/FR/NR/63/e4/ca/13296739/1540-1/tsp20210322123210/Wonder-Woman-1984-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (5, 'Tenet', 'Muni d''un seul mot – Tenet – et décidé à se battre pour sauver le monde, notre protagoniste sillonne l''univers crépusculaire de l''espionnage international. Sa mission le projettera dans une dimension qui dépasse le temps.', '2021-06-01', 'Thriller', 9.99, 19, 'https://static.fnac-static.com/multimedia/Images/FR/NR/c8/f4/c2/12776648/1540-1/tsp20201113125135/Tenet-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (6, '1917', 'Pris dans la tourmente de la Première Guerre Mondiale, Schofield et Blake, deux jeunes soldats britanniques, se voient assigner une mission à proprement parler impossible.', '2021-02-20', 'Guerre', 9.99, 34, 'https://static.fnac-static.com/multimedia/Images/FR/NR/a6/4d/b2/11685286/1540-1/tsp20200225173140/1917-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (7, 'Raya et le dernier dragon', 'Il y a de cela fort longtemps, au royaume imaginaire de Kumandra, humains et dragons vivaient en harmonie. Mais un jour, une force maléfique s’abattit sur le royaume.', '2021-12-01', 'Dessin Animé', 14.99, 22, 'https://static.fnac-static.com/multimedia/Images/FR/NR/f1/1e/cf/13573873/1540-1/tsp20210602092053/Raya-et-le-Dernier-Dragon-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (8, 'Il faut sauver le soldat Ryan', 'Tandis que les forces alliées débarquent à Omaha Beach, Miller doit conduire son escouade derrière les lignes ennemies pour une mission particulièrement dangereuse: trouver et ramener sain et sauf le simple soldat James Ryan.', '2021-11-01', 'Guerre',13.99, 8, 'https://static.fnac-static.com/multimedia/FR/Images_Produits/FR/fnac.com/Visual_Principal_340/5/3/9/3333973138935/tsp20121012180707/Il-faut-sauver-le-soldat-Ryan.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (9, 'Joyeuse retraite !', 'L’heure de la retraite est enfin arrivée pour Philippe et Marilou ! Ils s’apprêtent à réaliser leur rêve : partir vivre sous le soleil du Portugal.', '2021-08-01', 'Comédie', 9.99, 5, 'https://static.fnac-static.com/multimedia/Images/FR/NR/bf/3a/b0/11549375/1540-1/tsp20200117164136/Joyeuse-retraite-DVD.jpg');
insert into products (id, label, description, release_date, genre, unit_price, qty_stock, url_img) values (10, 'La daronne', 'Patience Portefeux est interprète judiciaire francoarabe, spécialisée dans les écoutes téléphoniques pour la brigade des Stups.', '2021-09-01', 'Comédie', 16.99, 34, 'https://static.fnac-static.com/multimedia/Images/FR/NR/36/76/c3/12809782/1540-1/tsp20201029125053/La-Daronne-DVD.jpg');

insert into orders (id, address, zip_code, city, order_date, receiver, total_price, delivery_id, user_id) values (1, '17 avenue des fleurs', "75001", 'Paris', '2021-11-05', 'Mme Jim', 22.5, 1, 10);
insert into orders (id, address, zip_code, city, order_date, receiver, total_price, delivery_id, user_id) values (2, '3 bis rue du soleil', "13002",'Marseille', '2021-10-24', 'Mme Jim', 26.5, 1, 3);
insert into orders (id, address, zip_code, city, order_date, receiver, total_price, delivery_id, user_id) values (3, '67 rue des loups', "29200", 'Brest', '2021-01-07', 'Chloé', 18.5, 1, 4);
insert into orders (id, address, zip_code, city, order_date, receiver, total_price, delivery_id, user_id) values (4, '24 boulevard des roses', "93100", 'Montreuil', '2021-05-15', 'Bob', 67.5, 2, 5);
insert into orders (id, address, zip_code, city, order_date, receiver, total_price, delivery_id, user_id) values (5, '4 place du Général', "67000", 'Strasbourg', '2021-02-12', 'Mr Biagini', 19.5, 2, 2);

insert into order_detail (id, price_by_qty, product_id, quantity, user_id, status) values (1, 20, 1, 2, 10, true);
insert into order_detail (id, price_by_qty, product_id, quantity, user_id, status) values (2, 24, 1, 1, 3, true);
insert into order_detail (id, price_by_qty, product_id, quantity, user_id, status) values (3, 16, 2, 1, 10, true);
insert into order_detail (id, price_by_qty, product_id, quantity, user_id, status) values (4, 60, 4, 2, 10, true);
insert into order_detail (id, price_by_qty, product_id, quantity, user_id, status) values (5, 12, 8, 5, 10, true);

insert into orders_order_detail_list (order_id, order_detail_list_id) values (1, 1);
insert into orders_order_detail_list (order_id, order_detail_list_id) values (2, 2);
insert into orders_order_detail_list (order_id, order_detail_list_id) values (1, 3);
insert into orders_order_detail_list (order_id, order_detail_list_id) values (4, 4);
insert into orders_order_detail_list (order_id, order_detail_list_id) values (4, 5);
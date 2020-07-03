INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('1', 'Jaja i živinsko meso');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('2', 'Živa stoka');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('3', 'Mleko');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('4', 'Mlečni proizvodi');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('5', 'Voće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('6', 'Povrće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('7', 'Žitarice');

INSERT INTO `mvm`.`user` (`name`, `password`, `username`) VALUES ('USER', '$2a$10$a00nqUIZBgh9OtnCyqHhk.VT73kyt8aiYK2216.yvtgBMR7EPqOf.', 'user');
INSERT INTO `mvm`.`user` (`name`, `password`, `username`, `category_id`) VALUES ('Milica Matijevic', '$2a$10$PzRvaXkFuJsFzd2RBL5wnOTEST96YasTLQiaM3RLpq/67J7Yrmxsi', 'mica', '6'); /*password: 123*/


INSERT INTO `mvm`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');

INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '1');

INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('1', 'src/main/resources/chicken.png', '1');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('2', 'src/main/resources/lamb.png', '2');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('3', 'src/main/resources/milk.png', '3');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('4', 'src/main/resources/milk_products.png', '4');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('5', 'src/main/resources/fruit.png', '5');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('6', 'src/main/resources/vegetables.png', '6');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('7', 'src/main/resources/grains.png', '7');

INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (1,1);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (2,2);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (3,3);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (4,4);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (5,5);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (6,6);
INSERT INTO `mvm`.`forum` (`id`,`category_id`) VALUES (7,7);

INSERT INTO `mvm`.`discussion` (`id`,`content`,`date_time`,`title`,`forum_id`,`user_id`) VALUES (1,'sadrzaj','2020-06-28 23:00:00.000000','naslov',6,2);
INSERT INTO `mvm`.`discussion` (`id`,`content`,`date_time`,`title`,`forum_id`,`user_id`) VALUES (2,'sadrzaj2','2020-06-28 23:01:00.000000','naslov2',6,2);


INSERT INTO mvm.product (id, name, category_id) VALUES (1, 'Bikovi', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (2, 'Jagnjad', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (3, 'Jarad', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (4, 'Junad', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (5, 'Koze', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (6, 'Krave', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (7, 'Krmace', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (8, 'Ovce', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (9, 'Ovnovi', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (10, 'Prasad (<15kg)', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (11, 'Prasad (>15kg)', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (12, 'Junice', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (13, 'Kokoske', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (14, 'Siljezad', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (15, 'Telad', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (16, 'Tovljenici', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (17, 'Dviske', 2);
INSERT INTO mvm.product (id, name, category_id) VALUES (18, 'Kukuruz u zrnu', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (19, 'Kukuruz u klipu', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (20, 'Lucerka u balama', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (21, 'Psenica u dzaku', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (22, 'Psenica u rinfuzi', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (23, 'Sojina sacma', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (24, 'Sojino zrno', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (25, 'Stocni jecam', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (26, 'Stocno brasno', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (27, 'Suncokret u zrnu', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (28, 'Suncokretova sacma', 7);
INSERT INTO mvm.product (id, name, category_id) VALUES (29, 'Jaja', 1);
INSERT INTO mvm.product (id, name, category_id) VALUES (30, 'Piletina', 1);
INSERT INTO mvm.product (id, name, category_id) VALUES (31, 'Sir', 4);
INSERT INTO mvm.product (id, name, category_id) VALUES (32, 'Kajmak', 4);
INSERT INTO mvm.product (id, name, category_id) VALUES (33, 'Breskva', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (34, 'Jabuka', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (35, 'Kajsija', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (36, 'Kruska', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (37, 'Limun', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (38, 'Visnja', 5);
INSERT INTO mvm.product (id, name, category_id) VALUES (39, 'Blitva', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (40, 'Boranija', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (41, 'Brokoli', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (42, 'Celer', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (43, 'Cvekla', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (44, 'Dinja', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (45, 'Karfiol', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (46, 'Kelj', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (47, 'Krastavac', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (48, 'Krompir', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (49, 'Kupus', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (50, 'Lubenica', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (51, 'Beli luk', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (52, 'Crni luk', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (53, 'Paprika', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (54, 'Paradajz', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (55, 'Pasulj', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (56, 'Patlidžan', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (57, 'Peršun', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (58, 'Pečurke', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (59, 'Praziluk', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (60, 'Ren', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (61, 'Rotkva', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (62, 'Rotkvica', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (63, 'Spanać', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (64, 'Tikvice', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (65, 'Zelen', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (66, 'Zelena salata', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (67, 'Zelje', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (68, 'Šargarepa', 6);
INSERT INTO mvm.product (id, name, category_id) VALUES (69, 'Špargla', 6);
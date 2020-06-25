INSERT INTO `mvm`.`user` (`name`, `password`, `username`) VALUES ('USER', '$2a$10$a00nqUIZBgh9OtnCyqHhk.VT73kyt8aiYK2216.yvtgBMR7EPqOf.', 'user');

INSERT INTO `mvm`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');

INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('1', 'Jaja i živinsko meso');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('2', 'Živa stoka');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('3', 'Mleko');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('4', 'Mlečni proizvodi');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('5', 'Voće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('6', 'Povrće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('7', 'Žitarice');

INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('1', 'src/main/resources/chicken.png', '1');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('2', 'src/main/resources/lamb.png', '2');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('3', 'src/main/resources/milk.png', '3');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('4', 'src/main/resources/milk_products.png', '4');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('5', 'src/main/resources/fruit.png', '5');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('6', 'src/main/resources/vegetables.png', '6');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('7', 'src/main/resources/grains.png', '7');

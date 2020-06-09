INSERT INTO `mvm`.`user` (`name`, `password`, `username`) VALUES ('USER', '$2a$10$a00nqUIZBgh9OtnCyqHhk.VT73kyt8aiYK2216.yvtgBMR7EPqOf.', 'user');

INSERT INTO `mvm`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');

INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `mvm`.`user` (`name`, `password`, `username`) VALUES ('Admin Admin', '$2a$10$OG11FUU61dFASaGM6x7tMuW4yjDSg0YkLswAnYLzla.VeSIPrdp5u', 'admin');
INSERT INTO `mvm`.`user` (`name`, `password`, `username`) VALUES ('User User', '$2a$10$a00nqUIZBgh9OtnCyqHhk.VT73kyt8aiYK2216.yvtgBMR7EPqOf.',  'user');

INSERT INTO `mvm`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');
INSERT INTO `mvm`.`role` (`id`, `name`) VALUES ('2', 'ROLE_ADMIN');

INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `mvm`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '1');

INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('1', 'Jaja i živinsko meso');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('2', 'Živa stoka');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('3', 'Mleko');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('4', 'Mlečni proizvodi');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('5', 'Voće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('6', 'Povrće');
INSERT INTO `mvm`.`category` (`id`, `name`) VALUES ('7', 'Žitarice');

INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('1', 'p1', '1');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('2', 'p2', '2');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('3', 'p3', '3');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('4', 'p4', '4');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('5', 'p5', '5');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('6', 'p6', '6');
INSERT INTO `mvm`.`image` (`id`, `path`, `category_id`) VALUES ('7', 'p7', '7');

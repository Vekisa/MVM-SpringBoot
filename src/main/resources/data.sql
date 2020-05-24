INSERT INTO `mvm`.`user` (`address`, `email`, `first_name`, `last_name`, `password`, `phone`, `username`) VALUES ('Pere Dobrinovica 35', 'admin@gmail.com', 'Admin', 'Admin', '$2a$10$OG11FUU61dFASaGM6x7tMuW4yjDSg0YkLswAnYLzla.VeSIPrdp5u', '064789742', 'admin');
INSERT INTO `mvm`.`user` (`address`, `email`, `first_name`, `last_name`, `password`, `phone`, `username`) VALUES ('Pere Dobrinovica 30', 'user@gmail.com', 'User', 'User', '$2a$10$a00nqUIZBgh9OtnCyqHhk.VT73kyt8aiYK2216.yvtgBMR7EPqOf.', '064789742', 'user');

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
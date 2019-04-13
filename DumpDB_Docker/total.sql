use jpa_db01;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
);

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_roles_ibfk_2` (`role_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

INSERT INTO `user` VALUES (2,'adam@grokonez.com','adamgkz','$2a$10$l2C/zvhcyrGkcUSRZaW4hO8gUDk5.MqLPMSmBmRzU.dTk97hX2ByK','Adam'),(3,'thaihv@eplatform.vn','thaihv','$2a$10$M9wgTcagcmQ./ojRRQFvr.aCTPXzKulxw7F.g0puaFZO/qXQeIflq','ThaiHV'),(4,'thaihuynh@eplatform.vn','thaihuynh','$2a$10$1.2eyWUu3rnnmvgJJO5iVOD8GSIzO2lXbUZNXKeXyQfULf7K3zsXW','ThaiHV');
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_PM'),(3,'ROLE_ADMIN');
INSERT INTO `user_roles` VALUES (2,1),(3,1),(4,1),(3,2),(4,2),(4,3);

CREATE TABLE `bank_account` (
  `ID` bigint(20) NOT NULL,
  `FULL_NAME` varchar(128) NOT NULL,
  `BALANCE` double NOT NULL,
  PRIMARY KEY (`ID`)
);

INSERT INTO `bank_account` VALUES (1,'Tom',1000),(2,'Jerry',2000),(3,'Donald',3000);
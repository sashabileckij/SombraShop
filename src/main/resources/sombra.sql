CREATE TABLE users
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  login    VARCHAR(150) NOT NULL,
  email    VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  number   VARCHAR(50)  NOT NULL,
  role     INT  NOT NULL,
  CONSTRAINT users_email_uindex
  UNIQUE (email)
)
  COMMENT 'all users';

CREATE TABLE lot
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  jpg      VARCHAR(150) NOT NULL,
  name     VARCHAR(150) NOT NULL,
  price    VARCHAR(150) NOT NULL,
  category VARCHAR(150) NOT NULL
)
  COMMENT 'all cart';

CREATE TABLE cities
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(150) NOT NULL,
  role    INT NOT NULL,
  CONSTRAINT users_name_uindex
  UNIQUE (name)
);

CREATE TABLE cart
(
  id         INT AUTO_INCREMENT PRIMARY KEY,
  id_user    INT(150) NOT NULL,
  id_lot     INT(150) NOT NULL,
  role     INT(150) NOT NULL
);

INSERT INTO `cities` (`name`,`role`)
VALUES ("NY","1");

INSERT INTO `cities` (`name`,`role`)
VALUES ("Los angeles","0");



INSERT INTO `users` (`login`, `email`, `password`, `number`, `role`)
VALUES ("admin", "admin@gmail.com", "admin", "00000000000","2");

INSERT INTO `users` (`login`, `email`, `password`, `number`, `role`)
VALUES ("user1", "user1@gmail.com", "user1", "11111111111",1);

INSERT INTO `users` (`login`, `email`, `password`, `number`, `role`)
VALUES ("user2", "user2@gmail.com", "user2", "11111111111",0);

INSERT INTO `users` (`login`, `email`, `password`, `number`, `role`)
VALUES ("user3", "user3@gmail.com", "user3", "11111111111", 1);

INSERT INTO `users` (`login`, `email`, `password`, `number`, `role`)
VALUES ("user4", "user4@gmail.com", "user4", "11111111111",0);


INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot1/1.jpg", "lot1", "11", "category1");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot1/2.jpg", "lot1", "11", "category1");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot1/3.jpg", "lot1", "11", "category1");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot1/4.jpg", "lot1", "11", "category1");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot1/5.jpg", "lot1", "11", "category1");

INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot2/1.jpg", "lot2", "11", "category1");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot2/2.jpg", "lot2", "11", "category1");

INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category1/lot3/1.jpg", "lot3", "11", "category1");

INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category2/lot1/1.jpg", "lot1", "11", "category2");
INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category2/lot1/2.jpg", "lot1", "11", "category2");

INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category2/lot2/1.jpg", "lot2", "11", "category2");

INSERT INTO lot (`jpg`, `name`, `price`, `category`)
VALUES ("/category3/lot1/1.jpg", "lot1", "11", "category3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("3", "1", "3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("3", "8", "3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("3", "6", "3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("4", "1", "3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("5", "8", "3");

INSERT INTO cart (`id_user`, `id_lot`, `role`)
VALUES ("2", "6", "3");


CREATE TABLE `cinema`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `director`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    `lastname`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `movie`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `poster`      varchar(255) NOT NULL,
    `rating`      float DEFAULT NULL,
    `title`       varchar(255) NOT NULL,
    `director_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `movie_cinema`
(
    `movie_id`  int DEFAULT NULL,
    `cinema_id` int DEFAULT NULL
);

INSERT INTO `cinema`(`id`, `logo`, `name`)
VALUES ('1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Multikino_logo.png/1198px-Multikino_logo.png',
        'Multikino');
INSERT INTO `cinema`(`id`, `logo`, `name`)
VALUES ('2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Imax.svg/330px-Imax.svg.png', 'IMAX');
INSERT INTO `cinema`(`id`, `logo`, `name`)
VALUES ('3', 'https://www.cinema-city.pl/xmedia/img/10103/logo.svg', 'Cinema City');

INSERT INTO `director`(`id`, `firstname`, `lastname`)
VALUES ('1', 'Steven', 'Spielberg');
INSERT INTO `director`(`id`, `firstname`, `lastname`)
VALUES ('2', 'Woody', 'Allen');
INSERT INTO `director`(`id`, `firstname`, `lastname`)
VALUES ('3', 'Guy', 'Ritchie');

INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('1', 'https://static.posters.cz/image/750webp/73584.webp', '2.2', 'Jaws', '1');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('2', 'https://fwcdn.pl/fpo/01/79/179/7710998.6.jpg', '8.1', 'Saving Private Ryan', '1');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('3', 'https://fwcdn.pl/fpo/12/15/1215/6918508.6.jpg', '7.1', 'E.T.', '1');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('4', 'https://upload.wikimedia.org/wikipedia/en/0/05/Vicky_Cristina_Barcelona_film_poster.png', '7.1',
        'Vicky Cristina Barcelona', '2');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('5', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Manhattan-poster01.jpg/220px-Manhattan-poster01.jpg',
        '7.1', 'Manhattan', '2');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('6', 'https://fwcdn.pl/fpo/13/26/1326/7635628.6.jpg', '7.1', 'Snatch', '3');
INSERT INTO `movie`(`id`, `poster`, `rating`, `title`, `director_id`)
VALUES ('7', 'https://fwcdn.pl/fpo/19/97/441997/7239460.6.jpg', '7.1', 'RockNRolla', '3');

INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('1', '1');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('1', '3');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('2', '3');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('3', '1');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('3', '2');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('4', '1');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('4', '3');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('5', '2');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('5', '3');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('6', '1');
INSERT INTO `movie_cinema`(`movie_id`, `cinema_id`)
VALUES ('7', '2');
















CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');





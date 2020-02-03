CREATE DATABASE ivanka;

CREATE USER 'kozel'@'localhost' IDENTIFIED BY 'Qwerty1-';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON ivanka.* TO 'kozel'@'localhost';
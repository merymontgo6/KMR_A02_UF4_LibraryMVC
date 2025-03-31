CREATE DATABASE IF NOT EXISTS llibreria;
USE llibreria;

CREATE TABLE IF NOT EXISTS llibre (
    id_llibre INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255) NOT NULL,
    data_publicacio DATE NOT NULL,
    tematica VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE
);
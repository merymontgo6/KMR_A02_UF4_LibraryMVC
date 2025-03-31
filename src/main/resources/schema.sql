CREATE DATABASE IF NOT EXISTS Llibreria;
USE Llibreria;

CREATE TABLE IF NOT EXISTS llibre (
    id_llibre INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    editorial VARCHAR(255),
    data_publicacio DATE,
    tematica VARCHAR(255),
    isbn VARCHAR(13) NOT NULL UNIQUE
);
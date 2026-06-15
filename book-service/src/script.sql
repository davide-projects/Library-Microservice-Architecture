-- Creazione database
CREATE DATABASE IF NOT EXISTS book_service_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE book_service_db;

-- Creazione tabella 'book'
CREATE TABLE IF NOT EXISTS book (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

-- Dati Esempio
INSERT INTO book (title, author, publisher) VALUES
        ('Il Signore degli Anelli', 'J.R.R. Tolkien', 'Allen & Unwin'),
        ('I Promessi Sposi', 'Alessandro Manzoni', 'G. Ferrario'),
        ('Orgoglio e Pregiudizio', 'Jane Austen', 'T. Egerton'),
        ('Il Conte di Montecristo', 'Alexandre Dumas', 'Pétion'),
        ('1984', 'George Orwell', 'Secker & Warburg');


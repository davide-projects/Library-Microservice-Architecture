-- Creazione database
CREATE DATABASE IF NOT EXISTS member_service_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE member_service_db;

-- Creazione tabella 'members'
CREATE TABLE IF NOT EXISTS members (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
    );

-- Dati Esempio
INSERT INTO members (first_name, last_name, city, phone) VALUES
             ('Giovanni', 'Bianchi', 'Milano', '3331234567'),
             ('Maria', 'Rossi', 'Roma', '3209876543'),
             ('Luca', 'Esposito', 'Napoli', '0811234567'),
             ('Francesca', 'Ricci', 'Firenze', '0557654321'),
             ('Alessandro', 'Greco', 'Bari', '3471122334');


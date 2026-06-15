-- Creazione database
CREATE DATABASE IF NOT EXISTS loan_service_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE loan_service_db;

-- Creazione tabella 'loans'
CREATE TABLE IF NOT EXISTS loans (
                                     id INT NOT NULL AUTO_INCREMENT,
                                     book_id INT NOT NULL,
                                     member_id INT NOT NULL,
                                     loan_date DATE NOT NULL,
                                     return_date DATE,
                                     PRIMARY KEY (id)
    );

-- Indici utili per performance
CREATE INDEX idx_loans_book_id ON loans(book_id);
CREATE INDEX idx_loans_member_id ON loans(member_id);

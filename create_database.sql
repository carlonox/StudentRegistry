-- Create the database
CREATE DATABASE IF NOT EXISTS crudPersona;

-- Use the database
USE crudPersona;

-- Create the persona table
CREATE TABLE IF NOT EXISTS persona (
    idPersona INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    facultad VARCHAR(100) NOT NULL,
    puntaje INT NOT NULL,
    admitido VARCHAR(2) NOT NULL
);

-- Insert some sample data
INSERT INTO persona (dni, nombre, apellido, facultad, puntaje, admitido) VALUES
('12345678', 'Juan', 'Perez', 'Ingenieria', 400, 'SI'),
('87654321', 'Maria', 'Gomez', 'Artes', 380, 'SI'),
('11223344', 'Carlos', 'Lopez', 'Tecnologica', 300, 'SI');

--Creaci�n Base de datos
CREATE DATABASE PruebaTecnicaFormulario
USE PruebaTecnicaFormulario

-- Tabla: Tipo de Identificaci�n
CREATE TABLE Tipo_Identificacion (
    Cod_Identificacion INT PRIMARY KEY,
    Tipo VARCHAR(50) NOT NULL
);

-- Tabla: Pa�s
CREATE TABLE Pais (
    Cod_Pais INT PRIMARY KEY,
    Pais VARCHAR(100) NOT NULL
);

-- Tabla: Departamento
CREATE TABLE Departamento (
    Cod_Departamento INT PRIMARY KEY,
    Departamento VARCHAR(100) NOT NULL,
    Cod_Pais INT FOREIGN KEY REFERENCES Pais(Cod_Pais)
);

-- Tabla: Ciudad
CREATE TABLE Ciudad (
    Cod_Ciudad INT PRIMARY KEY,
    Ciudad VARCHAR(100) NOT NULL,
    Cod_Departamento INT FOREIGN KEY REFERENCES Departamento(Cod_Departamento)
);

-- Tabla: Marca
CREATE TABLE Marca (
    Id_Marca INT PRIMARY KEY,
    Marca VARCHAR(100) NOT NULL
);

-- Tabla: Cliente
CREATE TABLE Cliente (
    Numero_Identificacion VARCHAR(20) PRIMARY KEY,
    Cod_Identificacion INT FOREIGN KEY REFERENCES Tipo_Identificacion(Cod_Identificacion),
    Nombres VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Direccion VARCHAR(150),
    Cod_Ciudad INT FOREIGN KEY REFERENCES Ciudad(Cod_Ciudad),
    Cod_Departamento INT FOREIGN KEY REFERENCES Departamento(Cod_Departamento),
    Cod_Pais INT FOREIGN KEY REFERENCES Pais(Cod_Pais)
);

-- Tabla: Clientes_PorMarca
CREATE TABLE Clientes_PorMarca (
    Numero_Identificacion VARCHAR(20) FOREIGN KEY REFERENCES Cliente(Numero_Identificacion),
    Id_Marca INT FOREIGN KEY REFERENCES Marca(Id_Marca),
    PRIMARY KEY (Numero_Identificacion, Id_Marca)
);

INSERT INTO Tipo_Identificacion VALUES
(1, 'C�dula de Ciudadan�a'),
(2, 'C�dula de Extranjer�a'),
(3, 'Pasaporte'),
(4, 'Tarjeta de Identidad'),
(5, 'NIT');

INSERT INTO Pais VALUES
(1, 'Colombia');

INSERT INTO Departamento VALUES
(1, 'Antioquia', 1),
(2, 'Cundinamarca', 1),
(3, 'Valle del Cauca', 1),
(4, 'Atl�ntico', 1),
(5, 'Santander', 1),
(6, 'Bol�var', 1),
(7, 'Nari�o', 1),
(8, 'Cesar', 1),
(9, 'Boyac�', 1),
(10, 'Risaralda', 1);

--Ciudades por departamento
INSERT INTO Ciudad VALUES (1, 'Medell�n', 1);
INSERT INTO Ciudad VALUES (2, 'Envigado', 1);
INSERT INTO Ciudad VALUES (3, 'Sabaneta', 1);

INSERT INTO Ciudad VALUES (4, 'Bogot�', 2);
INSERT INTO Ciudad VALUES (5, 'Soacha', 2);
INSERT INTO Ciudad VALUES (6, 'Zipaquir�', 2);

INSERT INTO Ciudad VALUES (7, 'Cali', 3);
INSERT INTO Ciudad VALUES (8, 'Palmira', 3);
INSERT INTO Ciudad VALUES (9, 'Buenaventura', 3);

INSERT INTO Ciudad VALUES (10, 'Barranquilla', 4);
INSERT INTO Ciudad VALUES (11, 'Soledad', 4);

INSERT INTO Ciudad VALUES (12, 'Bucaramanga', 5);
INSERT INTO Ciudad VALUES (13, 'Floridablanca', 5);

INSERT INTO Ciudad VALUES (14, 'Cartagena', 6);
INSERT INTO Ciudad VALUES (15, 'Magangu�', 6);

INSERT INTO Ciudad VALUES (16, 'Pasto', 7);
INSERT INTO Ciudad VALUES (17, 'Tumaco', 7);

INSERT INTO Ciudad VALUES (18, 'Valledupar', 8);
INSERT INTO Ciudad VALUES (19, 'Aguachica', 8);

INSERT INTO Ciudad VALUES (20, 'Tunja', 9);
INSERT INTO Ciudad VALUES (21, 'Duitama', 9);

INSERT INTO Ciudad VALUES (22, 'Pereira', 10);
INSERT INTO Ciudad VALUES (23, 'Dosquebradas', 10);

INSERT INTO Marca VALUES
(1, 'Americanino'),
(2, 'American Eagle'),
(3, 'Chevignon'),
(4, 'Esprit'),
(5, 'Naf Naf'),
(6, 'Rifle');

SELECT 
    c.Cod_Ciudad,
    c.Ciudad,
    d.Departamento,
    p.Pais
FROM 
    Ciudad c
INNER JOIN Departamento d ON c.Cod_Departamento = d.Cod_Departamento
INNER JOIN Pais p ON d.Cod_Pais = p.Cod_Pais;



SELECT COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'Clientes_PorMarca';







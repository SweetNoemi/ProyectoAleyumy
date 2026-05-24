-- Crear base de datos
-- Proyecto Marcos
DROP DATABASE bdaleyumy;
CREATE DATABASE bdaleyumy;
USE bdaleyumy;

-- Tabla de usuarios

CREATE TABLE CLIENTES (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  CORREO VARCHAR(50) UNIQUE NOT NULL,
  CONTRASENA VARCHAR(255) NOT NULL,
  NOMBRE VARCHAR(50) NOT NULL,
  APELLIDO VARCHAR(50) NOT NULL,
  TOKEN_LOGIN VARCHAR(6) NULL,
  TOKEN_LOGIN_EXPIRA DATETIME NULL,
  TOKEN_RECUPERAR VARCHAR(6) NULL,
  TOKEN_RECUPERAR_EXPIRA DATETIME NULL
);
SELECT * FROM CLIENTES;


-- Tabla de categoría de producto
CREATE TABLE CATEGORIA_PRODUCTO (
  ID_CATEGORIA INT AUTO_INCREMENT PRIMARY KEY,
  NOMBRE_CATEGORIA VARCHAR(50) NOT NULL
);
INSERT INTO CATEGORIA_PRODUCTO (NOMBRE_CATEGORIA) VALUES
('Pasteles'),
('Galletas'),
('Helados'),
('Tiramisus'),
('Cheesecake'),
('Brownies'),
('Cupcakes'),
('Panes');


-- Tabla de producto
CREATE TABLE PRODUCTO (
  ID_PRODUCTO INT AUTO_INCREMENT PRIMARY KEY,
  NOM_PRODUCTO VARCHAR(50) NOT NULL,
  CANTIDAD_PRO INT NOT NULL,
  PRECIO DECIMAL(10,2) NOT NULL,
  ID_CATEGORIA INT NOT NULL,
  FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA_PRODUCTO(ID_CATEGORIA)
);
SELECT * FROM PRODUCTO;

INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Torta de tres leches', 10, 50.00, 1),
('Torta de Chocolate', 10, 55.00, 1),
('Torta de Lúcuma', 10, 60.00, 1),
('Dulzura de pecanas', 10, 75.00, 1);

-- Galletas (ID_CATEGORIA = 2)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Galletas de chocolate', 20, 24.00, 2),
('Galletas de vainilla', 20, 24.00, 2),
('Galletas navideñas', 20, 24.00, 2),
('Galletas de azúcar', 20, 24.00, 2);

-- Helados (ID_CATEGORIA = 3)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Helado de fresa', 30, 18.00, 3),
('Helado de chocolate', 30, 12.00, 3),
('Helado de vainilla', 30, 12.50, 3),
('Helado de lúcuma', 30, 12.50, 3);

-- Tiramisus (ID_CATEGORIA = 4)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Tiramisú de licor de café', 10, 50.00, 4),
('Tiramisú de chocolate', 10, 60.00, 4),
('Tiramisú de pistacho', 10, 65.00, 4),
('Tiramisú de limón', 10, 50.00, 4);

-- Cheesecake (ID_CATEGORIA = 5)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Cheesecake de fresa', 10, 65.00, 5),
('Cheesecake de chocolate', 10, 65.00, 5),
('New York Cheesecake', 10, 75.00, 5),
('Cheesecake japonés', 10, 85.00, 5);

-- Brownies (ID_CATEGORIA = 6)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Brownie de chocolate', 15, 45.00, 6),
('Brownie con nueces', 15, 45.00, 6),
('Brownie de frambuesa', 15, 45.00, 6),
('Brownie navideño', 15, 55.00, 6);

-- Cupcakes (ID_CATEGORIA = 7)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Cupcake Red Velvet', 15, 45.50, 7),
('Cupcake de plátano', 15, 30.00, 7),
('Cupcake de vainilla', 15, 40.50, 7),
('Cupcake de zanahoria', 15, 40.00, 7);

-- Panes (ID_CATEGORIA = 8)
INSERT INTO PRODUCTO (NOM_PRODUCTO, CANTIDAD_PRO, PRECIO, ID_CATEGORIA) VALUES
('Brioche', 20, 12.00, 8),
('Pan de maíz', 20, 10.00, 8),
('Panetón', 20, 45.00, 8),
('Berlinesas', 20, 7.50, 8);


-- Tabla de métodos de pago
CREATE TABLE METODO_PAGO (
  ID_PAGO INT AUTO_INCREMENT PRIMARY KEY,
  TIPO_PAGO VARCHAR(30) NOT NULL
);
SELECT*FROM METODO_PAGO;
INSERT INTO METODO_PAGO (TIPO_PAGO) VALUES ('tarjeta'), ('yape'), ('tienda');


-- Tabla de factura (encabezado)
DROP TABLE IF EXISTS FACTURA;
CREATE TABLE FACTURA (
  N_FAC INT AUTO_INCREMENT PRIMARY KEY,
  FECHA_FAC DATE NOT NULL DEFAULT (CURRENT_DATE),
  ID_CLIENTE INT NOT NULL,
  ID_PAGO INT NOT NULL,
  FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID),
  FOREIGN KEY (ID_PAGO) REFERENCES METODO_PAGO(ID_PAGO)
);
SELECT*FROM FACTURA;


-- Tabla de detalle factura (productos vendidos)
CREATE TABLE DETALLE_FACTURA (
  ID_DETALLE INT AUTO_INCREMENT PRIMARY KEY,
  N_FAC INT NOT NULL,
  ID_PRODUCTO INT NOT NULL,
  CANTIDAD INT NOT NULL,
  PRECIO_UNITARIO DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (N_FAC) REFERENCES FACTURA(N_FAC),
  FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO)
);
SELECT*FROM DETALLE_FACTURA;


-- Tabla de postulaciones
CREATE TABLE POSTULACION (
  ID_POSTULANTE INT AUTO_INCREMENT PRIMARY KEY,
  NOMBRE VARCHAR(50) NOT NULL,
  APELLIDO VARCHAR(50) NOT NULL,
  DNI_PASAPORTE VARCHAR(50) NOT NULL UNIQUE,
  TELEFONO VARCHAR(50) NOT NULL,
  CORREO_POSTULACION VARCHAR(50) NOT NULL,
  DIRECCION VARCHAR(50) NOT NULL
);


CREATE TABLE EMPLEADOS (
	EMP_ID CHAR(5) NOT NULL DEFAULT '',
    EMP_NOM VARCHAR(50) NOT NULL,
    EMP_APE VARCHAR(50) NOT NULL,
    EMP_DNI VARCHAR(50) NOT NULL UNIQUE,
	EMP_TEL VARCHAR(50) NOT NULL,
    EMP_COR VARCHAR(50) NOT NULL
);
SELECT * FROM EMPLEADOS;

INSERT INTO EMPLEADOS (EMP_ID, EMP_NOM, EMP_APE, EMP_DNI, EMP_TEL, EMP_COR) VALUES
("E0001", "Angel", "Alvarez","45673456", "987456734", "importa@hotmail.com"),
("E0002", "Carlos", "Ramirez", "78912345", "987123456", "carlos.ramirez@email.com"),
("E0003", "Lucia", "Fernandez", "23456789", "987234567", "lucia.fernandez@email.com"),
("E0004", "Miguel", "Torres", "34567890", "987345678", "miguel.torres@email.com"),
("E0005", "Sofia", "Gomez", "45678901", "987456789", "sofia.gomez@email.com"),
("E0006", "Juan", "Perez", "56789012", "987567890", "juan.perez@email.com"),
("E0007", "Valeria", "Lopez", "67890123", "987678901", "valeria.lopez@email.com"),
("E0008", "Diego", "Martinez", "78901234", "987789012", "diego.martinez@email.com"),
("E0009", "Camila", "Rojas", "89012345", "987890123", "camila.rojas@email.com"),
("E0010", "Andres", "Vargas", "90123456", "987901234", "andres.vargas@email.com"),
("E0011", "Natalia", "Morales", "91234567", "987912345", "natalia.morales@email.com"),
("E0012", "Sebastian", "Castro", "92345678", "987923456", "sebastian.castro@email.com"),
("E0013", "Fernanda", "Ruiz", "93456789", "987934567", "fernanda.ruiz@email.com"),
("E0014", "Gabriel", "Mendoza", "94567890", "987945678", "gabriel.mendoza@email.com"),
("E0015", "Daniela", "Campos", "95678901", "987956789", "daniela.campos@email.com"),
("E0016", "Javier", "Salazar", "96789012", "987967890", "javier.salazar@email.com"),
("E0017", "Paola", "Chavez", "97890123", "987978901", "paola.chavez@email.com"),
("E0018", "Ricardo", "Huaman", "98901234", "987989012", "ricardo.huaman@email.com"),
("E0019", "Mariana", "Paredes", "99012345", "987990123", "mariana.paredes@email.com"),
("E0020", "Eduardo", "Carrillo", "99123456", "987991234", "eduardo.carrillo@email.com"),
("E0021", "Antonella", "Silva", "99234567", "987992345", "antonella.silva@email.com");


INSERT INTO CLIENTES (CORREO, CONTRASENA, NOMBRE, APELLIDO) VALUES
('ana.gomez@example.com', 'ana123', 'Ana', 'Gómez'),
('luis.martinez@example.com', 'luis456', 'Luis', 'Martínez'),
('carla.rojas@example.com', 'carla789', 'Carla', 'Rojas'),
('pedro.lopez@example.com', 'pedro321', 'Pedro', 'López'),
('maria.torres@example.com', 'maria654', 'María', 'Torres'),
('jose.ramirez@example.com', 'jose987', 'José', 'Ramírez'),
('laura.mendoza@example.com', 'laura111', 'Laura', 'Mendoza'),
('andres.soto@example.com', 'andres222', 'Andrés', 'Soto'),
('valeria.chavez@example.com', 'valeria333', 'Valeria', 'Chávez'),
('diego.fernandez@example.com', 'diego444', 'Diego', 'Fernández'),
('camila.silva@example.com', 'camila555', 'Camila', 'Silva'),
('sebastian.reyes@example.com', 'sebas666', 'Sebastián', 'Reyes'),
('paula.morales@example.com', 'paula777', 'Paula', 'Morales'),
('daniel.castillo@example.com', 'daniel888', 'Daniel', 'Castillo'),
('sofia.espinoza@example.com', 'sofia999', 'Sofía', 'Espinoza'),
('matias.vera@example.com', 'matias000', 'Matías', 'Vera'),
('isabella.castro@example.com', 'isa1234', 'Isabella', 'Castro'),
('alejandro.perez@example.com', 'ale4567', 'Alejandro', 'Pérez'),
('fernanda.ruiz@example.com', 'fer8910', 'Fernanda', 'Ruiz'),
('cristian.navarro@example.com', 'cris1112', 'Cristian', 'Navarro');



-- /-----------------/
--   PROCEDIMIENTOS
-- /---------------/

DELIMITER //
CREATE PROCEDURE obtenerPostulantes()
BEGIN
	SELECT 
	p.ID_POSTULANTE AS id, 
	p.NOMBRE AS nombre, 
	p.APELLIDO AS apellido, 
	p.DNI_PASAPORTE AS dni, 
	p.TELEFONO AS telefono,
	p.CORREO_POSTULACION AS correo,
	p.DIRECCION
	FROM POSTULACION p;
END //
DELIMITER ;





DELIMITER $$
CREATE PROCEDURE listar_empleados()
BEGIN
    SELECT 
        EMP_ID AS id,
        EMP_NOM AS nombre,
        EMP_APE AS apellido,
        EMP_DNI AS dni,
        EMP_TEL AS telefono,
        EMP_COR AS correo
    FROM EMPLEADOS
    ORDER BY EMP_ID ASC;
END $$
DELIMITER ;





DELIMITER //
CREATE PROCEDURE obtenerClientes()
BEGIN
    SELECT 
        ID, 
        CORREO, 
        CONTRASENA, 
        NOMBRE, 
        APELLIDO,
        TOKEN_LOGIN,
        TOKEN_LOGIN_EXPIRA,
        TOKEN_RECUPERAR,
        TOKEN_RECUPERAR_EXPIRA
    FROM CLIENTES;
END //
DELIMITER ;
CALL obtenerClientes()




DELIMITER //
CREATE PROCEDURE buscarFac(nfac VARCHAR(8))
BEGIN
	SELECT date_format(F.FECHA_FAC, '%d/%m/%y') as fecha, concat(C.NOMBRE, ' ',C.APELLIDO)
    as nombre, P.NOM_PRODUCTO, DF.CANTIDAD, DF.PRECIO_UNITARIO, 
    (DF.CANTIDAD * DF.PRECIO_UNITARIO) as subtotal
	FROM DETALLE_FACTURA DF
	JOIN FACTURA F ON DF.N_FAC = F.N_FAC
	JOIN CLIENTES C ON F.ID_CLIENTE = C.ID
	JOIN PRODUCTO P ON DF.ID_PRODUCTO = P.ID_PRODUCTO
	JOIN METODO_PAGO MP ON F.ID_PAGO = MP.ID_PAGO
	WHERE F.N_FAC = nfac;
END //
DELIMITER ; 


-- Creación de la base de datos
DROP DATABASE IF EXISTS sistema_nutricional;
CREATE DATABASE sistema_nutricional;
USE sistema_nutricional;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    edad INT,
    grupo_etario VARCHAR(50)
);

-- Tabla de productos actualizada
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100),
    unidad VARCHAR(20),
    categoria VARCHAR(50),
    marca VARCHAR(50),
    fuente ENUM('supermercado', 'banco', 'tienda'),
    cantidad_disponible DOUBLE,
    fecha_ingreso DATE
);

-- Tabla de valores nutricionales
CREATE TABLE valores_nutricionales (
    id_valor INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT,
    calorias DOUBLE,
    agua DOUBLE,
    proteinas DOUBLE,
    grasas DOUBLE,
    carbohidratos DOUBLE,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de planes nutricionales
CREATE TABLE planes_nutricionales (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    nombre_plan VARCHAR(100),
    fecha_inicio DATE,
    fecha_fin DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE valoresnutricionalesapi (
    id SERIAL PRIMARY KEY,
    nombre_producto TEXT,
    calorias DOUBLE PRECISION,
    proteinas DOUBLE PRECISION,
    grasas DOUBLE PRECISION,
    carbohidratos DOUBLE PRECISION,
    azucar DOUBLE PRECISION,
    fibra DOUBLE PRECISION,
    calcio DOUBLE PRECISION,
    hierro DOUBLE PRECISION
);


-- Inserción de productos
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'AlimBank', 'banco', 1709.82, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Galletas', 'Kilos', 'Snacks', 'BuenSabor', 'banco', 1709.82, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Piña', 'Kilos', 'Frutas', 'Don Alimento', 'banco', 26.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Manzana', 'Kilos', 'Frutas', 'AlimBank', 'banco', 26.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Harina', 'Kilos', 'Cereales', 'Don Alimento', 'banco', 74.4, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'BuenSabor', 'banco', 74.4, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Cebolla', 'Kilos', 'Hortalizas', 'AlimBank', 'banco', 4.61, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Papa', 'Kilos', 'Hortalizas', 'NutriVida', 'banco', 4.61, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Carne molida', 'Kilos', 'Carnes', 'AlimBank', 'banco', 189.08, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Pollo', 'Kilos', 'Carnes', 'NutriVida', 'banco', 189.08, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Pollo', 'Kilos', 'Carnes', 'Don Alimento', 'banco', 5.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Carne molida', 'Kilos', 'Carnes', 'BuenSabor', 'banco', 5.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Papa', 'Kilos', 'Hortalizas', 'BuenSabor', 'banco', 64.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Cebolla', 'Kilos', 'Hortalizas', 'BuenSabor', 'banco', 64.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 3.92, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'SaludPlus', 'banco', 3.92, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Yogur', 'Kilos', 'Lácteos', 'AlimBank', 'banco', 225.91, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Queso', 'Kilos', 'Lácteos', 'AlimBank', 'banco', 225.91, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Galletas', 'Kilos', 'Snacks', 'BuenSabor', 'banco', 20.12, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'NutriVida', 'banco', 20.12, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Galletas', 'Kilos', 'Snacks', 'SaludPlus', 'banco', 0.35, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'NutriVida', 'banco', 0.35, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Papa', 'Kilos', 'Hortalizas', 'NutriVida', 'banco', 292.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Zanahoria', 'Kilos', 'Hortalizas', 'AlimBank', 'banco', 292.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'Kilos', 'Enlatados', 'NutriVida', 'banco', 204.9, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'Kilos', 'Enlatados', 'AlimBank', 'banco', 204.9, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'Kilos', 'Enlatados', 'SaludPlus', 'banco', 187.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Atún', 'Kilos', 'Enlatados', 'SaludPlus', 'banco', 187.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Atún', 'Kilos', 'Enlatados', 'BuenSabor', 'banco', 0.65, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'Kilos', 'Enlatados', 'Don Alimento', 'banco', 0.65, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'Kilos', 'Enlatados', 'SaludPlus', 'banco', 158.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'Kilos', 'Enlatados', 'BuenSabor', 'banco', 158.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Zanahoria', 'Kilos', 'Hortalizas', 'SaludPlus', 'banco', 2887.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Papa', 'Kilos', 'Hortalizas', 'Don Alimento', 'banco', 2887.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Lentejas', 'Kilos', 'Legumbres', 'NutriVida', 'banco', 1.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Garbanzos', 'Kilos', 'Legumbres', 'Don Alimento', 'banco', 1.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'BuenSabor', 'banco', 41.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Harina', 'Kilos', 'Cereales', 'AlimBank', 'banco', 41.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Queso', 'Kilos', 'Lácteos', 'SaludPlus', 'banco', 352.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Yogur', 'Kilos', 'Lácteos', 'BuenSabor', 'banco', 352.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Duraznos en almíbar', 'Kilos', 'Conservas', 'Don Alimento', 'banco', 849.9, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Mermelada', 'Kilos', 'Conservas', 'SaludPlus', 'banco', 849.9, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 344.08, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 344.08, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Manzana', 'Kilos', 'Frutas', 'AlimBank', 'banco', 175.38, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Piña', 'Kilos', 'Frutas', 'NutriVida', 'banco', 175.38, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Arroz', 'Kilos', 'Cereales', 'BuenSabor', 'banco', 1.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'SaludPlus', 'banco', 1.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Arroz', 'Kilos', 'Cereales', 'Don Alimento', 'banco', 523.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'BuenSabor', 'banco', 523.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'KILOS', 'Enlatados', 'NutriVida', 'banco', 20.4, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'KILOS', 'Enlatados', 'BuenSabor', 'banco', 20.4, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'Don Alimento', 'banco', 0.41, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Harina', 'Kilos', 'Cereales', 'SaludPlus', 'banco', 0.41, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'SaludPlus', 'banco', 3.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Barritas', 'Kilos', 'Snacks', 'BuenSabor', 'banco', 3.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'BuenSabor', 'banco', 62.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 62.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 138.24, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'SaludPlus', 'banco', 138.24, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 195.76, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'Don Alimento', 'banco', 195.76, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Embutidos', 'Kilos', 'Carnes', 'Don Alimento', 'banco', 994.86, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Carne molida', 'Kilos', 'Carnes', 'BuenSabor', 'banco', 994.86, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'SaludPlus', 'banco', 633.75, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'NutriVida', 'banco', 633.75, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'Kilos', 'Enlatados', 'AlimBank', 'banco', 3.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Atún', 'Kilos', 'Enlatados', 'NutriVida', 'banco', 3.25, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Barritas', 'Kilos', 'Snacks', 'AlimBank', 'banco', 114.95, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'SaludPlus', 'banco', 114.95, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Piña', 'Kilos', 'Frutas', 'SaludPlus', 'banco', 273.17, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Banano', 'Kilos', 'Frutas', 'SaludPlus', 'banco', 273.17, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Papa', 'Kilos', 'Hortalizas', 'NutriVida', 'banco', 321.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Cebolla', 'Kilos', 'Hortalizas', 'AlimBank', 'banco', 321.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Barritas', 'KILOS', 'Snacks', 'AlimBank', 'banco', 138.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'KILOS', 'Snacks', 'NutriVida', 'banco', 138.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'Kilos', 'Enlatados', 'Don Alimento', 'banco', 102.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Frijoles enlatados', 'Kilos', 'Enlatados', 'BuenSabor', 'banco', 102.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Avena', 'Kilos', 'Cereales', 'BuenSabor', 'banco', 2.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Arroz', 'Kilos', 'Cereales', 'NutriVida', 'banco', 2.8, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'AlimBank', 'banco', 0.68, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Galletas', 'Kilos', 'Snacks', 'NutriVida', 'banco', 0.68, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Duraznos en almíbar', 'Kilos', 'Conservas', 'AlimBank', 'banco', 2346.09, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Mermelada', 'Kilos', 'Conservas', 'SaludPlus', 'banco', 2346.09, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Sardinas', 'Kilos', 'Enlatados', 'BuenSabor', 'banco', 41.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Atún', 'Kilos', 'Enlatados', 'NutriVida', 'banco', 41.0, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Embutidos', 'Kilos', 'Carnes', 'BuenSabor', 'banco', 75.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Carne molida', 'Kilos', 'Carnes', 'Don Alimento', 'banco', 75.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Carne molida', 'Kilos', 'Carnes', 'AlimBank', 'banco', 25.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Pollo', 'Kilos', 'Carnes', 'AlimBank', 'banco', 25.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Jugo de frutas', 'Kilos', 'Bebidas', 'BuenSabor', 'banco', 10.77, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Bebida vegetal', 'Kilos', 'Bebidas', 'SaludPlus', 'banco', 10.77, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Arroz', 'Kilos', 'Cereales', 'Don Alimento', 'banco', 0.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Harina', 'Kilos', 'Cereales', 'NutriVida', 'banco', 0.15, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Leche', 'Kilos', 'Lácteos', 'NutriVida', 'banco', 53.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Queso', 'Kilos', 'Lácteos', 'Don Alimento', 'banco', 53.5, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Galletas', 'Kilos', 'Snacks', 'Don Alimento', 'banco', 11.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Chocolates', 'Kilos', 'Snacks', 'AlimBank', 'banco', 11.7, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Piña', 'Kilos', 'Frutas', 'AlimBank', 'banco', 17209.43, CURDATE());
INSERT INTO productos (nombre_producto, unidad, categoria, marca, fuente, cantidad_disponible, fecha_ingreso) VALUES ('Manzana', 'Kilos', 'Frutas', 'BuenSabor', 'banco', 17209.43, CURDATE());

INSERT INTO valoresnutricionalesapi (nombre_producto, calorias, proteinas, grasas, carbohidratos, fibra, azucar, hierro, calcio)
VALUES ('Chocolates', 546, 7.6, 31.0, 61.0, 7.0, 47.0, 2.4, 110),
       ('Galletas', 502, 6.5, 24.0, 66.0, 2.5, 22.0, 3.2, 30),
       ('Piña', 50, 0.5, 0.1, 13.0, 1.4, 10.0, 0.3, 13),
       ('Manzana', 52, 0.3, 0.2, 14.0, 2.4, 10.0, 0.1, 6),
       ('Harina', 364, 10.0, 1.0, 76.0, 2.7, 0.3, 1.2, 15),
       ('Avena', 389, 16.9, 6.9, 66.3, 10.6, 0.0, 4.7, 54),
       ('Cebolla', 40, 1.1, 0.1, 9.3, 1.7, 4.2, 0.2, 23),
       ('Papa', 77, 2.0, 0.1, 17.0, 2.2, 0.8, 0.8, 12),
       ('Carne molida', 250, 26.0, 17.0, 0.0, 0.0, 0.0, 2.6, 18),
       ('Pollo', 239, 27.0, 14.0, 0.0, 0.0, 0.0, 1.3, 15),
       ('Jugo de frutas', 45, 0.5, 0.1, 11.0, 0.2, 9.0, 0.2, 8),
       ('Bebida vegetal', 35, 1.0, 1.5, 4.0, 0.5, 2.0, 0.3, 120),
       ('Yogur', 59, 10.0, 0.4, 3.6, 0.0, 3.2, 0.1, 110),
       ('Queso', 402, 25.0, 33.0, 1.3, 0.0, 0.5, 0.7, 721),
       ('Zanahoria', 41, 0.9, 0.2, 10.0, 2.8, 4.7, 0.3, 33),
       ('Sardinas', 208, 25.0, 11.0, 0.0, 0.0, 0.0, 2.9, 382),
       ('Frijoles enlatados', 127, 8.7, 0.5, 22.8, 6.4, 0.6, 2.1, 46),
       ('Atún', 132, 28.0, 1.3, 0.0, 0.0, 0.0, 1.3, 15),
       ('Lentejas', 116, 9.0, 0.4, 20.0, 7.9, 1.8, 3.3, 19),
       ('Garbanzos', 164, 8.9, 2.6, 27.4, 7.6, 4.8, 2.9, 49),
       ('Embutidos', 301, 12.0, 27.0, 2.1, 0.0, 1.0, 1.2, 30),
       ('Barritas', 389, 6.0, 15.0, 56.0, 3.0, 18.0, 1.5, 60),
       ('Duraznos en almíbar', 83, 0.4, 0.1, 22.0, 1.4, 19.0, 0.5, 6),
       ('Mermelada', 278, 0.3, 0.1, 75.0, 0.4, 52.0, 0.2, 9),
       ('Banano', 89, 1.1, 0.3, 23.0, 2.6, 12.0, 0.3, 5),
       ('Leche', 42, 3.4, 1.0, 5.0, 0.0, 5.0, 0.0, 120),
       ('Arroz', 130, 2.7, 0.3, 28.0, 0.4, 0.1, 1.2, 10),
		('Pasta', 157, 5.8, 0.9, 30.9, 1.8, 0.6, 1.3, 7),
		('Choclo', 96, 3.4, 1.5, 21.0, 2.7, 4.5, 0.5, 2),
		('Huevo', 143, 13.0, 10.0, 1.1, 0.0, 0.4, 1.2, 50);
        
        UPDATE productos SET cantidad_disponible = cantidad_disponible + 35;


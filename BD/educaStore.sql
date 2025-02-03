CREATE DATABASE IF NOT EXISTS EduStoreGuayaquil;
USE EduStoreGuayaquil;

-- Crear tabla Usuarios
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    tipo_usuario ENUM('Padre', 'Estudiante', 'Personal') NOT NULL
);

-- Crear tabla Productos
CREATE TABLE Productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    stock INT,
    categoria VARCHAR(100)
);

-- Crear tabla Pedidos
CREATE TABLE Pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    fecha DATE,
    total DECIMAL(10, 2),
    estado ENUM('Pendiente', 'Procesando', 'Enviado', 'Entregado', 'Cancelado') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

-- Crear tabla DetallesPedidos
CREATE TABLE DetallesPedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    producto_id INT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    FOREIGN KEY (pedido_id) REFERENCES Pedidos(id),
    FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

-- Crear tabla Inventario
CREATE TABLE Inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    cantidad INT,
    fecha_actualizacion DATE,
    FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

-- Crear tabla Transacciones
CREATE TABLE Transacciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    fecha DATE,
    metodo_pago ENUM('Tarjeta de Crédito', 'Tarjeta de Débito', 'Transferencia Bancaria', 'Efectivo') NOT NULL,
    estado ENUM('Completada', 'Pendiente', 'Fallida') NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedidos(id)
);
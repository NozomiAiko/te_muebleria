-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2024 a las 15:54:47
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_muebleria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre_cat` varchar(255) DEFAULT NULL,
  `descripcion_cat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_cat`, `descripcion_cat`) VALUES
(1, 'dormitorio', 'muebles exclusivos para dormitorio'),
(2, 'silla', 'sillas de madera variada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cli` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `direccion_cli` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre_cli`, `email`, `direccion_cli`, `telefono`) VALUES
(221, 'katherine alejandra santos', 'kathy@gmail.com', 'calle monte video nro 539', 69965522),
(222, 'luis fernando', 'fernando@gmail.com', 'calle kentuky', 76721329),
(224, 'alejandro', 'al@gmial.com', 'calle monte video', 79605740);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_inventario`
--

CREATE TABLE `detalle_inventario` (
  `id_detalle` int(11) NOT NULL,
  `cd_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha_det` date DEFAULT NULL,
  `id_inventario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_inventario`
--

INSERT INTO `detalle_inventario` (`id_detalle`, `cd_producto`, `cantidad`, `fecha_det`, `id_inventario`) VALUES
(8001, 11, 12, '2024-06-11', 6001);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle_pedido` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `cod_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle_pedido`, `id_pedido`, `cod_producto`, `cantidad`) VALUES
(7001, 5001, 11, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id_inventario`, `id_producto`, `cantidad`, `fecha`) VALUES
(6001, 11, 12, '2024-06-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  `cod_usuario` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `cod_cliente`, `cod_usuario`, `fecha`, `total`, `estado`) VALUES
(5001, NULL, 3001, '2024-06-26', 120.30, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre_pro` varchar(255) DEFAULT NULL,
  `descripcion_pro` text DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre_pro`, `descripcion_pro`, `precio_unitario`, `id_categoria`) VALUES
(11, 'mesa', 'mesa para dormitorio hecho con madera de pino color blanco', 10.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usu` varchar(100) DEFAULT NULL,
  `contraseña` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono_usu` int(11) DEFAULT NULL,
  `rol` varchar(10) DEFAULT 'user'
) ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usu`, `contraseña`, `correo`, `direccion`, `telefono_usu`, `rol`) VALUES
(3001, 'maria josefina', '12345', 'josefina@gmail.com', 'calle alex nro 214', 79546515, 'user'),
(3002, 'Victor Hugo', '12345', 'rosavictor625@gmail.com', 'calle obaya', 77253201, 'admin'),
(3003, 'Victor Hugo', '1234', 'rosavictor625@gmail.com', 'calle obaya', 77253201, 'user'),
(3004, 'Victor Hugo', NULL, 'rosavictor625@gmail.com', 'calle obaya', 77253201, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `fecha_venta` date DEFAULT NULL,
  `cd1_producto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `id_cliente`, `id_usuario`, `total`, `fecha_venta`, `cd1_producto`) VALUES
(4001, NULL, 3001, 10006.00, '2024-06-25', 11);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `detalle_inventario`
--
ALTER TABLE `detalle_inventario`
  ADD PRIMARY KEY (`id_detalle`) USING BTREE,
  ADD KEY `cd_producto` (`cd_producto`),
  ADD KEY `id_inventario` (`id_inventario`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle_pedido`) USING BTREE,
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `cod_producto` (`cod_producto`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_inventario`) USING BTREE,
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`) USING BTREE,
  ADD KEY `cod_cliente` (`cod_cliente`),
  ADD KEY `cod_usuario` (`cod_usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`) USING BTREE,
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`) USING BTREE,
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `cd1_producto` (`cd1_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=225;

--
-- AUTO_INCREMENT de la tabla `detalle_inventario`
--
ALTER TABLE `detalle_inventario`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8002;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7002;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_inventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6002;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5002;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4002;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_inventario`
--
ALTER TABLE `detalle_inventario`
  ADD CONSTRAINT `cd_producto` FOREIGN KEY (`cd_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `id_inventario` FOREIGN KEY (`id_inventario`) REFERENCES `inventario` (`id_inventario`);

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `cod_producto` FOREIGN KEY (`cod_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `id_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `id_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `cod_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `cod_usuario` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `cd1_producto` FOREIGN KEY (`cd1_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

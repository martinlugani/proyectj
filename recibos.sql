-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-09-2020 a las 07:38:31
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recibos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo`
--

CREATE TABLE `archivo` (
  `idarchivo` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `ruta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `archivo`
--

INSERT INTO `archivo` (`idarchivo`, `nombre`, `ruta`) VALUES
(1, '4fe5dfce-5897-4db5-bcc0-432c0d6ffab3_RecibosImpotados.csv', 'abril');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(2) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `porcentaje` int(11) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `gratificacion` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `descripcion`, `porcentaje`, `tipo`, `gratificacion`) VALUES
(1, 'Jubilacion', 10, 1, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firma`
--

CREATE TABLE `firma` (
  `idfirma` bigint(20) NOT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `firma` varchar(255) DEFAULT NULL,
  `refirma` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `firma`
--

INSERT INTO `firma` (`idfirma`, `idusuario`, `firma`, `refirma`) VALUES
(1, NULL, '12345', '12345'),
(2, NULL, '2345', '2345'),
(3, NULL, '2378', '2378'),
(4, NULL, '6789', '6789'),
(5, NULL, '123', '123'),
(6, 2, '321', '321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `id` bigint(20) NOT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `idrecibo` varchar(255) DEFAULT NULL,
  `idusuario` varchar(255) DEFAULT NULL,
  `importe` int(11) NOT NULL,
  `importetotal` int(11) NOT NULL,
  `nrorecibo` varchar(255) DEFAULT NULL,
  `tipoconcepto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`id`, `concepto`, `idrecibo`, `idusuario`, `importe`, `importetotal`, `nrorecibo`, `tipoconcepto`) VALUES
(1, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(2, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(3, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(4, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(5, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(6, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(7, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(8, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(9, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(10, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(11, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(12, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(13, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(14, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(15, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(16, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(17, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(18, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(19, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(20, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(21, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(22, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(23, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(24, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(25, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(26, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(27, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(28, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(29, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(30, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(31, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(32, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(33, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(34, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(35, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(36, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(37, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(38, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(39, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(40, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(41, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(42, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D'),
(43, 'Sueldo Basico', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a5', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 1500, 1450, '234324', 'H'),
(44, 'Jubilacion', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a6', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '234245', 'D'),
(45, 'Obra social', '3c6fb2c9-600e-4d76-92b3-8ba2d0f392a7', '1cdf83da-2d3c-4148-9cb7-b6e063c527d7', 25, 1450, '287654', 'D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` bigint(20) NOT NULL,
  `abreviacion` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellido` varchar(150) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `tipodocumento` int(2) NOT NULL,
  `nrodocumento` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fechaAlta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `usuario`, `tipodocumento`, `nrodocumento`, `email`, `fechaAlta`) VALUES
(1, 'Daniel', 'Granizado', 'dgranizado', 1, 20458745, 'dgranizado@gmail.com', '2020-06-01'),
(2, 'Elizabeth', 'Grant', 'egrant', 1, 21452146, 'egrant@gmail.com', '2020-06-10'),
(3, 'Juan', 'Perz', 'jperez', 1, 23145256, 'jperez@gmail.com', '2020-06-09');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD PRIMARY KEY (`idarchivo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indices de la tabla `firma`
--
ALTER TABLE `firma`
  ADD PRIMARY KEY (`idfirma`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idtipodocumento`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivo`
--
ALTER TABLE `archivo`
  MODIFY `idarchivo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `firma`
--
ALTER TABLE `firma`
  MODIFY `idfirma` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2020 a las 23:01:58
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
(1, '4fe5dfce-5897-4db5-bcc0-432c0d6ffab3_RecibosImpotados.csv', 'abril'),
(6, 'RecibosImpotadosV4.csv', 'lanita'),
(7, 'recibos Octubre', 'Octubre');

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
(1, 'Jubilacion', 34, 1, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idempresa` bigint(20) NOT NULL,
  `cuit` bigint(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `fechainicioactividades` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idempresa`, `cuit`, `direccion`, `empresa`, `fechainicioactividades`) VALUES
(1, 30692138747, 'av.Libertador 2546', 'HEDLAN', '2019-03-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firma`
--

CREATE TABLE `firma` (
  `id` bigint(20) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `firma` varchar(255) DEFAULT NULL,
  `refirma` varchar(255) DEFAULT NULL,
  `idusuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `id` int(11) NOT NULL,
  `idusuario` int(10) DEFAULT NULL,
  `estado` varchar(50) DEFAULT '1',
  `idtrax` int(10) DEFAULT NULL,
  `periodo` varchar(50) DEFAULT NULL,
  `idconceptouno` int(10) DEFAULT NULL,
  `importeuno` int(10) DEFAULT NULL,
  `idconceptodos` int(10) DEFAULT NULL,
  `importedos` int(10) DEFAULT NULL,
  `idconceptotres` int(10) DEFAULT NULL,
  `importetres` int(10) DEFAULT NULL,
  `importetotal` int(10) DEFAULT NULL,
  `idfirmausuario` int(10) DEFAULT NULL,
  `idfirmadmin` int(10) DEFAULT NULL,
  `idcategoria` bigint(20) DEFAULT NULL,
  `conceptodos` varchar(255) DEFAULT NULL,
  `conceptotres` varchar(255) DEFAULT NULL,
  `conceptouno` varchar(255) DEFAULT NULL,
  `idempresa` bigint(20) DEFAULT 1,
  `concepto` varchar(255) DEFAULT NULL,
  `idrecibo` varchar(255) DEFAULT NULL,
  `importe` int(11) NOT NULL,
  `nrorecibo` varchar(255) DEFAULT NULL,
  `tipoconcepto` varchar(255) DEFAULT NULL,
  `conformidad` int(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`id`, `idusuario`, `estado`, `idtrax`, `periodo`, `idconceptouno`, `importeuno`, `idconceptodos`, `importedos`, `idconceptotres`, `importetres`, `importetotal`, `idfirmausuario`, `idfirmadmin`, `idcategoria`, `conceptodos`, `conceptotres`, `conceptouno`, `idempresa`, `concepto`, `idrecibo`, `importe`, `nrorecibo`, `tipoconcepto`, `conformidad`) VALUES
(1, 1, '0', 1, 'abril', 1, 350, 2, 250, 3, 20000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 0),
(2, 2, '0', 2, 'Junio', 1, 450, 2, 320, 3, 24000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 0),
(4, 7, '2', 1, 'abril', 1, 350, 2, 250, 3, 20000, 0, 7, 0, NULL, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 2),
(5, 8, '3', 2, 'Junio', 1, 450, 2, 320, 3, 24000, 0, 7, 8, NULL, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 0),
(6, 7, '3', 3, 'Agosto', 1, 350, 2, 250, 3, 27000, 0, 7, 8, NULL, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idrol` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `rol` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idrol`, `idusuario`, `rol`) VALUES
(1, 7, 'ROLE_USER'),
(2, 1, 'ROLE_USER'),
(3, 8, 'ROLE_ADMIN'),
(4, 4, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` bigint(20) NOT NULL,
  `abreviacion` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idtipodocumento`, `abreviacion`, `descripcion`) VALUES
(1, 'DNI', 'DOCUMENTO NACIONAL IDENTIDAD'),
(2, 'PASS', 'PASSAPORTE'),
(3, 'CARNET EXT', 'CARNET DE EXTRANJERO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellido` varchar(150) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nrodocumento` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `idtipodocumento` bigint(20) DEFAULT NULL,
  `fecha_alta` date DEFAULT current_timestamp(),
  `password` varchar(100) DEFAULT NULL,
  `enable` int(1) DEFAULT 0,
  `activo` int(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `username`, `nrodocumento`, `email`, `idtipodocumento`, `fecha_alta`, `password`, `enable`, `activo`) VALUES
(1, 'Daniel', 'Granizado', 'dgranizado', 20458745, 'dgranizado@gmail.com', 1, '2020-07-15', '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 0),
(2, 'Elizabeth', 'Grant', 'egrant', 21452146, 'egrant@gmail.com', 1, '2020-05-12', NULL, 1, 0),
(4, 'lanita', 'Usuario', 'uprueba', 25432453, 'pedro@friendface.com', 2, '2020-11-03', '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 0),
(7, 'user', 'Usuario', 'user', 43456232, 'busuario@gmail.com', 1, NULL, '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 0),
(8, 'Usuario', 'admin', 'admin', 23982382, 'jimena.villca2@gmail.com', 1, '2020-10-01', '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 0),
(43, 'Oscar', 'Mendez', 'omendez', 20392871, 'jimena.villca2@gmail.com', 1, NULL, '1e2cd9ba-f2b3-4e60-879f-f49fda7897c4', NULL, NULL),
(45, 'Isabel', 'Winigs', 'iwinigs', 28129328, 'jimena.villca2@gmail.com', 3, NULL, '30134a17-967b-410a-83a6-a374005153e7', NULL, NULL);

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
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`idempresa`);

--
-- Indices de la tabla `firma`
--
ALTER TABLE `firma`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `FK1ob3plf5yn7uxvdg85g5rcofy` (`idempresa`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idrol`),
  ADD KEY `iduserol` (`idusuario`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idtipodocumento`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD KEY `FK5ioqihytjua20v0gx70p10grx` (`idtipodocumento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivo`
--
ALTER TABLE `archivo`
  MODIFY `idarchivo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `idempresa` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD CONSTRAINT `FK1ob3plf5yn7uxvdg85g5rcofy` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  ADD CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `iduserol` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK5ioqihytjua20v0gx70p10grx` FOREIGN KEY (`idtipodocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

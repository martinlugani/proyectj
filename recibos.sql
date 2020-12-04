-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2020 a las 22:51:03
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.1.31

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
(7, 'recibos Octubre', 'Octubre'),
(9, 'RecibosImpotadosV5.csv', 'Summertime sadness');

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
  `idfirma` bigint(20) NOT NULL,
  `idusuario` bigint(20) DEFAULT NULL,
  `fecha_alta` date DEFAULT current_timestamp(),
  `firma` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `firma`
--

INSERT INTO `firma` (`idfirma`, `idusuario`, `fecha_alta`, `firma`) VALUES
(1, 7, '2020-10-05', 'admin'),
(2, 8, NULL, 'radio');

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
  `nrorecibo` varchar(255) DEFAULT NULL,
  `tipoconcepto` varchar(255) DEFAULT NULL,
  `conformidad` int(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`id`, `idusuario`, `estado`, `idtrax`, `periodo`, `idconceptouno`, `importeuno`, `idconceptodos`, `importedos`, `idconceptotres`, `importetres`, `importetotal`, `idfirmausuario`, `idfirmadmin`, `idcategoria`, `conceptodos`, `conceptotres`, `conceptouno`, `idempresa`, `concepto`, `idrecibo`, `nrorecibo`, `tipoconcepto`, `conformidad`) VALUES
(1, 1, '0', 1, 'abril', 1, 350, 2, 250, 3, 20000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(2, 2, '0', 2, 'Junio', 1, 450, 2, 320, 3, 24000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(4, 7, '2', 1, 'abril', 1, 350, 2, 250, 3, 20000, 0, 7, 0, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 2),
(5, 8, '3', 2, 'Junio', 1, 450, 2, 320, 3, 24000, 0, 7, 8, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(6, 7, '3', 3, 'Agosto', 1, 350, 2, 250, 3, 27000, 0, 7, 8, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(20, 1, '0', 1, 'abril', 1, 27000, 2, 2500, 3, 1500, 23000, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(21, 2, '0', 2, 'Junio', 1, 29000, 2, 3000, 3, 1500, 24500, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(22, 3, '0', 3, 'Agosto', 1, 35000, 2, 2400, 3, 1500, 31100, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(23, 2, '0', 2, 'Junio', 1, 45000, 2, 700, 3, 1500, 42800, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(24, 2, '0', 2, 'OCTUBRE', 1, 41000, 2, 800, 3, 1500, 38700, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(25, 8, '0', 2, 'SEPTIEMBRE', 1, 35000, 2, 800, 3, 1500, 32700, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0),
(26, 7, '0', 2, 'SEPTIEMBRE', 1, 41000, 2, 500, 3, 1500, 37000, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` bigint(20) NOT NULL,
  `rol` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `visible` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `rol`, `descripcion`, `visible`) VALUES
(1, 'ROLE_ADMIN', 'Administrador', 0),
(2, 'ROLE_USER', 'Usuario', 0),
(3, 'ROLE_INIT_ADMIN', 'Rol Administrador', 1),
(4, 'ROLE_INIT_USER', 'Rol Usuario', 1);

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
  `enable` int(1) DEFAULT 1,
  `idrol` bigint(20) DEFAULT NULL,
  `activo` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `username`, `nrodocumento`, `email`, `idtipodocumento`, `fecha_alta`, `password`, `enable`, `idrol`, `activo`) VALUES
(1, 'Daniel', 'Granizado', 'dgranizado', 20458745, 'dgranizado@gmail.com', 1, '2020-07-15', '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 3, NULL),
(2, 'Elizabeth', 'Grant', 'egrant', 21452146, 'egrant@gmail.com', 1, '2020-05-12', '$2a$10$80TpVhCcuvNz.Kiiamr5uOgbIauyzc4oNFaQDeRV1RatbxjO6i1NC', 1, 3, NULL),
(3, 'Federico', 'Carpe', 'fcarpe', 38299128, 'fcarpe@gmail.com.ar', 1, NULL, '0802606a-c193-4cb0-895d-0dc24f143e67', NULL, 2, NULL),
(7, 'user', 'Usuario', 'user', 43456232, 'busuario@gmail.com', 1, NULL, '$2a$10$v6GAy.YpRU/VV4WqExcNteaEpVrZGSEVAhG3zLx8PZ8tk.ozx3ODy', 1, 2, NULL),
(8, 'Usuario', 'admin', 'admin', 23982382, 'jimena.villca2@gmail.com', 1, '2020-10-01', '$2a$10$ePLjZ0cRad5KTCZxYMQeTebB5a6DvLLEEh72s4EQEfgt33ufh32A2', 1, 1, NULL),
(70, 'Federico', 'Usuario', 'fusuario', 24576121, 'jimena.villca2@gmail.com', 1, NULL, '92c659dd-6218-4f14-ab2c-bda3e6cd8592', NULL, 2, NULL),
(71, 'Federico', 'Carpe', 'fcarpe', 24576121, 'jimena.villca2@gmail.com', 1, NULL, '08b16aed-8c28-44c7-88a2-5b692c32f356', NULL, 2, NULL),
(72, 'Felipe', 'Rey', 'frey', 9877767, 'jimena.villca2@gmail.com', 1, NULL, '$2a$10$GRCw74yYqwdPTNyb0epfVuV0JwY2g/jCHq2xfsclMfbX9BPRoGBUa', 1, 3, NULL),
(73, 'Julia', 'Rey', 'jrey', 24576121, 'jimena.villca2@gmail.com', 1, NULL, '$2a$10$qmkoDkFSk586qA2dBLElcOdwl10UtGfGbHypV4CG0oSE7tE5.FRly', NULL, 4, NULL),
(74, 'lanabanana', 'Musk', 'lmusck', 24576121, 'jimena.villca2@gmail.com', 1, NULL, '$2a$10$8BjzcobUPkcW4u.oW6OeHuWMzlYlnvJQFY.IuNnr6itCkUEWPC2d.', 1, 1, NULL),
(75, 'Daniel', 'Ultra', 'dultra', 24576121, 'jimena.villca2@gmail.com', 1, NULL, '$2a$10$p3UIDH3/ebW5RTcicwRLfuC/N1wp1seSPJf6V6J1J9tT8QE3PA3kW', 1, 2, NULL);

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
  ADD PRIMARY KEY (`idfirma`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `FK1ob3plf5yn7uxvdg85g5rcofy` (`idempresa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

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
  ADD KEY `FK5ioqihytjua20v0gx70p10grx` (`idtipodocumento`),
  ADD KEY `FK10bib7rrkh36ss78063ifbq6k` (`idrol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivo`
--
ALTER TABLE `archivo`
  MODIFY `idarchivo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
-- AUTO_INCREMENT de la tabla `firma`
--
ALTER TABLE `firma`
  MODIFY `idfirma` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD CONSTRAINT `FK1ob3plf5yn7uxvdg85g5rcofy` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  ADD CONSTRAINT `FKnkl0qxj20e7bfmaf7xbwhq3mx` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK10bib7rrkh36ss78063ifbq6k` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`),
  ADD CONSTRAINT `FK5ioqihytjua20v0gx70p10grx` FOREIGN KEY (`idtipodocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

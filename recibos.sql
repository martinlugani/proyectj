-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2020 a las 02:46:01
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.1.32

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
(6, '27a29e6c-7f7b-45a1-89c3-1aeac62f5452_RecibosImpotadosV2.csv', 'lanita');

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
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idempresa` int(2) NOT NULL,
  `empresa` varchar(150) DEFAULT NULL,
  `fechainicioactividades` date DEFAULT NULL,
  `cuit` int(20) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idempresa`, `empresa`, `fechainicioactividades`, `cuit`, `direccion`) VALUES
(1, 'HEDLAN', '2020-09-01', 303810032, 'Av.Libertador 2500');

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
  `idempresa` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`id`, `idusuario`, `estado`, `idtrax`, `periodo`, `idconceptouno`, `importeuno`, `idconceptodos`, `importedos`, `idconceptotres`, `importetres`, `importetotal`, `idfirmausuario`, `idfirmadmin`, `idcategoria`, `conceptodos`, `conceptotres`, `conceptouno`, `idempresa`) VALUES
(1, 1, '1', 1, 'abril', 1, 350, 2, 250, 3, 20000, 19400, NULL, NULL, NULL, 'Cobertura medica', 'Sueldo bruto', 'Jubilacion', 1),
(2, 2, '1', 2, 'Junio', 1, 450, 2, 320, 3, 24000, 23230, NULL, NULL, NULL, 'Cobertura medica', 'Sueldo bruto', 'Jubilacion', 1),
(4, 1, '0', 1, 'abril', 1, 350, 2, 250, 3, 20000, 19400, 0, 0, NULL, 'Cobertura medica', 'Sueldo bruto', 'Jubilacion', 1),
(5, 2, '0', 2, 'Junio', 1, 450, 2, 320, 3, 24000, 23230, 0, 0, NULL, 'Cobertura medica', 'Sueldo bruto', 'Jubilacion', 1),
(6, 3, '0', 3, 'Agosto', 1, 350, 2, 250, 3, 27000, 26400, 0, 0, NULL, 'Cobertura medica', 'Sueldo bruto', 'Jubilacion', 1);

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
(1, 'DNI', 'DOCUMNETO NACIONAL IDENTIDAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellido` varchar(150) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `nrodocumento` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `idtipodocumento` bigint(20) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `usuario`, `nrodocumento`, `email`, `idtipodocumento`, `fecha_alta`) VALUES
(1, 'Daniel', 'Granizado', 'dgranizado', 20458745, 'dgranizado@gmail.com', 1, '2020-06-01'),
(2, 'Elizabeth', 'Grant', 'egrant', 21452146, 'egrant@gmail.com', 1, '2020-06-10'),
(3, 'Juan', 'Perz', 'jperez', 23145256, 'jperez@gmail.com', 1, '2020-06-09');

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
  ADD KEY `idusuario` (`idusuario`);

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
  MODIFY `idarchivo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `idempresa` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `firma`
--
ALTER TABLE `firma`
  MODIFY `idfirma` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK5ioqihytjua20v0gx70p10grx` FOREIGN KEY (`idtipodocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

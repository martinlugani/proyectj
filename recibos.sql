-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2020 a las 19:46:38
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.1.26

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
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE `concepto` (
  `idConcepto` int(11) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `primerconcepto` varchar(50) DEFAULT NULL,
  `primerTipoConcepto` varchar(1) DEFAULT NULL,
  `primerImporte` int(11) DEFAULT NULL,
  `idRecibo` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `NroLoteProcesado` int(11) DEFAULT NULL,
  `segundoConcepto` varchar(50) DEFAULT NULL,
  `segundoTipoConcepto` varchar(1) DEFAULT NULL,
  `segundoImporte` int(11) DEFAULT NULL,
  `tercerConcepto` varchar(50) DEFAULT NULL,
  `tercerTipoConcepto` varchar(1) DEFAULT NULL,
  `tercerImporte` int(11) DEFAULT NULL,
  `cuartoConcepto` varchar(50) DEFAULT NULL,
  `cuartoTipoConcepto` varchar(1) DEFAULT NULL,
  `cuartoImporte` int(11) DEFAULT NULL,
  `importeTotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`idConcepto`, `fechaAlta`, `primerconcepto`, `primerTipoConcepto`, `primerImporte`, `idRecibo`, `idusuario`, `NroLoteProcesado`, `segundoConcepto`, `segundoTipoConcepto`, `segundoImporte`, `tercerConcepto`, `tercerTipoConcepto`, `tercerImporte`, `cuartoConcepto`, `cuartoTipoConcepto`, `cuartoImporte`, `importeTotal`) VALUES
(1, '2019-10-27', 'D', 'H', 1500, NULL, 1, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(2, '2019-10-27', NULL, 'D', 25, NULL, 1, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(3, '2019-10-27', NULL, 'D', 25, NULL, 1, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(4, '2019-10-27', 'H', 'H', 1500, NULL, 41, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(5, '2019-10-27', 'D', 'D', 25, NULL, 1, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(6, '2019-10-27', 'D', 'D', 25, NULL, 1, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(7, '2019-10-27', 'H', 'H', 1500, NULL, 41, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(8, '2019-10-27', 'D', 'D', 25, NULL, 41, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(9, '2019-10-27', 'D', 'D', 25, NULL, 1, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(10, '2019-10-27', 'Sueldo Basico', 'H', 1500, NULL, 40, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(11, '2019-10-27', 'Jubilacion', 'D', 25, NULL, 40, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(12, '2019-10-27', 'Obra social', 'D', 25, NULL, 40, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(13, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(14, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(15, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, NULL, '', '', 0, '', '', 0, '', '', 0, 0),
(16, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(17, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(18, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(19, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(20, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(21, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 1, '', '', 0, '', '', 0, '', '', 0, 0),
(22, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(23, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(24, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(25, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(26, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(27, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(28, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(29, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(30, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 2, '', '', 0, '', '', 0, '', '', 0, 0),
(31, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(32, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(33, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(34, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(35, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(36, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(37, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(38, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(39, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(40, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(41, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(42, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(43, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(44, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(45, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(46, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(47, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(48, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 3, '', '', 0, '', '', 0, '', '', 0, 0),
(49, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 5, '', '', 0, '', '', 0, '', '', 0, 0),
(50, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 5, '', '', 0, '', '', 0, '', '', 0, 0),
(51, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 5, '', '', 0, '', '', 0, '', '', 0, 0),
(52, '2019-11-02', 'Sueldo Basico', 'H', 1500, NULL, NULL, 7, '', '', 0, '', '', 0, '', '', 0, 0),
(53, '2019-11-02', 'Jubilacion', 'D', 25, NULL, NULL, 7, '', '', 0, '', '', 0, '', '', 0, 0),
(54, '2019-11-02', 'Obra social', 'D', 25, NULL, NULL, 7, '', '', 0, '', '', 0, '', '', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firma`
--

CREATE TABLE `firma` (
  `idfirma` int(11) NOT NULL,
  `CodigoFirma` int(11) NOT NULL,
  `IdUsuario` int(11) DEFAULT NULL,
  `FechaAlta` int(11) NOT NULL,
  `FechaBaja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `Descripcion` varchar(75) DEFAULT NULL,
  `FechaAlta` date DEFAULT NULL,
  `FechaBaja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `Descripcion`, `FechaAlta`, `FechaBaja`) VALUES
(21, 'Administrador', '2019-09-08', NULL),
(22, 'usuario consulta', '2019-09-08', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `abreviacion` varchar(10) DEFAULT NULL,
  `fechaAlta` date DEFAULT NULL,
  `fechaBaja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idtipodocumento`, `descripcion`, `abreviacion`, `fechaAlta`, `fechaBaja`) VALUES
(30, 'Documento Nacional de Identidad', 'DNI', '2019-09-09', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `idTipoDocumento` int(11) DEFAULT NULL,
  `numeroDocumento` varchar(15) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `FechaAlta` date DEFAULT NULL,
  `idFirma` int(11) DEFAULT NULL,
  `FechaBaja` date DEFAULT NULL,
  `idRol` varchar(45) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `idTipoDocumento`, `numeroDocumento`, `usuario`, `contrasena`, `email`, `FechaAlta`, `idFirma`, `FechaBaja`, `idRol`, `cargo`) VALUES
(1, 'sda', 'sad', 30, '213213', 'jo', 'a', 'a', '2019-09-02', 1, '2019-10-07', '21', NULL),
(40, 'Usuario', 'Prueba', 30, '21023612', 'prueba', 'abc123', 'prueba@gmail.com', '2019-09-09', NULL, NULL, '21', NULL),
(41, 'dsfds', 'sfsdf', 30, '45435', 'mar', 'w', 'ww', '2019-09-02', NULL, NULL, '21', NULL),
(42, 'dsafsa', 'dsfsDSAD', 30, '123', 'WQEW', '12', '21', '2019-09-23', NULL, NULL, 'DASD', NULL),
(43, 'ASDSAD', 'ASDA', 30, '111', 'SAD', 'SAS', '21', '2019-09-23', NULL, NULL, 'SADSA', NULL),
(44, 'Daniel', 'Lopez', 30, '123293248', 'danielop', 'lop', '21', '2019-10-05', NULL, NULL, 'prueba@gmail.com', NULL),
(45, 'Dario', 'Nuverio', 30, '23345347', 'dash', 'hup', '21', '2019-10-05', NULL, NULL, 'asdsa@gmail.com', NULL),
(46, 'Javier', 'Uport', 30, '23432987', 'uportasda', 'asdasd', '21', '2019-10-05', NULL, NULL, 'prueba@akjdaks.com', NULL),
(47, 'Ignacio', 'Omio', 30, '24234090', 'lip', 'lip', '21', '2019-10-05', NULL, NULL, 'jahsdj@jshadas,m', NULL),
(48, 'Omar', 'Chavez', 30, '2398309', 'om', 'om', '21', '2019-10-05', NULL, NULL, 'prueba@aslmdsa', NULL),
(49, 'HHJAS', 'SDFS', 30, '342423', 'SKLJDKAL', 'KLASJDLKA', '21', '2019-10-05', NULL, NULL, 'JHSADKHAJKS@JKASHDJA', NULL),
(50, 'HHGJ', 'JHGJ', 30, '765764', 'JKHGHJ', 'JKGH', '21', '2019-10-05', NULL, '2019-10-07', 'JKHJKFG', NULL),
(51, 'iHGAJSD', 'JHGADJAS', 30, '67579382', 'KLAJDLASLSAJDKL', 'JHSAKDAHS', '21', '2019-10-05', NULL, NULL, 'LASJDAKLDJAS', NULL),
(52, 'aloskp', 'lakdlañ', 30, '879769', 'ma,nsda', 'jahsjdkahs', '21', '2019-10-05', NULL, '2019-10-07', 'nmabsndma', NULL),
(53, 'hgfrths', 'hqgwdqwwq', 30, '545', '45fghf', 'dfgfdg', '21', '2019-10-05', NULL, NULL, 'fghfhb', NULL),
(54, 'Prueba', 'usuario', 30, '1231132', 'admin', '123456', '21', '2019-10-07', NULL, NULL, 'prueba@gmail.com', NULL),
(55, 'jhgthj', 'bnmbnm', 30, '65675765', 'ghjgh', 'hghjgh', '21', '2019-10-07', NULL, NULL, 'jhbjnbmm@hghj', NULL),
(56, 'Claudio', 'Tab', 30, '29189128', 'clautab', 'popcha', 'jhsanb@gmail.com', '2019-10-07', NULL, NULL, '21', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

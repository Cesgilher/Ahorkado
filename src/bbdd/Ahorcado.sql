-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2023 a las 12:57:07
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ahorcado`
--
CREATE DATABASE IF NOT EXISTS `ahorcado` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ahorcado`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `palabras`
--

CREATE TABLE `palabras` (
  `Id` int(11) NOT NULL,
  `Word` varchar(50) NOT NULL,
  `Level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `palabras`
--

INSERT INTO `palabras` (`Id`, `Word`, `Level`) VALUES
(1, 'taza', 1),
(2, 'reptil', 2),
(3, 'taladro', 2),
(4, 'impresionar', 3),
(5, 'azulejo', 2),
(6, 'ramo', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `palabras`
--
ALTER TABLE `palabras`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `palabras`
--
ALTER TABLE `palabras`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

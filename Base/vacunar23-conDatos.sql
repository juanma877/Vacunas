-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2023 a las 23:18:32
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
-- Base de datos: `vacunar23`
--
CREATE DATABASE IF NOT EXISTS `vacunar23` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacunar23`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `codCita` int(11) NOT NULL,
  `codRefuerzo` int(11) NOT NULL,
  `fechaHoraCita` varchar(60) NOT NULL,
  `idVacunatorio` int(11) NOT NULL,
  `fechaHoraColoca` datetime DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `nroSerie` int(11) NOT NULL,
  `cancelada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`codCita`, `codRefuerzo`, `fechaHoraCita`, `idVacunatorio`, `fechaHoraColoca`, `dni`, `nroSerie`, `cancelada`) VALUES
(1, 1, '2023-01-18 10:00', 1, NULL, 26986852, 4273147, 1),
(2, 1, '2023-01-02 12:00', 2, NULL, 40391237, 12534112, 1),
(3, 1, '2023-01-31 16:45', 3, NULL, 41171723, 16813715, 1),
(4, 1, '2023-02-14 17:15', 4, NULL, 2967600, 16841668, 1),
(5, 1, '2023-02-21 15:15', 5, NULL, 1030215, 18345241, 1),
(6, 1, '2023-08-02 13:45', 5, NULL, 5395154, 33507529, 0),
(7, 1, '2023-07-19 09:45', 5, NULL, 1110430, 27070983, 0),
(8, 1, '2023-07-29 16:15', 1, NULL, 12498450, 31177100, 0),
(9, 1, '2023-07-31 10:00', 3, NULL, 12816602, 31657611, 0),
(10, 1, '2023-08-22 15:30', 1, NULL, 19461537, 33891652, 0),
(11, 1, '2023-09-15 13:45', 4, '2023-10-27 18:11:05', 1297558, 34128717, 1),
(12, 2, '2023-11-24 13:45', 4, NULL, 1297558, 34324556, 1),
(13, 1, '2023-09-02 13:45', 2, '2023-10-27 18:11:34', 1637116, 43847342, 1),
(14, 2, '2023-11-24 13:45', 2, NULL, 1637116, 46287194, 1),
(15, 1, '2023-09-29 16:45', 5, '2023-10-27 18:12:04', 1655925, 46331274, 1),
(16, 2, '2023-11-24 16:45', 5, NULL, 1655925, 48091466, 1),
(17, 1, '2023-10-04 11:30', 4, '2023-10-27 18:12:45', 2726376, 51255210, 1),
(18, 2, '2023-11-24 11:30', 4, NULL, 2726376, 52039905, 1),
(19, 1, '2023-10-16 09:00', 2, '2023-10-27 18:13:12', 2790677, 53976823, 1),
(20, 2, '2023-11-24 09:00', 2, NULL, 2790677, 58571626, 1),
(21, 1, '2023-08-02 09:45', 5, NULL, 1110430, 27070983, 1),
(22, 1, '2023-08-12 16:15', 1, NULL, 12498450, 31177100, 1),
(23, 1, '2023-08-14 10:00', 3, NULL, 12816602, 31657611, 1),
(24, 1, '2023-09-05 15:30', 1, NULL, 19461537, 33891652, 1),
(25, 1, '2023-08-16 13:45', 5, NULL, 5395154, 33507529, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `idCiudadano` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombreCompleto` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `celular` varchar(60) NOT NULL,
  `patologia` varchar(60) DEFAULT NULL,
  `ambitoTrabajo` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`idCiudadano`, `dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `estado`) VALUES
(1, 40921434, 'Paki Ferguson', 'sed.nunc.est@aol.net', '1177558727', 'asma', 'comercio', 1),
(2, 41212787, 'Ray Buckner', 'nulla.cras@hotmail.com', '1112246379', 'cardiopatia', 'salud', 1),
(3, 34482445, 'Nigel Wilder', 'ac.feugiat@yahoo.net', '1196884521', NULL, 'desempleado', 1),
(4, 47685888, 'Isaac Holder', 'sed@hotmail.couk', '1176044285', 'diabetes', 'comercio', 1),
(5, 20406245, 'Lee Leach', 'eu.ligula.aenean@aol.org', '1172223248', 'obesidad', 'desempleado', 1),
(6, 33725815, 'Hamilton Mcbride', 'tincidunt.nunc@hotmail.edu', '1145848219', 'diabetes', 'educacion', 1),
(7, 2967600, 'Colt Cantu', 'aliquet.metus.urna@yahoo.org', '1124812981', 'cardiopatia', 'desempleado', 1),
(8, 23192554, 'Guy Holder', 'orci@aol.couk', '1162871178', NULL, 'salud', 1),
(9, 2726376, 'Channing Guthrie', 'lorem.eu.metus@yahoo.edu', '1152884521', NULL, 'salud', 1),
(10, 36563751, 'Salvador Cannon', 'a.dui@outlook.couk', '1156019578', 'diabetes', 'estudiante', 1),
(11, 38743768, 'Fitzgerald Ross', 'duis.ac@hotmail.ca', '1134088803', 'diabetes', 'otro', 1),
(12, 38160576, 'Harrison Sexton', 'suspendisse.tristique@icloud.org', '1151225662', 'oncologico', 'salud', 1),
(13, 16801412, 'Owen Gay', 'tristique.senectus@yahoo.edu', '1114283887', 'cardiopatia', 'salud', 1),
(14, 1335540, 'Peter Woods', 'nec@google.ca', '1153641234', 'diabetes', 'comercio', 1),
(15, 24434532, 'Leonard Simpson', 'nec@aol.net', '1164713412', NULL, 'desempleado', 1),
(16, 24484501, 'Hasad Kerr', 'nec.urna.et@hotmail.com', '1180878022', 'diabetes', 'desempleado', 1),
(17, 31938357, 'Howard Valdez', 'id.risus.quis@aol.net', '1122422819', 'cardiopatia', 'comercio', 1),
(18, 33313395, 'Dylan Holden', 'dapibus.quam@google.net', '1123842153', 'obesidad', 'desempleado', 1),
(19, 37864494, 'Kennan Giles', 'tellus.eu@hotmail.com', '1182546872', 'diabetes', 'otro', 1),
(20, 12541418, 'Ralph Hood', 'enim.gravida@outlook.couk', '1146835111', 'obesidad', 'desempleado', 1),
(21, 42968907, 'Cadman Schroeder', 'tempor.diam.dictum@yahoo.edu', '1171732328', NULL, 'comercio', 1),
(22, 3461986, 'Knox Chandler', 'lectus@icloud.edu', '1126457417', 'diabetes', 'desempleado', 1),
(23, 4791341, 'Keefe Cameron', 'eu.augue.porttitor@outlook.com', '1124537715', NULL, 'otro', 1),
(24, 28268799, 'Perry Lane', 'aliquam.arcu@icloud.couk', '1133137074', 'diabetes', 'educacion', 1),
(25, 11582698, 'Ryan Owen', 'auctor.odio@icloud.couk', '1133316742', NULL, 'desempleado', 1),
(26, 44620828, 'Lamar Mckay', 'et.ipsum@hotmail.edu', '1130642721', 'diabetes', 'estudiante', 1),
(27, 18561572, 'Arden Page', 'ipsum@hotmail.edu', '1123997488', 'obesidad', 'desempleado', 1),
(28, 43775896, 'Dylan Kline', 'penatibus@protonmail.net', '1111491150', 'diabetes', 'otro', 1),
(29, 28203652, 'Isaiah Black', 'nec.tempus@icloud.net', '1191251155', 'obesidad', 'salud', 1),
(30, 44273759, 'Steven Dawson', 'scelerisque.lorem@yahoo.couk', '1119877805', NULL, 'comercio', 1),
(31, 34827638, 'Fulton Cote', 'mi.tempor@aol.edu', '1156848527', 'asma', 'salud', 1),
(32, 38810858, 'Jonah Cervantes', 'in.tincidunt@protonmail.com', '1124543466', 'cardiopatia', 'salud', 1),
(33, 3363906, 'Magee Mathews', 'sem.vitae.aliquam@hotmail.net', '1112071549', 'asma', 'desempleado', 1),
(34, 6455590, 'Tyrone Gibson', 'ipsum.cursus@protonmail.org', '1113712376', 'cardiopatia', 'salud', 1),
(35, 25369179, 'Samuel Butler', 'purus.nullam@google.org', '1161392278', NULL, 'salud', 1),
(36, 29947569, 'Jasper Bailey', 'vulputate.velit@hotmail.edu', '1168828437', 'obesidad', 'salud', 1),
(37, 9418248, 'Amos Trevino', 'scelerisque.neque.sed@aol.com', '1120425769', 'cardiopatia', 'comercio', 1),
(38, 29799367, 'Reed Blair', 'dictum.cursus@outlook.edu', '1175420017', 'obesidad', 'comercio', 1),
(39, 1637116, 'Adrian Caldwell', 'lacus.cras@icloud.couk', '1126796265', NULL, 'seguridad', 1),
(40, 1030215, 'Melvin Bennett', 'et.malesuada@google.net', '1116314240', 'obesidad', 'salud', 1),
(41, 5395154, 'Hu Ortega', 'quam.a@hotmail.net', '1137347442', 'diabetes', 'salud', 1),
(42, 19855239, 'Merrill Rios', 'nunc.ac@yahoo.couk', '1158430124', NULL, 'otro', 1),
(43, 9995393, 'Mufutau Battle', 'cum.sociis@icloud.ca', '1183772285', 'oncologico', 'comercio', 1),
(44, 9304980, 'Baker Juarez', 'vulputate.posuere@outlook.net', '1102375087', 'obesidad', 'comercio', 1),
(45, 34960797, 'Beck Castillo', 'enim.sed@hotmail.couk', '1181711182', 'obesidad', 'otro', 1),
(46, 34665935, 'Raphael Aguirre', 'bibendum.donec@protonmail.org', '1195747748', NULL, 'comercio', 1),
(47, 4681835, 'Jeremy Glenn', 'consectetuer@protonmail.edu', '1164303313', 'obesidad', 'educacion', 1),
(48, 20709494, 'Lewis Booker', 'sem@icloud.ca', '1175835264', 'asma', 'educacion', 1),
(49, 25764128, 'Murphy Nelson', 'vel@google.couk', '1133397545', 'cardiopatia', 'otro', 1),
(50, 27257791, 'Omar Stout', 'velit.pellentesque@aol.net', '1189116213', 'cardiopatia', 'comercio', 1),
(51, 12816602, 'Marshall Contreras', 'in@outlook.com', '1174184447', 'diabetes', 'comercio', 1),
(52, 9228498, 'Knox Good', 'aenean.egestas@aol.edu', '1147323443', 'asma', 'salud', 1),
(53, 26986852, 'Sawyer Caldwell', 'a.sollicitudin@aol.couk', '1157728383', 'cardiopatia', 'salud', 1),
(54, 29723885, 'Wing Pate', 'aliquam@aol.ca', '1105586514', 'cardiopatia', 'salud', 1),
(55, 8940330, 'Stone Moody', 'ipsum@google.net', '1187151573', 'cardiopatia', 'comercio', 1),
(56, 28781199, 'Valentine French', 'libero@outlook.couk', '1166556677', 'diabetes', 'otro', 1),
(57, 32861810, 'Harper Myers', 'ante.iaculis.nec@aol.couk', '1188643662', 'cardiopatia', 'desempleado', 1),
(58, 47224790, 'Donovan Charles', 'turpis.non@google.com', '1154231718', 'oncologico', 'educacion', 1),
(59, 37494586, 'Edward Dennis', 'fusce.fermentum@hotmail.org', '1151782783', NULL, 'salud', 1),
(60, 7356900, 'Kermit Mcguire', 'velit.quisque@protonmail.net', '1141681672', 'obesidad', 'salud', 1),
(61, 39771198, 'Perry Chavez', 'semper@aol.edu', '1194571226', 'diabetes', 'desempleado', 1),
(62, 28305747, 'Ross Briggs', 'suspendisse@yahoo.ca', '1131521026', 'cardiopatia', 'seguridad', 1),
(63, 40391237, 'Reed Soto', 'quisque@protonmail.couk', '1123354291', 'obesidad', 'comercio', 1),
(64, 4324562, 'Carlos Norman', 'tristique.ac.eleifend@hotmail.com', '1131652845', NULL, 'salud', 1),
(65, 2970593, 'Moses Cortez', 'egestas.aliquam@icloud.org', '1159375248', 'cardiopatia', 'desempleado', 1),
(66, 1297558, 'Acton Mcclure', 'at.iaculis@aol.ca', '1164563419', 'cardiopatia', 'otro', 1),
(67, 5441694, 'Armand Calderon', 'eget.volutpat@aol.couk', '1195533646', 'diabetes', 'comercio', 1),
(68, 35865375, 'Declan Palmer', 'non.luctus@aol.ca', '1148614176', 'obesidad', 'desempleado', 1),
(69, 9495717, 'Connor Estes', 'nulla.semper.tellus@aol.couk', '1152237734', 'asma', 'salud', 1),
(70, 43463562, 'Garrison Pierce', 'etiam@google.couk', '1185181131', 'obesidad', 'comercio', 1),
(71, 25208476, 'Zane Rogers', 'velit.aliquam.nisl@yahoo.net', '1183825618', 'obesidad', 'desempleado', 1),
(72, 2790677, 'Richard Scott', 'non.bibendum.sed@icloud.couk', '1148760774', 'diabetes', 'educacion', 1),
(73, 12178518, 'Armand Valencia', 'sociis.natoque@google.edu', '1193247167', 'obesidad', 'comercio', 1),
(74, 22737238, 'Logan Berg', 'tortor.integer.aliquam@protonmail.org', '1113875351', 'asma', 'comercio', 1),
(75, 31242377, 'Lamar Goodman', 'in.faucibus@google.edu', '1142473727', 'asma', 'comercio', 1),
(76, 16196643, 'Igor Gross', 'et@hotmail.couk', '1192217595', 'diabetes', 'salud', 1),
(77, 26836652, 'Austin Lyons', 'aliquam.adipiscing@hotmail.edu', '1161812462', 'obesidad', 'otro', 1),
(78, 23674852, 'Fitzgerald Williams', 'libero.proin@hotmail.org', '1172349463', 'obesidad', 'salud', 1),
(79, 28555681, 'Elvis Sanchez', 'pellentesque@icloud.org', '1125584012', 'diabetes', 'comercio', 1),
(80, 42902816, 'Damon Holloway', 'aliquam.adipiscing@icloud.couk', '1148521417', 'asma', 'educacion', 1),
(81, 16655835, 'Roth Zimmerman', 'dictum.magna.ut@yahoo.couk', '1177504108', 'diabetes', 'comercio', 1),
(82, 1655925, 'Otto Bennett', 'aenean.gravida@outlook.edu', '1121574861', 'obesidad', 'desempleado', 1),
(83, 46735153, 'Quinlan Parsons', 'dui@yahoo.couk', '1172756510', 'diabetes', 'seguridad', 1),
(84, 8129550, 'Micah Stout', 'purus.gravida@yahoo.org', '1101822838', 'asma', 'otro', 1),
(85, 24221584, 'Geoffrey Wooten', 'nullam.scelerisque.neque@hotmail.net', '1191873634', 'oncologico', 'otro', 1),
(86, 1110430, 'Evan Mitchell', 'etiam.laoreet@google.com', '1181596417', NULL, 'otro', 1),
(87, 23238845, 'Tyler Wade', 'dolor.tempus@hotmail.net', '1112484153', 'asma', 'salud', 1),
(88, 15953996, 'Hedley Kirk', 'nunc.sit@yahoo.edu', '1166993674', 'cardiopatia', 'otro', 1),
(89, 12498450, 'Philip Blackburn', 'ut.cursus@outlook.net', '1184399749', 'cardiopatia', 'salud', 1),
(90, 40333415, 'Clark Salazar', 'integer.tincidunt@outlook.com', '1173227254', 'diabetes', 'desempleado', 1),
(91, 9357961, 'Brian Chase', 'nullam.velit@icloud.org', '1114443232', 'obesidad', 'otro', 1),
(92, 3438999, 'Conan Rodriquez', 'interdum.sed@protonmail.net', '1123580063', NULL, 'otro', 1),
(93, 4338081, 'Tarik Gates', 'morbi.sit@yahoo.ca', '1157334145', 'cardiopatia', 'seguridad', 1),
(94, 26269160, 'Marvin Holland', 'ligula.donec.luctus@protonmail.couk', '1173382245', 'obesidad', 'desempleado', 1),
(95, 16932428, 'Brock Colon', 'orci@yahoo.net', '1185168164', 'cardiopatia', 'comercio', 1),
(96, 42618985, 'Salvador Justice', 'vestibulum.mauris.magna@hotmail.edu', '1146692388', 'obesidad', 'estudiante', 1),
(97, 29613149, 'Clinton Huff', 'quis.accumsan@google.couk', '1133222441', 'diabetes', 'desempleado', 1),
(98, 19461537, 'Clark Sawyer', 'et@outlook.ca', '1144873132', 'obesidad', 'comercio', 1),
(99, 12578353, 'Vernon Orr', 'sed@aol.org', '1147317076', 'diabetes', 'salud', 1),
(100, 41171723, 'Drew Howard', 'non.enim@aol.org', '1159411127', 'asma', 'otro', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `cuit` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `pais` varchar(60) NOT NULL,
  `domicilio` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `cuit`, `nombre`, `pais`, `domicilio`, `estado`) VALUES
(1, '30-50351851-8', 'Pfizer', 'USA', '235 East 42nd St.', 1),
(2, '30-50115282-6', 'Moderna', 'USA', '150 East 25nd St.', 1),
(3, '30-54167722-0', 'Centro Nacional Gamaleya', 'Rusia', '30-1 Berezhkovskaya nab. GSP-3', 1),
(4, '30-50077232-4', 'AstraZeneca', 'Inlgaterra', 'Charter Way, Macclesfield SK10 2NA', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `nroSerie` int(11) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `medida` double NOT NULL,
  `fechaCad` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idLaboratorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`nroSerie`, `marca`, `medida`, `fechaCad`, `estado`, `idLaboratorio`) VALUES
(4273147, 'SputnikV', 0.3, '2024-09-14', 0, 3),
(12534112, 'Moderna', 0.5, '2024-02-03', 0, 2),
(16813715, 'SputnikV', 0.5, '2024-08-05', 0, 3),
(16841668, 'AstraZeneca', 0.9, '2024-10-09', 0, 4),
(18345241, 'Moderna', 0.9, '2024-02-11', 0, 2),
(27070983, 'Comirnaty', 0.9, '2024-02-21', 0, 1),
(31177100, 'SputnikV', 0.5, '2024-12-11', 0, 3),
(31657611, 'Moderna', 0.5, '2024-12-06', 0, 2),
(33507529, 'Comirnaty', 0.5, '2024-09-02', 0, 1),
(33891652, 'AstraZeneca', 0.3, '2024-06-24', 0, 4),
(34128717, 'Moderna', 0.3, '2024-04-06', 0, 2),
(34324556, 'Comirnaty', 0.3, '2024-05-24', 0, 1),
(43847342, 'Comirnaty', 0.3, '2024-10-24', 0, 1),
(46287194, 'SputnikV', 0.9, '2024-03-25', 0, 3),
(46331274, 'SputnikV', 0.3, '2024-11-07', 0, 3),
(48091466, 'AstraZeneca', 0.9, '2024-08-23', 0, 4),
(51255210, 'Comirnaty', 0.5, '2024-02-16', 0, 1),
(52039905, 'Moderna', 0.3, '2024-12-15', 0, 2),
(53976823, 'AstraZeneca', 0.5, '2024-01-06', 0, 4),
(58571626, 'Moderna', 0.9, '2024-01-29', 0, 2),
(60551892, 'SputnikV', 0.9, '2024-11-08', 1, 3),
(63062323, 'Moderna', 0.5, '2024-01-16', 1, 2),
(63514785, 'AstraZeneca', 0.9, '2024-10-19', 1, 4),
(63637978, 'Comirnaty', 0.3, '2024-06-02', 1, 1),
(68481321, 'Comirnaty', 0.9, '2024-05-27', 1, 1),
(70218484, 'Comirnaty', 0.9, '2024-11-19', 1, 1),
(70259511, 'AstraZeneca', 0.5, '2024-10-25', 1, 4),
(71378717, 'Comirnaty', 0.5, '2024-02-26', 1, 1),
(73435863, 'SputnikV', 0.5, '2024-09-06', 1, 3),
(75389153, 'Moderna', 0.3, '2024-12-19', 1, 2),
(76832661, 'Comirnaty', 0.5, '2024-06-17', 1, 1),
(79384164, 'AstraZeneca', 0.5, '2024-01-31', 1, 4),
(81510751, 'AstraZeneca', 0.3, '2024-08-08', 1, 4),
(82716881, 'AstraZeneca', 0.9, '2024-06-20', 1, 4),
(87377285, 'SputnikV', 0.9, '2024-08-11', 1, 3),
(87395165, 'SputnikV', 0.9, '2024-03-29', 1, 3),
(87749289, 'Moderna', 0.3, '2024-12-19', 1, 2),
(94656655, 'AstraZeneca', 0.9, '2024-07-14', 1, 4),
(95963386, 'SputnikV', 0.3, '2024-07-24', 1, 3),
(98195107, 'Moderna', 0.9, '2024-09-04', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacunatorio`
--

CREATE TABLE `vacunatorio` (
  `idVacunatorio` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacunatorio`
--

INSERT INTO `vacunatorio` (`idVacunatorio`, `descripcion`, `estado`) VALUES
(1, 'Centro 1', 1),
(2, 'Centro 2', 1),
(3, 'Centro 3\r\n', 1),
(4, 'Centro 4', 1),
(5, 'Centro 5', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`codCita`),
  ADD KEY `dni` (`dni`),
  ADD KEY `nroSerie` (`nroSerie`),
  ADD KEY `idVacunatorio` (`idVacunatorio`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`idCiudadano`),
  ADD UNIQUE KEY `email` (`email`,`celular`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLaboratorio`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`nroSerie`),
  ADD KEY `idLaboratorio` (`idLaboratorio`);

--
-- Indices de la tabla `vacunatorio`
--
ALTER TABLE `vacunatorio`
  ADD PRIMARY KEY (`idVacunatorio`),
  ADD UNIQUE KEY `descipcion` (`descripcion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `codCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `idCiudadano` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `nroSerie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98195108;

--
-- AUTO_INCREMENT de la tabla `vacunatorio`
--
ALTER TABLE `vacunatorio`
  MODIFY `idVacunatorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `ciudadano` (`dni`),
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`nroSerie`) REFERENCES `vacuna` (`nroSerie`),
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`idVacunatorio`) REFERENCES `vacunatorio` (`idVacunatorio`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `vacuna_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

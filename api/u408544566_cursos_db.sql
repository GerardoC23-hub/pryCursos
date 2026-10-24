-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-10-2026 a las 17:37:49
-- Versión del servidor: 11.8.9-MariaDB-log
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `u408544566_cursos_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_alumnos`
--

CREATE TABLE `tbl_alumnos` (
  `matricula` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido_paterno` varchar(60) NOT NULL,
  `apellido_materno` varchar(60) DEFAULT NULL,
  `correo_institucional` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Volcado de datos para la tabla `tbl_alumnos`
--

INSERT INTO `tbl_alumnos` (`matricula`, `nombre`, `apellido_paterno`, `apellido_materno`, `correo_institucional`) VALUES
('20251049', 'Francisco', 'Hernández', 'Hernández', '20251049@uthh.edu.mx'),
('20251050', 'Carlos Alberto', 'Martínez', 'López', '20251050@uthh.edu.mx'),
('20251051', 'María Fernanda', 'García', 'Pérez', '20251051@uthh.edu.mx'),
('20251052', 'José Luis', 'Ramírez', 'Torres', '20251052@uthh.edu.mx'),
('20251053', 'Ana Sofía', 'Hernández', 'Cruz', '20251053@uthh.edu.mx'),
('20251054', 'Daniel', 'López', 'Sánchez', '20251054@uthh.edu.mx'),
('20251055', 'Valeria', 'Pérez', 'Morales', '20251055@uthh.edu.mx'),
('20251056', 'Miguel Ángel', 'Cruz', 'Flores', '20251056@uthh.edu.mx'),
('20251057', 'Andrea', 'Torres', 'Gómez', '20251057@uthh.edu.mx'),
('20251058', 'Roberto Carlos', 'Mendoza', 'Vargas', '20251058@uthh.edu.mx'),
('20251059', 'Karla Vanessa', 'Sánchez', 'Reyes', '20251059@uthh.edu.mx'),
('20251060', 'Luis Fernando', 'Gómez', 'Castillo', '20251060@uthh.edu.mx'),
('20251061', 'Diana Paola', 'Flores', 'Ramírez', '20251061@uthh.edu.mx'),
('20251062', 'Emmanuel', 'Morales', 'Jiménez', '20251062@uthh.edu.mx'),
('20251063', 'Camila', 'Vargas', 'Hernández', '20251063@uthh.edu.mx'),
('20251064', 'Alejandro', 'Reyes', 'Mendoza', '20251064@uthh.edu.mx'),
('20251065', 'Fernanda', 'Castillo', 'López', '20251065@uthh.edu.mx'),
('20251066', 'Diego Armando', 'Jiménez', 'Sánchez', '20251066@uthh.edu.mx'),
('20251067', 'Ximena', 'Ramírez', 'Cruz', '20251067@uthh.edu.mx'),
('20251164', 'Francisco Javier', 'Santiago', 'Hernández', '20251164@uthh.edu.mx');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_carreras`
--

CREATE TABLE `tbl_carreras` (
  `id` int(11) NOT NULL,
  `carrera` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_carreras`
--

INSERT INTO `tbl_carreras` (`id`, `carrera`) VALUES
(5, 'Administración'),
(2, 'Desarrollo de Software Multiplataforma'),
(3, 'Infraestructura de Redes Digitales'),
(4, 'Mecatrónica'),
(1, 'Tecnologías de la Información');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cursos`
--

CREATE TABLE `tbl_cursos` (
  `id` int(11) NOT NULL,
  `codigo_curso` varchar(20) NOT NULL,
  `nombre_curso` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `edificio` varchar(100) DEFAULT NULL,
  `salon` varchar(100) DEFAULT NULL,
  `total_horas` int(11) NOT NULL,
  `dias_atencion` varchar(150) NOT NULL,
  `horas_atencion` varchar(100) DEFAULT NULL,
  `url_imagen_principal` varchar(255) DEFAULT NULL,
  `cupo_maximo` int(100) DEFAULT NULL,
  `id_carrera` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_cursos`
--

INSERT INTO `tbl_cursos` (`id`, `codigo_curso`, `nombre_curso`, `descripcion`, `edificio`, `salon`, `total_horas`, `dias_atencion`, `horas_atencion`, `url_imagen_principal`, `cupo_maximo`, `id_carrera`) VALUES
(1, 'CUR-001', 'Programación avanzada', 'Este curso está enfocado en el desarrollo de habilidades avanzadas de programación mediante el uso de estructuras de control, funciones, programación orientada a objetos y buenas prácticas de desarrollo de software. Los estudiantes aprenderán a diseñar soluciones para problemas complejos, organizar el código en módulos, reutilizar componentes y aplicar técnicas para mejorar la eficiencia, legibilidad y mantenimiento de las aplicaciones. Además, se realizarán ejercicios prácticos para fortalecer la lógica de programación y desarrollar proyectos que respondan a necesidades reales.', 'Edificio A', 'Salón C-101', 60, 'Lunes a viernes', '08:00-10:00', 'upload/cursos/principales/programacion1.png', 50, 2),
(2, 'CUR-002', 'Base de datos II', 'Este curso profundiza en el diseño, administración y optimización de bases de datos relacionales. Los estudiantes trabajarán con consultas SQL, relaciones entre tablas, restricciones, vistas, procedimientos almacenados y mecanismos para mantener la integridad de la información. También conocerán técnicas de normalización, respaldos, recuperación de datos y control de acceso. Mediante prácticas y ejercicios, aprenderán a construir bases de datos organizadas, seguras y eficientes que puedan integrarse con aplicaciones web, móviles y de escritorio.', 'Edificio A', 'Salón C-102', 60, 'Lunes a viernes', '10:00-12:00', 'upload/cursos/principales/basedatos1.png', 50, 2),
(3, 'CUR-003', 'Inteligencia artificial (AI)', 'Este curso introduce los conceptos y aplicaciones fundamentales de la inteligencia artificial, incluyendo la resolución de problemas, el análisis de datos, los sistemas inteligentes y los principios básicos del aprendizaje automático. Los estudiantes conocerán cómo se utilizan los algoritmos para identificar patrones, realizar predicciones y apoyar la toma de decisiones en diferentes sectores. También analizarán ejemplos prácticos de inteligencia artificial en aplicaciones cotidianas, servicios digitales y herramientas tecnológicas, considerando la importancia del uso responsable de los datos y las implicaciones éticas de estas soluciones.', 'Edificio B', 'Salón C-103', 60, 'Lunes a viernes', '12:00-14:00', 'upload/cursos/principales/ia1.png', 50, 2),
(4, 'CUR-004', 'Redes de computadoras', 'Este curso permite comprender los fundamentos de las redes de computadoras y su importancia para la comunicación entre dispositivos y sistemas informáticos. Los estudiantes aprenderán sobre los modelos OSI y TCP/IP, direccionamiento IPv4, subredes, protocolos de comunicación y funciones de los principales dispositivos de red, como routers y switches. Además, realizarán prácticas de configuración, conectividad y diagnóstico de fallas para desarrollar habilidades en la instalación, administración y mantenimiento de redes locales. Se abordarán medidas básicas de seguridad para mejorar la disponibilidad y confiabilidad de la comunicación.', 'Edificio B', 'Salón C-104', 60, 'Lunes a viernes', '08:00-10:00', 'upload/cursos/principales/redes1.png', 50, 3),
(5, 'CUR-005', 'Estructura de datos', 'Este curso se centra en el estudio de las principales estructuras utilizadas para organizar, almacenar y procesar información dentro de un programa. Los estudiantes conocerán arreglos, listas, pilas, colas, árboles y otras estructuras, así como las operaciones que pueden realizarse sobre ellas. También analizarán algoritmos de búsqueda y ordenamiento para comprender cómo influye la elección de una estructura en el rendimiento de una aplicación. A través de ejercicios prácticos, desarrollarán soluciones que permitan administrar datos de manera ordenada, mejorar el uso de la memoria y resolver problemas de programación con mayor eficiencia.', 'Edificio A', 'Salón C-105', 60, 'Lunes a viernes', '10:00-12:00', 'upload/cursos/principales/estructura1.png', 50, 2),
(6, 'CUR-006', 'Internet de las cosas (IoT)', 'Este curso aborda los fundamentos del Internet de las cosas, una tecnología que permite conectar objetos físicos a redes digitales para recopilar, transmitir y analizar información. Los estudiantes conocerán el funcionamiento de sensores, actuadores, microcontroladores y módulos de comunicación, así como los principios básicos para integrar dispositivos con plataformas de software. Mediante actividades prácticas, explorarán la creación de prototipos para automatización, monitoreo y control remoto, por ejemplo, en hogares, edificios y entornos industriales. También se estudiarán aspectos esenciales de conectividad, protección de datos y seguridad en dispositivos conectados.', 'Edificio B', 'Salón C-106', 60, 'Lunes a viernes', '12:00-14:00', 'upload/cursos/principales/iot1.png', 50, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_imagenes_curso`
--

CREATE TABLE `tbl_imagenes_curso` (
  `id` int(11) NOT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `url_imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_imagenes_curso`
--

INSERT INTO `tbl_imagenes_curso` (`id`, `id_curso`, `url_imagen`) VALUES
(1, 1, 'upload/cursos/galeria/programacion1.png'),
(2, 1, 'upload/cursos/galeria/programacion2.png'),
(3, 1, 'upload/cursos/galeria/programacion3.png'),
(4, 1, 'upload/cursos/galeria/programacion4.png'),
(5, 1, 'upload/cursos/galeria/programacion5.png'),
(6, 2, 'upload/cursos/galeria/basedatos1.png'),
(7, 2, 'upload/cursos/galeria/basedatos2.png'),
(8, 2, 'upload/cursos/galeria/basedatos3.png'),
(9, 2, 'upload/cursos/galeria/basedatos4.png'),
(10, 2, 'upload/cursos/galeria/basedatos5.png'),
(11, 3, 'upload/cursos/galeria/ia1.png'),
(12, 3, 'upload/cursos/galeria/ia2.png'),
(13, 3, 'upload/cursos/galeria/ia3.png'),
(14, 3, 'upload/cursos/galeria/ia4.png'),
(15, 3, 'upload/cursos/galeria/ia5.png'),
(16, 4, 'upload/cursos/galeria/redes1.png'),
(17, 4, 'upload/cursos/galeria/redes2.png'),
(18, 4, 'upload/cursos/galeria/redes3.png'),
(19, 4, 'upload/cursos/galeria/redes4.png'),
(20, 4, 'upload/cursos/galeria/redes5.png'),
(21, 5, 'upload/cursos/galeria/estructura1.png'),
(22, 5, 'upload/cursos/galeria/estructura2.png'),
(23, 5, 'upload/cursos/galeria/estructura3.png'),
(24, 5, 'upload/cursos/galeria/estructura4.png'),
(25, 5, 'upload/cursos/galeria/estructura5.png'),
(26, 6, 'upload/cursos/galeria/iot1.png'),
(27, 6, 'upload/cursos/galeria/iot2.png'),
(28, 6, 'upload/cursos/galeria/iot3.png'),
(29, 6, 'upload/cursos/galeria/iot4.png'),
(30, 6, 'upload/cursos/galeria/iot5.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_inscripciones`
--

CREATE TABLE `tbl_inscripciones` (
  `id` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `fecha_registro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_alumnos`
--
ALTER TABLE `tbl_alumnos`
  ADD PRIMARY KEY (`matricula`),
  ADD UNIQUE KEY `correo_institucional` (`correo_institucional`);

--
-- Indices de la tabla `tbl_carreras`
--
ALTER TABLE `tbl_carreras`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`carrera`);

--
-- Indices de la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo_curso`),
  ADD KEY `fk_carrera` (`id_carrera`);

--
-- Indices de la tabla `tbl_imagenes_curso`
--
ALTER TABLE `tbl_imagenes_curso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_curso_imagenes` (`id_curso`);

--
-- Indices de la tabla `tbl_inscripciones`
--
ALTER TABLE `tbl_inscripciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_alumno_curso` (`matricula`,`id_curso`),
  ADD KEY `fk_inscripciones_cursos` (`id_curso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_carreras`
--
ALTER TABLE `tbl_carreras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tbl_imagenes_curso`
--
ALTER TABLE `tbl_imagenes_curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `tbl_inscripciones`
--
ALTER TABLE `tbl_inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_cursos`
--
ALTER TABLE `tbl_cursos`
  ADD CONSTRAINT `fk_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `tbl_carreras` (`id`);

--
-- Filtros para la tabla `tbl_imagenes_curso`
--
ALTER TABLE `tbl_imagenes_curso`
  ADD CONSTRAINT `fk_curso_imagenes` FOREIGN KEY (`id_curso`) REFERENCES `tbl_cursos` (`id`);

--
-- Filtros para la tabla `tbl_inscripciones`
--
ALTER TABLE `tbl_inscripciones`
  ADD CONSTRAINT `fk_inscripciones_alumnos` FOREIGN KEY (`matricula`) REFERENCES `tbl_alumnos` (`matricula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_inscripciones_cursos` FOREIGN KEY (`id_curso`) REFERENCES `tbl_cursos` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

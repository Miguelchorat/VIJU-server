-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2023 a las 11:51:19
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
-- Base de datos: `viju`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorites`
--

CREATE TABLE `favorites` (
  `id` int(15) NOT NULL,
  `user_id` int(15) NOT NULL,
  `review_id` int(15) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `favorites`
--

INSERT INTO `favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES
(1, 2, 3, '2023-05-08 10:28:58'),
(2, 4, 5, '2023-05-08 10:28:58'),
(4, 3, 4, '2023-05-08 10:28:58'),
(5, 5, 1, '2023-05-08 10:28:58'),
(26, 1, 18, '2023-05-31 12:46:12'),
(34, 1, 22, '2023-06-01 12:01:20'),
(35, 1, 6, '2023-06-01 12:01:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likes`
--

CREATE TABLE `likes` (
  `id` int(15) NOT NULL,
  `user_id` int(15) NOT NULL,
  `review_id` int(15) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `likes`
--

INSERT INTO `likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES
(1, 2, 3, '2023-05-08 10:28:58'),
(2, 4, 5, '2023-05-08 10:28:58'),
(4, 3, 4, '2023-05-08 10:28:58'),
(5, 5, 1, '2023-05-08 10:28:58'),
(15, 4, 22, '2023-05-25 21:39:32'),
(73, 1, 6, '2023-05-31 12:30:28'),
(74, 1, 5, '2023-05-31 12:30:36'),
(82, 1, 22, '2023-06-01 12:01:18'),
(83, 1, 11, '2023-06-01 12:01:52');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `review`
--

CREATE TABLE `review` (
  `id` int(15) NOT NULL,
  `title` varchar(50) NOT NULL,
  `message` mediumtext NOT NULL,
  `score` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `videogame_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `review`
--

INSERT INTO `review` (`id`, `title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES
(1, 'Nintendo no nos fallo', '# Mario Odyssey es un juego de aventura en 3D desarrollado por Nintendo para la consola Switch.\n\n ~~El juego sigue a Mario mientras viaja~~ a diferentes mundos para salvar a su princesa Peach y restaurar el reino de los sueños. La jugabilidad es divertida y fluida, y los controles son fáciles de aprender y usar. Además, el juego ofrece una gran variedad de mundos y desafíos, lo que significa que nunca te aburrirás. \n\nOtro aspecto destacado es la personalidad y la presentación del juego. La dirección artística y la banda sonora son excelentes, y la historia es adictiva y llena de momentos divertidos y emocionantes. En general, Mario Odyssey es un juego imprescindible para cualquier fan de Mario o de los juegos de aventura en 3D en general. \n\n## Es un juego lleno de acción, diversión y emoción,\n\n y seguro que te mantendrá entretenido durante horas. Mario Odyssey es un juego de aventura en 3D desarrollado por Nintendo para la consola Switch. El juego sigue a Mario mientras viaja a diferentes mundos para salvar a su princesa Peach y restaurar el reino de los sueños. \n\n ![Imagen](https://fotografias-neox.atresmedia.com/clipping/cmsimages02/2017/10/27/DBE87618-DD95-44DE-BDDE-C5F4B4DD420B/98.jpg?crop=1280,720,x0,y0&width=1900&height=1069&optimize=high&format=webply) \n\nLa jugabilidad es divertida y fluida, y los controles son fáciles de aprender y usar. Además, el juego ofrece una gran variedad de mundos y desafíos, lo que significa que nunca te aburrirás. \n\nOtro aspecto destacado es la personalidad y la presentación del juego. La dirección artística y la banda sonora son excelentes, y la historia es adictiva y llena de momentos divertidos y emocionantes. En general, Mario Odyssey es un juego imprescindible para cualquier fan de Mario o de los juegos de aventura en 3D en general. Es un juego lleno de acción, diversión y emoción, y seguro que te mantendrá entretenido durante horas. Mario Odyssey es un juego de aventura en 3D desarrollado por Nintendo para la consola Switch. El juego sigue a Mario mientras viaja a diferentes mundos para salvar a su princesa Peach y restaurar el reino de los sueños. La jugabilidad es divertida y fluida, y los controles son fáciles de aprender y usar. Además, el juego ofrece una gran variedad de mundos y desafíos, lo que significa que nunca te aburrirás. \n\nOtro aspecto destacado es la personalidad y la presentación del juego. La dirección artística y la banda sonora son excelentes, y la historia es adictiva y llena de momentos divertidos y emocionantes. En general, Mario Odyssey es un juego imprescindible para cualquier fan de Mario o de los juegos de aventura en 3D en general. Es un juego lleno de acción, diversión y emoción, y seguro que te mantendrá entretenido durante horas. \n\n## Es un juego lleno de acción, diversión y emoción,\n\n y seguro que te mantendrá entretenido durante horas. Mario Odyssey es un juego de aventura en 3D desarrollado por Nintendo para la consola Switch. El juego sigue a Mario mientras viaja a diferentes mundos para salvar a su princesa Peach y restaurar el reino de los sueños.\n\nLa jugabilidad es divertida y fluida, y los controles son fáciles de aprender y usar. Además, el juego ofrece una gran variedad de mundos y desafíos, lo que significa que nunca te aburrirás. \n\nOtro aspecto destacado es la personalidad y la presentación del juego. La dirección artística y la banda sonora son excelentes, y la historia es adictiva y llena de momentos divertidos y emocionantes. En general, Mario Odyssey es un juego imprescindible para cualquier fan de Mario o de los juegos de aventura en 3D en general. Es un juego lleno de acción, diversión y emoción, y seguro que te mantendrá entretenido durante horas. Mario Odyssey es un juego de aventura en 3D desarrollado por Nintendo para la consola Switch. El juego sigue a Mario mientras viaja a diferentes mundos para salvar a su princesa Peach y restaurar el reino de los sueños. La jugabilidad es divertida y fluida, y los controles son fáciles de aprender y usar. Además, el juego ofrece una gran variedad de mundos y desafíos, lo que significa que nunca te aburrirás. \n\nOtro aspecto destacado es la personalidad y la presentación del juego. La dirección artística y la banda sonora son excelentes, y la historia es adictiva y llena de momentos divertidos y emocionantes. En general, Mario Odyssey es un juego imprescindible para cualquier fan de Mario o de los juegos de aventura en 3D en general. Es un juego lleno de acción, diversión y emoción, y seguro que te mantendrá entretenido durante horas.\n\n1. [Hola](https://google.es)\n\n2. Adios\n\n3. Hey', 5, '2023-05-22 10:28:57', '2023-05-30 13:47:04', 3, 1),
(2, 'Buen juego', 'Es un juego muy entretenido, pero esperaba un poco más de contenido.', 4, '2023-05-08 10:28:58', '2023-05-08 10:28:58', 3, 4),
(3, 'Mal juego', 'No me gustó este juego, es muy repetitivo y la historia es aburrida.', 4, '2023-05-08 10:28:58', '2023-05-08 10:28:58', 2, 5),
(4, 'Excelente juego increible', '# Este es uno de los mejores juegos que he jugado,\n\n**de**  y los personajes son muy bien desarrollados.\n\n- lklk\n- lklk', 2, '2023-05-14 21:32:58', '2023-05-30 18:21:48', 5, 1),
(5, 'Regular juego', 'Es un juego decente, pero tiene algunos errores que deben ser corregidos.', 3, '2023-05-08 10:28:56', '2023-05-08 10:28:58', 4, 3),
(6, 'Un clásico', '# Es un juego de mi infancia. Una clásico entre clásico', 5, '2023-05-14 14:51:04', '2023-05-12 11:51:04', 29, 2),
(7, 'Un clásico remasterizado', 'Una vuelta a la matanza de demonios sin fin.', 4, '2023-05-12 11:52:09', '2023-05-12 11:52:09', 28, 3),
(8, 'El mejor RTS existente', 'Starcraft es un RTS de blizzard el cual es insuperable en lo que a esport se trata.', 4, '2023-05-12 11:52:37', '2023-05-12 11:52:37', 37, 1),
(9, 'Otro clásico remasterizado', 'Aunque es un clásico remasterizado le quitaron algo fundamental de su nucleo.', 3, '2023-05-12 11:53:15', '2023-05-12 11:53:15', 16, 1),
(10, 'Un juego multijador de terror', 'DBD es un juego de cuatro supervivientes contra un asesino.', 3, '2023-05-12 11:54:02', '2023-05-12 11:54:02', 47, 5),
(11, 'Un nuevo juego de la saga', 'Hizo un lavado de la saga para volver a sus origenes de terror.', 4, '2023-05-12 11:55:41', '2023-05-12 11:55:41', 23, 4),
(12, 'El mejor juego de la decada pasada', 'Skyrim se hizo hincapié en el camino de los mejores videojuegos de la década y siglo.', 5, '2023-05-12 11:56:10', '2023-05-12 11:56:10', 12, 2),
(13, 'Un chasco tras su precesor', 'Diablo III no fue los que los fans acérrimo de Diablo II querían.', 2, '2023-05-12 11:57:02', '2023-05-12 11:57:02', 39, 4),
(14, 'Un juego donde tus manos son tu salvación', 'Un juego soul con la mejor mecanica de parry hasta la fecha.', 5, '2023-05-12 11:57:43', '2023-05-12 11:57:43', 49, 1),
(15, 'El mejor juego de la Switch', 'El nuevo zelda es una bocanada de aire fresco para los mundo abiertos.', 5, '2023-05-12 11:59:12', '2023-05-12 11:59:12', 1, 1),
(16, 'Un juego de rol de lo mejorcito', 'Skyrim trata en la región de Skyrim luego de los sucesos de las puertas de Oblivion.', 4, '2023-05-12 12:00:21', '2023-05-12 12:00:21', 12, 4),
(17, 'El juego que triunfa entre los jovenes', 'Fortnite es el nuevo juego de los jóvenes el cual trata de sobrevivir entre cien personas mas.', 4, '2023-05-12 12:08:40', '2023-05-12 12:08:40', 33, 1),
(18, 'Dante contra Vergil', 'Un nuevo juego de la saga llega para quedarse.', 4, '2023-05-12 12:09:21', '2023-05-12 12:09:21', 50, 1),
(19, 'El nuevo superheroe de la ciudad', 'Un juego donde conocemos los orígenes de nuevo de Spiderman y su evolución.', 5, '2023-05-12 12:10:21', '2023-05-12 12:10:21', 19, 5),
(20, 'El nuevo looting shooter de Gearbox', 'La tercera entrega de la saga de videojuegos Borderlands', 4, '2023-05-12 12:11:03', '2023-05-12 12:11:03', 46, 3),
(21, 'El juego con mas ingreso', 'Genshin Impact se ha vuelto el juego con los mayores ingresos a dia de hoy.', 4, '2023-05-12 12:12:19', '2023-05-12 12:12:19', 27, 2),
(22, 'Un soul que mejora la formula', 'La tercera entrega de la saga souls que llega para mejorar la formula del primer soul y descartar cosas de la segunda entrega.', 5, '2023-05-12 12:12:57', '2023-05-12 12:12:57', 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(15) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `avatar` varchar(100) NOT NULL,
  `role` enum('USER','ADMIN') NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`, `avatar`, `role`, `created_at`, `updated_at`) VALUES
(1, 'Miguel', 'admin@admin.com', '$2a$10$yWKeEtSl77NguHvFr/cgMObmHjfkm.E6SyEA/EL14fdVMjqNkObZ6', '1.svg', 'ADMIN', '2023-05-30 13:49:04', '2023-05-31 12:17:51'),
(2, 'luisa789', 'luisa789@hotmail.com', '$2a$10$vXaUeIGjSMimT4Bl0n0WPOp1PZXBPbvX2Nvp1A70.EAAl4K8QK1YW', '2.svg', 'USER', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(3, 'pedro456', 'pedro456@yahoo.com', '$2a$10$vXaUeIGjSMimT4Bl0n0WPOp1PZXBPbvX2Nvp1A70.EAAl4K8QK1YW', '3.svg', 'USER', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(4, 'ana789', 'ana789@hotmail.com', '$2a$10$vXaUeIGjSMimT4Bl0n0WPOp1PZXBPbvX2Nvp1A70.EAAl4K8QK1YW', '1.svg', 'USER', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(5, 'carlos123', 'carlos123@gmail.com', '$2a$10$vXaUeIGjSMimT4Bl0n0WPOp1PZXBPbvX2Nvp1A70.EAAl4K8QK1YW', '4.svg', 'USER', '2023-05-08 10:28:58', '2023-05-08 10:28:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videogame`
--

CREATE TABLE `videogame` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `image` varchar(250) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `videogame`
--

INSERT INTO `videogame` (`id`, `name`, `description`, `image`, `created_at`, `updated_at`) VALUES
(1, 'The Legend of Zelda: Breath of the Wild', 'The Legend of Zelda: Breath of the Wild es un juego de aventura y acción desarrollado y publicado por Nintendo. Fue lanzado en 2017 para las consolas Nintendo Switch y Wii U. El juego se desarrolla en un amplio mundo abierto que invita a la exploración, resolución de puzles y combate. Los jugadores controlan al personaje principal, Link, mientras viaja por el reino de Hyrule en su misión de derrotar al malvado Calamity Ganon y salvar a la princesa Zelda.', 'https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/wiiu_14/SI_WiiU_TheLegendOfZeldaBreathOfTheWild_image1600w.jpg', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(2, 'Grand Theft Auto V', 'Grand Theft Auto V es un videojuego de acción-aventura y mundo abierto desarrollado por Rockstar North y publicado por Rockstar Games. Fue lanzado en 2013 para las consolas PlayStation 3 y Xbox 360, y posteriormente para PlayStation 4, Xbox One y Microsoft Windows. El juego sigue a tres personajes criminales en la ciudad ficticia de Los Santos y su área circundante mientras cometen robos y cumplen misiones. Con un mundo abierto masivo y una amplia variedad de actividades, Grand Theft Auto V ha sido aclamado por la crítica y ha vendido millones de copias en todo el mundo.', 'https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Fgrand-theft-auto-v%2Fhome%2FGTAV_EGS_Artwork_1920x1080_Hero-Carousel_V06-1920x1080-1503e4b1320d5652dd4f57466c8bcb79424b3fc0.jpg', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(3, 'Super Mario Odyssey', 'Super Mario Odyssey es un videojuego de plataformas de acción-aventura desarrollado y publicado por Nintendo para la consola Nintendo Switch. Fue lanzado en 2017 y es el decimocuarto título principal de la serie Super Mario. En el juego, los jugadores controlan a Mario mientras viaja a través de diversos mundos con su nuevo compañero de aventuras, un sombrero llamado Cappy, en una misión para rescatar a la princesa Peach de Bowser y recuperar los fragmentos del poderoso Anillo del Poder.', 'https://fotografias-neox.atresmedia.com/clipping/cmsimages02/2017/10/27/DBE87618-DD95-44DE-BDDE-C5F4B4DD420B/98.jpg?crop=1280,720,x0,y0&width=1900&height=1069&optimize=high&format=webply', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(4, 'The Witcher 3: Wild Hunt', 'The Witcher 3: Wild Hunt es un videojuego de rol de acción desarrollado y publicado por CD Projekt RED. Fue lanzado en 2015 para PC, PlayStation 4 y Xbox One. El juego sigue a Geralt of Rivia, un cazador de monstruos conocido como un witcher, mientras viaja por un vasto mundo abierto en busca de su hija adoptiva y se enfrenta a una invasión de un grupo de cazadores de almas conocidos como la Caza Salvaje. Con su combinación de combate dinámico, elecciones y consecuencias significativas, exploración detallada y una rica mitología, The Witcher 3: Wild Hunt ha sido ampliamente aclamado por la crítica y es considerado uno de los mejores juegos de rol de la última década.', 'https://cdn1.epicgames.com/offer/14ee004dadc142faaaece5a6270fb628/EGS_TheWitcher3WildHuntCompleteEdition_CDPROJEKTRED_S1_2560x1440-82eb5cf8f725e329d3194920c0c0b64f', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(5, 'Minecraft', 'Minecraft es un juego de construcción y aventura desarrollado por Mojang Studios y publicado por Xbox Game Studios. Fue lanzado en 2011 y está disponible en una amplia variedad de plataformas, incluyendo PC, consolas, dispositivos móviles y más. El juego consiste en colocar bloques y vivir aventuras en un mundo generado por procedimientos. Los jugadores pueden construir estructuras, crear objetos y explotar recursos para sobrevivir y prosperar en un mundo lleno de peligros. Minecraft es uno de los juegos más populares y vendidos de todos los tiempos y ha sido aclamado por su creatividad y versatilidad.', 'https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_Minecraft.jpg', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(6, 'Red Dead Redemption 2', 'Red Dead Redemption 2 es un videojuego de acción-aventura y mundo abierto desarrollado y publicado por Rockstar Games. Fue lanzado en 2018 para las consolas PlayStation 4 y Xbox One, y posteriormente para Microsoft Windows. El juego sigue la historia de Arthur Morgan, un miembro del grupo de bandidos van der Linde, mientras luchan por sobrevivir en el oeste americano en pleno declive en la década de 1890. Los jugadores pueden explorar un mundo abierto realista y detallado, completar misiones, interactuar con personajes no jugables y participar en actividades como la caza y el juego.', 'https://cdn1.epicgames.com/b30b6d1b4dfd4dcc93b5490be5e094e5/offer/RDR2476298253_Epic_Games_Wishlist_RDR2_2560x1440_V01-2560x1440-2a9ebe1f7ee202102555be202d5632ec.jpg', '2023-05-08 10:28:58', '2023-05-08 10:28:58'),
(7, 'God of War (2018)', 'God of War (2018) es un videojuego de acción-aventura desarrollado por Santa Monica Studio y publicado por Sony Interactive Entertainment. Fue lanzado en 2018 exclusivamente para la consola PlayStation 4. Este juego es un reinicio de la serie God of War y sigue a Kratos, el antiguo dios de la guerra, y su hijo Atreus mientras viajan juntos a través de un mundo lleno de dioses y monstruos para cumplir con una promesa. Con un enfoque renovado en la narrativa y el combate, God of War (2018) es considerado como uno de los mejores juegos de la generación de consolas.', 'https://assetsio.reedpopcdn.com/-1634741977375.jpg?width=1200&height=1200&fit=bounds&quality=70&format=jpg&auto=webp', '2023-05-10 11:41:16', '2023-05-10 11:41:16'),
(8, 'Halo: Combat Evolved', 'Halo: Combat Evolved es un videojuego de disparos en primera persona desarrollado por Bungie y publicado por Microsoft Game Studios. Fue lanzado en 2001 exclusivamente para la consola Xbox y se convirtió rápidamente en un éxito comercial y crítico. La historia sigue al soldado spartano-117, también conocido como Master Chief, mientras lucha contra los Covenant, una alianza de razas extraterrestres, para proteger la humanidad. Con un enfoque en la acción y la estrategia, Halo: Combat Evolved sentó las bases para una exitosa franquicia y es ampliamente considerado como uno de los mejores juegos de disparos de todos los tiempos.', 'https://as01.epimg.net/meristation/imagenes/2020/03/03/videos/1583269944_517777_1583269974_noticia_normal.jpg', '2023-05-10 11:41:58', '2023-05-10 11:41:58'),
(9, 'Portal 2', 'Portal 2 es un videojuego de puzzle y plataformas desarrollado y publicado por Valve Corporation. Fue lanzado en 2011 para PC, PlayStation 3 y Xbox 360. El juego sigue a un personaje llamado Chell mientras explora y resuelve puzzles en una serie de instalaciones de la compañía de investigación Aperture Science. La mecánica principal del juego consiste en usar un dispositivo llamado portal para teletransportarse a través del mundo y manipular el entorno. Con su combinación de puzles ingeniosos, narrativa sorprendente y un mundo detallado y atmosférico, Portal 2 ha sido aclamado por la crítica y es considerado uno de los mejores juegos de su género.', 'https://i.blogs.es/2a441c/4173317-portal-2-hd/1366_2000.jpeg', '2023-05-10 11:42:22', '2023-05-10 11:42:22'),
(10, 'BioShock', 'BioShock es un videojuego de disparos en primera persona desarrollado por Irrational Games y publicado por 2K Games. Fue lanzado en 2007 para PC, Xbox 360 y PlayStation 3. El juego tiene lugar en una ciudad submarina llamada Rapture, que una vez fue una utopía tecnológica, pero ahora está en ruinas y habitada por monstruos conocidos como splicers. El jugador asume el control de Jack, un hombre que lucha por sobrevivir en Rapture mientras descubre los secretos de su pasado y la caída de la ciudad. Con su combinación de combate intenso, exploración detallada y una narrativa impactante, BioShock es considerado uno de los mejores juegos de disparos de la última década.', 'https://cdn1.epicgames.com/offer/e9e3ee13329f434f94105e6ec63435e0/EGS_BioShockRemastered_MassMediaGames_S1_2560x1440-cb7067c24252c5602497ab42fc488eed', '2023-05-10 11:42:44', '2023-05-10 11:42:44'),
(11, 'Mass Effect 2', 'Mass Effect 2 es un videojuego de rol de ciencia ficción desarrollado por BioWare y publicado por Electronic Arts. Fue lanzado en 2010 para PC, Xbox 360 y PlayStation 3. El juego sigue a Commander Shepard, un miembro de la Alianza de la Tierra que debe reclutar a un equipo de aliados únicos para detener a una amenaza imparable conocida como los Collectors. Con su combinación de elecciones y consecuencias significativas, un sistema de combate dinámico, personajes memorables y una narrativa épica, Mass Effect 2 es ampliamente considerado como uno de los mejores juegos de rol de la última década.', 'https://as01.epimg.net/meristation/imagenes/2021/04/30/reportajes/1619770232_826421_1619770447_noticia_normal.jpg', '2023-05-10 11:43:03', '2023-05-10 11:43:03'),
(12, 'The Elder Scrolls V: Skyrim', 'The Elder Scrolls V: Skyrim es un videojuego de rol de fantasía desarrollado por Bethesda Game Studios y publicado por Bethesda Softworks. Fue lanzado en 2011 para PC, Xbox 360, PlayStation 3 y Nintendo Switch. El juego tiene lugar en la provincia de Skyrim, un mundo abierto lleno de misterios y aventuras. El jugador asume el control de un personaje llamado Dovahkiin, que debe luchar contra un dragon mortal y descubrir su destino como el último de los Dragonborn. Con un sistema de juego flexible, una narrativa no lineal, una amplia variedad de misiones y un mundo en constante expansión, Skyrim se ha convertido en uno de los juegos de rol más emblemáticos de todos los tiempos.', 'https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_TheElderScrollsVSkyrim.jpg', '2023-05-10 11:43:23', '2023-05-10 11:43:23'),
(13, 'Fallout 4', 'Fallout 4 es un videojuego de rol post-apocalíptico desarrollado por Bethesda Game Studios y publicado por Bethesda Softworks. Fue lanzado en 2015 para PC, Xbox One y PlayStation 4. El juego tiene lugar en el área de la Bahía de la Costa Este, en un futuro distópico después de una guerra nuclear. El jugador asume el papel de un sobreviviente que se despierta después de 200 años en un refugio subterráneo y comienza su búsqueda por encontrar a su hijo desaparecido. Con un sistema de juego de elecciones y consecuencias, un mundo abierto vasto y lleno de misterios, un sistema de crafting y construcción, y una gran cantidad de personajes interesantes y misiones, Fallout 4 es un juego que ofrece una experiencia única y emocionante para los jugadores de rol.', 'https://as01.epimg.net/meristation/imagenes/2022/10/25/noticias/1666680538_307288_1666680660_noticia_normal.jpg', '2023-05-10 11:43:51', '2023-05-10 11:43:51'),
(14, 'Metal Gear Solid V: The Phantom Pain', 'Metal Gear Solid V: The Phantom Pain es un videojuego de sigilo y acción desarrollado por Kojima Productions y publicado por Konami. Fue lanzado en 2015 para PC, Xbox One, Xbox 360, PlayStation 3 y PlayStation 4. Es el quinto juego de la serie Metal Gear Solid y sigue las aventuras de Big Boss en su lucha contra las fuerzas militares de todo el mundo. Con un sistema de juego de sigilo en tiempo real y un mundo abierto, The Phantom Pain ofrece una experiencia única y emocionante para los jugadores de sigilo y acción. El juego también incluye un sistema de base y comandos en tiempo real, así como una gran cantidad de armas y equipos personalizables.', 'https://i.ytimg.com/vi/WeV992m7L84/maxresdefault.jpg', '2023-05-10 11:44:19', '2023-05-10 11:44:19'),
(15, 'Dark Souls III', 'Dark Souls III es un juego de rol de acción desarrollado por FromSoftware y publicado por Bandai Namco Entertainment. Fue lanzado en 2016 para PC, Xbox One y PlayStation 4. Con un mundo oscuro y desafiante, Dark Souls III pone a prueba la habilidad y la determinación de los jugadores a medida que avanzan a través de un mundo lleno de monstruos y peligros. Con combates intensos y un sistema de juego de rol profundo, Dark Souls III es un juego que requiere habilidad, paciencia y una buena estrategia. El juego también cuenta con un sistema de bonificaciones y penalizaciones que influyen en la experiencia del juego y una gran cantidad de armas y armaduras personalizables.', 'https://static.bandainamcoent.eu/high/dark-souls/dark-souls-3/00-page-setup/ds3_game-thumbnail.jpg', '2023-05-10 11:44:35', '2023-05-10 11:44:35'),
(16, 'Final Fantasy VII Remake', 'Final Fantasy VII Remake es un juego de rol de acción desarrollado y publicado por Square Enix. Fue lanzado en 2020 y es una versión remasterizada y reimaginada del clásico juego de rol de 1997, Final Fantasy VII. Con gráficos y jugabilidad mejorados, el juego cuenta la historia de Cloud Strife, un ex-soldado de la compañía Shinra que se une a un grupo de ecoterroristas conocido como AVALANCHE en su lucha contra la corporación y su control sobre la ciudad de Midgar. Con un sistema de combate renovado, una gran cantidad de secundarias y una historia profunda, Final Fantasy VII Remake es una experiencia épica para los fans de los juegos de rol y la franquicia.', 'https://cdn1.epicgames.com/offer/6f43ab8025ad42d18510aa91e9eb688b/EGS_FINALFANTASYVIIREMAKEINTERGRADE_SquareEnix_S1_2560x1440-85f829541a833442eaace75d02e0f07d', '2023-05-10 11:44:56', '2023-05-10 11:44:56'),
(17, 'Resident Evil 2 (2019)', 'Resident Evil 2 (2019) es un juego de terror y supervivencia desarrollado y publicado por Capcom. Fue lanzado en 2019 y es una versión remasterizada del clásico juego de terror de 1998, Resident Evil 2. Con gráficos mejorados, una nueva jugabilidad y una experiencia más intensa, el juego sigue a Leon S. Kennedy y Claire Redfield mientras luchan por sobrevivir en la infestada ciudad de Raccoon mientras investigan la enigmática epidemia de virus T. Con un sistema de combate renombrado, puzzles desafiantes y una atmósfera aterrorizante, Resident Evil 2 (2019) es una experiencia terrorífica para los fanáticos de los juegos de terror y la franquicia.', 'https://i0.wp.com/nerfeados.com/wp-content/uploads/2019/02/Leon_Claire_KeyArt_August.jpg?fit=2094%2C1080&ssl=1', '2023-05-10 11:45:15', '2023-05-10 11:45:15'),
(18, 'Uncharted 4: A Thief\'s End', 'Uncharted 4: A Thief\'s End es un juego de aventura y acción en tercera persona desarrollado por Naughty Dog y publicado por Sony Computer Entertainment. Fue lanzado en 2016 y es el cuarto juego en la serie Uncharted. El juego sigue a Nathan Drake, un aventurero y cazatesoros retirado, mientras viaja por todo el mundo en busca de un tesoro perdido y se enfrenta a varios enemigos peligrosos. Con una mezcla de acción, plataformas, combate y puzzle, Uncharted 4 ofrece una experiencia de juego emocionante y llena de aventuras para los jugadores.', 'https://image.api.playstation.com/vulcan/img/rnd/202010/2620/eIO6Ka26JChNo8KaFi7wON4L.jpg', '2023-05-10 11:45:33', '2023-05-10 11:45:33'),
(19, 'Spider-Man (2018)', 'Spider-Man (2018) es un juego de aventura en mundo abierto desarrollado por Insomniac Games y publicado por Sony Interactive Entertainment. Fue lanzado en 2018 y presenta al héroe de cómic, Spider-Man, mientras lucha contra el crimen en la ciudad de Nueva York. Con un sistema de combate fluido, seguimiento de misiones y una amplia gama de habilidades y equipamiento, el juego permite a los jugadores experimentar la vida como Spider-Man y enfrentarse a algunos de sus enemigos más conocidos. Con una trama épica y un mundo lleno de detalles, Spider-Man (2018) ofrece una experiencia de juego emocionante y llena de aventuras para los fans de Spider-Man y de los juegos de aventura en mundo abierto.', 'https://www.somosxbox.com/wp-content/uploads/2022/08/91McsWOj8sL._AC_SL1500_.jpg', '2023-05-10 11:45:53', '2023-05-10 11:45:53'),
(20, 'Bloodborne', 'Bloodborne es un juego de rol de acción desarrollado por FromSoftware y publicado por Sony Computer Entertainment. Lanzado en 2015 para PlayStation 4, el juego se desarrolla en un mundo oscuro y gótico llamado Yharnam, que está plagado de peligrosos monstruos y misterios ocultos. Con su combate desafiante y su mundo vasto e inmersivo, Bloodborne ha sido aclamado por la crítica como uno de los mejores juegos de su generación.', 'https://image.api.playstation.com/vulcan/img/rnd/202010/2614/NVmnBXze9ElHzU6SmykrJLIV.png', '2023-05-10 11:46:06', '2023-05-10 11:46:06'),
(21, 'Super Smash Bros. Ultimate', 'Super Smash Bros. Ultimate es un juego de lucha desarrollado y publicado por Nintendo. Lanzado en 2018 para Nintendo Switch, el juego es el sexto título de la serie Super Smash Bros. y cuenta con un elenco de personajes de juegos de Nintendo y de terceros. Con más de 80 personajes jugables, una variedad de modos de juego y una jugabilidad intensa y divertida, Super Smash Bros. Ultimate se ha convertido en uno de los juegos más populares y aclamados de la consola Nintendo Switch.', 'https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_SuperSmashBrosUltimate_02_image1600w.jpg', '2023-05-10 11:46:22', '2023-05-10 11:46:22'),
(22, 'The Last of Us Part II', 'The Last of Us Parte II es un juego de acción y aventura en tercera persona desarrollado por Naughty Dog y publicado por Sony Interactive Entertainment. Es la secuela del exitoso juego de 2013, The Last of Us, y sigue las aventuras de Ellie y Joel en un mundo postapocalíptico lleno de peligros y desafíos. Con gráficos impresionantes y una trama emocionante, The Last of Us Parte II es uno de los juegos más aclamados y premiados de la generación de consolas.', 'https://sm.ign.com/ign_es/news/t/the-last-o/the-last-of-us-part-2-has-sold-over-10-million-copies_x8z4.jpg', '2023-05-10 11:46:43', '2023-05-10 11:46:43'),
(23, 'Resident Evil 7: Biohazard', 'Resident Evil 7: Biohazard es un juego de survival horror desarrollado y publicado por Capcom. El juego sigue la historia de un hombre llamado Ethan que viaja a una mansión en Louisiana en busca de su esposa desaparecida, y se ve inmerso en un mundo de terror y misterio. Con un enfoque en la jugabilidad en primera persona y un sistema de combate renovado, Resident Evil 7 ofrece una experiencia de juego emocionante y aterrador.', 'https://s3.gaming-cdn.com/images/products/1568/orig/resident-evil-7-biohazard-pc-juego-steam-cover.jpg?v=1655206009', '2023-05-10 11:46:54', '2023-05-10 11:46:54'),
(24, 'Shadow of the Colossus (2018)', 'Shadow of the Colossus es un juego de aventura y acción en mundo abierto desarrollado por Bluepoint Games y publicado por Sony Interactive Entertainment. El juego es una remasterización del título original lanzado en 2005 para la consola PlayStation 2. En Shadow of the Colossus, el jugador controla a un caballero llamado Wander que viaja a través de un extenso mundo en ruinas en busca de colosos para derrotarlos y traer de vuelta la vida a una mujer dormida. Con combatir colosos épicos y una atmósfera cautivadora, este juego es una experiencia única en su clase.', 'https://i.ytimg.com/vi/PGsztueI9hg/maxresdefault.jpg', '2023-05-10 11:47:08', '2023-05-10 11:47:08'),
(25, 'Call of Duty: Modern Warfare (2019)', 'Call of Duty: Modern Warfare es un juego de disparos en primera persona desarrollado por Infinity Ward y publicado por Activision. Este juego de la serie Call of Duty se centra en la guerra moderna y cuenta con una campaña intensa y épica junto con multijugador competitivo y cooperativo. Con gráficos detallados y jugabilidad fluida, Modern Warfare es uno de los juegos más populares de la serie Call of Duty.', 'https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2019/10/hipertextual-call-of-duty-modern-warfare-2019-2019688876.jpg?fit=1920%2C1080&quality=55&strip=all&ssl=1', '2023-05-10 11:47:37', '2023-05-10 11:47:37'),
(26, 'Monster Hunter: World', 'Monster Hunter: World es un juego de acción y aventura en mundo abierto desarrollado y publicado por Capcom. El objetivo del juego es cazar criaturas gigantes y utilizar su equipo para mejorar su armamento y habilidades. La jugabilidad se centra en la exploración de un mundo vasto y la planificación de estrategias para derrotar a los monstruos. El juego fue lanzado en 2018 para PlayStation 4 y Xbox One, y posteriormente para PC.', 'https://cdn-ext.fanatical.com/production/product/1280x720/7f6e4bbc-69a4-4910-a424-8b4f14100c12.jpeg', '2023-05-10 11:48:04', '2023-05-10 11:48:04'),
(27, 'Genshin Impact', 'Genshin Impact es un juego de rol y acción en mundo abierto desarrollado por miHoYo. El juego se centra en la exploración de un vasto mundo llamado Teyvat y la adquisición de personajes con habilidades únicas para luchar contra enemigos y resolver misterios. Los jugadores pueden intercambiar personajes y equipamiento mediante un sistema de gachas. Genshin Impact fue lanzado en septiembre de 2020 para dispositivos móviles, PlayStation 4, PC y Nintendo Switch.', 'https://phantom-marca.unidadeditorial.es/99b50a97938f06813c5d6642a42b65f3/resize/1320/f/jpg/assets/multimedia/imagenes/2022/05/03/16515963523569.jpg', '2023-05-10 11:48:19', '2023-05-10 11:48:19'),
(28, 'DOOM (2016)', 'DOOM es un juego de disparos en primera persona desarrollado por id Software y publicado por Bethesda Softworks. El juego es una nueva versión de la franquicia DOOM, y sigue al protagonista, un marine del DOOM Slayer, mientras lucha contra hordas de demonios en Marte y en el infierno. La jugabilidad se centra en la acción rápida y la exploración, y el juego cuenta con una gran variedad de armas y habilidades para derrotar a los enemigos. DOOM fue lanzado en 2016 para PlayStation 4, Xbox One y PC.', 'https://videojuegos.roams.es/images/post/es_ES_videogames/juegos-doom-2016.jpg', '2023-05-10 11:48:33', '2023-05-10 11:48:33'),
(29, 'Tetris', 'Tetris es un juego puzzle clásico desarrollado originalmente en la Unión Soviética en el año 1984. En el juego, los jugadores deben colocar piezas tetromino en una pantalla en forma de caída para formar líneas completas, lo que resulta en su eliminación y puntuación. El juego ha sido portado a una amplia variedad de plataformas a lo largo de los años, incluyendo consolas de juegos, teléfonos móviles, computadoras personales y más.', 'https://images.ecestaticos.com/dUFL58S3fs8SSN-paQRmEkLg1hc=/4x0:1918x1075/1600x899/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2Fab7%2F34e%2Fe91%2Fab734ee91b787a1ca3c041a9929aa448.jpg', '2023-05-10 11:48:54', '2023-05-10 11:48:54'),
(30, 'Warcraft III', 'Warcraft III es un juego de estrategia en tiempo real desarrollado y publicado por Blizzard Entertainment. Se sitúa en un mundo de fantasía y sigue a cuatro razas: Humanos, Orcos, Elfos Nocturnos y Neutrales. Los jugadores construyen sus propias aldeas, reclutan ejércitos y compiten contra otros jugadores en batallas épicas. El juego incluye una campaña en solitario y un modo multijugador en línea. Warcraft III fue lanzado en 2002 para PC.', 'https://gomultiplayer.com/wp-content/uploads/2018/11/warcraft-3-reforged.jpg', '2023-05-10 11:49:55', '2023-05-10 11:49:55'),
(31, 'Overwatch', 'Overwatch es un juego de disparos en primera persona multijugador desarrollado y publicado por Blizzard Entertainment. El juego se centra en equipos de seis jugadores que compiten entre sí en diferentes modos de juego. Cada jugador puede seleccionar a un personaje con habilidades únicas y trabajar en equipo para completar objetivos y derrotar al equipo enemigo. Overwatch fue lanzado en mayo de 2016 para PlayStation 4, Xbox One y PC.', 'https://blog.latam.playstation.com/tachyon/sites/3/2022/06/3d2d01626430e2ee9117d81b834970fa6242e10f.jpg', '2023-05-10 11:50:14', '2023-05-10 11:50:14'),
(32, 'PUBG', 'PlayerUnknown\'s Battlegrounds, también conocido como PUBG, es un juego de disparos en primera persona multijugador en línea que se desarrolla en una isla abandonada. Los jugadores luchan para ser el último en pie y ganar. PUBG fue uno de los primeros juegos en popularizar el género de los Battle Royale y ha sido un éxito comercial en todo el mundo. Fue lanzado originalmente en 2017 para PC y se ha expandido a consolas y dispositivos móviles.', 'https://media.vandal.net/i/1200x630/1-2022/20221279492820_1.jpg', '2023-05-10 11:50:31', '2023-05-10 11:50:31'),
(33, 'Fortnite', 'Fortnite es un juego de estrategia y acción en mundo abierto desarrollado por Epic Games. El juego combina elementos de juegos de supervivencia y construcción, permitiendo a los jugadores recolectar recursos y construir fortificaciones mientras luchan contra otros jugadores y monstruos. Fortnite cuenta con varios modos de juego, incluyendo su popular modo Battle Royale, que ha sido ampliamente imitado por otros juegos de acción. Fortnite es un juego gratuito disponible para muchas plataformas, incluyendo PC, consolas y dispositivos móviles.', 'https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_download_software_1/2x1_NSwitchDS_Fortnite_image1600w.jpg', '2023-05-10 11:50:49', '2023-05-10 11:50:49'),
(34, 'Dota 2', 'Dota 2 es un juego de estrategia en tiempo real y multijugador en línea. Desarrollado y publicado por Valve Corporation, el juego se centra en partidas de 5 contra 5 en un mapa donde los jugadores deben trabajar juntos para destruir la base enemiga. Cada jugador controla a un héroe con habilidades únicas, y debe farmear recursos y colaborar con su equipo para fortalecer su posición y eventualmente ganar la partida. Dota 2 es uno de los juegos más populares de la industria de los juegos en línea, y cuenta con una base de seguidores y jugadores leales.', 'https://img.redbull.com/images/q_auto,f_auto/redbullcom/2014/10/09/1331683687434_2/dota-2-is-unlike-most-games-of-its-kind', '2023-05-10 11:51:08', '2023-05-10 11:51:08'),
(35, 'Counter-Strike: Global Offensive', 'Counter-Strike: Global Offensive es un juego de acción en primera persona desarrollado por Valve Corporation y Hidden Path Entertainment. Es una versión actualizada del juego original de Counter-Strike, un juego en línea que se ha convertido en uno de los más populares y aclamados juegos de acción en primera persona en el mundo. El juego incluye nuevos mapas, personajes, armas y modos de juego, así como mejoras en la jugabilidad y la tecnología.', 'https://1.bp.blogspot.com/-bUWP_6OIs9c/Xw4Ri3HYd6I/AAAAAAAAB10/Z0nNbWzEejYekv1WpkCe46esiRNSr-UagCLcBGAsYHQ/s1920/CSGO.jpg', '2023-05-10 11:51:32', '2023-05-10 11:51:32'),
(36, 'League of Legends', 'League of Legends es un juego multijugador en línea de estrategia y arena de batalla en tiempo real. Los jugadores controlan a un personaje con habilidades únicas y trabajan en equipo para destruir la base enemiga ubicada en los extremos opuestos del campo de batalla. El juego ofrece una amplia variedad de campeones con diferentes habilidades y playstyles, lo que permite a los jugadores personalizar su estrategia y abordar el juego de diferentes maneras. League of Legends fue lanzado en 2009 y se ha convertido en uno de los juegos multijugador en línea más populares y jugados en todo el mundo.', 'https://cdn1.epicgames.com/salesEvent/salesEvent/EGS_LeagueofLegends_RiotGames_S1_2560x1440-ee500721c06da3ec1e5535a88588c77f', '2023-05-10 11:51:59', '2023-05-10 11:51:59'),
(37, 'StarCraft II', 'StarCraft II es un juego de estrategia en tiempo real desarrollado y publicado por Blizzard Entertainment. La jugabilidad se centra en la construcción de bases y la creación de ejércitos para enfrentarse a los oponentes. El juego cuenta con tres razas jugables distintas, cada una con habilidades y estrategias únicas. StarCraft II se lanzó en 2010 y ha sido ampliamente elogiado por su jugabilidad y su complejidad.', 'https://i.blogs.es/fc719b/starcraft2/1366_2000.jpg', '2023-05-10 11:52:13', '2023-05-10 11:52:13'),
(38, 'World of Warcraft', 'World of Warcraft es un MMORPG desarrollado y publicado por Blizzard Entertainment. Fue lanzado en 2004 y se ha convertido en uno de los juegos en línea más populares de todos los tiempos. Los jugadores pueden elegir entre una variedad de razas y clases para crear a su personaje y explorar un mundo vasto lleno de misiones, eventos en tiempo real y otras aventuras. El juego se ha actualizado con varias expansiones a lo largo de los años, cada una agregando nuevas características y contenido al juego.', 'https://www.gameprotv.com/archivos/202008/world-of-warcraft-shadowlands-principal.jpg', '2023-05-10 11:52:33', '2023-05-10 11:52:33'),
(39, 'Diablo III', 'Diablo III es un juego de rol y acción desarrollado y publicado por Blizzard Entertainment. El juego es una secuela de Diablo II y sigue la historia de un héroe que lucha contra el mal en un mundo oscuro y peligroso. La jugabilidad se centra en la exploración de dungeons, la recolección de equipo y la lucha contra jefes y enemigos. Diablo III fue lanzado en 2012 para PC y posteriormente para PlayStation 3, Xbox 360 y PlayStation 4.', 'https://www.hd-tecnologia.com/imagenes/articulos/2012/05/AMD-Trinity-Diablo-III.jpg', '2023-05-10 11:52:52', '2023-05-10 11:52:52'),
(40, 'Hearthstone', 'Hearthstone es un juego de cartas en línea desarrollado y publicado por Blizzard Entertainment. El juego se juega en un mundo de fantasía y los jugadores construyen mazos de cartas representando personajes, hechizos y habilidades para derrotar a sus oponentes. Hearthstone es conocido por su accesibilidad y su jugabilidad adictiva, y ha sido uno de los juegos de cartas en línea más populares desde su lanzamiento en 2014.', 'https://d2q63o9r0h0ohi.cloudfront.net/_next/static/images/default-4fff3c606c794dc03a915b9071f562d3.jpg', '2023-05-10 11:53:08', '2023-05-10 11:53:08'),
(41, 'Heroes of the Storm', 'Heroes of the Storm es un juego multijugador en línea de estrategia en tiempo real desarrollado y publicado por Blizzard Entertainment. El juego combina elementos de MOBA y juegos de aventura para ofrecer una experiencia única en línea. Los jugadores pueden elegir a héroes de diferentes universos de Blizzard, como Warcraft, Diablo y StarCraft, y trabajar juntos para completar objetivos y vencer a la equipo enemigo. El juego fue lanzado en 2015 para PC.', 'https://static.heroesofthestorm.com/images/global/fb-share-1fcc54becc.jpg', '2023-05-10 11:53:26', '2023-05-10 11:53:26'),
(42, 'Tom Clancy\'s Rainbow Six Siege', 'Tom Clancy\'s Rainbow Six Siege es un juego de disparos en primera persona táctico desarrollado y publicado por Ubisoft. El juego se centra en la coordinación de equipos y la estrategia para completar misiones y derrotar a los enemigos. Se destaca por su ambientación realista y su sistema de destrucción de entornos. Se lanzó en 2015 para PlayStation 4, Xbox One y PC.', 'https://stadiahoy.com/wp-content/uploads/2020/09/Rainbow-Six-Siege.jpg', '2023-05-10 11:53:45', '2023-05-10 11:53:45'),
(43, 'Tom Clancy\'s The Division 2', 'Tom Clancy\'s The Division 2 es un juego de disparos en tercera persona desarrollado por Massive Entertainment y publicado por Ubisoft. El juego se desarrolla en un futuro cercano en Washington D.C., y sigue los eventos de su predecesor, Tom Clancy\'s The Division. Los jugadores asumen el papel de agentes de la División, un grupo secreto de agentes especializados, y deben trabajar juntos para restaurar el orden y proteger la ciudad de diversos grupos de enemigos. El juego fue lanzado en 2019 para PlayStation 4, Xbox One y PC.', 'https://cdn1.epicgames.com/impala/offer/Game-Page-Promo-2580x1450-99fd67a6a935b8c2436385b0c54e6f92-2580x1450-99fd67a6a935b8c2436385b0c54e6f92.jpg', '2023-05-10 11:54:01', '2023-05-10 11:54:01'),
(44, 'Apex Legends', 'Apex Legends es un juego de battle royale gratuito desarrollado y publicado por Respawn Entertainment. El juego se centra en la competición de 60 jugadores en un mapa gigante en el que deben luchar por ser el último equipo en pie. Cada jugador elige a un personaje con habilidades únicas y trabaja en equipo para sobrevivir y ganar la partida. Apex Legends fue lanzado en febrero de 2019 y ha sido muy popular desde entonces.', 'https://www.hd-tecnologia.com/imagenes/articulos/2020/04/Apex-Legends-no-tendr%C3%A1-un-modo-Solos-permanente-porque-impacta-de-forma-negativa-al-juego.jpg', '2023-05-10 11:54:19', '2023-05-10 11:54:19'),
(45, 'Destiny 2', 'Destiny 2 es un juego de disparos en primera persona en línea que combina elementos de juego de rol y multijugador masivo. El juego sigue la historia de los Guardianes, guerreros sobrenaturales que protegen la Tierra de las fuerzas del mal. Los jugadores pueden elegir entre tres clases diferentes de Guardianes y personalizarlos con armas y habilidades únicas. Destiny 2 también cuenta con un modo multijugador en línea que permite a los jugadores formar equipos y luchar juntos contra hordas de enemigos y jefes épicos.', 'https://sm.ign.com/ign_es/news/d/destiny-2-/destiny-2-anti-cheating-legal-battle-seems-to-lean-in-bungie_px8k.jpg', '2023-05-10 11:54:40', '2023-05-10 11:54:40'),
(46, 'Borderlands 3', 'Borderlands 3 es un juego de disparos en primera persona con elementos de rol desarrollado por Gearbox Software. El juego se sitúa en un universo post-apocalíptico y ofrece a los jugadores la opción de elegir entre una variedad de personajes, cada uno con sus propias habilidades y habilidades únicas. La jugabilidad se centra en la exploración de misiones y enfrentamientos con enemigos, así como en la recolección de armas y equipamiento. Borderlands 3 fue lanzado en septiembre de 2019 para PlayStation 4, Xbox One y PC.', 'https://cdn1.epicgames.com/catnip/offer/BL3Wide_2560x1440-2560x1440-462318f36bee20de4412e111ef72dc62.jpg', '2023-05-10 11:54:57', '2023-05-10 11:54:57'),
(47, 'Dead by Daylight', 'Dead by Daylight es un juego multijugador asimétrico en el que un jugador controla a un psicópata y el resto de los jugadores tratan de escapar. El objetivo del psicópata es cazar y sacrificar a los otros jugadores, mientras que los jugadores que escapan deben reparar y activar los generadores para abrir la puerta de salida. El juego se juega en un entorno de terror y ofrece una amplia variedad de personajes jugables, psicópatas y mapas.', 'https://cdn1.epicgames.com/offer/611482b8586142cda48a0786eb8a127c/EGS_DeadbyDaylight_BehaviourInteractive_S1_2560x1440-a32581cf9948a9a2e24b2ff15c1577c7', '2023-05-10 11:55:14', '2023-05-10 11:55:14'),
(48, 'Dead Cells', 'Dead Cells is a rogue-lite, metroidvania inspired, action-platformer. You\'ll explore a sprawling, ever-changing castle... assuming you’re able to fight your way past its keepers in 2D souls-lite combat.', 'https://cdn2.unrealengine.com/egs-deadcells-motiontwin-s1-2560x1440-312502186.jpg', '2023-05-10 11:55:30', '2023-05-10 11:55:30'),
(49, 'Sekiro: Shadows Die Twice', 'Sekiro: Shadows Die Twice is an action-adventure video game developed by FromSoftware and published by Activision. The game is set in a fictionalized version of Sengoku-era Japan and follows a shinobi known as Wolf as he attempts to rescue his young lord. The game features fast-paced combat, stealth elements, and challenging boss battles. Sekiro: Shadows Die Twice was praised for its challenging difficulty, tight controls, and immersive world.', 'https://fotografias-neox.atresmedia.com/clipping/cmsimages01/2018/06/26/93B3E4F4-0C96-45B5-B22A-5099DF3F900D/default.jpg', '2023-05-10 11:55:46', '2023-05-10 11:55:46'),
(50, 'Devil May Cry 5', 'Devil May Cry 5 es un juego de acción y aventura en tercera persona desarrollado y publicado por Capcom. El juego sigue a tres personajes: Dante, Nero y V, mientras luchan contra demonios y otras criaturas sobrenaturales en un mundo ficticio. El juego cuenta con gráficos impresionantes, combates intensos y una banda sonora memorable.', 'https://s1.gaming-cdn.com/images/products/2670/orig/devil-may-cry-5-vergil-pc-juego-steam-europe-cover.jpg?v=1650445593', '2023-05-10 11:56:06', '2023-05-10 11:56:06');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_user_has_review_review2_idx` (`review_id`),
  ADD KEY `fk_user_has_review_user2_idx` (`user_id`);

--
-- Indices de la tabla `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `likescol_UNIQUE` (`id`),
  ADD KEY `fk_user_has_review_review1_idx` (`review_id`),
  ADD KEY `fk_user_has_review_user1_idx` (`user_id`);

--
-- Indices de la tabla `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_review_videogame1_idx` (`videogame_id`),
  ADD KEY `fk_review_user1_idx` (`user_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- Indices de la tabla `videogame`
--
ALTER TABLE `videogame`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `favorites`
--
ALTER TABLE `favorites`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `likes`
--
ALTER TABLE `likes`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT de la tabla `review`
--
ALTER TABLE `review`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `videogame`
--
ALTER TABLE `videogame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `fk_user_has_review_review2` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_has_review_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `fk_user_has_review_review1` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_has_review_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `fk_review_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_review_videogame1` FOREIGN KEY (`videogame_id`) REFERENCES `videogame` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

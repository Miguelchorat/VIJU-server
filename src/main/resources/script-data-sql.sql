/* USER */
INSERT INTO viju.user (id, username, email, password, avatar, date, created_at, updated_at) VALUES (1, 'jose123', 'jose123@gmail.com', 'contraseña123', 'avatar1.png', '2022-03-09 10:00:00', NOW(), NOW());
INSERT INTO viju.user (id, username, email, password, avatar, date, created_at, updated_at) VALUES (2, 'luisa789', 'luisa789@hotmail.com', 'clave1234', 'avatar2.png', '2022-03-08 15:30:00', NOW(), NOW());
INSERT INTO viju.user (id, username, email, password, avatar, date, created_at, updated_at) VALUES (3, 'pedro456', 'pedro456@yahoo.com', 'password123', 'avatar3.png', '2022-03-07 09:45:00', NOW(), NOW());
INSERT INTO viju.user (id, username, email, password, avatar, date, created_at, updated_at) VALUES (4, 'ana789', 'ana789@hotmail.com', 'contraseña567', 'avatar4.png', '2022-03-05 18:20:00', NOW(), NOW());
INSERT INTO viju.user (id, username, email, password, avatar, date, created_at, updated_at) VALUES (5, 'carlos123', 'carlos123@gmail.com', 'clave456', 'avatar5.png', '2022-03-04 11:10:00', NOW(), NOW());

/* PLATFORM */
INSERT INTO viju.platform (id, name, description, created_at, updated_at) VALUES (1, 'PlayStation', 'Consola de videojuegos desarrollada por Sony Interactive Entertainment. Lanzada por primera vez en 1994 en Japón.', NOW(), NOW());
INSERT INTO viju.platform (id, name, description, created_at, updated_at) VALUES (2, 'Xbox', 'Consola de videojuegos desarrollada por Microsoft. La primera versión se lanzó en 2001.', NOW(), NOW());
INSERT INTO viju.platform (id, name, description, created_at, updated_at) VALUES (3, 'Nintendo Switch', 'Consola híbrida de videojuegos desarrollada por Nintendo. Se lanzó en 2017 y puede ser utilizada tanto en modo portátil como en modo sobremesa.', NOW(), NOW());
INSERT INTO viju.platform (id, name, description, created_at, updated_at) VALUES (4, 'PC', 'Plataforma de juegos para ordenadores personales. Ofrece una amplia variedad de juegos y la posibilidad de personalizar la configuración para una experiencia de juego óptima.', NOW(), NOW());
INSERT INTO viju.platform (id, name, description, created_at, updated_at) VALUES (5, 'PlayStation Portable', 'Consola portátil de videojuegos desarrollada por Sony. Fue lanzada en 2004 y permitía a los usuarios jugar a videojuegos en cualquier lugar.', NOW(), NOW());

/* VIDEOGAME */
INSERT INTO viju.videogame (id, name, description, image, created_at, updated_at) VALUES (1, 'The Legend of Zelda: Breath of the Wild', 'Videojuego de acción y aventura desarrollado y publicado por Nintendo para la consola Nintendo Switch. El juego se centra en la exploración y resolución de puzles en un mundo abierto. Recibió críticas muy positivas por su jugabilidad y diseño de mundo.', 'https://example.com/zelda.jpg', NOW(), NOW());
INSERT INTO viju.videogame (id, name, description, image, created_at, updated_at) VALUES (2, 'Grand Theft Auto V', 'Videojuego de acción y mundo abierto desarrollado por Rockstar North y publicado por Rockstar Games. El juego se desarrolla en una ciudad ficticia basada en Los Ángeles y sigue las vidas de tres personajes jugables. Ha sido uno de los videojuegos más vendidos de todos los tiempos.', 'https://example.com/gta5.jpg', NOW(), NOW());
INSERT INTO viju.videogame (id, name, description, image, created_at, updated_at) VALUES (3, 'Super Mario Odyssey', 'Videojuego de plataformas desarrollado y publicado por Nintendo para la consola Nintendo Switch. Mario viaja a través de diferentes mundos para rescatar a la princesa Peach de Bowser. Recibió críticas muy positivas por su jugabilidad, diseño de niveles y música.', 'https://example.com/mario.jpg', NOW(), NOW());
INSERT INTO viju.videogame (id, name, description, image, created_at, updated_at) VALUES (4, 'The Witcher 3: Wild Hunt', 'Videojuego de rol desarrollado por CD Projekt RED y publicado por CD Projekt. El juego sigue al cazador de monstruos Geralt de Rivia mientras viaja por el mundo abierto en busca de su hija adoptiva. Recibió críticas muy positivas por su narrativa, jugabilidad y diseño de mundo.', 'https://example.com/witcher3.jpg', NOW(), NOW());
INSERT INTO viju.videogame (id, name, description, image, created_at, updated_at) VALUES (5, 'Minecraft', 'Videojuego de construcción y aventura desarrollado y publicado por Mojang Studios. Los jugadores pueden construir y explorar mundos generados proceduralmente, recolectar recursos y luchar contra enemigos. Es uno de los videojuegos más populares de todos los tiempos.', 'https://example.com/minecraft.jpg', NOW(), NOW());

/* REVIEW */
INSERT INTO `viju`.`review` (`title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES ('Gran juego', 'Me encantó este juego, tiene una trama muy interesante y los gráficos son impresionantes.', 9, NOW(), NOW(), 1, 2);
INSERT INTO `viju`.`review` (`title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES ('Buen juego', 'Es un juego muy entretenido, pero esperaba un poco más de contenido.', 7, NOW(), NOW(), 3, 4);
INSERT INTO `viju`.`review` (`title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES ('Mal juego', 'No me gustó este juego, es muy repetitivo y la historia es aburrida.', 4, NOW(), NOW(), 2, 5);
INSERT INTO `viju`.`review` (`title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES ('Excelente juego', 'Este es uno de los mejores juegos que he jugado, tiene una historia increíble y los personajes son muy bien desarrollados.', 10, NOW(), NOW(), 5, 1);
INSERT INTO `viju`.`review` (`title`, `message`, `score`, `created_at`, `updated_at`, `videogame_id`, `user_id`) VALUES ('Regular juego', 'Es un juego decente, pero tiene algunos errores que deben ser corregidos.', 6, NOW(), NOW(), 4, 3);

/* LIKE */
INSERT INTO `viju`.`likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES (1, 2, 3, NOW());
INSERT INTO `viju`.`likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES (2, 4, 5, NOW());
INSERT INTO `viju`.`likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES (3, 1, 2, NOW());
INSERT INTO `viju`.`likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES (4, 3, 4, NOW());
INSERT INTO `viju`.`likes` (`id`, `user_id`, `review_id`, `created_at`) VALUES (5, 5, 1, NOW());

/* FAVORITE */
INSERT INTO `viju`.`favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES (1, 2, 3, NOW());
INSERT INTO `viju`.`favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES (2, 4, 5, NOW());
INSERT INTO `viju`.`favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES (3, 1, 2, NOW());
INSERT INTO `viju`.`favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES (4, 3, 4, NOW());
INSERT INTO `viju`.`favorites` (`id`, `user_id`, `review_id`, `created_at`) VALUES (5, 5, 1, NOW());

/* Videogame_platform */
INSERT INTO `viju`.`videogame_platform` (`id`, `videogame_id`, `platform_id`, `created_at`) VALUES (1, 2, 3, NOW());
INSERT INTO `viju`.`videogame_platform` (`id`, `videogame_id`, `platform_id`, `created_at`) VALUES (2, 4, 5, NOW());
INSERT INTO `viju`.`videogame_platform` (`id`, `videogame_id`, `platform_id`, `created_at`) VALUES (3, 1, 2, NOW());
INSERT INTO `viju`.`videogame_platform` (`id`, `videogame_id`, `platform_id`, `created_at`) VALUES (4, 3, 4, NOW());
INSERT INTO `viju`.`videogame_platform` (`id`, `videogame_id`, `platform_id`, `created_at`) VALUES (5, 5, 1, NOW());
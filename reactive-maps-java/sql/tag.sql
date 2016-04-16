CREATE TABLE `tag`(
    `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `postId` int(10) UNSIGNED NOT NULL,
    `tag` varchar(65) NOT NULL,
    PRIMARY key(`id`),
    KEY(`tag`)
    CONSTRAINT `tag_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

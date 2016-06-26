CREATE TABLE `user`(
    `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `userName` varchar(64) NOT NULL,
    `firstName` varchar(1024) NOT NULL,
    `lastName` varchar(1024) NOT NULL,
    `email` varchar(1024) NOT NULL,
    `joinDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    `lastModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY key(id),
);

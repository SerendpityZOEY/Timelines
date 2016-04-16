CREATE TABLE `timelines`.`post` (
  `id` int(10) unsigned NOT NULL AUTOINCREMENT COMMENT "id of post",
  `content` text NOT NULL COMMENT "content of post",
  `userId` varchar(255) NOT NULL "user who owns post",
  `postDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "time post was created",
  `lastModified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT "last time entry was changed",
  PRIMARY KEY (`id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

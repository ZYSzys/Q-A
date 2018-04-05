DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdTime` datetime DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `question_tag_relation`;
CREATE TABLE `question_tag_relation` (
  `questionId` bigint(20) NOT NULL,
  `tag` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

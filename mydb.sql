CREATE DATABASE `profitability_rank` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `projectmarkstatus` (
  `status_id` varchar(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `status_id_UNIQUE` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `projects` (
  `project_id` varchar(36) NOT NULL,
  `segment_id` varchar(36) NOT NULL,
  `mark_status_id` varchar(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  `head` varchar(45) NOT NULL,
  `human_amount` double NOT NULL COMMENT 'количество человек',
  `average_salary` double NOT NULL COMMENT 'средняя з.п.',
  `profit` double NOT NULL,
  `term` double NOT NULL,
  `profitability` double NOT NULL COMMENT 'индекс',
  PRIMARY KEY (`project_id`),
  KEY `category_id_idx` (`segment_id`),
  KEY `mark_status_id_idx` (`mark_status_id`),
  CONSTRAINT `mark_status_id` FOREIGN KEY (`mark_status_id`) REFERENCES `projectmarkstatus` (`status_id`),
  CONSTRAINT `segment_id` FOREIGN KEY (`segment_id`) REFERENCES `segments` (`segment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `segments` (
  `segment_id` varchar(36) NOT NULL,
  `segment_name` varchar(45) NOT NULL,
  PRIMARY KEY (`segment_id`),
  UNIQUE KEY `category_name_UNIQUE` (`segment_name`),
  UNIQUE KEY `category_id_UNIQUE` (`segment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `users` (
  `user_id` varchar(36) NOT NULL,
  `user_status_id` varchar(36) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_status_id_idx` (`user_status_id`),
  CONSTRAINT `user_status_id` FOREIGN KEY (`user_status_id`) REFERENCES `userstatus` (`user_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `userstatus` (
  `user_status_id` varchar(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_status_id`),
  UNIQUE KEY `user_status_id_UNIQUE` (`user_status_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


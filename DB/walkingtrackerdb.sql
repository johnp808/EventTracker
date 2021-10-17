-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema walkingtrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `walkingtrackerdb` ;

-- -----------------------------------------------------
-- Schema walkingtrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `walkingtrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `walkingtrackerdb` ;

-- -----------------------------------------------------
-- Table `contestant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contestant` ;

CREATE TABLE IF NOT EXISTS `contestant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `gender` CHAR NULL,
  `age` INT NULL,
  `contestant_image` VARCHAR(1000) NULL,
  `representing_city` VARCHAR(100) NULL,
  `representing_state` VARCHAR(50) NULL,
  `event_name` VARCHAR(100) NULL,
  `event_date` VARCHAR(50) NULL,
  `finish_time` VARCHAR(10) NULL,
  `place` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS walkinguser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'walkinguser'@'localhost' IDENTIFIED BY 'walkinguser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'walkinguser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `contestant`
-- -----------------------------------------------------
START TRANSACTION;
USE `walkingtrackerdb`;
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (1, 'John', 'M', 29, 'https://www.themekaverse.com/images/mattey.jpg', 'Honolulu', 'Hawaii', 'Color Run', '2021-10-06', '45:03', 5);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (2, 'Aimi', 'F', 25, NULL, 'Honolulu', 'Hawaii', 'Color Run', '2021-10-06', '45:00', 4);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (3, 'Mikey', 'M', 18, NULL, 'Kahului', 'Hawaii', 'Color Run', '2021-10-06', '50:05', 6);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (4, 'Gene', 'M', 33, NULL, 'Fort Lauderdale', 'Florida', 'Color Run', '2021-10-06', '33:20', 3);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (5, 'Jin', 'M', 27, NULL, 'San Diego', 'California', 'Color Run', '2021-10-06', '32:50', 1);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (6, 'Stacey', 'F', 30, NULL, 'Kula', 'Hawaii', 'Color Run', '2021-10-06', '33:00', 2);

COMMIT;


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
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Gender` CHAR NULL,
  `age` INT NULL,
  `user_image` VARCHAR(1000) NULL,
  `City` VARCHAR(100) NULL,
  `state` VARCHAR(50) NULL,
  `walking_date` DATE NULL,
  `minute_duration` INT NULL,
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
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `walkingtrackerdb`;
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (1, 'John', 'M', 29, 'https://www.themekaverse.com/images/mattey.jpg', 'Honolulu', 'Hawaii', '2021-10-6', 45);
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (2, 'Aimi', 'F', 25, NULL, 'Honolulu', 'Hawaii', '2021-10-6', 45);
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (3, 'Mikey', 'M', 18, NULL, 'Kahului', 'Hawaii', '2021-9-23', 15);
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (4, 'Gene', 'M', 33, NULL, 'Fort Lauderdale', 'Florida', '2021-10-5', 25);
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (5, 'Jin', 'M', 27, NULL, 'San Diego', 'California', '2021-9-3', 32);
INSERT INTO `user` (`id`, `name`, `Gender`, `age`, `user_image`, `City`, `state`, `walking_date`, `minute_duration`) VALUES (6, 'Stacey', 'F', 30, NULL, 'Kula', 'Hawaii', '2021-10-7', 60);

COMMIT;


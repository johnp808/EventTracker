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
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (1, 'Michael Scott', 'M', 38, 'https://chumley.barstoolsports.com/wp-content/uploads/2019/03/12/michael-scott-run.png', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '45:03', 8);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (2, 'Angela Martin', 'F', 34, 'https://medias.spotern.com/spots/w640/216/216276-1563438671.jpg', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '12:07', 3);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (3, 'Toby', 'M', 45, 'http://bp0.blogger.com/_lxhNumYsFg8/Rv3F1I3pqcI/AAAAAAAABWs/6QRLQveIL-0/s320/1255.jpg', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '10:23', 1);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (4, 'Jim Halpert', 'M', 30, 'https://oyster.ignimgs.com/wordpress/stg.ign.com/2021/01/4.jpg', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '46:50', 10);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (5, 'Dwight Shrute', 'M', 34, 'https://i.pinimg.com/originals/27/16/c1/2716c14a8eee6cf598e2f09726537c5d.jpg', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '32:50', 6);
INSERT INTO `contestant` (`id`, `name`, `gender`, `age`, `contestant_image`, `representing_city`, `representing_state`, `event_name`, `event_date`, `finish_time`, `place`) VALUES (6, 'Kevin Malone', 'M', 36, 'https://helios-i.mashable.com/imagery/articles/04PWOwbkr65fRLHT5ANjKcf/hero-image.fill.size_1200x900.v1614275957.png', 'Scranton', 'Pennsylvania', 'Run For Rabies Fun Run', '2009-10-06', '23:45', 4);

COMMIT;


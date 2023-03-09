-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rating
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rating
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rating` ;
USE `rating` ;

-- -----------------------------------------------------
-- Table `rating`.`ratings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rating`.`ratings` (
  `userId` VARCHAR(45) NOT NULL,
  `movieId` VARCHAR(45) NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`userId`, `movieId`, `rating`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `rating`;

DELIMITER $$
USE `rating`$$
CREATE DEFINER = CURRENT_USER TRIGGER `rating`.`ratings_BEFORE_INSERT` BEFORE INSERT ON `ratings` FOR EACH ROW
BEGIN
	if  new.rating > 5 OR new.rating < 0 then
       SIGNAL SQLSTATE '45000'   
       SET MESSAGE_TEXT = 'Cannot add or update row: only';
       end if; 

END$$


DELIMITER ;

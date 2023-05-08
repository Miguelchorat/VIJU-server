-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema viju
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema viju
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `viju` DEFAULT CHARACTER SET utf8 ;
USE `viju` ;

-- -----------------------------------------------------
-- Table `viju`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `avatar` VARCHAR(100) NOT NULL,
  `date` DATETIME NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `correo_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`videogame`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`videogame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` TEXT(1500) NOT NULL,
  `image` VARCHAR(200) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `message` MEDIUMTEXT NOT NULL,
  `score` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `videogame_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_videogame1_idx` (`videogame_id` ASC) VISIBLE,
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_videogame1`
    FOREIGN KEY (`videogame_id`)
    REFERENCES `viju`.`videogame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `viju`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`platform`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`platform` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` TEXT(1500) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`videogame_platform`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`videogame_platform` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `videogame_id` INT NOT NULL,
  `platform_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  INDEX `fk_videogame_has_platform_platform1_idx` (`platform_id` ASC) VISIBLE,
  INDEX `fk_videogame_has_platform_videogame_idx` (`videogame_id` ASC) VISIBLE,
  UNIQUE INDEX `videogame_id_UNIQUE` (`videogame_id` ASC) VISIBLE,
  UNIQUE INDEX `platform_id_UNIQUE` (`platform_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `videogame_has_platformcol_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_videogame_has_platform_videogame`
    FOREIGN KEY (`videogame_id`)
    REFERENCES `viju`.`videogame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_videogame_has_platform_platform1`
    FOREIGN KEY (`platform_id`)
    REFERENCES `viju`.`platform` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`likes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `review_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  INDEX `fk_user_has_review_review1_idx` (`review_id` ASC) VISIBLE,
  INDEX `fk_user_has_review_user1_idx` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `review_id_UNIQUE` (`review_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `likescol_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `viju`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_review_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `viju`.`review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viju`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viju`.`favorites` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `review_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  INDEX `fk_user_has_review_review2_idx` (`review_id` ASC) VISIBLE,
  INDEX `fk_user_has_review_user2_idx` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `review_id_UNIQUE` (`review_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_review_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `viju`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_review_review2`
    FOREIGN KEY (`review_id`)
    REFERENCES `viju`.`review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

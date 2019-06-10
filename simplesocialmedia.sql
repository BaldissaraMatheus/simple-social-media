-- MySQL Script generated by MySQL Workbench
-- Mon Jun 10 10:29:56 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema simplesocialmedia
-- -----------------------------------------------------
DROP DATABASE IF EXISTS simplesocialmedia ;
CREATE DATABASE simplesocialmedia ;
-- -----------------------------------------------------
-- Schema simplesocialmedia
-- -----------------------------------------------------
USE simplesocialmedia ;

-- -----------------------------------------------------
-- Table `simplesocialmedia`.`user`
-- -----------------------------------------------------


CREATE TABLE user (
  username VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  icon VARCHAR(45) NOT NULL,
  PRIMARY KEY (username))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simplesocialmedia`.`post`
-- -----------------------------------------------------


CREATE TABLE post (
  idpost INT NOT NULL AUTO_INCREMENT,
  content VARCHAR(45) NOT NULL,
  likes INT NULL,
  user_username VARCHAR(45) NOT NULL,
  UNIQUE KEY (idpost),  
  CONSTRAINT `fk_post_user`
    FOREIGN KEY (user_username) REFERENCES user (username)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB AUTO_INCREMENT=1;


-- -----------------------------------------------------
-- Table `simplesocialmedia`.`reply`
-- -----------------------------------------------------


CREATE TABLE reply (
  idreply INT NOT NULL AUTO_INCREMENT,
  content VARCHAR(45) NOT NULL,
  user_username VARCHAR(45) NOT NULL,
  post_idpost INT NOT NULL,
  UNIQUE KEY (idreply),
  CONSTRAINT `fk_reply_user1`
    FOREIGN KEY (user_username)
    REFERENCES user (username)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reply_post1`
    FOREIGN KEY (post_idpost)
    REFERENCES post (idpost)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB AUTO_INCREMENT=1;

insert into user (username, email, name, password, icon) values( 'everynite', 'chalitameneguelli14@gmail.com', 'Davi Chalita Meneguelli', '123', 'katara');

describe user;
select * from user;
describe post;
select * from post;
describe reply;
select * from reply;
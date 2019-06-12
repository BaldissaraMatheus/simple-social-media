DROP DATABASE IF EXISTS socialmedia ;
CREATE DATABASE socialmedia ;

USE socialmedia ;

CREATE TABLE user (
  username VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  icon VARCHAR(10) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE post (
    id INT NOT NULL AUTO_INCREMENT,
    content VARCHAR(45) NOT NULL,
    user_username VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),  
    FOREIGN KEY (user_username) REFERENCES user (username)
);

CREATE TABLE reply (
  id INT NOT NULL AUTO_INCREMENT,
  content VARCHAR(45) NOT NULL,
  user_username VARCHAR(45) NOT NULL,
  post_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_username) REFERENCES user (username),
  FOREIGN KEY (post_id) REFERENCES post (id)
);

insert into user (username, email, name, password, icon) values(
'everynite', 'chalitameneguelli14@gmail.com', 'Davi', '123', 'katara');

insert into post (content, user_username, )

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
    content VARCHAR(280) NOT NULL,
    user_username VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),  
    FOREIGN KEY (user_username) REFERENCES user (username)
);

CREATE TABLE likedPost (
    id INT NOT NULL AUTO_INCREMENT,
    user_username VARCHAR(45) NOT NULL,
    post_id INT NOT NULL,
    PRIMARY KEY (id),  
    FOREIGN KEY (user_username) REFERENCES user (username),
    FOREIGN KEY (post_id) REFERENCES post (id)
);

CREATE TABLE reply (
  id INT NOT NULL AUTO_INCREMENT,
  content VARCHAR(280) NOT NULL,
  user_username VARCHAR(45) NOT NULL,
  post_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_username) REFERENCES user (username),
  FOREIGN KEY (post_id) REFERENCES post (id)
);

insert into user (username, email, name, password, icon) values('davi', 'davi@gmail.com', 'Davi', '123', 'katara');
insert into user (username, email, name, password, icon) values('catherine', 'catherine@gmail.com', 'Catherine', '123', 'aang');
insert into user (username, email, name, password, icon) values('samir', 'samir@gmail.com', 'Samir', '123', 'toph');

insert into post (content, user_username) values('Bom dia! Que todos tenham uma semana de luz', 'samir');
insert into post (content, user_username) values('Ouvindo aquele pagodao no churras', 'davi');
insert into post (content, user_username) values('oi gentee', 'catherine');
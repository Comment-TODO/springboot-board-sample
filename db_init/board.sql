CREATE DATABASE IF NOT EXISTS board;
USE board;

CREATE USER IF NOT EXISTS 'board_user'@'%' IDENTIFIED BY 'sample';
GRANT ALL PRIVILEGES ON board.* TO 'board_user'@'%';

CREATE TABLE IF NOT EXISTS article (
  id  INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  content VARCHAR(2000),
  CONSTRAINT article_PK PRIMARY KEY(id)
) ENGINE=INNODB;

INSERT INTO article (title, content) VALUES ('Hello, world!', 'Nice to meet you.');
INSERT INTO article (title, content) (SELECT title, content FROM article);
INSERT INTO article (title, content) (SELECT title, content FROM article);
INSERT INTO article (title, content) (SELECT title, content FROM article);
INSERT INTO article (title, content) (SELECT title, content FROM article);
INSERT INTO article (title, content) (SELECT title, content FROM article);
INSERT INTO article (title, content) (SELECT title, content FROM article);

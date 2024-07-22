USE board;

GRANT ALL PRIVILEGES ON user.* TO 'board_user'@'%';

CREATE TABLE IF NOT EXISTS user (
  user_id VARCHAR(30) NOT NULL,
  name VARCHAR(50) NOT NULL,
  password CHAR(64),
  CONSTRAINT user_PK PRIMARY KEY(user_id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user_unique (
  idx INT NOT NULL AUTO_INCREMENT,
  user_id VARCHAR(30) NULL,
  CONSTRAINT user_unique_PK PRIMARY KEY(idx),
  CONSTRAINT user_unique_user_FK_1 FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE SET NULL
) ENGINE=INNODB;

INSERT INTO user (user_id, name, password) VALUES ('test001', 'John', '');
INSERT INTO user_unique(user_id) VALUES ('test001');

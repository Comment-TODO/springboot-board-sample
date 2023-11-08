CREATE DATABASE IF NOT EXISTS board;
USE board;

CREATE USER IF NOT EXISTS 'board_user'@'localhost' IDENTIFIED BY 'sample';
GRANT ALL PRIVILEGES ON board.* TO 'board_user'@'localhost';
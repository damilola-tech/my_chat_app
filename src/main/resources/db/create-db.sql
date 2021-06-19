create database if not exists chatdb;

create user if not exists 'chatuser'@'localhost' identified by 'chat123';
grant all privileges on chatdb.* to 'chatuser'@'localhost';
flush privileges;

create database if not exists doglab;
use agenda;
create table if not exists users(

	id int not null auto_increment,
	fullname varchar(40),
	nickname varchar(20),
	email varchar(40),
	born Date,
	primary key(id)
	
) default charset = utf8;
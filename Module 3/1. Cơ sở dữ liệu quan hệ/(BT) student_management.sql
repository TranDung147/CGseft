CREATE DATABASE student_management;
use student_management;

create table `Class`(
	id int not null,
    name varchar(255) not null
);

create table `Teacher`(
	id int not null,
    name varchar(255) not null,
    age int not null,
    country varchar(255) not null
);

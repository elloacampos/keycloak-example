create table if not exists users (
    username varchar(64) not null primary key,
    password varchar(64) not null,
    email varchar(128),
    firstName varchar(128) not null,
    lastName varchar(128) not null,
    birthDate DATE not null
);

insert into users set username = 'elloa', password='123', email='elloa.campos@db.com', firstname='elloa',  lastname='campos', birthdate=now();
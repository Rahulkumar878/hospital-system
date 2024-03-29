create database hotelmanagment;
use hotelmanagment;
create table details(Id int primary key auto_increment,fullname varchar(50) not null,
email varchar(50) not null,password varchar(50) not null);
select *from details;
create table specialist(id int primary key auto_increment,spec_name varchar(50) not null);
select *from specialist;
delete from specialist where id=1;
create table doctor(id int primary key auto_increment,fullname varchar(50) not null,dob varchar(20) not null,
qualification varchar(50) not null,specialist varchar(50) not null,email varchar(50) not null,
mobNo varchar(15) not null, password varchar(50) not null);
select *from doctor;
create table appo(id int primary key auto_increment,userid int  not null,fullname varchar(50),
gender varchar(10)not null,age int not null,appoindate varchar(50) not null,email varchar(50)not null,phone varchar(15) not null,
diseases varchar(50)not null,doctorid int not null,address varchar(500) not null,status varchar(500));
select *from appo;
drop table appo;
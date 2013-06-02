use nutch;
select * from datapresso_webpage;

select * from datapresso.address
select * from datapresso.person
select * from datapresso.document
select * from datapresso.event


-- INSERT INTO user (Host,User,Password) VALUES('localhost','my_user',PASSWORD('my_pass'))

 select user,host from mysql.user; 

CREATE schema datapresso;

CREATE USER datapresso IDENTIFIED BY 'welcome2013';
GRANT ALL PRIVILEGES ON datapresso.* TO 'datapresso'@'%';
GRANT ALL PRIVILEGES ON nutch.* TO 'datapresso'@'%';

select password('welcome2013')

insert into "document" ("name","url","status")  values (5791,'',1368676882500)
set SQL_MODE = 'ANSI_QUOTES';
select * from "datapresso"."address"


Use datapresso;


alter database datapresso character set=latin1;
use datapresso;
drop table document;
drop table section;
drop table entity;
drop table address;
drop table person;
drop table organization;
drop table relation;
drop table event;


		create table document
       (id int, name varchar(512), uri varchar(512), documenttext text, datecreated date, dateupdated date, doctimestamp varchar(100), status int);

       create table section
       (id int, documentid int, uid varchar(30), concept varchar(8000), context varchar(8000), coveredtext varchar(8000), status int);

       create table entity
       (id int, sectionid int, uid varchar(30), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));
       
       create table person
       (id int, uid varchar(30),  sectionid int, SSN varchar(20), firstname varchar(50), middlename varchar(50), lastname varchar(50), birthdate varchar(50), 
       race varchar(50), sex varchar(50),height varchar(10), weight varchar(10), title varchar(50), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));

       create table organization
       (id int,uid varchar(30),  sectionid int, name varchar(512), type varchar(100), contact varchar(255), url varchar(255), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));

       create table address
       (id int, uid varchar(30), sectionid int, number varchar(50), street varchar(255), city varchar(255), state varchar(255), country varchar(255),zip varchar(50),
        airport varchar(100), longitude varchar(50), latitude varchar(50), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));

       create table event
       (id int, uid varchar(30), sectionid int, eventname varchar(512), subject varchar(255), eventresult varchar(512), possentiment varchar(255), negsentiment varchar(255), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));
        
       create table relation
       (id int, uid varchar(30), sectionid int, relation varchar(512), subject varchar(255), object varchar(512), entitytype varchar(512), coveredtext varchar(8000), beginpos int, endpos int, ruleid varchar(100));


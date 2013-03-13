﻿-- Database: datapresso

-- DROP DATABASE datapresso;

CREATE DATABASE datapresso
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;


       create table document
       (id int, name varchar(512), url varchar(512), documenttext text, datecreated date, dateupdated date, status int);

       create table section
       (id int, documentid int, concept varchar(8000), sectiontext varchar(8000), status int);

       create table person
       (id int, sectionid int, SSN varchar(20), firstname varchar(50), middlename varchar(50), lastname varchar(50), birthdate varchar(50), 
       race varchar(50), sex varchar(50),height varchar(10), weight varchar(10), title varchar(50));

       create table organization
       (id int, sectionid int, name varchar(512), type varchar(100), contact varchar(255), url varchar(255));

       create table address
       (id int, sectionid int, number varchar(50), street varchar(255), city varchar(255), state varchar(255), country varchar(255),zip varchar(50),
       longitude varchar(50), latitude varchar(50));

       create table event
       (id int, sectionid int, eventname varchar(512), subject varchar(255), eventresult varchar(512), sentiment varchar(255));
        
       create table relation
       (id int, sectionid int, relation varchar(512), subject varchar(255), object varchar(512));



       

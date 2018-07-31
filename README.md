## Problem statement
Given the following content of a csv file:

name;bank_identifier

Postbank;10010010
  
Eurocity;10030700
  
Commerzbank;10040000
  
Raiffeisenbank;22163114

1. Write a program which imports the entries of the csv file into a database of your
choice (preferably PostgreSQL)
2. Fetch the record with the bank identifier 10040000 from DB and print the name
of the related bank to system out.

## Proposed solution

A simple JDBC connection with postgresql has been used for connecting and storing data to DB.

*"Insert"* query is run to insert data and *"Select"* query to retrieve data from DB.

## How to run project

- Create a user "_testUser_" in your postgresql.
- Run below query to create database.
  ````postgresql
  CREATE DATABASE <YOUR_DBNAME>
  WITH
  OWNER = <YOUR_USER>
  ENCODING = 'UTF8'
  LC_COLLATE = 'English_United States.1252'
  LC_CTYPE = 'English_United States.1252'
  TABLESPACE = pg_default
  CONNECTION LIMIT = -1;

- Run below query to create table.
```postgresql
CREATE TABLE <YOUR_TABLE_NAME> (
  name           VARCHAR(50) NOT NULL,
  postbank       VARCHAR(50) NOT NULL,
  eurocity       VARCHAR(50) NOT NULL,
  commerzbank    VARCHAR(50) NOT NULL,
  raiffeisenbank VARCHAR(50) NOT NULL
);
````
- Edit "_dbconfig.properties_" and add your DB details.
- Run Main.java

### Technical trade-off
- We could also use ORM like hibernate for storage and retrieval of data.

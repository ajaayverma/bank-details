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
- Run "_createDatabase.sql_" to create database and table.
- Edit "_dbconfig.properties_" and add your DB details.
- Run Main.java

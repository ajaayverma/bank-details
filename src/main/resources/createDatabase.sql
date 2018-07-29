CREATE DATABASE bankdb:
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE bank(
 name VARCHAR (50) NOT NULL,
 postbank VARCHAR (50) NOT NULL,
 eurocity VARCHAR (50) NOT NULL,
 commerzbank VARCHAR (50) NOT NULL,
 raiffeisenbank VARCHAR (50) NOT NULL
);
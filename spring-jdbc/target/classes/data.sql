/*create table person
(
  id integer not null,
  birth_date timestamp,
  location varchar(255),
  name varchar(255),
  primary key (id)
);*/

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(1,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(2,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(3,  'Pieter', 'Amsterdam',sysdate());
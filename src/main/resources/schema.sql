CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE CLIENT(
	idClient INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	nom varchar(20),
	primary key (idClient)
);

CREATE TABLE COMPTE_BANCAIRE(
  iban varchar(32),
  proprietaire VARCHAR (50),
	PRIMARY KEY (iban)
);

CREATE TABLE COMPTE_CLIENT(
  idClient INTEGER ,
  iban varchar(20),
  PRIMARY KEY (idClient, iban),
	FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
  FOREIGN KEY (iban) REFERENCES COMPTE_BANCAIRE(iban)
);


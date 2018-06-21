CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;
CREATE SEQUENCE ASSURANCE_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE COMPTE_BANCAIRE(
    idCompteBancaire INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    iban varchar(34),
    BIC varchar(11),
    swift_code varchar(8),
	PRIMARY KEY (iban)
);

CREATE TABLE CLIENT(
	idClient INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	nom varchar(20),
	comptePrincipal INTEGER,
	PRIMARY KEY (idClient),
	FOREIGN KEY (comptePrincipal) REFERENCES COMPTE_BANCAIRE(idCompteBancaire)
);

CREATE TABLE COMPTE_CLIENT(
  idCompte INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
  idClient INTEGER ,
  PRIMARY KEY (idCompte),
  FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
  FOREIGN KEY (idCompte) REFERENCES COMPTE_BANCAIRE(idCompteBancaire)
);


CREATE TABLE ASSURANCE(
    idAssurance INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    typeAssurance varchar(10),
    PRIMARY KEY (idAssurance)
);

CREATE TABLE CLIENT_ASSURANCE(
    idClient INTEGER,
    idAssurance INTEGER,
    PRIMARY KEY (idClient, idAssurance),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
    FOREIGN KEY (idAssurance) REFERENCES ASSURANCE(idAssurance)
);

CREATE TABLE CONTACT(
    idContact INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    idClient INTEGER,
    typeContact VARCHAR(80),
    valeurContact VARCHAR(160),
    PRIMARY KEY (idContact),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient)
);
CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;
CREATE SEQUENCE ASSURANCE_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE COMPTE_BANCAIRE(
  idCompteBancaire INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
  idClient INTEGER,
  iban varchar(34),
  BIC varchar(11),
	swiftCode varchar(8),
	PRIMARY KEY (idCompteBancaire),
  FOREIGN KEY (idClient) REFERENCES CLIENT(idClient)
);


CREATE TABLE CLIENT(
	idClient INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	nom varchar(20),
	comptePrincipal INTEGER,
	PRIMARY KEY (idClient),
	FOREIGN KEY (comptePrincipal) REFERENCES COMPTE_BANCAIRE(idCompteBancaire)
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
    typeContact INTEGER,
    valeurContact VARCHAR(160),
    PRIMARY KEY (idContact),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
    FOREIGN KEY (typeContact) REFERENCES TYPE_CONTACT(idType)
);

CREATE TABLE TYPE_CONTACT(
    idType INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    libelle VARCHAR(80),
    PRIMARY KEY (idType)
);

CREATE TABLE PERSONNE_MORALE(
    idClient INTEGER,
    siren VARCHAR(15),
    PRIMARY KEY (idClient),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient)
);

CREATE TABLE PERSONNE_PHYSIQUE(
    idClient INTEGER,
    prenom VARCHAR(40),
    dateNaissance DATE,
    PRIMARY KEY (idClient),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient)
);
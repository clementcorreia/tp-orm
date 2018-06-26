CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;
CREATE SEQUENCE ASSURANCE_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE CLIENT(
    idClient INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
	nom varchar(20),
	comptePrincipal INTEGER,
	PRIMARY KEY (idClient)
);

CREATE TABLE COMPTE_BANCAIRE(
    idCompteBancaire INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
    idClient INTEGER,
    iban varchar(34),
    BIC varchar(11),
    swiftCode varchar(8),
	PRIMARY KEY (idCompteBancaire)
);

CREATE TABLE CLIENT_ASSURANCE(
    idClient INTEGER,
    idAssurance INTEGER,
    PRIMARY KEY (idClient, idAssurance)
);

CREATE TABLE CONTACT(
    idContact INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
    idClient INTEGER,
    typeContact INTEGER,
    valeurContact VARCHAR(160),
    PRIMARY KEY (idContact)
);

CREATE TABLE TYPE_CONTACT(
    idType INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),
    libelle VARCHAR(80),
    PRIMARY KEY (idType)
);

CREATE TABLE PERSONNE_MORALE(
    idClient INTEGER,
    siren VARCHAR(15),
    PRIMARY KEY (idClient)
);

CREATE TABLE PERSONNE_PHYSIQUE(
    idClient INTEGER,
    prenom VARCHAR(40),
    dateNaissance DATE,
    PRIMARY KEY (idClient)
);

CREATE TABLE ECHEANCE(
    idEcheance INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),
    prix INTEGER,
    dateEmission DATE,
    datePaiement DATE,
    dateEmissionFacture DATE,
    PRIMARY KEY (idEcheance)
);

CREATE TABLE ASSURANCE(
    idAssurance INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numero VARCHAR(20),
    dateSouscription DATE,
    dateAnniversaire DATE,
    datePrelevement DATE,
    PRIMARY KEY (idAssurance)
);

ALTER TABLE CLIENT ADD FOREIGN KEY (comptePrincipal) REFERENCES COMPTE_BANCAIRE(idCompteBancaire);
ALTER TABLE COMPTE_BANCAIRE ADD FOREIGN KEY (idClient) REFERENCES CLIENT(idClient);
ALTER TABLE CLIENT_ASSURANCE ADD FOREIGN KEY (idClient) REFERENCES CLIENT(idClient);
ALTER TABLE CLIENT_ASSURANCE ADD FOREIGN KEY (idAssurance) REFERENCES ASSURANCE(idAssurance);
ALTER TABLE CONTACT ADD FOREIGN KEY (idClient) REFERENCES CLIENT(idClient);
ALTER TABLE CONTACT ADD FOREIGN KEY (typeContact) REFERENCES TYPE_CONTACT(idType);
ALTER TABLE PERSONNE_MORALE ADD FOREIGN KEY (idClient) REFERENCES CLIENT(idClient);
ALTER TABLE PERSONNE_PHYSIQUE ADD FOREIGN KEY (idClient) REFERENCES CLIENT(idClient);
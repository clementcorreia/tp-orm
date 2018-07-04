insert into CLIENT  (id, nom) values (1, 'cathy cathou');
insert into CLIENT  (id, nom) values (2, 'toto cathou');

insert INTO COMPTE_BANCAIRE (idCompteBancaire, idClient, iban, BIC, swiftCode) values(1, 1, 'FR7630001007941234567890185','Azerty', 'BOUSFRPP', 'SWIFT1');
insert INTO COMPTE_BANCAIRE (idCompteBancaire, idClient, iban, BIC, swiftCode) values(2, 2, 'FR7630004000031234567890143','toto', 'BOUSFRPP', 'SWIFT2');
insert INTO COMPTE_BANCAIRE (idCompteBancaire, idClient, iban, BIC, swiftCode) values(3, 1, 'FR7630006000011234567890189','toto', 'HSBCFRPP', 'SWIFT3');

/*insert INTO ASSURANCE (typeAssurance) values ('Auto');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from client where nom='cathy cathou'),
              (SELECT idAssurance from ASSURANCE where typeAssurance='Auto'));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES ((SELECT idClient from client where nom='cathy cathou'),'FR7630001007941234567890185');*/
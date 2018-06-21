INSERT INTO CLIENT  (nom) VALUES ('cathy cathou');
INSERT INTO CLIENT  (nom) VALUES ('toto cathou');
INSERT INTO CLIENT  (nom) VALUES ('testou testal');

INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='cathy cathou'), 'FR7630001007941234567890185','Azerty', 'BOUSFRPP');
INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='toto cathou'), 'FR7630004000031234567890143','toto', 'BOUSFRPP');
INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='testou testal'), 'FR7630006000011234567890189','toto', 'HSBCFRPP');

INSERT INTO ASSURANCE (typeAssurance) VALUES ('Auto');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      VALUES ((SELECT idClient FROM CLIENT WHERE nom='cathy cathou'),
              (SELECT idAssurance FROM ASSURANCE WHERE typeAssurance='Auto'));

INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='cathy cathou', 'téléphone', '0600340312');
INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='cathy cathou', 'mail', 'cathy.cathou@mail.fr');
INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='toto cathou', 'téléphone', '0600431212');
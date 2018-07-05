INSERT INTO CLIENT  (nom) VALUES ('cathy cathou');
INSERT INTO CLIENT  (nom) VALUES ('toto cathou');
INSERT INTO CLIENT  (nom) VALUES ('testou testal');

INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='cathy cathou'), 'FR7630001007941234567890185','Azerty', 'BOUSFRPP');
INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='toto cathou'), 'FR7630004000031234567890143','toto', 'BOUSFRPP');
INSERT INTO COMPTE_BANCAIRE (idClient, iban, BIC, swiftCode) VALUES((SELECT idClient FROM CLIENT WHERE nom='testou testal'), 'FR7630006000011234567890189','toto', 'HSBCFRPP');

INSERT INTO ASSURANCE (numero, dateSouscription, dateAnniversaire, datePrelevement) VALUES ((SELECT idClient FROM CLIENT WHERE nom='cathy cathou'), '014UIA38P38', '2018-03-24', '2019-03-24', '2018-07-15');
INSERT INTO ASSURANCE (numero, dateSouscription, dateAnniversaire, datePrelevement) VALUES ('01AIR938J90', '2017-06-24', '2018-06-24', '2018-07-01');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      VALUES ((SELECT idClient FROM CLIENT WHERE nom='cathy cathou'),
              (SELECT idAssurance FROM ASSURANCE WHERE numero='014UIA38P38'));
INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      VALUES ((SELECT idClient FROM CLIENT WHERE nom='toto cathou'),
              (SELECT idAssurance FROM ASSURANCE WHERE numero='01AIR938J90'));

INSERT INTO ECHEANCE (prix, dateEmission, datePaiement, dateEmissionFacture) VALUES (45, '2018-03-24', '2018-07-15', '2018-03-24');
INSERT INTO ECHEANCE (prix, dateEmission, datePaiement, dateEmissionFacture) VALUES (120, '2017-06-24', '2018-07-01', '2017-06-24');

INSERT INTO TYPE_CONTACT (libelle) VALUES ('telephone');
INSERT INTO TYPE_CONTACT (libelle) VALUES ('mail');

INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='cathy cathou', (SELECT idType FROM TYPE_CONTACT WHERE libelle='telephone'), '0600340312');
INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='cathy cathou', (SELECT idType FROM TYPE_CONTACT WHERE libelle='mail'), 'cathy.cathou@mail.fr');
INSERT INTO CONTACT (idClient, typeContact, valeurContact) VALUES (SELECT idClient FROM CLIENT WHERE nom='toto cathou', (SELECT idType FROM TYPE_CONTACT WHERE libelle='telephone'), '0600431212');





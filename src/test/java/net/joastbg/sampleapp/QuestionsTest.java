package net.joastbg.sampleapp;

import net.joastbg.sampleapp.dao.ClientDaoDatabase;
import net.joastbg.sampleapp.dao.ClientDaoInMemory;
import net.joastbg.sampleapp.entities.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuestionsTest {

    @Autowired
    ClientDaoDatabase clientDaoDatabase;

    static ClientDaoInMemory clientDaoInMemory;

    static PersonnePhysique clientExemple;

    @BeforeClass
    public static void setUp() {
        clientDaoInMemory = new ClientDaoInMemory();
        clientExemple = new PersonnePhysique();
        clientExemple.setNom("Test Client");
    }

    public java.sql.Date getDate(String valeur) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        java.util.Date uDate = sdf.parse(valeur);
        LocalDate lDate = uDate.toInstant().atZone(ZoneId.of("Europe/Paris").systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(lDate);
        return sqlDate;
    }

    @Test
    public void q01_clientModel(){
        System.out.println("Test : Ajout d'un client de type PersonnePhysique");
        PersonnePhysique pp = new PersonnePhysique();
        pp.setNom("Blabla");
        clientDaoInMemory.persist(pp);
        Assert.assertEquals(pp, clientDaoInMemory.findByNom("Blabla"));
        System.out.println("Test : Ajout d'un client de type PersonneMorale");
        PersonneMorale pm = new PersonneMorale();
        pm.setNom("Toto");
        clientDaoInMemory.persist(pm);
        assertEquals(pm, clientDaoInMemory.findByNom("Toto"));
    }

    @Test
    public void q02_addClientListAccount(){
        System.out.println("Test : Ajout d'une liste de comptes bancaires à un client");
        List<CompteBancaire> cbs = new ArrayList<>();
        CompteBancaire cb = new CompteBancaire();
        cb.setSwiftCode("bbaen");
        cb.setBic("FD4356G");
        cb.setIban("FR7633304440333044440333");
        cbs.add(cb);
        cb = new CompteBancaire();
        cb.setSwiftCode("derfgd");
        cb.setBic("RTFGHER");
        cb.setIban("FR763TG645TG7T645Y53");
        cbs.add(cb);
        /*clientExemple.setComptesBancaires(cbs);
        assertEquals(cbs, clientExemple.getComptesBancaires());*/
    }

    @Test
    public void q03_definePrincipalAccount(){
        System.out.println("Test : Définir un compte principal pour un client");
        CompteBancaire cb = new CompteBancaire();
        cb.setSwiftCode("bbaen");
        cb.setBic("FD4356G");
        cb.setIban("FR7633304440333044440333");
        /*clientExemple.setComptePrincipal(cb);
        assertEquals(cb, clientExemple.getComptePrincipal());*/
    }

    @Test
    public void q04_contactGestion(){
        System.out.println("Test : Gestion des contacts d'un client");
        TypeContact tMail = new TypeContact();
        tMail.setLibelle("Mail");
        TypeContact tTel = new TypeContact();
        tTel.setLibelle("Téléphone");
        TypeContact tPort = new TypeContact();
        tPort.setLibelle("Portable");
        Contact cMail = new Contact();
        cMail.setType(tMail);
        cMail.setValeur("prenom.nom@epsi.fr");
        Contact cTel = new Contact();
        cTel.setType(tTel);
        cTel.setValeur("0405060708");
        Contact cPort = new Contact();
        cPort.setType(tTel);
        cPort.setValeur("0706050403");
        List<Contact> lContacts = new ArrayList<>();
        lContacts.add(cMail);
        lContacts.add(cTel);
        clientExemple.setContacts(lContacts);
        assertEquals(lContacts, clientExemple.getContacts());
        clientExemple.addContact(cPort);
        lContacts.add(cPort);
        assertEquals(lContacts, clientExemple.getContacts());
        clientExemple.removeContact(cPort);
        lContacts.remove(cPort);
        assertEquals(lContacts, clientExemple.getContacts());
    }

    @Test
    public void q05_assuranceModel() throws ParseException {
        System.out.println("Test : Gestion des assurances");

        List<Assurance> assurances = new ArrayList<>();
        AssuranceAuto aa = new AssuranceAuto();
        AssuranceHabitation ah = new AssuranceHabitation();

        /**
         * Assurance auto 1
         */
        aa.setImmatriculation("AK-042-BW");
        aa.setBonusMalus(100);
        aa.setDateAnniversaire(getDate("02/05/2018"));
        aa.setDatePrelevement(getDate("02/05/2018"));
        aa.setDateSouscription(getDate("02/05/2018"));
        assurances.add(aa);

        /**
         * Assurance habitation 1
         */
        ah.setAdresseAssuree("335 avenue du Chateau d'O");
        ah.setValeurCouverture(100000);
        ah.setDateAnniversaire(getDate("12/04/2016"));
        ah.setDatePrelevement(getDate("12/04/2016"));
        ah.setDateSouscription(getDate("12/04/2016"));
        assurances.add(ah);

        clientExemple.setAssurances(assurances);
        assertEquals(assurances, clientExemple.getAssurances());

        /**
         * Assurance auto 2
         */
        ConducteurSecondaire cs = new ConducteurSecondaire();
        cs.setNom("Conducteur");
        cs.setPrenom("Secondaire");
        aa = new AssuranceAuto();
        aa.setImmatriculation("BH-277-BA");
        aa.setBonusMalus(85);
        aa.setDateAnniversaire(getDate("30/08/2017"));
        aa.setDatePrelevement(getDate("30/08/2017"));
        aa.setDateSouscription(getDate("30/08/2017"));
        aa.addConducteurSecondaire(cs);
        assurances.add(aa);

        clientExemple.addAssurance(aa);
        assertEquals(assurances, clientExemple.getAssurances());

        assurances.remove(aa);
        clientExemple.removeAssurance(aa);
        assertEquals(assurances, clientExemple.getAssurances());

    }

    @Test
    public void q06_addEcheance() throws ParseException {
        System.out.println("Test : Ajouter les échéances");

        // Je sais que ce n'est pas bien ! Mais j'avais la flemme
        AssuranceAuto aa = (AssuranceAuto) clientExemple.getAssurances().get(0);
        AssuranceAuto aaBase = aa;

        Echeance e1, e2, e3, e4, e5, e6;
        java.sql.Date d0, d1, d2, d3, d4, d5, d6;
        d0 = getDate("05/07/2018");
        d1 = getDate("09/08/2018");
        d2 = getDate("09/09/2018");
        d3 = getDate("09/10/2018");
        d4 = getDate("09/11/2018");
        d5 = getDate("09/12/2018");
        d6 = getDate("09/01/2019");
        e1 = new Echeance();
        e1.setDateEmission(d0);
        e1.setDatePaiement(d1);
        e1.setPrix(80);
        e2 = new Echeance();
        e2.setDateEmission(d0);
        e2.setDatePaiement(d2);
        e2.setPrix(80);
        e3 = new Echeance();
        e3.setDateEmission(d0);
        e3.setDatePaiement(d3);
        e3.setPrix(80);
        e4 = new Echeance();
        e4.setDateEmission(d0);
        e4.setDatePaiement(d4);
        e4.setPrix(80);
        e5 = new Echeance();
        e5.setDateEmission(d0);
        e5.setDatePaiement(d5);
        e5.setPrix(80);
        e6 = new Echeance();
        e6.setDateEmission(d0);
        e6.setDatePaiement(d6);
        e6.setPrix(80);

        List<Echeance> echeances = new ArrayList<>();
        echeances.add(e1);
        echeances.add(e2);
        echeances.add(e3);
        echeances.add(e4);
        echeances.add(e5);
        aa.setEcheances(echeances);
        assertEquals(echeances, aa.getEcheances());

        aa.addEcheance(e6);
        echeances.add(e6);
        assertEquals(echeances, aa.getEcheances());

        aa.removeEcheance(e6);
        echeances.remove(e6);
        assertEquals(echeances, aa.getEcheances());

        aa.addEcheance(e6);
        clientExemple.updateAssurance(aaBase, aa);
    }

    @Test
    public void q07_printEcheancierSixMonth() throws ParseException {
        System.out.println("Test : Imprimer l'échéancier des 6 prochains mois");

        // Je sais que ce n'est pas bien ! Mais j'avais la flemme
        AssuranceAuto aa = (AssuranceAuto) clientExemple.getAssurances().get(0);

        String printedEcheance = aa.printEcheancier(getDate("05/07/2018"));

        String printed = "2018-08-09 : 80€\n" +
        "2018-09-09 : 80€\n" +
        "2018-10-09 : 80€\n" +
        "2018-11-09 : 80€\n" +
        "2018-12-09 : 80€\n" +
        "2019-01-09 : 80€\n";

        assertEquals(printedEcheance, printed);

    }

    @Test
    public void q08_addSinistre(){
        System.out.println("Test : Saisie du sinistre de son assurance");

        Assurance assurance = clientExemple.getAssurances().get(0);




        fail("Not implemented yet");
    }

    @Test
    public void q09_terminateContractAtAnniversaryDate(){
        fail("Not implemented yet");
    }

    /*@Test
    public void q10_allClientAnniversaryDateLessThanThreeMonth(){
        System.out.println("Test : Récupération client ayant date d'anniversaire dans moins de 3 mois");


        ClientDaoDatabase clientDaoDatabase = new ClientDaoDatabase();
        List<Client> listClient = clientDaoDatabase.findAll();
        StringBuilder str = new StringBuilder();
        try {

            for (Client c : listClient) {
                if ((c.getAssurances().get(0).getDateAnniversaire().compareTo(getDate("05/07/2018")) > 0) &&
                        (c.getAssurances().get(0).getDateAnniversaire().compareTo(getDate("05/10/2018")) < 0) ) {
                    str.append(c.getNom()+"\n");
                }
            }

            //assertEquals(str, ); // TODO insérer la liste des clients qu'on est sencé récupérer

        }catch(ParseException e){
            e.printStackTrace();
        }

    }*/

}
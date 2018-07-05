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
    static ClientDaoDatabase clientDaoDatabase;

    static ClientDaoInMemory clientDaoInMemory;

    static PersonnePhysique clientExemple;

    @BeforeClass
    public static void setUp() {
        clientDaoInMemory = new ClientDaoInMemory();
        clientDaoDatabase = new ClientDaoDatabase();
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
        clientDaoInMemory.persistPhysique(pp);
        clientDaoDatabase.persistPhysique(pp);
        Assert.assertEquals(pp, clientDaoInMemory.findByNom("Blabla"));
        System.out.println("Test : Ajout d'un client de type PersonneMorale");
        PersonneMorale pm = new PersonneMorale();
        pm.setNom("Toto");
        clientDaoInMemory.persistMorale(pm);
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

    }

    @Test
    public void q03_definePrincipalAccount(){
        System.out.println("Test : Définir un compte principal pour un client");
        CompteBancaire cb = new CompteBancaire();
        cb.setSwiftCode("bbaen");
        cb.setBic("FD4356G");
        cb.setIban("FR7633304440333044440333");

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


        assurances.remove(aa);


    }

    @Test
    public void q06_addEcheance() throws ParseException {
        System.out.println("Test : Ajouter les échéances");


    }


}
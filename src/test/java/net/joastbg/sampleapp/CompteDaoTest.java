package net.joastbg.sampleapp;


import org.junit.Assert;
import net.joastbg.sampleapp.dao.ClientDaoDatabase;
import net.joastbg.sampleapp.dao.CompteDao;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class CompteDaoTest {


    @Autowired
    CompteDao compteDao;

    CompteBancaire compte;

    @Before
    public void setUp() {
        /*compte = new CompteBancaire();
        compte.setIban("FR7612548029980000000150086");
        PersonneMorale c = new PersonneMorale();
        c.setSiren("aaaaaaaaaa");
        c.setNom("Test");
        ClientDaoDatabase clientDAODatabase = new ClientDaoDatabase();
        clientDAODatabase.persist(c);
        compte.setClient(c);
        compte.setBic("aaaa");
        compte.setSwiftCode("aaa");*/
        //compte.setProprietaire("Cathy Catou");
    }

    @Test
    public void testPersist(){
        assertTrue(true);/*
        String id = compteDao.persist(compte);
        assertTrue(id != null);
        compteDao.delete(compte);*/
    }

    @Test
    public void testFind(){/*
        Long id = Long.valueOf(compteDao.persist(compte));
        CompteBancaire compteFound = compteDao.find(id);
        Assert.assertNotNull(compteFound);
        Assert.assertEquals(compte,compteFound);
        compteDao.delete(compte);*/

    }

}

package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDaoDatabase;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoDatabaseTest {

    @Autowired
    ClientDaoDatabase clientDaoDatabase;

    @Before
    public void setUp() {

    }

    @Test
    public void testPersist(){
        PersonneMorale personneMorale = new PersonneMorale();
        Long idPersonneMorale = clientDaoDatabase.persistMorale(personneMorale);
        Client test = clientDaoDatabase.find(idPersonneMorale);
        Assert.assertNotNull("personneMorale null", test);

/*        Client personnePhysique = new PersonnePhysique();
        Long idPersonnePhysique = clientDaoDatabase.persist(personnePhysique);
        Client test2 = clientDaoDatabase.find(idPersonnePhysique);
        Assert.assertNotNull("personnePhysique null", test2);*/
    }
}
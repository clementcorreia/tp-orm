package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Assurance;
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

import java.util.List;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() {

    }

    @Test
    public void testPersist(){
        Client personneMorale = new PersonneMorale();
        Long idPersonneMorale = clientDao.persist(personneMorale);
        Client test = clientDao.find(idPersonneMorale);
        Assert.assertNotNull("personneMorale null", test);

        Client personnePhysique = new PersonnePhysique();
        Long idPersonnePhysique = clientDao.persist(personnePhysique);
        Client test2 = clientDao.find(idPersonnePhysique);
        Assert.assertNotNull("personnePhysique null", test2);
    }
}
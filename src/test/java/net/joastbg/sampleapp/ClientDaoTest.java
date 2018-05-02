package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.Client;
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
        Assert.assertTrue(true);
    }

    @Test
    public void testFindAll(){
        List<Client> allClients = clientDao.findAll();
        Client client = allClients.get(0);
        Assert.assertEquals(1,client.getContrats().size());
        Assurance contrat = client.getContrats().get(0);
        Assert.assertEquals("Auto", contrat.getType());
        Assert.assertEquals(client, contrat.getSouscripteurs().get(0));
    }

}

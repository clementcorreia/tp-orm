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

import static org.junit.Assert.fail;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class QuestionsTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() {

    }

    @Test
    public void clientModel(){
        fail("Not implemented yet");
    }

    @Test
    public void addClientListAccount(){
        fail("Not implemented yet");
    }

    @Test
    public void definePrincipalAccount(){
        fail("Not implemented yet");
    }

    @Test
    public void contactGestion(){
        fail("Not implemented yet");
    }

    @Test
    public void assuranceModel(){
        fail("Not implemented yet");
    }

    @Test
    public void addEcheance(){
        fail("Not implemented yet");
    }

    @Test
    public void printEcheancierSixMonth(){
        fail("Not implemented yet");
    }

    @Test
    public void addSinistre(){
        fail("Not implemented yet");
    }

    @Test
    public void terminateContractAtAnniversaryDate(){
        fail("Not implemented yet");
    }

    @Test
    public void allClientAnniversaryDateLessThanThreeMonth(){
        fail("Not implemented yet");
    }

}
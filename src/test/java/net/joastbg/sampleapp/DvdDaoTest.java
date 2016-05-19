package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.DvdDao;
import net.joastbg.sampleapp.entities.*;
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
public class DvdDaoTest {

	@Autowired
	DvdDao dvdDao;
	
	@Before
	public void setUp() {

	}
	
	@Test
	public void testPersist(){
		Dvd newDvd = new Dvd();
		newDvd.setDescription("A test dvd");
		newDvd.setCategory(DvdCategory.THRILLER);
		newDvd.setPrice(15.99f);
		Long id = dvdDao.persist(newDvd);
		Dvd dvd = dvdDao.find(id);
		
		Assert.assertNotNull("Disk null", dvd);
		Assert.assertEquals("Prix incorrect",15.99f, dvd.getPrice());
		Assert.assertEquals("Category incorrect", DvdCategory.THRILLER, dvd.getCategory());
	}

	@Test
	public void testFindByDescription() {
		Dvd dvd = dvdDao.findByDescription("Transformers");
		Assert.assertNotNull("Erreur lors de la recherche par description", dvd);
		Assert.assertEquals("Le Dvd remonté n'est pas conforme à l'attendu", "Transformers", dvd.getDescription());
	}

	@Test
	public void testDvdMapping() {
		Dvd dvd = dvdDao.findByDescription("Transformers");
		Assert.assertEquals("Vedettes mapping incorrect", 1, dvd.getVedettes().size());
		Assert.assertNotNull("Realisateur", dvd.getRealisateur());
		Person realisateur = dvd.getRealisateur();
		Assert.assertEquals(TypePerson.REALISATEUR, realisateur.getPersonType());
		Assert.assertEquals("Michael", realisateur.getFirstName());
		Assert.assertEquals("Bay", realisateur.getLastName());
	}
	
	
}

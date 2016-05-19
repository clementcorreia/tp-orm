package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.DiskDao;
import net.joastbg.sampleapp.entities.Book;
import net.joastbg.sampleapp.entities.Disk;
import net.joastbg.sampleapp.entities.MusicStyle;
import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class DiskDaoTest {

	@Autowired
	DiskDao diskDao;
	
	@Before
	public void setUp() {

	}
	
	@Test
	public void testPersist(){
		Disk newDisk = new Disk();
		newDisk.setDescription("A test disk");
		newDisk.setMusicStyle(MusicStyle.ROCK);
		newDisk.setPrice(9.99f);
		Long id = diskDao.persist(newDisk);
		Disk disk = diskDao.find(id);
		
		Assert.assertNotNull("Disk null", disk);
		Assert.assertEquals("Prix incorrect",9.99f, disk.getPrice());
		Assert.assertEquals("MusicType incorrect", MusicStyle.ROCK, disk.getMusicStyle());
	}

	
}

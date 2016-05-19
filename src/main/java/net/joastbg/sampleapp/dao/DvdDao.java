package net.joastbg.sampleapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Dvd;

@Service
@Transactional
public class DvdDao {
	

	@Autowired
	SessionFactory sessionFactory;

	public Long persist(Dvd dvd){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(dvd);
		return returnID;
	}

	public Dvd find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Dvd) session.load(Dvd.class, id);
	}

	public Dvd findByDescription(String description) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Dvd WHERE description = :description");
		q.setString("description", description);
		return (Dvd) q.uniqueResult();
	}
	
}

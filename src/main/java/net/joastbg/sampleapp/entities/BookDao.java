package net.joastbg.sampleapp.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Book book){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(book);
		return returnID;
	}
	
	public Book find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Book) session.load(Book.class, id);
	}

	
}

package net.joastbg.sampleapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Book;
import net.joastbg.sampleapp.exceptions.DaoException;

@Service
@Transactional
public class BookDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Book book){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}
	
	public Book find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}

	public List<Book> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}

	public Book findByTitle(String title) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return null;
	}	
	
	public Book findByIsbn(String isbn) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return null;
	}	
}

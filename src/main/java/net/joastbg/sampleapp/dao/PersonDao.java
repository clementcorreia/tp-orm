package net.joastbg.sampleapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.exceptions.DaoException;

@Service
@Transactional
public class PersonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Person person){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}
	
	public Person find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}	
	
	public Person findByName(String lastName) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return null;

	}

	public List<Person> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return null;
	}
}

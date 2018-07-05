package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientDaoDatabase implements ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long persistPhysique(PersonnePhysique client) {
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    @Override
    public Long persistMorale(PersonneMorale client) {
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    @Override
    public List<PersonneMorale> findAllMorale(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM PersonneMorale").list();
    }

    @Override
    public List<PersonnePhysique> findAllPhysique(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM PersonnePhysique").list();
    }

    @Override
    public PersonnePhysique findPhysique(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM PersonnePhysique WHERE idClient=:idClient");
        query.setLong("idClient", id);
        return (PersonnePhysique) query.uniqueResult();
    }

    @Override
    public PersonneMorale findMorale(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM PersonneMorale WHERE idClient=:idClient");
        query.setLong("idClient", id);
        return (PersonneMorale) query.uniqueResult();
    }

    @Override
    public PersonnePhysique findByNomPhysique(String nom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM PersonnePhysique WHERE nom=:nom");
        query.setString("nom", nom);
        return (PersonnePhysique) query.uniqueResult();
    }

    @Override
    public PersonneMorale findByNomMorale(String nom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM PersonneMorale WHERE nom=:nom");
        query.setString("nom", nom);
        return (PersonneMorale) query.uniqueResult();
    }

}

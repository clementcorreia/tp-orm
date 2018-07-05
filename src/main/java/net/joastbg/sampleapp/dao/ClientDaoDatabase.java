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
}

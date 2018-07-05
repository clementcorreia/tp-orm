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

    public Long persist(PersonneMorale client){
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    public PersonneMorale find(Long idPersonneMorale) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM PersonneMorale WHERE idClient=:idclient");
        query.setLong("idclient", idPersonneMorale);
        return (PersonneMorale) query.uniqueResult();
    }

    @Override
    public Client findByNom(String nom) {
        return null;
    }

    public List<Client> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Client").list();
    }

    @Override
    public List<PersonneMorale> findAllPersonneMorale() {
        return null;
    }

    @Override
    public List<PersonnePhysique> findAllPersonnePhysique() {
        return null;
    }
}

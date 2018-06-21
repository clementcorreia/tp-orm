package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.PersonneMorale;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long persist(Client client){
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    public Client find(Long idPersonneMorale) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT * FROM Client WHERE idClient=?");
        query.setLong(1, idPersonneMorale);
        return (Client) query.uniqueResult();
    }

    public List<Client> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Client").list();
    }
}

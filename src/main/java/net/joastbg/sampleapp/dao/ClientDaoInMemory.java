package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoInMemory {

    public List<Client> clients = new ArrayList<>();

    public ClientDaoInMemory() {
        PersonneMorale pm = new PersonneMorale();
        PersonnePhysique pp = new PersonnePhysique();
        pm.setNom("Cathy Catou");
        pp.setNom("Eddy Malou");
        clients.add(pm);
        clients.add(pp);
        pm = new PersonneMorale();
        pm.setNom("Test plus");
        clients.add(pm);
    }

    public Long persist(Client client) {
        clients.add(client);
        return Long.valueOf(1);
    }


    public Client find(Long idClient) {
        return null;
    }


    public Client findByNom(String nom) {
        for(Client c : clients) {
            if(c.getNom().equals(nom)) {
                return c;
            }
        }
        return null;
    }


    public List<Client> findAll() {
        return clients;
    }


    public List<PersonneMorale> findAllPersonneMorale() {
        List<PersonneMorale> pms = new ArrayList<>();
        for(Client c : clients) {
            if(c instanceof PersonneMorale) {
                pms.add((PersonneMorale) c);
            }
        }
        return pms;
    }


    public List<PersonnePhysique> findAllPersonnePhysique() {
        List<PersonnePhysique> pps = new ArrayList<>();
        for(Client c : clients) {
            if(c instanceof PersonnePhysique) {
                pps.add((PersonnePhysique) c);
            }
        }
        return pps;
    }
}

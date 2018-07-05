package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoInMemory implements ClientDao {

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

    @Override
    public Long persistPhysique(PersonnePhysique client) {
        clients.add(client);
        return Long.valueOf(1);
    }

    @Override
    public Long persistMorale(PersonneMorale client) {
        clients.add(client);
        return Long.valueOf(1);
    }

    @Override
    public Client find(Long idClient) {
        return null;
    }

    @Override
    public Client findByNom(String nom) {
        for(Client c : clients) {
            if(c.getNom().equals(nom)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public List<PersonneMorale> findAllPersonneMorale() {
        List<PersonneMorale> pms = new ArrayList<>();
        for(Client c : clients) {
            if(c instanceof PersonneMorale) {
                pms.add((PersonneMorale) c);
            }
        }
        return pms;
    }

    @Override
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

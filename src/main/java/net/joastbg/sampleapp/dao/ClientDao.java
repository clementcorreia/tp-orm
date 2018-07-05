package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import java.util.List;

public interface ClientDao {

    public Long persist(Client client);

    public Client find(Long idClient);

    public Client findByNom(String nom);

    public List<Client> findAll();

    public List<PersonneMorale> findAllPersonneMorale();

    public List<PersonnePhysique> findAllPersonnePhysique();

}

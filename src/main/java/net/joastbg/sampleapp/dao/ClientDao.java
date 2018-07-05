package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import java.util.List;

public interface ClientDao {

    public Long persistPhysique(PersonnePhysique client);

    public Long persistMorale(PersonneMorale client);

    public List<PersonneMorale> findAllMorale();

    public List<PersonnePhysique> findAllPhysique();

    public PersonnePhysique findPhysique(Long id);

    public PersonneMorale findMorale(Long id);

    public PersonnePhysique findByNomPhysique(String nom);

    public PersonneMorale findByNomMorale(String nom);

}

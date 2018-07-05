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

}

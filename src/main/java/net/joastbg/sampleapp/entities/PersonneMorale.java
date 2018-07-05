package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNE_MORALE")
public class PersonneMorale extends Client {


    @Column
    private String siren;

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }
}

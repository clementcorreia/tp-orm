package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNE_MORALE")
@PrimaryKeyJoinColumn(name = "idClient")
public class PersonneMorale extends Client {

    @OneToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Column
    private String siren;

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }
}

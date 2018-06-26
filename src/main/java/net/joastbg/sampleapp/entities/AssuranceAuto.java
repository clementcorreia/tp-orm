package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ASSURANCE_AUTO")
@PrimaryKeyJoinColumn(name = "idAssurance")
public class AssuranceAuto extends Assurance {

    @OneToOne
    @JoinColumn(name = "idAssurance")
    private Assurance assurance;

    @Column
    private String immatriculation;

    @Column
    private int bonusMalus;

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(int bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

}
package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ASSURANCE_AUTO")
public class AssuranceAuto extends Assurance {

    @Id
    public long getIdAssurance() {
        return super.getIdAssurance();
    }

    @Column
    private String immatriculation;

    @Column
    private int bonusMalus;

    @OneToMany(mappedBy = "assurance")
    private List<ConducteurSecondaire> conducteursSecondaires;

    public AssuranceAuto() {
        this.conducteursSecondaires = new ArrayList<>();
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

    public List<ConducteurSecondaire> getConducteursSecondaires() {
        return conducteursSecondaires;
    }

    public void setConducteursSecondaires(List<ConducteurSecondaire> conducteursSecondaires) {
        this.conducteursSecondaires = conducteursSecondaires;
    }

    public void addConducteurSecondaire(ConducteurSecondaire conducteurSecondaire) {
        this.conducteursSecondaires.add(conducteurSecondaire);
    }

    public void removeConducteurSecondaire(ConducteurSecondaire conducteurSecondaire) {
        this.conducteursSecondaires.remove(conducteurSecondaire);
    }
}
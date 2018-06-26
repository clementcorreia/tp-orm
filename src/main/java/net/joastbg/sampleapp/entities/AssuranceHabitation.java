package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ASSURANCE_HABITATION")
@PrimaryKeyJoinColumn(name = "idAssurance")
public class AssuranceHabitation extends Assurance {

    @OneToOne
    @JoinColumn(name = "idAssurance")
    private Assurance assurance;

    @Column
    private String adresseAssuree;

    @Column
    private int valeurCouverture;

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public String getAdresseAssuree() {
        return adresseAssuree;
    }

    public void setAdresseAssuree(String adresseAssuree) {
        this.adresseAssuree = adresseAssuree;
    }

    public int getValeurCouverture() {
        return valeurCouverture;
    }

    public void setValeurCouverture(int valeurCouverture) {
        this.valeurCouverture = valeurCouverture;
    }
}
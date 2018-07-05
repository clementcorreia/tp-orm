package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ASSURANCE_HABITATION")
public class AssuranceHabitation extends Assurance {

    @Id
    public long getIdAssurance() {
        return super.getIdAssurance();
    }

    @Column
    private String adresseAssuree;

    @Column
    private int valeurCouverture;

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
package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ECHEANCE")
public class Echeance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEcheance")
    private Long id;

    @Column
    private int prix;

    @Column
    private Date dateEmission;

    @Column
    private Date datePaiement;

    @Column
    private Date dateEmissionFacture;

/*    @ManyToOne
    @JoinColumn(name = "idAssurance")
    private Assurance assurance;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getDateEmissionFacture() {
        return dateEmissionFacture;
    }

    public void setDateEmissionFacture(Date dateEmissionFacture) {
        this.dateEmissionFacture = dateEmissionFacture;
    }

  /*  public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }*/

    public String toString() {
        return this.datePaiement + " : " + this.prix + "€";
    }
}

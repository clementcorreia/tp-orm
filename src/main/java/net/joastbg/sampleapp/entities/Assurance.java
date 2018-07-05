package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Assurance implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAssurance;

    public long getIdAssurance() {
        return idAssurance;
    }

    public void setIdAssurance(long idAssurance) {
        this.idAssurance = idAssurance;
    }

    @Column
    private String numero;

    @Column
    private Date dateSouscription;

    @Column
    private Date dateAnniversaire;

    @Column
    private Date datePrelevement;

    @OneToMany(mappedBy = "assurance")
    private List<Echeance> echeances;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    public Assurance() {
        this.echeances = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public Date getDateAnniversaire() {
        return dateAnniversaire;
    }

    public void setDateAnniversaire(Date dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }

    public Date getDatePrelevement() {
        return datePrelevement;
    }

    public void setDatePrelevement(Date datePrelevement) {
        this.datePrelevement = datePrelevement;
    }

    public List<Echeance> getEcheances() {
        return echeances;
    }

    public void setEcheances(List<Echeance> echeances) {
        this.echeances = echeances;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addEcheance(Echeance echeance) {
        this.echeances.add(echeance);
    }

    public void removeEcheance(Echeance echeance) {
        this.echeances.remove(echeance);
    }

    public String printEcheancier(java.sql.Date dateDemande) {
        List<Echeance> echeancesPrinted = new ArrayList<>();
        for(Echeance e : echeances) {
            if(e.getDatePaiement().after(dateDemande)) {
                echeancesPrinted.add(e);
            }
        }
        String retour = "";
        for(Echeance e : echeancesPrinted) {
            retour+= e + "\n";
        }
        return retour;
    }
}
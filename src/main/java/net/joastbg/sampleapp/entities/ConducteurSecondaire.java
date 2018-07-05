package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CONDUCTEUR_SECONDAIRE")
public class ConducteurSecondaire implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idConducteurSecondaire;

    public long getIdConducteurSecondaire() {
        return idConducteurSecondaire;
    }

    public void setIdConducteurSecondaire(long idConducteurSecondaire) {
        this.idConducteurSecondaire = idConducteurSecondaire;
    }

    @ManyToOne
    @JoinColumn(name = "idAssurance")
    private AssuranceAuto assurance;

    @Column
    private String nom;

    @Column
    private String prenom;

    @OneToMany(mappedBy = "conducteurSecondaire")
    private List<Contact> contacts;

    public AssuranceAuto getAssurance() {
        return assurance;
    }

    public void setAssurance(AssuranceAuto assurance) {
        this.assurance = assurance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}

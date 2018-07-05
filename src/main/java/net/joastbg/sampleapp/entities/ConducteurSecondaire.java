package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.util.List;

public class ConducteurSecondaire {

    @Id
    @Column(name = "idConducteurSecondaire")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idAssurance")
    private AssuranceAuto assurance;

    @Column
    private String nom;

    @Column
    private String prenom;

    @OneToMany(mappedBy = "conducteurSecondaire")
    private List<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

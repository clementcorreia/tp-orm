package net.joastbg.sampleapp.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CLIENT")
public abstract class Client implements Serializable  {

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idClient;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column
    private String nom;


}

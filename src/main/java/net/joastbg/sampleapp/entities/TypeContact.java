package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name="TYPE_CONTACT")
public class TypeContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idType")
    private Long id;

    @Column
    private String libelle;

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

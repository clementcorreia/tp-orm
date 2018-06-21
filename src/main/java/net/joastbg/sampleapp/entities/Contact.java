package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idContact")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "typeContact")
    private TypeContact type;

    @Column(name = "valeurContact")
    private String valeur;

    public Long getId() {
        return id;
    }

    public TypeContact getType() {
        return type;
    }

    public void setType(TypeContact type) {
        this.type = type;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}

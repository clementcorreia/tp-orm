package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name="CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idContact")
    private Long id;

    @ManyToOne
    @JoinColumn(name="fk_type")
    private TypeContact type;

    @Column
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

package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idContact")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "typeContact")
    private TypeContact type;

    @Column(name = "valeurContact")
    private String valeur;

/*    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;*/

/*    @ManyToOne
    @JoinColumn(name = "idConducteurSecondaire")
    private ConducteurSecondaire conducteurSecondaire;*/

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

package net.joastbg.sampleapp.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client {

    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "comptePrincipal")
    private int comptePrincipal;

    @OneToMany
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = {@JoinColumn(name = "idClient")},
            inverseJoinColumns = {@JoinColumn(name = "idClient")}
    )
    private List<CompteBancaire> compteBancaireList;

    public Client() {

    }
}

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

    @OneToOne
    @JoinColumn(name = "comptePrincipal")
    private CompteBancaire comptePrincipal;

    @OneToMany(mappedBy = "client")
    private List<CompteBancaire> compteBancaireList;

    public Client() {

    }
}

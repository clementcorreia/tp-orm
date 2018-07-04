package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Assurance {

    @Id
    @Column(name = "idAssurance")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private Long id;

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

    }
}
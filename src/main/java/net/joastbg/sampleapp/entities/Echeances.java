package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class Echeances {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEcheance")
    private Long id;

    @Column
    private int prix;

    @Column
    private Date dateEmission;

    @Column
    private Date datePaiement;

    @Column
    private Date dateEmissionFacture;

    @ManyToOne
    @JoinColumn(name = "idAssurance")
    private Assurance assurance;

}

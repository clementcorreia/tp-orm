package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SINISTRE")
@SequenceGenerator(name = "seq", initialValue = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Sinistre {

    @Id
    @Column(name = "idSinistre")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Column
    private Date dateSinistre;

    @Column
    private String titre;

    @Column
    private String description;

}

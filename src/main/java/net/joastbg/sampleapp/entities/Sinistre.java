package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "SINISTRE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Sinistre implements Serializable {

    @Id
    @Column(name = "idSinistre")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getId() {
        return id;
    }
}

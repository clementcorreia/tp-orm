package net.joastbg.sampleapp.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="seq", initialValue=1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Contact{

    @Id
    @Column(name = "idContact")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    private Long id;

    @Column(name = "typeContact")
    private String typeContact;

    @Column(name = "valeurContact")
    private String valeurContact;

    public Contact() {

    }
}
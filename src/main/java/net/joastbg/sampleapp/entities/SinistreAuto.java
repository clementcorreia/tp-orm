package net.joastbg.sampleapp.entities;


import javax.persistence.*;

@Entity
@Table(name = "SINISTRE_AUTO")
@PrimaryKeyJoinColumn(name = "idSinistre")
public class SinistreAuto extends Sinistre {

    @OneToOne
    @JoinColumn(name = "idSinistre")
    private Sinistre sinistre;

    @Column
    private String photo;

}

package net.joastbg.sampleapp.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SINISTRE_AUTO")
public class SinistreAuto extends Sinistre implements Serializable {

    @Column
    private String photo;

}

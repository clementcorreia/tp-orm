package net.joastbg.sampleapp.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SINISTRE_AUTO")
public class SinistreAuto extends Sinistre implements Serializable {
    private Long idSinistre;

    @Id
    public Long getIdSinistre() {
        return idSinistre;
    }

    public void setIdSinistre(Long idSinistre) {
        this.idSinistre = idSinistre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column
    private String photo;

}

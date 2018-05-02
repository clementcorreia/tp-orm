package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "assurance_seq")
@Table(name="ASSURANCE")
public class Assurance {

    public Long getIdAssurance() {
        return idAssurance;
    }

    public void setIdAssurance(Long idAssurance) {
        this.idAssurance = idAssurance;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="assurance_seq")
    @SequenceGenerator(
            name="assurance_seq",

            sequenceName="ASSURANCE_SEQUENCE"
    )
    private Long idAssurance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column(name = "typeAssurance")
    private String type;


    public List<Client> getSouscripteurs() {
        return souscripteurs;
    }

    public void setSouscripteurs(List<Client> souscripteurs) {
        this.souscripteurs = souscripteurs;
    }

    @ManyToMany(
            mappedBy = "contrats"
    )
    private List<Client> souscripteurs;
}

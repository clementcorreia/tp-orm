package net.joastbg.sampleapp.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONNE_PHYSIQUE")
@PrimaryKeyJoinColumn(name = "idClient")
public class PersonnePhysique extends Client {

    @Id
    @OneToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Column
    private String prenom;

    @Column
    private Date dateNaissance;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

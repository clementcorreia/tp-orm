package net.joastbg.sampleapp.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="COMPTE_BANCAIRE")
public class CompteBancaire {

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Id
    private String iban;

    private String proprietaire;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="COMPTE_CLIENT",
            joinColumns = @JoinColumn( name="iban"),
            inverseJoinColumns = @JoinColumn( name="idClient")
    )

    private List<Client> utilisateurs;

    public List<Client> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Client> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }



}

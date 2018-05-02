package net.joastbg.sampleapp.entities;


import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@SequenceGenerator(name = "client_seq")
@Table(name="CLIENT")
public class Client implements Serializable {

    @ManyToMany
    @JoinTable(
            name="CLIENT_ASSURANCE",
            joinColumns=@JoinColumn(name="idClient"),
            inverseJoinColumns=@JoinColumn(name="idAssurance")
    )
    private List<Assurance> contrats;
    public List<Assurance> getContrats() {
        return contrats;
    }

    public void setContrats(List<Assurance> contrats) {
        this.contrats = contrats;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient) &&
                Objects.equals(name, client.name) &&
                Objects.equals(dateAdhesion, client.dateAdhesion) &&
                Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idClient, name, dateAdhesion, lastName);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_seq")
    @SequenceGenerator(
            name="client_seq",

            sequenceName="client_sequence"
    )
    private Long idClient;
    @Column(name = "nom")
    private String name;
    private Date dateAdhesion;


    public Set<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void setComptesBancaires(Set<CompteBancaire> comptesBancaires) {
        this.comptesBancaires = comptesBancaires;
    }

    @OneToMany
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = {@JoinColumn(name = "idClient")},
            inverseJoinColumns = {@JoinColumn(name = "iban", nullable = false, updatable = false)}
    )
    private Set<CompteBancaire> comptesBancaires;

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }


    private String lastName;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}




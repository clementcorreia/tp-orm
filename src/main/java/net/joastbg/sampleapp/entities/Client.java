package net.joastbg.sampleapp.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client implements Serializable {

    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToOne
    @JoinColumn(name = "comptePrincipal")
    private CompteBancaire comptePrincipal;

    @OneToMany(mappedBy = "client")
    private List<CompteBancaire> comptesBancaires;

    @OneToMany(mappedBy = "client")
    private List<Assurance> assurances;

    @OneToMany(mappedBy = "client")
    private List<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CompteBancaire getComptePrincipal() {
        return comptePrincipal;
    }

    public void setComptePrincipal(CompteBancaire comptePrincipal) {
        this.comptePrincipal = comptePrincipal;
    }

    public List<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void setComptesBancaires(List<CompteBancaire> comptesBancaires) {
        this.comptesBancaires = comptesBancaires;
    }

    public void addCompteBancaire(CompteBancaire cb) {
        this.comptesBancaires.add(cb);
    }

    public List<Assurance> getAssurances() {
        return assurances;
    }

    public void setAssurances(List<Assurance> assurances) {
        this.assurances = assurances;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }

    public void addAssurance(Assurance assurance) {
        this.assurances.add(assurance);
    }

    public void removeAssurance(Assurance assurance) {
        this.assurances.remove(assurance);
    }

    public void updateAssurance(Assurance base, Assurance updated) {
        int index = assurances.size();
        for(int i=0; i < assurances.size(); i++) {
            Assurance a = assurances.get(i);
            if(a.equals(base)) {
                index = i;
                break;
            }
        }
        this.assurances.set(index, updated);
    }
}

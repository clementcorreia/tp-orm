package net.joastbg.sampleapp.entities;


import javax.persistence.*;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idCompteBancaire")
    private Long id;

    @ManyToOne
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = {@JoinColumn(name = "idClient")},
            inverseJoinColumns = {@JoinColumn(name = "idClient")}
    )
    private Client client;

    @Column
    private String iban;

    @Column(name="BIC")
    private String bic;

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}

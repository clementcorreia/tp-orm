package net.joastbg.sampleapp.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long idCompteBancaire;

    public long getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(long idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "idClient")
    private Client idClient;

    @Column(name="iban")
    private String iban;

    @Column(name="BIC")
    private String bic;

    @Column(name="swiftCode")
    private String swiftCode;

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
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

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
package net.joastbg.sampleapp.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idCompteBancaire")
    private Long id;

/*    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;*/

    @Column(name="iban")
    private String iban;

    @Column(name="BIC")
    private String bic;

    @Column(name="swiftCode")
    private String swiftCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

/*    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }*/

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
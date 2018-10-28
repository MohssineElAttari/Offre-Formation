/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mr. Mohamed DAKIR
 */
@Entity
public class ClientFormation {
    
    @EmbeddedId
    private ClientFormationPk id;
    @JoinColumn(name = "idClient", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Client client;
    @JoinColumn(name = "idFormation" , referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Formation formation;
    private int etat;

    public ClientFormation() {
    }

    public ClientFormation(ClientFormationPk id, Client client, Formation formation, int etat) {
        this.id = id;
        this.client = client;
        this.formation = formation;
        this.etat = etat;
    }

    public ClientFormationPk getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Formation getFormation() {
        return formation;
    }

    public int getEtat() {
        return etat;
    }

    public void setId(ClientFormationPk id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
    
    
    
}

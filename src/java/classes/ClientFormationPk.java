/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author Mr. Mohamed DAKIR
 */
@Embeddable
public class ClientFormationPk implements Serializable{
    
    private int idClient;
    private int idFormation;
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;

    public ClientFormationPk() {
    }

    public ClientFormationPk(int idClient, int idFormation, Date dateInscription) {
        this.idClient = idClient;
        this.idFormation = idFormation;
        this.dateInscription = dateInscription;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
   
   
    
}

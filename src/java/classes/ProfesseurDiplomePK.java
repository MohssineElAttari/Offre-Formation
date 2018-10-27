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
 * @author Sinponzakra
 */
@Embeddable
public class ProfesseurDiplomePK implements Serializable{
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dip_date;
    private int professeur_id;
    private int diplome_id;

    public ProfesseurDiplomePK() {
    }

    public ProfesseurDiplomePK(Date dip_date, int professeur_id, int diplome_id) {
        this.dip_date = dip_date;
        this.professeur_id = professeur_id;
        this.diplome_id = diplome_id;
    }

    public Date getDip_date() {
        return dip_date;
    }

    public void setDip_date(Date dip_date) {
        this.dip_date = dip_date;
    }

    public int getProfesseur_id() {
        return professeur_id;
    }

    public void setProfesseur_id(int professeur_id) {
        this.professeur_id = professeur_id;
    }

    public int getDiplome_id() {
        return diplome_id;
    }

    public void setDiplome_id(int diplome_id) {
        this.diplome_id = diplome_id;
    }
    
    
}

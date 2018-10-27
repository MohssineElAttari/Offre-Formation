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
public class ProfesseurCertificatPK implements Serializable{
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cert_date;
    private int professeur_id;
    private int certificat_id;

    public ProfesseurCertificatPK() {
    }

    public ProfesseurCertificatPK(Date cert_date, int professeur_id, int certificat_id) {
        this.cert_date = cert_date;
        this.professeur_id = professeur_id;
        this.certificat_id = certificat_id;
    }

    public Date getCert_date() {
        return cert_date;
    }

    public void setCert_date(Date cert_date) {
        this.cert_date = cert_date;
    }


    public int getProfesseur_id() {
        return professeur_id;
    }

    public void setProfesseur_id(int professeur_id) {
        this.professeur_id = professeur_id;
    }

    public int getCertificat_id() {
        return certificat_id;
    }

    public void setCertificat_id(int certificat_id) {
        this.certificat_id = certificat_id;
    }
    
    
    
}

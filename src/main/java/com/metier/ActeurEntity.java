package com.metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Robin on 18/10/2017.
 */
@Entity
@Table(name = "acteur", schema = "cinevial", catalog = "")
public class ActeurEntity {
    private int noAct;
    private String nomAct;
    private String prenAct;
    private Date dateNaiss;
    private Date dateDeces;

    @Id
    @Column(name = "NoAct")
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "NomAct")
    public String getNomAct() {
        return nomAct;
    }

    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

    @Basic
    @Column(name = "PrenAct")
    public String getPrenAct() {
        return prenAct;
    }

    public void setPrenAct(String prenAct) {
        this.prenAct = prenAct;
    }

    @Basic
    @Column(name = "DateNaiss")
    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Basic
    @Column(name = "DateDeces")
    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActeurEntity that = (ActeurEntity) o;

        if (noAct != that.noAct) return false;
        if (nomAct != null ? !nomAct.equals(that.nomAct) : that.nomAct != null) return false;
        if (prenAct != null ? !prenAct.equals(that.prenAct) : that.prenAct != null) return false;
        if (dateNaiss != null ? !dateNaiss.equals(that.dateNaiss) : that.dateNaiss != null) return false;
        if (dateDeces != null ? !dateDeces.equals(that.dateDeces) : that.dateDeces != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noAct;
        result = 31 * result + (nomAct != null ? nomAct.hashCode() : 0);
        result = 31 * result + (prenAct != null ? prenAct.hashCode() : 0);
        result = 31 * result + (dateNaiss != null ? dateNaiss.hashCode() : 0);
        result = 31 * result + (dateDeces != null ? dateDeces.hashCode() : 0);
        return result;
    }
}

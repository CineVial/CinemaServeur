package com.cinevial.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "acteur", schema = "cinevial")
public class ActeurEntity {
    private int noAct;
    private String nomAct;
    private String prenAct;
    private Date dateNaiss;
    private Date dateDeces;

    @Id
    @Column(name = "no_act", nullable = false)
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "nom_act", nullable = false, length = 20)
    public String getNomAct() {
        return nomAct;
    }

    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

    @Basic
    @Column(name = "pren_act", length = 20)
    public String getPrenAct() {
        return prenAct;
    }

    public void setPrenAct(String prenAct) {
        this.prenAct = prenAct;
    }

    @Basic
    @Column(name = "date_naiss")
    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Basic
    @Column(name = "date_deces")
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
        return noAct == that.noAct &&
                Objects.equals(nomAct, that.nomAct) &&
                Objects.equals(prenAct, that.prenAct) &&
                Objects.equals(dateNaiss, that.dateNaiss) &&
                Objects.equals(dateDeces, that.dateDeces);
    }

    @Override
    public int hashCode() {

        return Objects.hash(noAct, nomAct, prenAct, dateNaiss, dateDeces);
    }
}

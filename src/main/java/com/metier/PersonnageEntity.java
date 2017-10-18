package com.metier;

import javax.persistence.*;

/**
 * Created by Robin on 18/10/2017.
 */
@Entity
@Table(name = "personnage", schema = "cinevial", catalog = "")
@IdClass(PersonnageEntityPK.class)
public class PersonnageEntity {
    private int noFilm;
    private int noAct;
    private String nomPers;

    @Id
    @Column(name = "NoFilm")
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Id
    @Column(name = "NoAct")
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "NomPers")
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnageEntity that = (PersonnageEntity) o;

        if (noFilm != that.noFilm) return false;
        if (noAct != that.noAct) return false;
        if (nomPers != null ? !nomPers.equals(that.nomPers) : that.nomPers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + noAct;
        result = 31 * result + (nomPers != null ? nomPers.hashCode() : 0);
        return result;
    }
}

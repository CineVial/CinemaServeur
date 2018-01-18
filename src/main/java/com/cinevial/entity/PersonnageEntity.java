package com.cinevial.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personnage", schema = "cinevial", catalog = "")
@IdClass(PersonnageEntityPK.class)
public class PersonnageEntity {
    private int noFilm;
    private int noAct;
    private String nomPers;

    @Id
    @Column(name = "no_film", nullable = false)
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Id
    @Column(name = "no_act", nullable = false)
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "nom_pers", nullable = false, length = 30)
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
        return noFilm == that.noFilm &&
                noAct == that.noAct &&
                Objects.equals(nomPers, that.nomPers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(noFilm, noAct, nomPers);
    }
}

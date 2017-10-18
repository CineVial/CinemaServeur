package com.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Robin on 18/10/2017.
 */
public class PersonnageEntityPK implements Serializable {
    private int noFilm;
    private int noAct;

    @Column(name = "NoFilm")
    @Id
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Column(name = "NoAct")
    @Id
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnageEntityPK that = (PersonnageEntityPK) o;

        if (noFilm != that.noFilm) return false;
        if (noAct != that.noAct) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + noAct;
        return result;
    }
}

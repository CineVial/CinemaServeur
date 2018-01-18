package com.cinevial.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonnageEntityPK implements Serializable {
    private int noFilm;
    private int noAct;

    @Column(name = "no_film", nullable = false)
    @Id
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Column(name = "no_act", nullable = false)
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
        return noFilm == that.noFilm &&
                noAct == that.noAct;
    }

    @Override
    public int hashCode() {

        return Objects.hash(noFilm, noAct);
    }
}

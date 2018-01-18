package com.cinevial.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "realisateur", schema = "cinevial")
public class RealisateurEntity {
    private int noRea;
    private String nomRea;
    private String prenRea;

    @Id
    @Column(name = "no_rea", nullable = false)
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "nom_rea", nullable = false, length = 20)
    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    @Basic
    @Column(name = "pren_rea", nullable = false, length = 20)
    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealisateurEntity that = (RealisateurEntity) o;
        return noRea == that.noRea &&
                Objects.equals(nomRea, that.nomRea) &&
                Objects.equals(prenRea, that.prenRea);
    }

    @Override
    public int hashCode() {

        return Objects.hash(noRea, nomRea, prenRea);
    }
}

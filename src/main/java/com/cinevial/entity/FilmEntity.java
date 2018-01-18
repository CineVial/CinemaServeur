package com.cinevial.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "cinevial")
public class FilmEntity {
    private int noFilm;
    private String titre;
    private int duree;
    private Date dateSortie;
    private int budget;
    private int montantRecette;
    private int noRea;
    private String codeCat;

    @Id
    @Column(name = "no_film", nullable = false)
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "titre", nullable = false, length = 30)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "duree", nullable = false)
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "date_sortie", nullable = false)
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "budget", nullable = false)
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "montant_recette", nullable = false)
    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Basic
    @Column(name = "no_rea", nullable = false)
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "code_cat", nullable = false, length = 2)
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return noFilm == that.noFilm &&
                duree == that.duree &&
                budget == that.budget &&
                montantRecette == that.montantRecette &&
                noRea == that.noRea &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(dateSortie, that.dateSortie) &&
                Objects.equals(codeCat, that.codeCat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(noFilm, titre, duree, dateSortie, budget, montantRecette, noRea, codeCat);
    }
}

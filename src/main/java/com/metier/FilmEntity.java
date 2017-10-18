package com.metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Robin on 18/10/2017.
 */
@Entity
@Table(name = "film", schema = "cinevial", catalog = "")
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
    @Column(name = "NoFilm")
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Duree")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "DateSortie")
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "Budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "MontantRecette")
    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Basic
    @Column(name = "NoRea")
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "CodeCat")
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

        if (noFilm != that.noFilm) return false;
        if (duree != that.duree) return false;
        if (budget != that.budget) return false;
        if (montantRecette != that.montantRecette) return false;
        if (noRea != that.noRea) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (dateSortie != null ? !dateSortie.equals(that.dateSortie) : that.dateSortie != null) return false;
        if (codeCat != null ? !codeCat.equals(that.codeCat) : that.codeCat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + duree;
        result = 31 * result + (dateSortie != null ? dateSortie.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + montantRecette;
        result = 31 * result + noRea;
        result = 31 * result + (codeCat != null ? codeCat.hashCode() : 0);
        return result;
    }
}

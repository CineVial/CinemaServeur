package com.metier;

import javax.persistence.*;

/**
 * Created by Robin on 18/10/2017.
 */
@Entity
@Table(name = "categorie", schema = "cinevial", catalog = "")
public class CategorieEntity {
    private String codeCat;
    private String libelleCat;

    @Id
    @Column(name = "CodeCat")
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "LibelleCat")
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorieEntity that = (CategorieEntity) o;

        if (codeCat != null ? !codeCat.equals(that.codeCat) : that.codeCat != null) return false;
        if (libelleCat != null ? !libelleCat.equals(that.libelleCat) : that.libelleCat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeCat != null ? codeCat.hashCode() : 0;
        result = 31 * result + (libelleCat != null ? libelleCat.hashCode() : 0);
        return result;
    }
}

package com.cinevial.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorie", schema = "cinevial", catalog = "")
public class CategorieEntity {
    private int codeCat;
    private String libelleCat;

    @Id
    @Column(name = "code_cat", nullable = false)
    public int getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(int codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "libelle_cat", nullable = false, length = 20)
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
        return codeCat == that.codeCat &&
                Objects.equals(libelleCat, that.libelleCat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeCat, libelleCat);
    }
}

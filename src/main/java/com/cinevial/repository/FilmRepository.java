package com.cinevial.repository;

import com.cinevial.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    List<FilmEntity> findAllByCodeCat(Integer codeCat);
    List<FilmEntity> findAllByTitre(String titre);
}

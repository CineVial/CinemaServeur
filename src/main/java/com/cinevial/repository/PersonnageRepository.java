package com.cinevial.repository;

import com.cinevial.entity.PersonnageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnageRepository extends JpaRepository<PersonnageEntity, Integer> {

    PersonnageEntity findFirstByNoActAndNoFilm(int noAct, int noFilm);

    List<PersonnageEntity> findAllByNoAct(int noAct);

    List<PersonnageEntity> findAllByNoFilm(int noFilm);

    void deleteAllByNoAct(int noAct);

    void deleteAllByNoFilm(int noFilm);

    void deleteAllByNoActAndNoFilm(int noAct, int noFilm);
}

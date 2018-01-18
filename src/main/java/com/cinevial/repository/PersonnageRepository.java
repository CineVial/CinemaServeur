package com.cinevial.repository;

import com.cinevial.entity.PersonnageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnageRepository extends JpaRepository<PersonnageEntity, Integer> {

    PersonnageEntity findFirstByNoActAndNoFilm(int noAct, int noFilm);

    PersonnageEntity findAllByNoAct(int noAct);

    PersonnageEntity findAllByNoFilm(int noFilm);
}

package com.cinevial.repository;

import com.cinevial.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {
}

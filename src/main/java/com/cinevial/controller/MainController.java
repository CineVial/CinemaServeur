package com.cinevial.controller;

import com.cinevial.entity.*;
import com.cinevial.repository.*;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private ActeurRepository acteurRepository;
    private CategorieRepository categorieRepository;
    private FilmRepository filmRepository;
    private PersonnageRepository personnageRepository;
    private RealisateurRepository realisateurRepository;

    private Gson gson;

    public MainController(ActeurRepository acteurRepository,
                          CategorieRepository categorieRepository,
                          FilmRepository filmRepository,
                          PersonnageRepository personnageRepository,
                          RealisateurRepository realisateurRepository) {
         this.gson = new Gson();
        this.acteurRepository = acteurRepository;
        this.categorieRepository = categorieRepository;
        this.filmRepository = filmRepository;
        this.personnageRepository = personnageRepository;
        this.realisateurRepository = realisateurRepository;
    }

    @RequestMapping("/acteurs")
    public ResponseEntity getActeurs() {
        List<ActeurEntity> acteurs = new ArrayList<>();
        acteurRepository.findAll().forEach(acteurs::add);
        return ResponseEntity.ok(gson.toJson(acteurs));
    }

    @RequestMapping("/films")
    public ResponseEntity getFilms() {
        List<FilmEntity> films = new ArrayList<>();
        filmRepository.findAll().forEach(films::add);
        return ResponseEntity.ok(gson.toJson(films));
    }

    @RequestMapping("/categories")
    public ResponseEntity getCategories() {
        List<CategorieEntity> categories = new ArrayList<>();
        categorieRepository.findAll().forEach(categories::add);
        return ResponseEntity.ok(gson.toJson(categories));
    }

    @RequestMapping("/personnages")
    public ResponseEntity getPersonnages() {
        List<PersonnageEntity> personnages = new ArrayList<>();
        personnageRepository.findAll().forEach(personnages::add);
        return ResponseEntity.ok(gson.toJson(personnages));
    }

    @RequestMapping("/realisateurs")
    public ResponseEntity getRealisateurs() {
        List<RealisateurEntity> realisateurs = new ArrayList<>();
        realisateurRepository.findAll().forEach(realisateurs::add);
        return ResponseEntity.ok(gson.toJson(realisateurs));
    }
}

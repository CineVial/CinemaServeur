package com.cinevial.controller;

import com.cinevial.entity.*;
import com.cinevial.repository.*;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
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

    // GETTERS for all

    @RequestMapping("/acteurs")
    public ResponseEntity getActeurs() {
        List<ActeurEntity> acteurs = new ArrayList<>();
        acteurRepository.findAll().forEach(acteurs::add);
        return ResponseEntity.ok(acteurs);
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

    // GETTERS for one

    @RequestMapping("/acteur/{id}")
    public ResponseEntity getActeurById(@PathVariable("id") Integer id) {
        ActeurEntity acteur = acteurRepository.findOne(id);
        return ResponseEntity.ok(gson.toJson(acteur));
    }

    @RequestMapping("/categorie/{id}")
    public ResponseEntity getCategorieById(@PathVariable("id") Integer id) {
        CategorieEntity categorie = categorieRepository.findOne(id);
        return ResponseEntity.ok(gson.toJson(categorie));
    }

    @RequestMapping("/film/{id}")
    public ResponseEntity getFilmById(@PathVariable("id") Integer id) {
        FilmEntity film = filmRepository.findOne(id);
        return ResponseEntity.ok(gson.toJson(film));
    }

    @RequestMapping("/personnage")
    public ResponseEntity getPersonnageById(@RequestParam(value = "a_id", required = false) Integer acteurId, @RequestParam(value = "f_id", required = false) Integer filmId) {
        PersonnageEntity personnage;
        if(acteurId != null & filmId != null) {
            personnage = personnageRepository.findFirstByNoActAndNoFilm(acteurId, filmId);
        }
        else if(acteurId != null) {
            personnage = personnageRepository.findAllByNoAct(acteurId);
        }
        else if(filmId != null) {
            personnage = personnageRepository.findAllByNoFilm(filmId);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(gson.toJson(personnage));
    }
    
    @RequestMapping("/realisateur/{id}")
    public ResponseEntity getRealisateurById(@PathVariable("id") Integer id) {
        RealisateurEntity realisateur = realisateurRepository.findOne(id);
        return ResponseEntity.ok(gson.toJson(realisateur));
    }

    // SETTERS

    @RequestMapping("/acteur/update")
    public ResponseEntity saveorUpdate(@RequestBody ActeurEntity acteurEntity) {
        ActeurEntity acteur = acteurRepository.saveAndFlush(acteurEntity);
        return ResponseEntity.created(URI.create("/acteur/" + acteur.getNoAct())).body(gson.toJson(acteur));
    }

    @RequestMapping("/categorie/update")
    public ResponseEntity saveorUpdate(@RequestBody CategorieEntity categorieEntity) {
        categorieEntity = categorieRepository.saveAndFlush(categorieEntity);
        return ResponseEntity.created(URI.create("/categorie/" + categorieEntity.getCodeCat())).body(gson.toJson(categorieEntity));
    }
    
    @RequestMapping("/film/update")
    public ResponseEntity saveorUpdate(@RequestBody FilmEntity filmEntity) {
        filmEntity = filmRepository.saveAndFlush(filmEntity);
        return ResponseEntity.created(URI.create("/film/" + filmEntity.getNoFilm())).body(gson.toJson(filmEntity));
    }

    @RequestMapping("/personnage/update")
    public ResponseEntity saveorUpdate(@RequestBody PersonnageEntity personnageEntity) {
        personnageEntity = personnageRepository.saveAndFlush(personnageEntity);
        return ResponseEntity.created(URI.create("/personnage/" + personnageEntity.getNoAct())).body(gson.toJson(personnageEntity));
    }

    @RequestMapping("/realisateur/update")
    public ResponseEntity saveorUpdate(@RequestBody RealisateurEntity realisateurEntity) {
        realisateurEntity = realisateurRepository.saveAndFlush(realisateurEntity);
        return ResponseEntity.created(URI.create("/realisateur/" + realisateurEntity.getNoRea())).body(gson.toJson(realisateurEntity));
    }
}

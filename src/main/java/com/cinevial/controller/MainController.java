package com.cinevial.controller;

import com.cinevial.entity.*;
import com.cinevial.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final ActeurRepository acteurRepository;
    private final CategorieRepository categorieRepository;
    private final FilmRepository filmRepository;
    private final PersonnageRepository personnageRepository;
    private final RealisateurRepository realisateurRepository;


    public MainController(ActeurRepository acteurRepository,
                          CategorieRepository categorieRepository,
                          FilmRepository filmRepository,
                          PersonnageRepository personnageRepository,
                          RealisateurRepository realisateurRepository) {
        this.acteurRepository = acteurRepository;
        this.categorieRepository = categorieRepository;
        this.filmRepository = filmRepository;
        this.personnageRepository = personnageRepository;
        this.realisateurRepository = realisateurRepository;
    }

    @RequestMapping("/")
    public ResponseEntity index() {
        return ResponseEntity.ok().body("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>Cinéma EPUL - API</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h3>Service RESTFUL pour le projet \"Cinéma\", version web hébergée à l'adresse <a href=\"http://api.cinema-epul.tk\">api.cinema-epul.tk</a>.</h3>\n" +
                "        <h4>Services accessibles :</h4>\n" +
                "        <ul>\n" +
                "            <li>liste des entités :</li>\n" +
                "            <br />\n" +
                "            <ul>\n" +
                "                <li>/acteurs</li>\n" +
                "                <li>/categories</li>\n" +
                "                <li>/films</li>\n" +
                "                <li>/personnages</li>\n" +
                "                <li>/realisateurs</li>\n" +
                "            </ul>\n" +
                "        </ul>\n" +
                "        <ul>\n" +
                "            <li>accès à une entité :</li>\n" +
                "            <br />\n" +
                "            <ul>\n" +
                "                <li>/acteur?a_id=X</li>\n" +
                "                <li>/categorie?c_id=X </li>\n" +
                "                <li>/film?f_id=X </li>\n" +
                "                <li>/personnage?a_id=X&f_id=X </li>\n" +
                "                <li>/realisateur?r_id=X</li>\n" +
                "            </ul>\n" +
                "        </ul>\n" +
                "    </body>\n" +
                "</html>");
    }

    // GETTERS for all

    @RequestMapping("/acteurs")
    public ResponseEntity getActeurs() {
        List<ActeurEntity> acteurs = new ArrayList<>(acteurRepository.findAll());
        return ResponseEntity.ok(acteurs);
    }

    @RequestMapping("/categories")
    public ResponseEntity getCategories() {
        List<CategorieEntity> categories = new ArrayList<>(categorieRepository.findAll());
        return ResponseEntity.ok(categories);
    }

    @RequestMapping("/films")
    public ResponseEntity getFilms() {
        List<FilmEntity> films = new ArrayList<>(filmRepository.findAll());
        return ResponseEntity.ok(films);
    }



    @RequestMapping("/personnages")
    public ResponseEntity getPersonnages() {
        List<PersonnageEntity> personnages = new ArrayList<>(personnageRepository.findAll());
        return ResponseEntity.ok(personnages);
    }

    @RequestMapping("/realisateurs")
    public ResponseEntity getRealisateurs() {
        List<RealisateurEntity> realisateurs = new ArrayList<>(realisateurRepository.findAll());
        return ResponseEntity.ok(realisateurs);
    }

    // GETTERS for one

    @RequestMapping("/acteur")
    public ResponseEntity getActeurById(@RequestParam("a_id") Integer a_id) {
        ActeurEntity acteur = acteurRepository.findOne(a_id);
        return ResponseEntity.ok(acteur);
    }

    @RequestMapping("/categorie")
    public ResponseEntity getCategorieById(@RequestParam("c_id") Integer c_id) {
        CategorieEntity categorie = categorieRepository.findOne(c_id);
        return ResponseEntity.ok(categorie);
    }

    @RequestMapping("/film")
    public ResponseEntity getFilmById(@RequestParam(value = "f_id", required = false) Integer f_id,
                                      @RequestParam(value = "c_id", required = false) Integer c_id,
                                      @RequestParam(value = "r_id", required = false) Integer r_id) {
        if(f_id != null) {
            FilmEntity film = filmRepository.findOne(f_id);
            return ResponseEntity.ok(film);
        }
        else if(c_id != null) {
            List<FilmEntity> films = filmRepository.findAllByCodeCat(c_id);
            return ResponseEntity.ok(films);
        }
        else if(r_id != null) {
            List<FilmEntity> films = filmRepository.findAllByNoRea(r_id);
            return ResponseEntity.ok(films);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

    @RequestMapping("/personnage")
    public ResponseEntity getPersonnageById(@RequestParam(value = "a_id", required = false) Integer acteurId, @RequestParam(value = "f_id", required = false) Integer filmId) {
        if(acteurId != null & filmId != null) {
            PersonnageEntity personnage = personnageRepository.findFirstByNoActAndNoFilm(acteurId, filmId);
            return ResponseEntity.ok(personnage);
        }
        else if(acteurId != null) {
            List<PersonnageEntity> personnages = personnageRepository.findAllByNoAct(acteurId);
            return ResponseEntity.ok(personnages);
        }
        else if(filmId != null) {
            List<PersonnageEntity> personnages = personnageRepository.findAllByNoFilm(filmId);
            return ResponseEntity.ok(personnages);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @RequestMapping("/realisateur")
    public ResponseEntity getRealisateurById(@RequestParam("r_id") Integer r_id) {
        RealisateurEntity realisateur = realisateurRepository.findOne(r_id);
        return ResponseEntity.ok(realisateur);
    }

    // SETTERS

    @RequestMapping("/acteur/update")
    public ResponseEntity saveOrUpdateActeur(@RequestBody ActeurEntity acteurEntity) {
        ActeurEntity acteur = acteurRepository.saveAndFlush(acteurEntity);
        return ResponseEntity.created(URI.create("/acteur/" + acteur.getNoAct())).body(acteur);
    }

    @RequestMapping("/categorie/update")
    public ResponseEntity saveOrUpdateCategorie(@RequestBody CategorieEntity categorieEntity) {
        categorieEntity = categorieRepository.saveAndFlush(categorieEntity);
        return ResponseEntity.created(URI.create("/categorie/" + categorieEntity.getCodeCat())).body(categorieEntity);
    }
    
    @RequestMapping("/film/update")
    public ResponseEntity saveOrUpdateFilm(@RequestBody FilmEntity filmEntity) {
        filmEntity = filmRepository.saveAndFlush(filmEntity);
        return ResponseEntity.created(URI.create("/film/" + filmEntity.getNoFilm())).body(filmEntity);
    }

    @RequestMapping("/personnage/update")
    public ResponseEntity saveOrUpdatePersonnage(@RequestBody PersonnageEntity personnageEntity) {
        personnageEntity = personnageRepository.saveAndFlush(personnageEntity);
        return ResponseEntity.created(URI.create("/personnage/" + personnageEntity.getNoAct())).body(personnageEntity);
    }

    @RequestMapping("/realisateur/update")
    public ResponseEntity saveOrUpdateRealisateur(@RequestBody RealisateurEntity realisateurEntity) {
        realisateurEntity = realisateurRepository.saveAndFlush(realisateurEntity);
        return ResponseEntity.created(URI.create("/realisateur/" + realisateurEntity.getNoRea())).body(realisateurEntity);
    }
    
    // DELETE

    @Transactional
    @RequestMapping("/acteur/delete")
    public ResponseEntity deleteActeur(@RequestParam("id") Integer id) {
        acteurRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @RequestMapping("/categorie/delete")
    public ResponseEntity deleteCategorie(@RequestParam("id") Integer id) {
        categorieRepository.deleteAllByCodeCat(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @RequestMapping("/film/delete")
    public ResponseEntity deleteFilm(@RequestParam("id") Integer id) {
        filmRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @RequestMapping("/personnage/delete")
    public ResponseEntity deletePersonnage(@RequestParam(value = "a_id", required = false) Integer acteurId, @RequestParam(value = "f_id", required = false) Integer filmId) {
        if(acteurId != null & filmId != null) {
            personnageRepository.deleteAllByNoActAndNoFilm(acteurId, filmId);
        }
        else if(acteurId != null) {
            personnageRepository.deleteAllByNoAct(acteurId);
        }
        else if(filmId != null) {
            personnageRepository.deleteAllByNoFilm(filmId);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @Transactional
    @RequestMapping("/realisateur/delete")
    public ResponseEntity deleteRealisateur(@RequestParam("id") Integer id) {
        realisateurRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    // SEARCH

    @RequestMapping("/film/search")
    public ResponseEntity findFilmsByTitre(@RequestParam("q") String search) {
        List<FilmEntity> films = filmRepository.findAllByTitre(search);
        return ResponseEntity.ok(films);
    }
}

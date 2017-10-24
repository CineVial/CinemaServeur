package com.cinevial;

import com.google.gson.Gson;
import com.metier.*;
import com.services.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainControleur {

    public static Gson gson = new Gson();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity sayHello(@RequestParam(value = "firstName", required = false, defaultValue = "World!") String firstName) {
        return ResponseEntity.ok("Hello "+ firstName);
    }

    @RequestMapping(value = "/acteurs", method = RequestMethod.GET)
    public ResponseEntity getActeurs() {
        Service service = new Service();
        List<ActeurEntity> acteurs = service.getAll(ActeurEntity.class);
        return ResponseEntity.ok(gson.toJson(acteurs));
    }
    @RequestMapping(value = "/acteur/{id}", method = RequestMethod.GET)
    public ResponseEntity getActeurByID(@PathVariable("id") String id) {
        Service service = new Service();
        ActeurEntity acteur = service.getByID(ActeurEntity.class,id);
        return ResponseEntity.ok(gson.toJson(acteur));
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ResponseEntity getFilms() {
        Service service = new Service();
        List<FilmEntity> films = service.getAll(FilmEntity.class);
        return ResponseEntity.ok(gson.toJson(films));
    }
    @RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
    public ResponseEntity getFilmByID(@PathVariable("id") String id) {
        Service service = new Service();
        FilmEntity film = service.getByID(FilmEntity.class,id);
        return ResponseEntity.ok(gson.toJson(film));
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity getCategories() {
        Service service = new Service();
        List<CategorieEntity> categories = service.getAll(CategorieEntity.class);
        return ResponseEntity.ok(gson.toJson(categories));
    }
    @RequestMapping(value = "/categorie/{id}", method = RequestMethod.GET)
    public ResponseEntity getCategorieByID(@PathVariable("id") String id) {
        Service service = new Service();
        CategorieEntity categorie = service.getByID(CategorieEntity.class,id);
        return ResponseEntity.ok(gson.toJson(categorie));
    }

    @RequestMapping(value = "/personnages", method = RequestMethod.GET)
    public ResponseEntity getPersonnages() {
        Service service = new Service();
        List<PersonnageEntity> personnages = service.getAll(PersonnageEntity.class);
        return ResponseEntity.ok(gson.toJson(personnages));
    }
    @RequestMapping(value = "/personnage/{idFilm}/{idAct}", method = RequestMethod.GET)
    public ResponseEntity getPersonnageById(@PathVariable("idFilm") String idFilm, @PathVariable("idAct") String idAct) {
        Service service = new Service();
        PersonnageEntity personnage = service.getByID(PersonnageEntity.class,idFilm,idAct);
        return ResponseEntity.ok(gson.toJson(personnage));
    }

    @RequestMapping(value = "/realisateurs", method = RequestMethod.GET)
    public ResponseEntity getRealisateurs() {
        Service service = new Service();
        List<RealisateurEntity> realisateurs = service.getAll(RealisateurEntity.class);
        return ResponseEntity.ok(gson.toJson(realisateurs));
    }
    @RequestMapping(value = "/realisateur/{id}", method = RequestMethod.GET)
    public ResponseEntity getRealisateursByID(@PathVariable("id") String id) {
        Service service = new Service();
        RealisateurEntity realisateur = service.getByID(RealisateurEntity.class,id);
        return ResponseEntity.ok(gson.toJson(realisateur));
    }

}

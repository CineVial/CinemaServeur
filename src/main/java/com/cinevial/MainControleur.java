package com.cinevial;

import com.metier.ActeurEntity;
import com.services.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainControleur {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity sayHello(@RequestParam(value = "firstName", required = false, defaultValue = "World!") String firstName) {
        return ResponseEntity.ok("Hello "+ firstName);
    }

    @RequestMapping(value = "/acteurs", method = RequestMethod.GET)
    public ResponseEntity getActeurs() {
        Service service = new Service();
        List<ActeurEntity> acteurs = service.getAll(ActeurEntity.class);
        return ResponseEntity.ok(acteurs);
    }

}

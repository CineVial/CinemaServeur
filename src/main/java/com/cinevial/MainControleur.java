package com.cinevial;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControleur {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity sayHello(@RequestParam(value = "firstName", required = false, defaultValue = "World!") String firstName) {
        return ResponseEntity.ok("Hello "+ firstName);
    }

}

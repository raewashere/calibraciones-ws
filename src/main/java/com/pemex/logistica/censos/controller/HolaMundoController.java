package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prueba")
public class HolaMundoController {

    @GetMapping("/hello")
        public String helloWorld() {
            return "Hello World from Spring Boot!";
        }
    
        @GetMapping("/")
        public String index() {
            return "index.html";
        }
    
        @GetMapping("/hola")
            public String holaMundo() {
            return "Hola Mundo desde Spring Boot!";
        }
}

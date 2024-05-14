package com.example.Bookauthorgenre.controllers;

import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    //api
    @GetMapping("/autore")
    public ResponseEntity<List<Autore>> getAutori(){
        List<Autore> autori = autoreService.getAutori();
        return new ResponseEntity<>(autori, HttpStatus.OK);
    }
    @PostMapping("/autore")
    public ResponseEntity <Autore> createAutore(@RequestBody Autore request ){
        Autore autore = autoreService.createAutore(request);
        return new ResponseEntity<>(autore, HttpStatus.OK);
    }


}

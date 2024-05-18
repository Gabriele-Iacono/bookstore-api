package com.example.Bookauthorgenre.controllers;

import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    //api
    @GetMapping("/autore") // funz
    public ResponseEntity<List<Autore>> getAutori(){
        List<Autore> autori = autoreService.getAutori();
        return new ResponseEntity<>(autori, HttpStatus.OK);
    }
    @PostMapping("/autore")// funz
    public ResponseEntity <Autore> createAutore(@RequestBody Autore request ){
        Autore autore = autoreService.createAutore(request);
        return new ResponseEntity<>(autore, HttpStatus.OK);
    }
    @DeleteMapping("/autore/{id}") // funz
    public ResponseEntity <Void> deleteAutore(@PathVariable("id") Long id ){
        autoreService.deleteAutore(id);
        return ResponseEntity.noContent().build();
    }


}

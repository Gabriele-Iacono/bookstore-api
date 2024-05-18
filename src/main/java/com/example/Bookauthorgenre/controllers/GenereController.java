package com.example.Bookauthorgenre.controllers;

import com.example.Bookauthorgenre.entities.Genere;
import com.example.Bookauthorgenre.services.GenereService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/genere")
public class GenereController {
    @Autowired
    private GenereService genereService;

    @GetMapping() // FUNZIONA
    public ResponseEntity<List<Genere>> getGenere() {
        List<Genere> generi = genereService.getGenere();
        return new ResponseEntity<>(generi, HttpStatus.OK);

    }

}

package com.example.Bookauthorgenre.controllers;

import com.example.Bookauthorgenre.dtos.LibroAutoreDto;
import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.entities.Genere;
import com.example.Bookauthorgenre.entities.Libro;
import com.example.Bookauthorgenre.repository.AutoreRepository;
import com.example.Bookauthorgenre.repository.LibroPaginationRepository;
import com.example.Bookauthorgenre.repository.LibroRepository;
import com.example.Bookauthorgenre.services.LibroService;
import lombok.Data;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;
    private AutoreRepository autoreRepository;
    private LibroRepository libroRepository;
    private LibroPaginationRepository libroPaginationRepository;


    @GetMapping("/artname")  //  FUNZIONA
    public ResponseEntity<List<Libro>> findLibriByArtname(@RequestBody Autore request) {
        List<Libro> libri = libroService.findLibriByAuthor(request);
        return new ResponseEntity<>(libri, HttpStatus.OK);
    }

    @PostMapping() // NON FUNZIONA FIX
        public ResponseEntity<Libro> create (@RequestBody LibroAutoreDto request){
        Libro libro = libroService.createLibro(request);
        return new ResponseEntity<>(libro, HttpStatus.OK);

    }
    @GetMapping("{artname}")
    public ResponseEntity<List<Libro>> getLibriByAutore(@PathVariable("artname") String artname) {
       List<Libro> libri = libroService.getLibri(artname);
       return new ResponseEntity<>(libri, HttpStatus.OK);
   }
    @GetMapping()
    public ResponseEntity<List<Libro>> getLibriPaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<Libro> libriPaginati = libroService.getLibriPaginati(page, size);
        return new ResponseEntity<>(libriPaginati, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable("id") Long id, @RequestBody Libro request) {
        Libro libro = libroService.updateLibro(id, request);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }



}




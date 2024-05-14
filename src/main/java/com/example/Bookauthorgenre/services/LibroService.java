package com.example.Bookauthorgenre.services;

import com.example.Bookauthorgenre.dtos.LibroAutoreDto;
import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.entities.Libro;
import com.example.Bookauthorgenre.repository.AutoreRepository;
import com.example.Bookauthorgenre.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    private AutoreRepository autoreRepository;

    public List<Libro> findLibriByAuthor(Autore request) {
        List<Libro> libri = libroRepository.findByAutoreArtname(request.getArtname());
        return libri;
    }

    public Libro createLibro(LibroAutoreDto request) {
        Autore autore = autoreRepository.findByArtname(request.getArtname());
        Libro libro = new Libro();
        libro.setAutore(autore);
        libro.setName(request.getName());
        libro.setPublicationDate(request.getPublicationDate());
        libroRepository.save(libro);
        return libro;
    }

    public List<Libro> getLibri(String artname) {
        return libroRepository.findByAutoreArtname(artname);
    }


}

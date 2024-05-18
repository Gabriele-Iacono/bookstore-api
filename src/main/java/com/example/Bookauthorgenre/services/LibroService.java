package com.example.Bookauthorgenre.services;

import com.example.Bookauthorgenre.dtos.LibroAutoreDto;
import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.entities.Genere;
import com.example.Bookauthorgenre.entities.Libro;
import com.example.Bookauthorgenre.repository.AutoreRepository;
import com.example.Bookauthorgenre.repository.GenereRepository;
import com.example.Bookauthorgenre.repository.LibroPaginationRepository;
import com.example.Bookauthorgenre.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private LibroPaginationRepository libroPaginationRepository;
    @Autowired
    private GenereRepository genereRepository;



    public List<Libro> findLibriByAuthor(Autore request) {
        List<Libro> libri = libroRepository.findByAutoreArtname(request.getArtname());
        return libri;
    }
// METODO CREATELIBRO
    public Libro createLibro(LibroAutoreDto request) {
        Autore autore = autoreRepository.findByartname(request.getArtname());
        if (autore == null) {
            throw new RuntimeException("Author not found with artname: " + request.getArtname());
        }

        Libro libro = new Libro();
        libro.setAutore(autore);
        libro.setName(request.getName());
        libro.setPublicationDate(request.getPublicationDate());
        libro.setTitolo(request.getTitolo());

        List<Genere> generi = genereRepository.findAllById(request.getGenereIds());
        if (generi.isEmpty()) {
            throw new RuntimeException("No genres found with provided IDs: " + request.getGenereIds());
        }

        libro.setGenere(generi);
        libroRepository.save(libro);
        return libro;
    }

    // METODO GETLIBRI
    public List<Libro> getLibri(String artname) {
        return libroRepository.findByAutoreArtname(artname);
    }


    public List<Libro> getLibriPaginati(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        List<Libro> libriPaginati = libroPaginationRepository.findAll(pageable).getContent();
        return libriPaginati;
    }



    public Libro updateLibro(Long id, Libro request) {
        Libro libroEsistente = libroRepository.findById(id).orElse(null);
        if (libroEsistente != null) {
            libroEsistente.setTitolo(libroEsistente.getTitolo());
            libroEsistente.setGenere(libroEsistente.getGenere());
            libroEsistente.setAutore(libroEsistente.getAutore());
        }
        return libroEsistente;
    }

}

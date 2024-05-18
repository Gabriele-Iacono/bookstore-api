package com.example.Bookauthorgenre.services;

import com.example.Bookauthorgenre.entities.Autore;
import com.example.Bookauthorgenre.repository.AutoreRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AutoreService {


    @Autowired
    private AutoreRepository autoreRepository;

    public List<Autore> getAutori() {
        List<Autore> autori = autoreRepository.findAll();
        return autori;
    }

    public Autore createAutore(@RequestBody Autore request) {
        Autore foundAuthor = autoreRepository.findByartname(request.getArtname());
        if (foundAuthor != null) {
            return foundAuthor;
        }

        Autore autore = new Autore();
        autore.setName(request.getName());
        autore.setSurname(request.getSurname());
        autore.setBirthdate(request.getBirthdate());
        autore.setArtname(request.getArtname());
        autoreRepository.save(autore);
        return autore;
    }

    public void deleteAutore(Long id) {
        autoreRepository.deleteById(id);

    }



}

package com.example.Bookauthorgenre.services;
import com.example.Bookauthorgenre.entities.Genere;
import com.example.Bookauthorgenre.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GenereService {
    @Autowired
    private GenereRepository genereRepository;

    public List <Genere> getGenere(){
        List<Genere> generi = genereRepository.findAll();
        return generi;
    }


}

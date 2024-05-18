package com.example.Bookauthorgenre.repository;



import com.example.Bookauthorgenre.entities.Genere;
import com.example.Bookauthorgenre.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository  <Libro, Long>{
    List<Libro> findByAutoreArtname(String artname);
    List<Libro> findByGenere(Genere genere);


}



package com.example.Bookauthorgenre.repository;

import com.example.Bookauthorgenre.entities.Autore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository  extends JpaRepository <Autore, Long> {
    Autore findByartname(String artname);


}

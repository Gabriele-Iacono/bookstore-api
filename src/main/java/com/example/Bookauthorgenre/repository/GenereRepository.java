package com.example.Bookauthorgenre.repository;

import com.example.Bookauthorgenre.entities.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepository  extends JpaRepository <Genere, Long> {
}

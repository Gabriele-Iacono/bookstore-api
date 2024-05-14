package com.example.Bookauthorgenre.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Genere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String genere;
    @ManyToMany
    private List<Libro> libri;
}

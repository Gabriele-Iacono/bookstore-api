package com.example.Bookauthorgenre.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date publicationDate;
    private String titolo;

    @ManyToOne
    @JoinColumn(name="autore_id", nullable=false)
    @JsonBackReference
    private Autore autore;
    @ManyToMany
    private List<Genere> genere;
}

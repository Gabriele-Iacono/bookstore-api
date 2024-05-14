package com.example.Bookauthorgenre.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date publicationDate;
    @ManyToOne
    @JoinColumn(name="autore_id", nullable=false)
    private Autore autore;
}

package com.example.Bookauthorgenre.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class LibroAutoreDto {
    private String name;
    private Date publicationDate;
    private String artname;
    private String titolo;
    private List<Long> genereIds;
}

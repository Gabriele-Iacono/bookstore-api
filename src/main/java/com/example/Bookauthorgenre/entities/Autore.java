    package com.example.Bookauthorgenre.entities;

    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.Setter;

    import java.util.Date;
    import java.util.List;

    @Entity
    @Table
    @Data
    @Setter
    public class Autore {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private String surname;
        private String artname;
        private Date birthdate;

        @OneToMany(mappedBy = "autore", cascade = CascadeType.REMOVE)
        @JsonManagedReference
        private List<Libro> libri;
    }

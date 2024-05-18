package com.example.Bookauthorgenre.repository;

import com.example.Bookauthorgenre.entities.Libro;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibroPaginationRepository extends PagingAndSortingRepository <Libro, Long> {

}

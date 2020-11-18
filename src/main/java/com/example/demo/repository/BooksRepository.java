package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Books;

public interface BooksRepository extends CrudRepository<Books, String> {

}

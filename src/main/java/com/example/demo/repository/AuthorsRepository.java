package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Authors;

public interface AuthorsRepository extends CrudRepository<Authors, Integer> {

}

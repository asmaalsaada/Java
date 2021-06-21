package com.codingdojo.lan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lan.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    // this method retrieves all the books from the database
    List<Language> findAll();
//    List<Language> findByNameContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByCreatorContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByNameStartingWith(String search);
}

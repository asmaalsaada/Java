package com.codingdojo.driver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.driver.models.*;
@Repository 
public interface PersonRepository extends CrudRepository<Person, Long>{ //public interface
	
List<Person> findAll();
List<Person> findByLicenseIdIsNull(); 
 }

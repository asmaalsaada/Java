package com.codingdojo.driver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.driver.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>  {
List<License> findAll();
List<License> findTopByOrderByNumberDesc();
}

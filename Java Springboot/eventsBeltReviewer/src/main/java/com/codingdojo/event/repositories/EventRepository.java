package com.codingdojo.event.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.event.models.Event;

public interface EventRepository extends CrudRepository<Event,Long>{
List<Event> findAll();
ArrayList<Event> findByState(String state);
ArrayList<Event> findByStateIsNot(String state);
}

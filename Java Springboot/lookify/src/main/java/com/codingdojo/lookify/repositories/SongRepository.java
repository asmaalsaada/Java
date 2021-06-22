package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    // this method retrieves all the songs from the database
    List<Song> findAll();
    //find song by atrist name
    List<Song> findByArtistContaining(String search);
    // find song title
    
    //find Top10
    List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByTitleContaining(String search);
  
//    List<Song> findByTop10 
    // 
    
    }

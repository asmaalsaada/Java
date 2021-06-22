package com.codingdojo.lookify.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service

public class SongService {
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	// returns all the songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// creates a song
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	// updates a song
		public Song updateSong(Song s) {
			return songRepository.save(s);
		}
	
	//retrive a song by artist name 
	public List<Song> findSongByArtist(String search) {
		return songRepository.findByArtistContaining(search);
	}
	// retrieves a song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	//delete song by id 

	public void deleteById(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			Song s = optionalSong.get();
			songRepository.delete(s);
		}
	}
	
	public List<Song> findTitle(String search) {
		return songRepository.findByTitleContaining(search);
	}
	public List<Song> topTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}

}

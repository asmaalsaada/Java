package com.codingdojo.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.service.SongService;

@Controller

public class SongController {
	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/dashboard")
	public String all(Model model) {
		List<Song> s = songService.allSongs();
		System.out.println(s);
		model.addAttribute("song", s);
		return "all.jsp";
	}

	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("Song") Song song) {
		return "new.jsp";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("Song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
//show a song
@RequestMapping("/songs/{id}")
public String show(@PathVariable("id") Long id, Model model) {
	Song s = songService.findSong(id);
	model.addAttribute("song", s);
	return "show.jsp";
}
//delete song
@RequestMapping(value="/songs/{id}/delete", method=RequestMethod.DELETE)
public String destroy(@PathVariable("id") Long id) {
	songService.deleteById(id);
    return "redirect:/dashboard";
}
//search for a song
@RequestMapping("/search/{search}")
public String artist(@PathVariable("search") String search,Model model) {
	List<Song> res1 = songService.findTitle(search);
	List<Song> res2 = songService.findSongByArtist(search);
	model.addAttribute("res1", res1);
	model.addAttribute("res2", res2);
	return "artist.jsp";
}
@RequestMapping(value="/search", method=RequestMethod.POST)
public String search(@RequestParam("search") String search) {
	return "redirect:/search/"+search;
}
// top 10 
@RequestMapping("/search/topTen")
public String topTen(Model model){
	List<Song> res3 = songService.topTen();
	model.addAttribute("res3", res3);
	return "top.jsp";
	
}

}
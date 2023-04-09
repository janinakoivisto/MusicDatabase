package com.example.MusicDatabase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin
@Controller
public class GenreController {

	@Autowired
	private GenreRepository grepository;
	
	
	//listaa genret
	
	@GetMapping("/genrelist")
	public String getGenres(Model model) {
		model.addAttribute("genres", grepository.findAll());
		return "genrelist";
	}
	
	//lisää genren
	
	@RequestMapping("/genrelist/add")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	//tallentaa genren listaan
	
	@PostMapping("/genrelist/save")
	public String save(Genre genre) {
		grepository.save(genre);
		return "redirect:/genrelist";
	}
	
	@GetMapping("/genres")
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) grepository.findAll();
	}

	@GetMapping("/genres/{id}")
	public @ResponseBody Optional<Genre> findGenreById(@PathVariable("id") Long genreId) {
		return grepository.findById(genreId);
	}
	

	
}
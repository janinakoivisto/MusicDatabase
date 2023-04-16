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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.transaction.Transactional;



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

	@GetMapping("/genres/{genreId}")
	public @ResponseBody Optional<Genre> findGenreById(@PathVariable("genreId") Long genreId) {
		return grepository.findById(genreId);
	}
	
	@Transactional
	@RequestMapping(value = "/genrelist/delete/{genreId}", method = RequestMethod.GET)
	public String deleteGenre(@PathVariable("genreId") Long genreId, Model model) {
		grepository.deleteByGenreId(genreId);
		return "redirect:/genrelist";
	}
	
	@RequestMapping(value = "/genrelist/edit/{genreId}")
	public String editGenre(@PathVariable("genreId") Long genreId, Model model) {
		Optional<Genre> genre = grepository.findById(genreId);
		model.addAttribute("editgenre", genre.get());
		return "editgenre";
	}
	
	
	
}
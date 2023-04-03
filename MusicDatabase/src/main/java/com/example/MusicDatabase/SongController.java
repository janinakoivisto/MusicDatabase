package com.example.MusicDatabase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongController {

	@Autowired
	private SongRepository sRepository;
	
	@Autowired GenreRepository gRepository;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", "Welcome to the Music Database");
		return "index";
	}
	
	@RequestMapping(value= {"/", "/songlist"})
	public String songList(Model model) {
		model.addAttribute("songs", sRepository.findAll());
		return "songlist";
	}
	
	@GetMapping(value = "/addsong")
	public String addSong(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("genres", gRepository.findAll());
		return "addSong";
	}
	
	@PostMapping(value = "/save")
	public String save(Song song) {
		sRepository.save(song);
		return "redirect:songlist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteSong(@PathVariable("id") Long id, Model model) {
		sRepository.deleteById(id);
		return "redirect:../songlist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("songedit", sRepository.findById(id));
		return "edit";
	}
	
// REST find all
	
	@RequestMapping(value="/songs", method = RequestMethod.GET)
	public @ResponseBody List<Song> songListRest() {
		return (List<Song>) sRepository.findAll();
	}
	
// REST find song by id
	
	@RequestMapping(value="/song/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long id) {
		return sRepository.findById(id);
	}
	
	@RequestMapping (value="/login")
	public String login() {
		return "login";
	}
}

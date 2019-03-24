package pl.marcinmazur.animalshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.marcinmazur.animalshelter.service.AnimalService;

@RestController
public class CommentRestController {

	private AnimalService animalService;

	@Autowired
	public CommentRestController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@PostMapping("/addComment")
	public void addComment(@RequestParam String text, @RequestParam String author, @RequestParam String animalId) {

		animalService.addComment(author, text, animalId);
	}

}

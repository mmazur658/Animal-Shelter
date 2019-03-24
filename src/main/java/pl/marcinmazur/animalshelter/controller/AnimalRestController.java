package pl.marcinmazur.animalshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.marcinmazur.animalshelter.service.AnimalService;

@RestController
public class AnimalRestController {

	private AnimalService animalService;

	@Autowired
	public AnimalRestController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@PostMapping("/add-or-update")
	public void addOrEditAnimal(@RequestParam(required = false) String animalId, @RequestParam String animalName,
			@RequestParam String animalAge, @RequestParam String animalCategory, @RequestParam String animalDesc) {

		animalService.saveOrUpdateAnimal(animalId, animalName, animalAge, animalCategory, animalDesc);

	}

}

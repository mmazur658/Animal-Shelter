package pl.marcinmazur.animalshelter.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.marcinmazur.animalshelter.entity.Animal;
import pl.marcinmazur.animalshelter.entity.Comment;
import pl.marcinmazur.animalshelter.repository.AnimalRepository;

@Service
public class AnimalService {

	private final String SORTING_TYPE_ASC = "asc";
	private final String SORTING_TYPE_DESC = "desc";
	private final String DEFAULT_CATEGORY = "Wszystkie";
	private final String DEFAULT_NAME = "";
	private final String DEFAULT_SORTING_TYPE = "asc";

	private AnimalRepository animalRepository;

	@Autowired
	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public List<Animal> findByNameAndCategory(String name, String category, String sortingType) {

		if (category == null)
			category = DEFAULT_CATEGORY;

		if (name == null)
			name = DEFAULT_NAME;

		if (sortingType == null)
			sortingType = DEFAULT_SORTING_TYPE;

		List<Animal> animal = animalRepository.findByNameAndCategory(name, category);

		sortList(animal, sortingType);

		return animal;
	}

	private void sortList(List<Animal> animal, String sortingType) {

		if (sortingType.contentEquals(SORTING_TYPE_ASC))
			Collections.sort(animal);
		else if (sortingType.contentEquals(SORTING_TYPE_DESC)) {
			Collections.sort(animal);
			Collections.reverse(animal);
		}

	}

	public Animal getAnimalById(int animalId) {
		return animalRepository.findById(animalId);
	}

	public void saveOrUpdateAnimal(String animalId, String animalName, String animalAge, String animalCategory,
			String animalDesc) {

		Animal animal = new Animal(Integer.parseInt(animalAge), animalName, animalCategory, animalDesc, "url");

		if (animalId != null)
			animal.setId(Integer.parseInt(animalId));

		if (animal.getId() == 0)
			animalRepository.addAnimal(animal);
		else
			animalRepository.updateAnimal(animal);

	}

	public void addComment(String author, String text, String animalId) {

		Comment comment = new Comment(author, text);
		animalRepository.addComment(comment, Integer.parseInt(animalId));

	}

}

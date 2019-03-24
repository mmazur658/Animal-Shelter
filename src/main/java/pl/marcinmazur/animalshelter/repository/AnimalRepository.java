package pl.marcinmazur.animalshelter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.marcinmazur.animalshelter.entity.Animal;
import pl.marcinmazur.animalshelter.entity.Comment;

@Repository
public class AnimalRepository {

	private final String ALL_CATEGORIES = "Wszystkie";

	private List<Animal> animals = new ArrayList<>();
	private int nextId;
	private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a,"
			+ " scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra "
			+ "nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula "
			+ "ultricies purus, sed posuere libero dui id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate "
			+ "arcu, vel tempus metus leo non est. Etiam sit amet lectus quis est congue mollis. Phasellus congue lacus eget"
			+ " neque. Phasellus ornare, ante vitae consectetuer consequat, purus sapien ultricies dolor, et mollis pede metus "
			+ "eget nisi. Praesent sodales velit quis augue. Cras suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in "
			+ "interdum massa nibh nec erat.";

	public AnimalRepository() {

		Animal animal = new Animal(5, "Brzydki Pies", "Pies", loremIpsum, "temp-url");
		animal.setId(1);
		animals.add(animal);

		animal = new Animal(1, "Ładny Kot", "Kot", loremIpsum, "temp-url");
		animal.setId(2);
		animals.add(animal);

		animal = new Animal(8, "Parszywy Kaban", "Kaban", loremIpsum, "temp-url");
		animal.setId(3);
		animals.add(animal);

		animal = new Animal(7, "Azor", "Pies", loremIpsum, "temp-url");
		animal.setId(4);
		animals.add(animal);

		nextId = 5;
	}

	public void addAnimal(Animal animal) {
		animal.setId(nextId);
		animals.add(animal);
		nextId++;

	}

	public void deleteAnimal(int id) {

		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getId() == id) {
				animals.remove(i);
				break;
			}
		}
	}

	public List<Animal> findByNameAndCategory(String name, String category) {

		List<Animal> filteredAnimals = new ArrayList<>();
		name = name.toLowerCase();
		category = category.toLowerCase();

		// Filtrowanie po nazwie i kategorii
		if (!category.equals(ALL_CATEGORIES.toLowerCase()) && !name.equals("")) {
			for (Animal animal : animals) {
				if (animal.getName().toLowerCase().contains(name)
						&& animal.getCategory().toLowerCase().contains(category)) {
					filteredAnimals.add(animal);
				}
			}
			// filtrowanie po nazwie
		} else if (category.equals(ALL_CATEGORIES.toLowerCase()) && !name.equals("")) {
			for (Animal animal : animals) {
				if (animal.getName().toLowerCase().contains(name)) {
					filteredAnimals.add(animal);
				}
			}
			// filtrowanie po kategorii
		} else if (!category.equals(ALL_CATEGORIES.toLowerCase()) && name.equals("")) {
			for (Animal animal : animals) {
				if (animal.getCategory().toLowerCase().contains(category)) {
					filteredAnimals.add(animal);
				}
			}
			// Wszystko pozostałe
		} else {
			filteredAnimals = animals;
		}

		return filteredAnimals;
	}

	public Animal findById(int animalId) {

		for (Animal animal : animals) {
			if (animal.getId() == animalId) {
				return animal;
			}
		}

		return null;
	}

	public void updateAnimal(Animal animal) {

		for (int i = 0; i < animals.size(); i++) {

			if (animals.get(i).getId() == animal.getId()) {
				animals.set(i, animal);
				break;
			}

		}

	}

	public void addComment(Comment comment, int animalId) {

		for (int i = 0; i < animals.size(); i++) {

			if (animals.get(i).getId() == animalId)
				animals.get(i).addComment(comment);

		}

	}

}

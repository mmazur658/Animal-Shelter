package pl.marcinmazur.animalshelter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

	private List<String> categories = new ArrayList<>();

	public CategoryRepository() {
		categories.add("Wszystkie");
		categories.add("Kot");
		categories.add("Pies");
		categories.add("Kaban");
		categories.add("Inne");
	}

	public boolean addCategory(String categoryName) {

		categoryName = categoryName.trim();

		boolean categoryExists = false;

		for (String category : categories) {
			if (category.toLowerCase().equals(categoryName.toLowerCase()))
				categoryExists = true;
		}

		if (categoryExists)
			return false;
		else {
			categories.add(categoryName);
			return true;
		}

	}

	public List<String> findAll() {
		return categories;
	}

}

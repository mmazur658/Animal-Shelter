package pl.marcinmazur.animalshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.marcinmazur.animalshelter.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<String> findAll() {
		return categoryRepository.findAll();
	}

	public void addCategory(String category) {
		categoryRepository.addCategory(category);
	}

}

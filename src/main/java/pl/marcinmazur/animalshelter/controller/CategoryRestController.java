package pl.marcinmazur.animalshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.marcinmazur.animalshelter.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

	private CategoryService categoryService;

	@Autowired
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/get-all")
	public List<String> getCategories() {

		List<String> categories = categoryService.findAll();
		return categories;

	}

	@PostMapping("/add-category")
	public boolean addCategory(@RequestParam String category) {

		if (category == null || category == "")
			return false;

		categoryService.addCategory(category);
		return true;
	}

}

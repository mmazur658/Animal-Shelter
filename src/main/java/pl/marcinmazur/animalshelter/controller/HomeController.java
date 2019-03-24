package pl.marcinmazur.animalshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.marcinmazur.animalshelter.entity.Animal;
import pl.marcinmazur.animalshelter.service.AnimalService;
import pl.marcinmazur.animalshelter.service.CategoryService;

@Controller
public class HomeController {

	private CategoryService categoryService;
	private AnimalService animalService;

	@Autowired
	public HomeController(CategoryService categoryService, AnimalService animalService) {
		this.categoryService = categoryService;
		this.animalService = animalService;
	}

	@RequestMapping("/")
	public String showIndex(Model model) {

		List<Animal> animals = animalService.findByNameAndCategory(null, null, null);
		List<String> categories = categoryService.findAll();

		model.addAttribute("categories", categories);
		model.addAttribute("animals", animals);

		return "index";
	}

	@RequestMapping("/search")
	public String showSearchResult(@RequestParam(required = false) String categoryMain,
			@RequestParam(required = false) String name, @RequestParam(required = false) String sortingType,
			Model model) {

		List<Animal> animals = animalService.findByNameAndCategory(name, categoryMain, sortingType);
		List<String> categories = categoryService.findAll();

		model.addAttribute("nameModel", name);
		model.addAttribute("categoryModel", categoryMain);
		model.addAttribute("sortingTypeModel", sortingType);
		model.addAttribute("categories", categories);
		model.addAttribute("animals", animals);

		return "index";
	}

	@RequestMapping("/category")
	public String showCategory() {
		return "category";
	}

	@PostMapping("/animal-details")
	public String showAnimalDetails(@RequestParam String animalId, Model model) {

		Animal animal = animalService.getAnimalById(Integer.parseInt(animalId));
		model.addAttribute("animal", animal);

		return "parts/animal-details";
	}

	@RequestMapping("/list")
	public String loadList(Model model) {

		List<String> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		return "parts/category-list";
	}

	@GetMapping("/add-new-animal")
	public String showFormNewAdnimal(Model model) {

		Animal animal = new Animal();
		model.addAttribute("animal", animal);

		List<String> categories = categoryService.findAll();
		model.addAttribute("categoriesForm", categories);
		model.addAttribute("addNew", true);

		return "parts/animal-form";
	}

	@PostMapping("/edit-animal")
	public String showForm(@RequestParam String animalId, Model model) {

		Animal animal = animalService.getAnimalById(Integer.parseInt(animalId));
		model.addAttribute("animal", animal);

		List<String> categories = categoryService.findAll();
		model.addAttribute("categoriesForm", categories);

		return "parts/animal-form";
	}


}

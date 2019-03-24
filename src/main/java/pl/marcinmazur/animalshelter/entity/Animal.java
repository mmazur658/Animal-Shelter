package pl.marcinmazur.animalshelter.entity;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Comparable<Animal> {

	private int id;
	private int age;
	private String name;
	private String category;
	private String description;
	private String imgUrl;
	private List<Comment> comments;

	public Animal() {

	}

	public Animal(int age, String name, String category, String description, String imgUrl) {
		this.age = age;
		this.name = name;
		this.category = category;
		this.description = description;
		this.imgUrl = imgUrl;
		comments = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Animal o) {

		if (this.name.compareToIgnoreCase(o.name) > 0)
			return 1;
		else if (this.name.compareToIgnoreCase(o.name) == 0) {
			return 0;
		} else
			return -1;

	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}

}

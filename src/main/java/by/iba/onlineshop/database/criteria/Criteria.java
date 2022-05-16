package by.iba.onlineshop.database.criteria;

import by.iba.onlineshop.entities.enums.Category;
import by.iba.onlineshop.entities.enums.Subcategory;

public class Criteria {

	private Category category;

	private Subcategory subcategory;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

}

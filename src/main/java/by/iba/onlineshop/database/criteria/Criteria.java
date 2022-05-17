package by.iba.onlineshop.database.criteria;

import by.iba.onlineshop.entities.enums.Category;
import by.iba.onlineshop.entities.enums.Subcategory;
import lombok.Getter;
import lombok.Setter;

public class Criteria {

	@Getter
	@Setter
	private Category category;

	@Getter
	@Setter
	private Subcategory subcategory;

}

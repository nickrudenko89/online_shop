package by.iba.onlineshop.database.criteria;

import by.iba.onlineshop.entities.enums.Category;
import by.iba.onlineshop.entities.enums.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Criteria {

	@Getter
	@Setter
	private Category category;

	@Getter
	@Setter
	private Subcategory subcategory;

}

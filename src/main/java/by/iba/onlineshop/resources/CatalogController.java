package by.iba.onlineshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.entities.Product;
import by.iba.onlineshop.entities.enums.Category;
import by.iba.onlineshop.entities.enums.Subcategory;
import by.iba.onlineshop.services.CatalogService;

@RestController
@RequestMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> get() {
		return catalogService.getProducts();
	}

	@GetMapping(value = "/categorized/{category}/{subcategory}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getCategorized(@PathVariable("category") Category category,
			@PathVariable("subcategory") Subcategory subcategory) {
		Criteria criteria = new Criteria(category, subcategory);
		return catalogService.getCategirizedProducts(criteria);
	}

}

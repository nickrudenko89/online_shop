package by.iba.onlineshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.entities.Product;
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

	@GetMapping(value = "/categorized")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getCategorized(@RequestHeader("criteria") String criteriaHeader) {
		Criteria criteria = new Gson().fromJson(criteriaHeader, Criteria.class);
		return catalogService.getCategirizedProducts(criteria);
	}

}

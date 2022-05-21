package by.iba.onlineshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.onlineshop.entities.Product;
import by.iba.onlineshop.services.ProductService;

@RestController
@RequestMapping(value = "/catalog/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product get(@PathVariable int id) {
		return productService.getProduct(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('MODIFY')")
	public Product post(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('MODIFY')")
	public Product put(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('MODIFY')")
	public void delete(@RequestBody Product product) {
		productService.deleteProduct(product);
	}

}

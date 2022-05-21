package by.iba.onlineshop.database.dao;

import java.util.List;
import java.util.Optional;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.entities.Product;

public interface CatalogDao {

	List<Product> getProducts();

	List<Product> getCategorizedProducts(Criteria criteria);

	Optional<Product> getExistingProduct(Product product);

	Product getProduct(int id);

	Product createProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Product product);

}

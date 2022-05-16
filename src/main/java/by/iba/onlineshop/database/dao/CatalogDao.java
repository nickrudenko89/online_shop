package by.iba.onlineshop.database.dao;

import java.util.List;
import java.util.Optional;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.entities.Product;

public interface CatalogDao {

	public List<Product> getProducts();

	public List<Product> getCategorizedProducts(Criteria criteria);

	public Optional<Product> getExistingProduct(Product product);

	public Product getProduct(int id);

	public Product createProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(Product product);

}

package by.iba.onlineshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.CatalogDao;
import by.iba.onlineshop.entities.Product;

@Service
public class ProductService {

	@Autowired
	private CatalogDao catalogDao;

	public Product getProduct(int id) {
		return catalogDao.getProduct(id);
	}

	@Transactional
	public Product createProduct(Product product) {
		Optional<Product> existingProduct = catalogDao.getExistingProduct(product);
		if (existingProduct.isPresent()) {
			existingProduct.get().setAmount(product.getAmount() + existingProduct.get().getAmount());
			return existingProduct.get();
		} else {
			return catalogDao.createProduct(product);
		}
	}

	@Transactional
	public Product updateProduct(Product product) {
		return catalogDao.updateProduct(product);
	}

	@Transactional
	public void deleteProduct(Product product) {
		catalogDao.deleteProduct(product);
	}

}

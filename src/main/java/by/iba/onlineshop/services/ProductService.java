package by.iba.onlineshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.onlineshop.database.dao.CatalogDao;
import by.iba.onlineshop.entities.Cart;
import by.iba.onlineshop.entities.CartItem;
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
		Optional<Product> optionalExistingProduct = catalogDao.getExistingProduct(product);
		if (optionalExistingProduct.isPresent()) {
			Product existingProduct = optionalExistingProduct.get();
			existingProduct.setAmount(product.getAmount() + existingProduct.getAmount());
			return existingProduct;
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
		Product existingProduct = catalogDao.getExistingProduct(product).get();
		List<CartItem> cartItems = existingProduct.getCartItems();

		cartItems.forEach(cartItem -> {
			Cart cart = cartItem.getCart();
			cart.removeCartItem(cartItem);
			cart.setTotalProductsAmount(cart.getTotalProductsAmount() - cartItem.getProductAmount());
		});

		catalogDao.deleteProduct(existingProduct);
	}

}

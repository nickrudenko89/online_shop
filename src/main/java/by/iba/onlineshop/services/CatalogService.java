package by.iba.onlineshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.database.dao.CatalogDao;
import by.iba.onlineshop.entities.Product;

@Service
public class CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	public List<Product> getProducts() {
		return catalogDao.getProducts();
	}

	public List<Product> getCategirizedProducts(Criteria criteria) {
		return catalogDao.getCategorizedProducts(criteria);
	}
}

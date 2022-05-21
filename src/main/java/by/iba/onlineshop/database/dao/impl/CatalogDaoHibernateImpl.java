package by.iba.onlineshop.database.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.onlineshop.database.criteria.Criteria;
import by.iba.onlineshop.database.dao.CatalogDao;
import by.iba.onlineshop.entities.Product;

@Repository
public class CatalogDaoHibernateImpl implements CatalogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("From Product").list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getCategorizedProducts(Criteria criteria) {
		Session session = sessionFactory.openSession();
		Query<Product> query = session
				.createQuery("from Product p where p.category = :category and p.subcategory = :subcategory");
		query.setParameter("category", criteria.getCategory());
		query.setParameter("subcategory", criteria.getSubcategory());
		List<Product> products = query.getResultList();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Product> getExistingProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery(
				"select p from Product p where p.category = :category and p.subcategory = :subcategory and p.brand = :brand and p.model = :model");
		query.setParameter("category", product.getCategory());
		query.setParameter("subcategory", product.getSubcategory());
		query.setParameter("brand", product.getBrand());
		query.setParameter("model", product.getModel());
		return Optional.ofNullable(query.uniqueResult());
	}

	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, id);
		session.close();
		return product;
	}

	@Override
	public Product createProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		return product;
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}

}

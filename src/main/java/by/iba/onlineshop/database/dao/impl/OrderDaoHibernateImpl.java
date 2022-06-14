package by.iba.onlineshop.database.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.onlineshop.database.dao.OrderDao;
import by.iba.onlineshop.entities.Order;
import by.iba.onlineshop.entities.User;

@Repository
public class OrderDaoHibernateImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrders(User user) {
		Session session = sessionFactory.openSession();
		Query<Order> query = session.createQuery("from Order o where o.user = :user");
		query.setParameter("user", user);
		List<Order> orders = query.getResultList();
		session.close();
		return orders;
	}

	@Override
	public Order createOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		return order;
	}

}

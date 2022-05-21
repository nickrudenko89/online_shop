package by.iba.onlineshop.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.onlineshop.database.dao.UserDao;
import by.iba.onlineshop.entities.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery("select u from User u where u.username = :username");
		query.setParameter("username", username);
		User user = query.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

}

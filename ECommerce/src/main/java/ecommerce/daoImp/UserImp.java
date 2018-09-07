package ecommerce.daoImp;


import java.awt.print.Printable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.UserDao;
import ecommerce.model.User;
@Component
@Transactional
public class UserImp implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(user);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public User getUserById(long user_id) {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().get(User.class, user_id);
			
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	
	public User login(String user_email, String user_password,String role) {
		// TODO Auto-generated method stub
		try {
		Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where user_email=:user_email and user_password=:user_password and role=:role",User.class);
		query.setParameter("user_email", user_email);
		query.setParameter("user_password", user_password);
		query.setParameter("role", role);
		return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public boolean update(User user)
	{
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().update(user);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public User getUserByEmail(String user_email) {
		// TODO Auto-generated method stub
		try {
		Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where user_email=:email",User.class);
		query.setParameter("email", user_email);
		return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<User> getVendorDetails() {
		// TODO Auto-generated method stub
		try {
		Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor'",User.class);
		return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	

	
	

	

	
}

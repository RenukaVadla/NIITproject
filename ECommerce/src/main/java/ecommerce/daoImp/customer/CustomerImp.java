package ecommerce.daoImp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.model.customer.Customer;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
@Component
@Transactional
public class CustomerImp implements CustomerDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(customer);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Customer login(String customer_email, String customer_password) {
		// TODO Auto-generated method stub
		try {
			Query<Customer> query= sessionFactory.getCurrentSession().createQuery
					("from Customer where customer_email=:email and customer_password=:password",Customer.class);
			query.setParameter("email", customer_email);
			query.setParameter("password", customer_password);
			return query.getSingleResult();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String customer_email) {
		// TODO Auto-generated method stub
		try {
			
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from Customer where customer_email=:customer_email", Customer.class);
			query.setParameter("customer_email",customer_email);
			return query.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	

}

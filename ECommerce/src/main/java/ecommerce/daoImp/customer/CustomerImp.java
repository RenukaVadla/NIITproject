package ecommerce.daoImp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.daolayer.customer.CustomerDao;
import ecommerce.model.customer.Customer;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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
	

}

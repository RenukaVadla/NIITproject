package ecommerce.daoImp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.AddressDao;
import ecommerce.model.Address;
@Component
@Transactional
public class AddressImp implements AddressDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(address);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(address);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	

}

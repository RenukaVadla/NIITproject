package ecommerce.daolayer.productsDaoImpl;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.product.Mobile;
@Component
@Transactional
public class MobileImp implements MobileDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
		
		sessionFactory.getCurrentSession().save(mobile);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	

	public boolean deleteMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(mobile);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
		
	

}

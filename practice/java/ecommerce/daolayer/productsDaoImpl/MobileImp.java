package ecommerce.daolayer.productsDaoImpl;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productsDao.MobileDao;
import ecommerce.model.product.Mobile;
import ecommerce.model.vendor.Vendor;
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


	@Override
	public Mobile getMobileBySeries(String mobile_series) {
		// TODO Auto-generated method stub
		try {
			Query<Mobile> query=sessionFactory.getCurrentSession().createQuery("from Mobile where mobile_series=:mobile_series",Mobile.class);
			query.setParameter("mobile_series", mobile_series);
			return query.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public Mobile getMobileDetails(long product_id) {
		
			try {
				return sessionFactory.getCurrentSession().get(Mobile.class,product_id);
			} catch (Exception e) {
				return null;
			}
		
	}


	@Override
	public boolean editMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(mobile);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}


	

	
	
		
	

}

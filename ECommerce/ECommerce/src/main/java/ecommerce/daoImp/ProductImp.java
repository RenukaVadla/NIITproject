package ecommerce.daoImp;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.ProductDao;
import ecommerce.model.Product;

@Component
@Transactional
public class ProductImp implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(product);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}

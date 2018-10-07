package ecommerce.daolayer.productsDaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productsDao.LaptopDao;
import ecommerce.model.product.Laptop;
import ecommerce.model.product.Mobile;
@Component
@Transactional
public class LaptopImp implements LaptopDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(laptop);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean deleteLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(laptop);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Laptop getlaptopDetails(long product_id) {
		try {
			return sessionFactory.getCurrentSession().get(Laptop.class,product_id);
		} catch (Exception e) {
			return null;
		}
	}

}

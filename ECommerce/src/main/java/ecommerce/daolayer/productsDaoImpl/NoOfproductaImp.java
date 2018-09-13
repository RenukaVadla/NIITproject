package ecommerce.daolayer.productsDaoImpl;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productsDao.NoOfProductsDao;
import ecommerce.model.product.NoOfProducts;

@Transactional
@Component
public class NoOfproductaImp implements NoOfProductsDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean NoOfProductsAdded(NoOfProducts product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}

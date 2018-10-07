package ecommerce.daolayer.productsDaoImpl;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productsDao.NoOfProductsDao;
import ecommerce.model.product.NoOfProducts;

@Transactional
@Component
public class NoOfproductsImp implements NoOfProductsDao{
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

	@Override
	public List<NoOfProducts> getNoOfProducts(long product_id) {
		// TODO Auto-generated method stub
		try {
			Query<NoOfProducts> query=sessionFactory.getCurrentSession().createQuery("from NoOfProducts where product_id=:product_id",NoOfProducts.class);
			query.setParameter("product_id", product_id);
			return query.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
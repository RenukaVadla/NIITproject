package ecommerce.daoImp.productdetails;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productdetails.ProductDao;
import ecommerce.model.productdetails.Product;
import ecommerce.model.productdetails.SubCategory;

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

	@Override
	public List<Product> getAllProducts(long vendor_id) {
		// TODO Auto-generated method stub
		try {
			Query<Product> query=sessionFactory.getCurrentSession().createQuery("from Product where vendor_vendor_id =:id", Product.class);
			query.setParameter("id", vendor_id);
			return query.getResultList();
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
	}

	@Override
	public long getSubCategoryId(long product_id) {
		// TODO Auto-generated method stub
		try {
			Query<Product> query =sessionFactory.getCurrentSession().createQuery("from Product where product_id=:id",Product.class);
			query.setParameter("id", product_id);
			Product product=query.getSingleResult();
			return product.getSubCategory().getSubcategory_id();
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

	@Override
	public List<Product> getProductBySubCategory_id(long subcategory_id) {
		// TODO Auto-generated method stub
		try {
			Query<Product> query=sessionFactory.getCurrentSession().createQuery("from SubCategory where subCategory_subcategory_id=1",Product.class);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

package ecommerce.daoImp.productdetails;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.model.productdetails.Category;
import ecommerce.model.productdetails.SubCategory;


public class CategoryImp implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Category getCategoryId(long subcategory_id) {
		try {
		return sessionFactory.getCurrentSession().get(Category.class,subcategory_id);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	

}

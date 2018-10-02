package ecommerce.daoImp.productdetails;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productdetails.CategoryDao;
import ecommerce.model.productdetails.Category;
import ecommerce.model.productdetails.SubCategory;

@Transactional
@Component
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

	@Override
	public List<Category> getCategoryDetails() {
		// TODO Auto-generated method stub
		try {
			Query<Category> query=sessionFactory.getCurrentSession().createQuery("from Category",Category.class);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public Category getCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		try {
		Query<Category> query=sessionFactory.getCurrentSession().createQuery("from Category where categoryId=:categoryId",Category.class);
		query.setParameter("categoryId", categoryId);
		return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

}

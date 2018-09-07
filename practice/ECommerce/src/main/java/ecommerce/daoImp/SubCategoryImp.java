package ecommerce.daoImp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.SubCategoryDao;
import ecommerce.model.SubCategory;
@Component
@Transactional
public class SubCategoryImp implements SubCategoryDao{
	@Autowired
	SessionFactory sessionFactory;

	public SubCategory getCategory(long subcategory_id) {
		try {
		return sessionFactory.getCurrentSession().get(SubCategory.class, subcategory_id);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
		
	}

}

package ecommerce.daoImp.productdetails;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.productdetails.SubCategoryDao;
import ecommerce.model.productdetails.SubCategory;
@Component
@Transactional
public class SubCategoryImp implements SubCategoryDao{
	@Autowired
	SessionFactory sessionFactory;

	public SubCategory getSubCategory(long subcategory_id) {
		try {
		return sessionFactory.getCurrentSession().get(SubCategory.class, subcategory_id);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
		
	}

	@Override
	public List<SubCategory> getSubCategoryDetails(long categoryid) {
		// TODO Auto-generated method stub
		try {
			Query<SubCategory> query=sessionFactory.getCurrentSession().createQuery("from SubCategory where category_categoryId=:id",SubCategory.class);
			query.setParameter("id", categoryid);
			return query.list();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<SubCategory> getElectronics() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_categoryId=1", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	
	/*public SubCategory getSubCategoryId(long subcategory_id) {
		// TODO Auto-generated method stub
		try {
			Query<SubCategory> query=sessionFactory.getCurrentSession().createQuery("from SubCategory where subcategory_id=:id",SubCategory.class);
			query.setParameter("id", subcategory_id);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}*/

	
}

package ecommerce.daoImp.admin;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.admin.AdminDao;
import ecommerce.model.vendor.AdminDetails;
import ecommerce.model.vendor.Vendor;

@Component
@Transactional
public class AdminImp implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addAdmin(AdminDetails admin) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(admin);
			return true;
			}catch (Exception e) {
				// TODO: handle exception
				return false;
	
			}
	}

	@Override
	public boolean deleteAdmin(AdminDetails admin) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(admin);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public AdminDetails getAdminByEmail(String admin_email) {
		// TODO Auto-generated method stub
		try {
			Query<AdminDetails> query=sessionFactory.getCurrentSession().createQuery("from AdminDetails where admin_email=:email",AdminDetails.class);
			query.setParameter("email", admin_email);
			return query.getSingleResult();
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	}

	@Override
	public AdminDetails login(String admin_email, String admin_password) {
		// TODO Auto-generated method stub
		try{
			Query<AdminDetails> query=sessionFactory.getCurrentSession().createQuery("from AdminDetails where admin_email=:admin_email and admin_password=:admin_password",AdminDetails.class);
			query.setParameter("admin_email", admin_email);
			query.setParameter("admin_password", admin_password);
			return query.getSingleResult();
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}

	}

	@Override
	public List<Vendor> getVendor() {
		// TODO Auto-generated method stub
		try {
			Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor",Vendor.class);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
package ecommerce.daoImp.vendor;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.daolayer.vendor.VendorDao;
import ecommerce.model.vendor.Vendor;
@Component
@Transactional
public class VendorImp implements VendorDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(Vendor vendor) {
		try
		{
		sessionFactory.getCurrentSession().save(vendor);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteUser(Vendor vendor) {
		try {
			sessionFactory.getCurrentSession().delete(vendor);
			return true;
			}catch (Exception e) {
				// TODO: handle exception
				return false;
			}
	}

	@Override
	public Vendor getUserById(long vendor_id) {
		try {
			return	sessionFactory.getCurrentSession().get(Vendor.class, vendor_id);
				
			}catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
	}

	@Override
	public Vendor getUserByEmail(String vendor_email) {
		// TODO Auto-generated method stub
				try {
				Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_email=:email",Vendor.class);
				query.setParameter("email", vendor_email);
				return query.getSingleResult();
				}catch (Exception e) {
					// TODO: handle exception
					return null;
				}
	}

	@Override
	public Vendor login(String vendor_email, String vendor_password) {
		try {
			Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_email=:vendor_email and vendor_password=:vendor_password",Vendor.class);
			query.setParameter("vendor_email", vendor_email);
			query.setParameter("vendor_password", vendor_password);
			return query.getSingleResult();
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	}

	@Override
	public boolean update(Vendor vendor) {
		// TODO Auto-generated method stub
				try {
				sessionFactory.getCurrentSession().update(vendor);
				return true;
				}catch (Exception e) {
					// TODO: handle exception
					return false;
				}
				
	}

	@Override
	public List<Vendor> getVendorDetails() {
		// TODO Auto-generated method stub
				try {
				Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor",Vendor.class);
				return query.getResultList();
				}catch (Exception e) {
					// TODO: handle exception
					return null;
				}
	}
	
	

	}

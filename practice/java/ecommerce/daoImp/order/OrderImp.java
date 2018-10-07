package ecommerce.daoImp.order;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecommerce.daolayer.order.OrderDao;

import ecommerce.model.order.Orderer;

public class OrderImp implements OrderDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder( Orderer order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrder( Orderer order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateOrder( Orderer order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(order);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public  Orderer getOrderByOrderId(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List< Orderer> getOrderByCustomerId(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

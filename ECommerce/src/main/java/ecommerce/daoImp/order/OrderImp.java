package ecommerce.daoImp.order;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecommerce.daolayer.order.OrderDao;
import ecommerce.model.order.Order;

public class OrderImp implements OrderDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(Order order) {
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
	public boolean deleteOrder(Order order) {
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
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(order);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Order getOrderByOrderId(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByCustomerId(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

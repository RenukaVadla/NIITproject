package ecommerce.daoImp.cart;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.daolayer.cart.CartDao;
import ecommerce.model.cart.Cart;
@Component
@Transactional
public class CartImp implements CartDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addcart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cart);
					return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean deletecart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cart);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updatecart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Cart getCartById(int cart_id) {
//		// TODO Auto-generated method stub
			try {
		Query<Cart> query=sessionFactory.getCurrentSession().createQuery("from Cart where cart_id=:cart_id",Cart.class);
			query.setParameter("cart_id", cart_id);
			return query.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Cart getCartByCustomerId(int customer_id) {
//		// TODO Auto-generated method stub		
		try {
			Query<Cart> query=sessionFactory.getCurrentSession().createQuery("from Cart where customer_customer_id=:customer_id",Cart.class);
			query.setParameter("customer_id", customer_id);
			return query.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		/*return null;*/
	}
	

}



	
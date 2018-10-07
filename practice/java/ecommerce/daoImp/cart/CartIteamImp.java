package ecommerce.daoImp.cart;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import ecommerce.daolayer.cart.CartItemDao;
import ecommerce.model.cart.CartItem;

public class CartIteamImp implements CartItemDao{
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CartItem getCartItemByCartId(int cart_id) {
		// TODO Auto-generated method stub
		try {
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where cart_cart_id=:cart_id",CartItem.class);
			query.setParameter("cart_id", cart_id);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<CartItem> getAllCartItemIdByCartId(int cart_id) {
		// TODO Auto-generated method stub
		try {
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where cart_cart_id=:cart_id",CartItem.class);
			query.setParameter("cart_id", cart_id);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

}

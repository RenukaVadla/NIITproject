package ecommerce.daoImp.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.daolayer.cart.CartItemDao;
import ecommerce.model.cart.CartItem;
@Component
@Transactional
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
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where cart_id=:cart_id",CartItem.class);
			query.setParameter("cart_id", cart_id);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<CartItem> getAllCartItemIdByCartid(int cart_id) {
		try {
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where cart_id=:cart_id",CartItem.class);
			query.setParameter("cart_id", cart_id);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deletecartByCartItem_id(int cartd_id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItem where cartIteam_id=:cartd_id")
			.setParameter("cartd_id", cartd_id);
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartItem> getCartItemId(int cartItem_id) {
		// TODO Auto-generated method stub
		try {
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where cartItem_id=:cartItem_id",CartItem.class);
			query.setParameter("cartItem_id", cartItem_id);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCartItemIdbycartItem_id(int cartItem_id) {
		// TODO Auto-generated method stub
		try {
		return (int) sessionFactory.getCurrentSession().createQuery("from CartItem where cartItem_id=:cartItem_id")
				.setParameter("cartItem_id", cartItem_id).getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	
}

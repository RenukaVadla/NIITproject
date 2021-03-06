package ecommerce.daoImp.cart;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import ecommerce.daolayer.cart.CartItemIdDao;
import ecommerce.model.cart.CartItemId;

public class CartItemIdImp implements CartItemIdDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItemId(CartItemId cartItemId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cartItemId);
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCartItemId(CartItemId cartItemId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cartItemId);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCartItemId(CartItemId cartItemId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartItemId);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CartItemId getCartItemIdByCartItemId_id(long cartItemId_id) {
		// TODO Auto-generated method stub
		try {
			Query<CartItemId> query=sessionFactory.getCurrentSession().createQuery("from CartItemId where cartItem_cartItem_id=:cartItemId_id",CartItemId.class);
			query.setParameter("cartItemId_id", cartItemId_id);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public CartItemId getCartItemIdBycartItem(int cartItem_id) {
		// TODO Auto-generated method stub
		try {
			Query<CartItemId> query=sessionFactory.getCurrentSession().createQuery("from CartItemId where cartItem_cartItem_id=:cartItem_id",CartItemId.class);
			query.setParameter("cartItem_id", cartItem_id);
			return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<CartItemId> getAllCartItemIdByCartItem_id(int cartItem_id) {
		// TODO Auto-generated method stub
		try {
			
			Query<CartItemId> query=sessionFactory.getCurrentSession().createQuery("from CartItemId where cartItem_cartItem_id=:cartItem_id",CartItemId.class);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

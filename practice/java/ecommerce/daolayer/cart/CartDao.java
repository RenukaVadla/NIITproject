package ecommerce.daolayer.cart;

import ecommerce.model.cart.Cart;

public interface CartDao {
	public abstract boolean addcart(Cart cart);
	public abstract boolean deletecart(Cart cart);
	public abstract boolean updatecart(Cart cart);
	public abstract Cart getCartById(int cart_id);
	public abstract Cart getCartByCustomerId(int customer_id);

}

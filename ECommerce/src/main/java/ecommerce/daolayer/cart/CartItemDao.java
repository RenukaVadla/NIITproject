package ecommerce.daolayer.cart;

import ecommerce.model.cart.CartItem;

public interface CartItemDao {
	public abstract boolean addCartItem(CartItem cartItem);
	public abstract boolean deleteCartItem(CartItem cartItem);
	public abstract boolean updateCartItem(CartItem cartItem);
	public abstract CartItem getCartItemByCartId(int cart_id);
	

}

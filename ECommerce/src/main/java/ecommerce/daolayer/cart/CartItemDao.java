package ecommerce.daolayer.cart;

import java.util.List;

import ecommerce.model.cart.CartItem;

public interface CartItemDao {
	public abstract boolean addCartItem(CartItem cartItem);
	public abstract boolean deleteCartItem(CartItem cartItem);
	public abstract boolean updateCartItem(CartItem cartItem);
	public abstract CartItem getCartItemByCartId(int cart_id);
	public List<CartItem> getAllCartItemIdByCartid(int cart_id);

	

}

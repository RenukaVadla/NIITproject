package ecommerce.daolayer.cart;

import java.util.List;

import ecommerce.model.cart.CartItem;
import ecommerce.model.cart.CartItemId;

public interface CartItemIdDao {
	public abstract boolean addCartItemId(CartItemId cartItemId);
	public abstract boolean deleteCartItemId(CartItemId cartItemId);
	public abstract boolean updateCartItemId(CartItemId cartItemId);
	public abstract CartItemId getCartItemIdByCartItemId_id(long cartItemId_id);
	public abstract CartItemId getCartItemIdBycartItem(int cartItem_id);
	public List<CartItemId> getAllCartItemIdByCartItemId_id(long cartItemId_id);
}

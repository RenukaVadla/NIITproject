package ecommerce.model.cart;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ecommerce.model.product.NoOfProducts;

public class CartItemId {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartItemId_id;
	@OneToOne
	private NoOfProducts noOfProducts;
	@ManyToOne
	private CartItem cartItem;
	public long getCartItemId_id() {
		return cartItemId_id;
	}
	public void setCartItemId_id(long cartItemId_id) {
		this.cartItemId_id = cartItemId_id;
	}
	public NoOfProducts getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(NoOfProducts noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	
}

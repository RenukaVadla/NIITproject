package ecommerce.model.cart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import ecommerce.model.productdetails.Product;

public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartItem_id;
	private int quantity;
	private int unitPrice;
	private int netPrice;
	@OneToOne
	private Product product;
	@ManyToOne
	private Cart cart;
	
	@OneToMany(mappedBy="cartItem",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItemId> cartItemId;
	
	public int getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(int netPrice) {
		this.netPrice = netPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}

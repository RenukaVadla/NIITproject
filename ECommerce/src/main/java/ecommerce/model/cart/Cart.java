package ecommerce.model.cart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ecommerce.model.customer.Customer;

public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cart_id;
	private int noOfitems;
	private int netPrice;
	@OneToOne
	private Customer customer;
	
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItem> cartItem;
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getNoOfitems() {
		return noOfitems;
	}
	public void setNoOfitems(int noOfitems) {
		this.noOfitems = noOfitems;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(int netPrice) {
		this.netPrice = netPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
}

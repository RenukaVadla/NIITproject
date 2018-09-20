package ecommerce.model.order;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ecommerce.model.cart.Cart;
import ecommerce.model.customer.Customer;


public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int order_id;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Cart cart;
	@OneToMany(mappedBy="order",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderedItems> orderedItems;
	private int noOfitems;
	private int netPrice;
	private Date date;
	private Timestamp timestamp;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<OrderedItems> getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	}

package ecommerce.model.order;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class OrderedItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int OrderedItems_id;
	private int quantity;
	private int unitprice;
	private int netprice;
	@ManyToOne()
	private Order order;
	public int getOrderedItems_id() {
		return OrderedItems_id;
	}
	public void setOrderedItems_id(int orderedItems_id) {
		OrderedItems_id = orderedItems_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getNetprice() {
		return netprice;
	}
	public void setNetprice(int netprice) {
		this.netprice = netprice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

}

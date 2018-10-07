package ecommerce.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import ecommerce.model.product.NoOfProducts;
@Entity
@Component
public class OrdererItemIds {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderedItemId_id;
	@OneToOne
	private NoOfProducts noOfProducts;
	@ManyToOne
	private OrderedItems orderedItems;
	public int getOrderedItemId_id() {
		return orderedItemId_id;
	}
	public void setOrderedItemId_id(int orderedItemId_id) {
		this.orderedItemId_id = orderedItemId_id;
	}
	public NoOfProducts getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(NoOfProducts noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public OrderedItems getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(OrderedItems orderedItems) {
		this.orderedItems = orderedItems;
	}
	
	
}

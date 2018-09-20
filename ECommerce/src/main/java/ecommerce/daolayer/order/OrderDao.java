package ecommerce.daolayer.order;

import java.util.List;

import ecommerce.model.order.Order;

public interface OrderDao {
	public abstract boolean addOrder(Order order);
	public abstract boolean deleteOrder(Order order);
	public abstract boolean updateOrder(Order order);
	public abstract Order getOrderByOrderId(int order_id);
	public abstract List<Order> getOrderByCustomerId(int customer_id);

}

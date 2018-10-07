package ecommerce.daolayer.order;

import java.util.List;


import ecommerce.model.order.Orderer;

public interface OrderDao {
	public abstract boolean addOrder( Orderer order);
	public abstract boolean deleteOrder( Orderer order);
	public abstract boolean updateOrder( Orderer order);
	public abstract  Orderer getOrderByOrderId(int order_id);
	public abstract List< Orderer> getOrderByCustomerId(int customer_id);

}

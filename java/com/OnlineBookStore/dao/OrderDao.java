package com.OnlineBookStore.dao;
import java.util.List;

import com.OnlineBookStore.Models.*;

public interface OrderDao {

	public boolean placeOrder(String customeremail, double totalBill, String orderStatus);
	public List<Order>getallOrder();
	
	public boolean clearCart(String customeruseremail);
	String checkOrderStatus(int orderid);
	
	List<Order> getOrderByName(String customerName);
	
	
	boolean updateOrderStatus(Order o);
	Order getOrderById(int id);
}

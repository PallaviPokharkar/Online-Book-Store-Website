package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.DBUtil;
import com.OnlineBookStore.dao.OrderDao;

public class OrderDaoImpl implements OrderDao
{

	@Override
	public boolean placeOrder(String customeremail, double totalBill,String orderStatus) {
		try {
			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("INSERT INTO " +Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+" (customerName,totalBill,orderStatus) values (?,?,?)");
			ps.setString(1, customeremail);
			ps.setDouble(2, totalBill);
			ps.setString(3, orderStatus);
			
		    int x=ps.executeUpdate();
		    if(x!=0)
		    {
		    	return true;
		    }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Order> getallOrder() {
		try {
			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Select * from " +Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+ "");
			
			ResultSet rs= ps.executeQuery();
			List<Order> orders=new ArrayList<>();
			while(rs.next())
			{
				Order order=new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderStatus(rs.getString("orderStatus"));
				order.setTotalBill(rs.getDouble("totalBill"));
				order.setCustomerName(rs.getString("customerName"));
				orders.add(order);
			}
	        return orders;		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean clearCart(String customeruseremail) {
		try {
			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Delete from "+Constant.DBCONSTANT.get(Constant.CART_TABLE)+" where customerEmailid=?");
			ps.setString(1, customeruseremail);
			
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		return false;
	}

	@Override
	public String checkOrderStatus(int orderid) {
		try {
			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Select  from " +Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+" where orderId=?");
			ps.setInt(1, orderid);
			ResultSet rs= ps.executeQuery();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		return null;
	}

	
	@Override
	public List<Order> getOrderByName(String customerName) {

		try {
			Connection con=DBUtil.getDBConnection();

			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+" where customerName=?");
			ps.setString(1, customerName);
			ResultSet rs =ps.executeQuery();
			List<Order> orders = new ArrayList<>();

			while(rs.next()) 
			{
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderStatus(rs.getString("orderStatus"));
				order.setTotalBill(rs.getDouble("totalBill"));
				order.setCustomerName(rs.getString("customerName"));
				orders.add(order);
			}
			return orders;
			
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateOrderStatus(Order o) {
		try {
			Connection con=DBUtil.getDBConnection();

			PreparedStatement ps= con.prepareStatement("update "+Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+" set orderStatus=? where orderId=?");
			ps.setString(1, o.getOrderStatus());
			ps.setInt(2, o.getOrderId());

			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Order getOrderById(int id) {

		try {
			Connection con=DBUtil.getDBConnection();

			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+Constant.DBCONSTANT.get(Constant.ORDER_TABLE)+" where orderId=?");
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();

			Order order = new Order();
			while(rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderStatus(rs.getString("orderStatus"));
				order.setTotalBill(rs.getDouble("totalBill"));
				order.setCustomerName(rs.getString("customerName"));
			}
			return order;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

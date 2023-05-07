package com.OnlineBookStore.Util;

import com.OnlineBookStore.impl.BookDaoImpl;
import com.OnlineBookStore.impl.CardDaoImpl;
import com.OnlineBookStore.impl.CartDaoImpl;
import com.OnlineBookStore.impl.CustomerDaoImpl;
import com.OnlineBookStore.impl.OrderDaoImpl;
import com.OnlineBookStore.impl.PaymentDaoImpl;

public class ObjectFactory 
{
    private static BookDaoImpl bookDaoImpl;
    private static CustomerDaoImpl customerDaoImpl;
    private static CartDaoImpl cartDaoImpl;
    private static OrderDaoImpl orderDaoImpl;
    private static PaymentDaoImpl paymentDaoImpl;
    private static CardDaoImpl cardDaoImpl;
    
    public static BookDaoImpl getBookDaoInstance()
    {
    	if(bookDaoImpl ==null)
    	{
    		bookDaoImpl=new BookDaoImpl();
    	}
    	return bookDaoImpl;
    }
    
    public static CustomerDaoImpl getCustomerDaoInstance()
    {
    	if(customerDaoImpl ==null)
    	{
    		customerDaoImpl=new CustomerDaoImpl();
    	}
    	return customerDaoImpl;
    }
    
    public static CartDaoImpl getCartDaoInstance()
    {
    	if(cartDaoImpl ==null)
    	{
    		cartDaoImpl=new CartDaoImpl();
    	}
    	return cartDaoImpl;
    }
    
    public static OrderDaoImpl getOrderDaoInstance()
    {
    	if(orderDaoImpl ==null)
    	{
    		orderDaoImpl=new OrderDaoImpl();
    	}
    	return orderDaoImpl;
    }
    
    public static PaymentDaoImpl getPaymentDaoInstance()
    {
    	if(paymentDaoImpl ==null)
    	{
    		paymentDaoImpl=new PaymentDaoImpl();
    	}
    	return paymentDaoImpl;
    }
    
    
    public static CardDaoImpl getCardsDaoInstance()
    {
    	if(cardDaoImpl ==null)
    	{
    	    cardDaoImpl=new CardDaoImpl();
    	}
    	return cardDaoImpl;
    }
    
}

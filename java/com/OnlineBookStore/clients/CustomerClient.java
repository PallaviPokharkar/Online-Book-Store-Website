package com.OnlineBookStore.clients;
import java.util.Scanner;

import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.impl.CustomerDaoImpl;
public class CustomerClient 
{
	public static void main(String[] args)
	{
    CustomerDaoImpl customerDaoImpl= new CustomerDaoImpl();
    
	Scanner sc = new Scanner(System.in);
	System.out.println("1: Add Customer: ");
	System.out.println("2: Update Customer: ");
	System.out.println("3: Delete Customer: ");
	System.out.println("4: login Customers by email and pass: ");
	System.out.println("5 - login admin by username and pass");
	System.out.println("6 - change pass by email and pass");
	System.out.println("7-show all customer ");
	System.out.println("8- show customer by id");
	System.out.println("9- show customer by name");
	
	
	System.out.println("Enter Your Choice: ");
	int c1=sc.nextInt();
	switch(c1) {
	
	case 1:
		System.out.println("Enter Customer Name= ");
		String name=sc.next();
		System.out.println("Enter Customer Address= ");
		String address=sc.next();
		System.out.println("Enter Customer Email ID= ");
		String email=sc.next();
		System.out.println("Enter Customer Contact No= ");
		String no=sc.next();
		System.out.println("Enter Customer Password= ");
		String pass=sc.next();
		
		Customer customer = new Customer();
		
		customer.setCustomerName(name);
		customer.setCustomerAddress(address);
		customer.setCustomerEmailid(email);
		customer.setCustomerContactno(no);
		customer.setCustomerPassword(pass);
		
		customerDaoImpl.addCustomer(customer);
		
		break;
		
	case 2:
		//Update
	case 3:
		System.out.println("Enter Customer ID= ");
		int id=sc.nextInt();
		
		Customer customer2 = new Customer();
		customer2.setCustomerId(id);
		customerDaoImpl.deleteCustomer(id);
		break;
		
		
	case 4:
		System.out.println("login customer :");
		System.out.println("Enter Customer email= ");
		String emailId=sc.next();
		
		System.out.println("Enter Customer pass= ");
		String password=sc.next();
		
		customerDaoImpl.LoginCustomer(emailId, password);
        break;
		
	case 5:
//		admin login
		break;
		
  	case 6:
  		//	 change password 
		break;
		
	case 7:
		System.out.println("show all Customer  ");
	
		customerDaoImpl.getAllCustomer();
		break;

	
	case 8:
		System.out.println("show  Customer  id ");
		int id2=sc.nextInt();
		
		Customer customer7 = new Customer();
		customer7.setCustomerId(id2);
		customerDaoImpl.getCustomerById(id2);
		break;
		
	case 9:
		System.out.println("show Customer by name= ");
		String Custusername=sc.next();
		
		Customer customer8 = new Customer();
		customer8.setCustomerName(Custusername);
		customerDaoImpl.getCustomerByName(Custusername);
		break;
}
}
}
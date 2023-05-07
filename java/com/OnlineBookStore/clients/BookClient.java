package com.OnlineBookStore.clients;
import java.util.Scanner;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.impl.BookDaoImpl;
public class BookClient 
{
   public static void main(String[] args) 
   {
	   BookDaoImpl bookDaoImpl=new BookDaoImpl();
	   
	  Scanner sc=new Scanner(System.in);
	  System.out.println("1 - Add book");
	  System.out.println("2 - update book");
	  System.out.println("3 - delete book");
	  System.out.println("4- show all book");
	  System.out.println("5 - show book By Id");
	  System.out.println("6 - show book by name");
	  System.out.println("7 - show book by category");
	  System.out.println("8 - show all book category");
	  System.out.println("9 - show book by publisher");
	  System.out.println("10 - show  all book publisher");
	  
	  System.out.println("enter choice");
	  int choice =sc.nextInt();
	  
	  switch(choice)
	  {
	  case 1 :
		    Book book =new Book();
		    
		    System.out.println("enter book name");
		    String bookName=sc.next();
		    book.setBookName(bookName);
		    
		    System.out.println("enter book author");
		    String bookAuthor=sc.next();
		    book.setBookAuthor(bookAuthor);
		    
		    System.out.println("enter book price");
		    Double bookPrice=sc.nextDouble();
		    book.setBookPrice(bookPrice);
		    
		    System.out.println("enter book publisher");
		    String bookPublish=sc.next();
		    book.setBookPublisher(bookPublish);
		    
		    System.out.println("enter book quantity");
		    int bookQuantity=sc.nextInt();
		    book.setBookQuantity(bookQuantity);
		    
		    System.out.println("enter book Category");
		    String bookCategory=sc.next();
		    book.setBookCategory(bookCategory);
		    
		    System.out.println("enter book Image");
		    String bookImg=sc.next();
		    book.setBookImg(bookImg);
		    
		    System.out.println("enter book Description");
		    String bookDesc=sc.next();
		    book.setBookDesc(bookDesc);
		    
		    
		    bookDaoImpl.addBook(book);
		    break;
		    
	  case 2 :
		  break;
		  
	  case 3:
		    System.out.println("Enter Book ID= ");
			int id=sc.nextInt();
			
			Book book1 = new Book();
			book1.setBookId(id);
			bookDaoImpl.deleteBook(id);
			break;
			
	  case 4 :
		   System.out.println("Select All book");
		   bookDaoImpl.getAllBook();
		   break;
		   
	  case 5 :
		    System.out.println("show book By ID=");
		    int id1=sc.nextInt();
		    
		    Book book2 = new Book();
			book2.setBookId(id1);
		    bookDaoImpl.getBookById(id1);
		    break;
		    
	  case 6:
		    System.out.println("Enter Book Name= ");
			String name=sc.next();
			
			Book book3 = new Book();
			book3.setBookName(name);
			bookDaoImpl.getBookByName(name);
			break;
			
	  case 7:
		    System.out.println("book by category ");
			String category=sc.next();
			
			Book book4 = new Book();
			book4.setBookCategory(category);
			bookDaoImpl.getBookByCategory(category);
			break;
			
	  case 8:
		    System.out.println("show all book category ");
			
			bookDaoImpl.getAllCategory();
			break;
			
	  case 9:
		    System.out.println("show book by publisher ");
			String publisher=sc.next();
			
			Book book6 = new Book();
			book6.setBookPublisher(publisher);
			bookDaoImpl.getBookByPublisher(publisher);
			break;
			
	  case 10:
		    System.out.println("show all book publisher ");
			bookDaoImpl.getAllPublisher();
			break;
		    
	  }
	  
}
}

package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.DBUtil;
import com.OnlineBookStore.dao.BookDao;

public class BookDaoImpl implements BookDao{

	@Override
	public boolean addBook(Book b)
	{

		try {
			Connection con =DBUtil.getDBConnection();

			PreparedStatement ps= con.prepareStatement("INSERT INTO "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"(bookName,bookAuthor,bookPrice,bookPublisher,bookQuantity,bookCategory,bookImg,bookDesc) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookAuthor());
			ps.setDouble(3, b.getBookPrice());
			ps.setString(4, b.getBookPublisher());
			ps.setInt(5, b.getBookQuantity());
			ps.setString(6, b.getBookCategory());
			ps.setString(7, b.getBookImg());
			ps.setString(8, b.getBookDesc());

			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}

		catch(SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateBook(Book b)
	{
		try {

			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Update "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" set bookName=?,bookAuthor=?,bookPrice=?,bookPublisher=?,bookQuantity=?,bookCategory=?,bookDesc=? where bookId=?");
		    ps.setString(1,b.getBookName());
		    ps.setString(2,b.getBookAuthor());
		    ps.setDouble(3,b.getBookPrice());
		    ps.setString(4,b.getBookPublisher());
		    ps.setInt(5,b.getBookQuantity());
		    ps.setString(6,b.getBookCategory());
		    ps.setString(7,b.getBookDesc());
		    ps.setInt(8,b.getBookId());

		    
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) 
	{

		try {

			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Delete from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" where bookId=?");
			ps.setInt(1,id);

			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	

	@Override
	public List<Book> getAllBook() 
	{
		try {
			Connection con =DBUtil.getDBConnection();

			PreparedStatement ps= con.prepareStatement("select  * from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"  ");

			ResultSet rs= ps.executeQuery();
			List<Book> books= new ArrayList<>();
			
			while(rs.next())
			{
				Book book =new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setBookQuantity(rs.getInt("bookQuantity"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setBookImg(rs.getString("bookImg"));
				book.setBookDesc(rs.getString("bookDesc"));
				
				books.add(book);
				
			}
			return books;
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookById(int id)
	{
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" where bookId=?");

			ps.setInt(1, id);

			ResultSet rs= ps.executeQuery();
			Book book=new Book();
			while(rs.next())
			{
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setBookQuantity(rs.getInt("bookQuantity"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setBookImg(rs.getString("bookImg"));
				book.setBookDesc(rs.getString("bookDesc"));
				
				
			}
			return book;
		 }catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookByName(String name) 
	{
		try {
			
			Connection con =DBUtil.getDBConnection();
		
			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" where bookName=?");

			ps.setString(1, name);

			ResultSet rs= ps.executeQuery();
			List<Book> books=new ArrayList<>();
			Book book=new Book();
			while(rs.next())
			{
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setBookQuantity(rs.getInt("bookQuantity"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setBookImg(rs.getString("bookImg"));
				book.setBookDesc(rs.getString("bookDesc"));
				
				books.add(book);
			}
			return books;
		}

		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookByCategory(String category) 
	{
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" where bookCategory=?");

			ps.setString(1, category);

			ResultSet rs= ps.executeQuery();
			List<Book> books =new ArrayList<>();
			while(rs.next())
			{
				Book book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setBookQuantity(rs.getInt("bookQuantity"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setBookImg(rs.getString("bookImg"));
				book.setBookDesc(rs.getString("bookDesc"));
				
				books.add(book);
			}
			return books;
		}
        catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAllCategory() 
	{
	
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select distinct bookCategory from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"");
			ResultSet rs= ps.executeQuery();
			List<Category> categories =new ArrayList<>();
			
			while(rs.next())
			{
				Category category = new Category();
				category.setCategoryName(rs.getString("bookCategory"));
				
				
				categories.add(category);
			}
			
			return categories;
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) 
	{
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"  where bookPublisher=?");
			ps.setString(1, publisher);
			ResultSet rs= ps.executeQuery();
			List<Book> books =new ArrayList<>();
			Book book=new Book();
			while(rs.next())
			{
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setBookQuantity(rs.getInt("bookQuantity"));
				book.setBookCategory(rs.getString("bookCategory"));
				book.setBookImg(rs.getString("bookImg"));
				book.setBookDesc(rs.getString("bookDesc"));
				
				books.add(book);
			}
			return books;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Publisher> getAllPublisher()
	{
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select  distinct bookPublisher from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"");
			ResultSet rs= ps.executeQuery();
			List<Publisher> publishers =new ArrayList<>();
			while(rs.next())
			{
				Publisher publisher =new Publisher();
				publisher.setPublisherName(rs.getString("bookPublisher"));
				
				publishers.add(publisher);
			}
			return publishers;
		}
       catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getMaxBookById() 
	{
		int maxBookId=0;
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("select max(bookId) as BookId from "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+"");

			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				maxBookId=rs.getInt("bookId");
			}
		 }catch(SQLException e) {
			e.printStackTrace();
		}
		return maxBookId;
	}

	@Override
	public boolean uploadBookImageById(String bookImgName) 
	{
		int maxBookId=this.getMaxBookById();
		try {
			Connection con =DBUtil.getDBConnection();
			
			PreparedStatement ps= con.prepareStatement("update "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" set BookImg=? where BookId=?");
			ps.setString(1, bookImgName);
			ps.setInt(2, maxBookId);

			int x=ps.executeUpdate();
			if(x!=0)
			{
				return true;
			}
		 }catch(SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}   
	
	
	@Override
	public boolean updateBook1(Book b)
	{
		try {

			Connection con =DBUtil.getDBConnection();
			PreparedStatement ps= con.prepareStatement("Update "+Constant.DBCONSTANT.get(Constant.BOOK_TABLE)+" set bookName=?,bookAuthor=?,bookPrice=?,bookPublisher=?,bookQuantity=?,bookCategory=?,bookDesc=? where bookId=?");
		    ps.setString(1,b.getBookName());
		    ps.setString(2,b.getBookAuthor());
		    ps.setDouble(3,b.getBookPrice());
		    ps.setString(4,b.getBookPublisher());
		    ps.setInt(5,b.getBookQuantity());
		    ps.setString(6,b.getBookCategory());
		    ps.setString(7,b.getBookDesc());
		    ps.setInt(8,b.getBookId());

		    
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

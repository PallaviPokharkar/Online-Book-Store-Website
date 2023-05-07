package com.OnlineBookStore.Controller;

import com.OnlineBookStore.impl.BookDaoImpl;
import java.io.IOException;
import java.util.List;

import com.OnlineBookStore.Util.ObjectFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Cart;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.dao.BookDao;

public class BookController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		BookDao bookDao = ObjectFactory.getBookDaoInstance();

		if (action != null && action.equalsIgnoreCase("deleteBookList")) 
		{
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			boolean isBookDeleted = bookDao.deleteBook(bookId);
			if (isBookDeleted) {
				List<Book> allBooks = bookDao.getAllBook();
				request.setAttribute("allBooks", allBooks);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateBookList.jsp");
				rd.forward(request, response);

			}

		} 
		else if (action != null && action.equalsIgnoreCase("bookById")) 
		{
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			Book book = bookDao.getBookById(bookId);
			request.setAttribute("book", book);

			RequestDispatcher rd = request.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(request, response);

		} 

		else if (action != null && action.equalsIgnoreCase("home")) 
		{
			HttpSession httpSession =request.getSession(); 
			String username=(String)httpSession.getAttribute("loggedInUser");
			
			if(username !=null)
			{
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			List<Book> allBooks = bookDao.getAllBook();
			request.setAttribute("allBooks", allBooks);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		else if (action != null && action.equalsIgnoreCase("AddBook"))
		{

			RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
			rd.forward(request, response);
		} 

		else if (action != null && action.equalsIgnoreCase("categories")) 
		{
			String bookCategory = request.getParameter("categoryName");

			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			List<Book> categoriesBook = bookDao.getBookByCategory(bookCategory);
			System.out.println(bookCategory);
			request.setAttribute("categoriesBook", categoriesBook);

			RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
			rd.forward(request, response);
		} 
		
		else if (action != null && action.equalsIgnoreCase("publishers")) 
		{
			String bookPublisher = request.getParameter("publisherName");

			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			List<Book> publisherBook = bookDao.getBookByPublisher(bookPublisher);
			request.setAttribute("publisherBook", publisherBook);
			//System.out.println(bookPublisher);

			RequestDispatcher rd = request.getRequestDispatcher("BookList1.jsp");
			rd.forward(request, response);
		} 

		else if (action.equalsIgnoreCase("detail"))
		{
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			int bookId=Integer.valueOf(request.getParameter("bookId"));

			
			HttpSession httpSession =request.getSession(); 
			String username=(String)httpSession.getAttribute("loggedInUser");

			Book allBooks =bookDao.getBookById(bookId);
			request.setAttribute("allBooks", allBooks);

			RequestDispatcher rd = request.getRequestDispatcher("ViewBook.jsp");
			rd.forward(request, response);

		}

		
		else if (action !=null && action.equalsIgnoreCase("SearchBook"))
		{
			HttpSession httpSession =request.getSession(); 
			String username=(String)httpSession.getAttribute("loggedInUser");

			if(username != null )
			{
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			String bookName = request.getParameter("searchBook");

			List<Book> searchBooks = bookDao.getBookByName(bookName);
			//System.out.println("searchBooks" + searchBooks);
			request.setAttribute("searchBooks", searchBooks );

			RequestDispatcher rd = request.getRequestDispatcher("SearchBook.jsp");
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}

		else if (action !=null && action.equalsIgnoreCase("BookSearch"))
		{
			
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			String bookName = request.getParameter("searchBook");
			
			List<Book> searchBooks = bookDao.getBookByName(bookName);
			//System.out.println("searchBooks" + searchBooks);
			request.setAttribute("searchBooks", searchBooks );
			
			RequestDispatcher rd = request.getRequestDispatcher("SearchAllBooks.jsp");
			rd.forward(request, response);
		}

		else if (action !=null && action.equalsIgnoreCase("books"))
		{
			HttpSession httpSession =request.getSession(); 
			String username=(String)httpSession.getAttribute("loggedInUser");

			if(username != null)
			{
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
			List<Book> allBooks = bookDao.getAllBook();
			request.setAttribute("allBooks", allBooks);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("fromUpdateBook"))
		{
			HttpSession httpSession =request.getSession();
			String username=(String)httpSession.getAttribute("loggedInUser");
			
			List<Book> allBooks =bookDao.getAllBook();
			request.setAttribute("allBooks", allBooks);
			
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
						
			RequestDispatcher rd=request.getRequestDispatcher("UpdateBookList.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("updateBookList"))
		{
			HttpSession httpSession =request.getSession();
			String username=(String)httpSession.getAttribute("loggedInUser");
			
			int bookId =Integer.valueOf(request.getParameter("bookId"));
			
			Book book = bookDao.getBookById(bookId);
			request.setAttribute("book", book);
			
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
						
			RequestDispatcher rd=request.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		String action = request.getParameter("action");

		if (action != null && (action.equalsIgnoreCase("addBook"))) {
			String bookName = request.getParameter("bookName");
			String bookAuthor = request.getParameter("bookAuthor");
			double bookPrice = Double.valueOf(request.getParameter("bookPrice"));
			String bookPublisher = request.getParameter("bookPublisher");
			int bookQuantity = Integer.valueOf(request.getParameter("bookQuantity"));
			String bookCategory = request.getParameter("bookCategory");
			String bookDesc = request.getParameter("bookDesc");

			Book book = new Book();
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookPrice(bookPrice);
			book.setBookPublisher(bookPublisher);
			book.setBookQuantity(bookQuantity);
			book.setBookCategory(bookCategory);
			book.setBookDesc(bookDesc);

			boolean isBookAdded = bookDao.addBook(book);
			if (isBookAdded == true) {
				response.sendRedirect("UploadBookImage.jsp");
			}
		}

		else if (action != null && (action.equalsIgnoreCase("updateBook"))) {
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		double bookPrice = Double.valueOf(request.getParameter("bookPrice"));
		String bookPublisher = request.getParameter("bookPublisher");
		int bookQuantity = Integer.valueOf(request.getParameter("bookQuantity"));
		String bookCategory = request.getParameter("bookCategory");
		String bookDesc = request.getParameter("bookDesc");
		
		int bookId1 = Integer.valueOf(request.getParameter("bookId"));
		Book book = bookDao.getBookById(bookId1);
		
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		book.setBookPrice(bookPrice);
		book.setBookPublisher(bookPublisher);
		book.setBookQuantity(bookQuantity);
		book.setBookCategory(bookCategory);
		book.setBookDesc(bookDesc);

		if (action.equalsIgnoreCase("updateBook")) {
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			String bookImg = request.getParameter("bookImg");
			book.setBookId(bookId);
			book.setBookImg(bookImg);

			boolean isBookUpdated = bookDao.updateBook(book);
			if (isBookUpdated) {
				List<Book> allBooks = bookDao.getAllBook();
				request.setAttribute("allBooks", allBooks);

				RequestDispatcher rd = request.getRequestDispatcher("UpdateBookList.jsp");
				rd.forward(request, response);
			}
		}
		}
		


	}
}


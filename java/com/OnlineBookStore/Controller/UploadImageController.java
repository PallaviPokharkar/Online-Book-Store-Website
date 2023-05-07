package com.OnlineBookStore.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.oreilly.servlet.MultipartRequest;

public class UploadImageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
         String action=request.getParameter("action");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String filePath="C:\\Users\\Administrator\\eclipse\\java-2021-09\\eclipse\\OnlineBookStoreWeb\\src\\main\\webapp\\BookStore_Image\\";
		String action=request.getParameter("action");
		response.setContentType("text/html");
		
		MultipartRequest multipartRequest=new MultipartRequest(request,filePath);
		Enumeration files=multipartRequest.getFileNames();
		
		String name=(String)files.nextElement();
		String fileName=multipartRequest.getFilesystemName(name);
		
		System.out.println(fileName);
		String bookImgNameWithPath=filePath+fileName;
		
        BookDao bookDao=ObjectFactory.getBookDaoInstance();
        
        boolean isBookAdded=bookDao.uploadBookImageById(bookImgNameWithPath);
        if(isBookAdded == true)
        {
        	List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);
			//System.out.println(allCategories);
			
			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);
			
        	List<Book> allBooks = bookDao.getAllBook();
			System.out.println("allBooks " + allBooks);
			request.setAttribute("allBooks", allBooks);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
        }
         
	}
}

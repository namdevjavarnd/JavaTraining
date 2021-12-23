/**
 * 
 */
package com.spring.lms.service;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.spring.lms.entity.Book;
import com.spring.lms.entity.LibUserBook;
import com.spring.lms.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@EnableScheduling
public interface BookService {
    
    List<Book> listBooks();

   
    Book findBook(String isbn);

  
    String requestBook(Integer bookId, Integer userId) throws ParseException;

   
    Book findBookById(Integer bookId);

    
    List<Book> listBooksOfUser(Integer userId);

   
    String returnBook(Integer bookId, Integer userId);

    
    List<Book> searchBookbyUser(Book book);

   
    boolean deleteBookByID(Integer id);


    Book updateBooks(Book updatedbook, HttpServletRequest request);

    String getAvailableBookCount();

   

    Book getBookByISBN(String isbn);

    
	boolean addBook(String isbn, String author, String title, String callnumber, String publisher, String year_of_publication, String location, int num_of_copies, String current_status, String keywords, byte[] image, User user);

  
    List<Book> findAll();

    

    List<LibUserBook> getAllLibUserBook();

   

    String renewBook(Integer bookId, Integer userId) throws ParseException;
}

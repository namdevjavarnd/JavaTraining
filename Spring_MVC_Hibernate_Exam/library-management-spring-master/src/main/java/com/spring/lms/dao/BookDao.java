package com.spring.lms.dao;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.Book;
import com.spring.lms.entity.LibUserBook;
import com.spring.lms.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@EnableScheduling
@Transactional
public interface BookDao {

    
    boolean addBook(Book book);

    

    boolean addBook(String isbn, String author, String title, String callnumber, String publisher, String year_of_publication, String location, int num_of_copies, String current_status, String keywords, byte[] image, User user);

   
    Book getBookByISBN(String isbn);

    List<Book> findAll();

   
    Book getBookbyId(Integer bookId);

   
    String setBookRequest(Integer bookId, Integer userId) throws ParseException;

   
    List<Book> searchBook(Book book);

   
    void updateBookStatus(Integer book_Id) throws InterruptedException;

    
    List<Book> getBookByUserId(Integer userId);

    String setBookReturn(Integer bookId, Integer userId);

   
    List<LibUserBook> getAllLibUserBook();

 
    String findCountAvailable();

   
    boolean deleteBookByID(Integer id);

    
    Book updateBooks(Book updatedbook, HttpServletRequest request);

    
    String setBookRenew(Integer bookId, Integer userId) throws ParseException;

    
    LocalDate bookAvailabilityDueDate(Book book);

    
    void waitlistMadeAvailable(Integer userId, Integer bookId);

  
    void didWLUserCheckoutBook(Integer userId, Integer bookId);

   
    void waitlistCron() throws ParseException;

    void remainderEmailCron() throws ParseException;
}

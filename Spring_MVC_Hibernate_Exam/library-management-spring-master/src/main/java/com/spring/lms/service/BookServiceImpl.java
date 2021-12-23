/**
 *
 */
package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.spring.lms.dao.BookDao;
import com.spring.lms.entity.Book;
import com.spring.lms.entity.LibUserBook;
import com.spring.lms.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@EnableScheduling
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    UserBookService userBookService;

   
    @Override
    public List<Book> listBooks() {
        return bookDao.findAll();
    }

   
    @Override
    public Book findBook(String isbn) {
        // TODO Auto-generated method stub
        Book book = bookDao.getBookByISBN(isbn);
        return book;
    }

    
    @Override
    public String requestBook(Integer bookId, Integer userId) throws ParseException {
        // TODO Auto-generated method stub
        return bookDao.setBookRequest(bookId, userId);

    }

    
    @Override
    public Book findBookById(Integer bookId) {
        return bookDao.getBookbyId(bookId);
    }

    
    @Override
    public List<Book> listBooksOfUser(Integer userId) {

        List<Book> books = bookDao.getBookByUserId(userId);
        return books;
    }

    @Override
    public String returnBook(Integer bookId, Integer userId) {
        return bookDao.setBookReturn(bookId, userId);

    }

   

    @Override
    public List<Book> searchBookbyUser(Book book) {

        return bookDao.searchBook(book);
    }

   

    @Override
    public boolean deleteBookByID(Integer id) {
        /*A book cannot be deleted if it’s checked out by a patron.*/
        if (!userBookService.checkIfEsxists(id)) {
            System.out.println(" Book does not exist, can delete safely. \n\r Now removing the waitlist entry for the same");

            return bookDao.deleteBookByID(id);
        } else {
            return false;
        }
    }

   
    @Override
    public String getAvailableBookCount() {
        return bookDao.findCountAvailable();
    }

    
    @Override
    public Book updateBooks(Book updatedbook, HttpServletRequest request) {
        return bookDao.updateBooks(updatedbook, request);
    }


   
    @Override
    public Book getBookByISBN(String isbn) {
        return bookDao.getBookByISBN(isbn);
    }

  
    @Override
    public boolean addBook(String isbn, String author, String title, String callnumber, String publisher, String year_of_publication, String location, int num_of_copies, String current_status, String keywords, byte[] image, User user) {
        return bookDao.addBook(isbn, author, title, callnumber, publisher, year_of_publication, location, num_of_copies, current_status, keywords, image, user);
    }

   
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

   
    @Override
    public List<LibUserBook> getAllLibUserBook() {
        return bookDao.getAllLibUserBook();
    }

   
    @Override
    public String renewBook(Integer bookId, Integer userId) throws ParseException {
        return bookDao.setBookRenew(bookId, userId);
    }
}

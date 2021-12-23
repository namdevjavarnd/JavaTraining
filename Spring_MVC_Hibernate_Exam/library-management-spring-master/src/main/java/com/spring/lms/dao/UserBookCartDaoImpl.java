package com.spring.lms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.Book;
import com.spring.lms.entity.UserBookCart;
import com.spring.lms.errors.Err;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class UserBookCartDaoImpl implements UserBookCartDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Err addUserBookToCartIssue(UserBookCart ubc) {
        List<UserBookCart> ubcList = this.getUserCartIssue(ubc.getUser_id());
        if (ubcList.size() > 4) {
            return new Err(true, "You can only add 5 books to the cart at a time");
        }
        for (UserBookCart u : ubcList) {
            if (u.getBook_id() == ubc.getBook_id()) {
                return new Err(true, "Book already added to cart!");
            }
        }
        entityManager.persist(ubc);
        return new Err();
    }

    @Override
    public Err addUserBookToCartReturn(UserBookCart ubc) {
        List<UserBookCart> ubcList = this.getUserCartReturn(ubc.getUser_id());
        if (ubcList.size() > 9) {
            return new Err(true, "You can only add 10 books to the cart at a time");
        }
        for (UserBookCart u : ubcList) {
            if (u.getBook_id() == ubc.getBook_id()) {
                return new Err(true, "Book already added to cart!");
            }
        }
        entityManager.persist(ubc);
        return new Err();
    }

  
    @Override
    public List<UserBookCart> getUserCartIssue(int userid) {
        String query = "Select ubc From UserBookCart ubc WHERE ubc.user_id = :userid AND ubc.type_return = 0";
        Query q = entityManager.createQuery(query, UserBookCart.class);
        q.setParameter("userid", userid);
        return q.getResultList();
    }

   
    @Override
    public List<UserBookCart> getUserCartReturn(int userid) {
        String query = "Select ubc From UserBookCart ubc WHERE ubc.user_id = :userid AND ubc.type_return > 0";
        Query q = entityManager.createQuery(query, UserBookCart.class);
        q.setParameter("userid", userid);
        return q.getResultList();
    }

  
    @Override
    public boolean removeCartEntry(UserBookCart ubc) {
        entityManager.remove(ubc);
        return true;
    }

   
    @Override
    public List<Book> getUserBooksInCartIssue(int userId) {

        List<UserBookCart> ubcs = this.getUserCartIssue(userId);
        List<Book> books = new ArrayList<Book>();
        for (UserBookCart u : ubcs) {
            books.add(entityManager.find(Book.class, u.getBook_id()));

        }
        return books;
    }

  
    @Override
    public List<Book> getUserBooksInCartReturn(int userId) {
        List<UserBookCart> ubcs = this.getUserCartReturn(userId);
        List<Book> books = new ArrayList<Book>();
        for (UserBookCart u : ubcs) {
            books.add(entityManager.find(Book.class, u.getBook_id()));

        }
        return books;
    }

}

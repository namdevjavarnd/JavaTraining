package com.spring.lms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.UserBook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Transactional
@Repository
public class UserBookDaoImpl implements UserBookDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

   
    @Override
    public int getUserDayBookCount(int userId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String query = "Select ub From UserBook ub WHERE ub.user.id = :userid AND ub.checkout_date = :checkout_date";
        Query q = entityManager.createQuery(query, UserBook.class);
        q.setParameter("userid", userId);
        q.setParameter("checkout_date", dtf.format(LocalDateTime.now()));
        return q.getResultList().size();
    }

    
    @Override
    public boolean exists(Integer bookid) {
        boolean flag = true;
        String query = "Select ub From UserBook ub WHERE ub.book.bookId = :book_id";
        Query q = entityManager.createQuery(query, UserBook.class);
        q.setParameter("book_id", bookid);
        if (q.getResultList().isEmpty()) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean removeUserBook(UserBook userBook) {
        entityManager.remove(userBook);
        return true;
    }
}


package com.spring.lms.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LIB_USER_BOOK_STATUS")
public class LibUserBook {

    @EmbeddedId

    @Column(name = "ID")
    private LibUserBookId id;
    @ManyToOne
    @JoinColumn(name = "BOOK", insertable = false, updatable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "USER", insertable = false, updatable = false)
    private User user;
    @Column(name = "ACTION")
    private String action;

    public LibUserBook() {
    }

   
    public LibUserBook(Book b, User u, String action) {
        // create primary key
        System.out.println("book id is ----" + b.getBookId());
        this.id = new LibUserBookId(b.getBookId(), u.getId());

        // initialize attributes
        this.book = b;
        this.user = u;
        this.action = action;
    }

  
    public LibUserBookId getId() {
        return id;
    }

  

    public void setId(LibUserBookId id) {
        this.id = id;
    }

  
    public Book getBook() {
        return book;
    }

    

    public void setBook(Book book) {
        this.book = book;
    }

    

    public User getUser() {
        return user;
    }

    

    public void setUser(User user) {
        this.user = user;
    }

    
    public String getAction() {
        return action;
    }

   
    public void setAction(String action) {
        this.action = action;
    }

   
    @Override
    public String toString() {
        return "LibUserBook{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", action='" + action + '\'' +
                '}';
    }

    @Embeddable
    public static class LibUserBookId implements Serializable {

        @Column(name = "book")
        protected Integer bookId;

        @Column(name = "user")
        protected Integer userId;

        public LibUserBookId() {

        }

       
        public LibUserBookId(Integer bookId, Integer userId) {
            System.out.println("book id is ----" + bookId);
            this.bookId = bookId;
            this.userId = userId;
        }

       
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((bookId == null) ? 0 : bookId.hashCode());
            result = prime * result
                    + ((userId == null) ? 0 : userId.hashCode());
            return result;
        }

      
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            LibUserBookId other = (LibUserBookId) obj;

            if (bookId == null) {
                if (other.bookId != null)
                    return false;
            } else if (!bookId.equals(other.bookId))
                return false;

            if (userId == null) {
                if (other.userId != null)
                    return false;
            } else if (!userId.equals(other.userId))
                return false;

            return true;
        }
    }
}

package com.spring.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_BOOK_CART")
public class UserBookCart {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "BOOK_ID")
    private int book_id;

    @Column(name = "TYPE_RETURN")
    private int type_return;

   
    public UserBookCart() {
    }

    
    public UserBookCart(int user_id, int book_id, int type_return) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.type_return = type_return;
    }

    
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    
    public int getUser_id() {
        return user_id;
    }

    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

   
    public int getType_return() {
        return type_return;
    }

   
    public void setType_return(int type_return) {
        this.type_return = type_return;
    }
}

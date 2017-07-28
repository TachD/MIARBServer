package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clPost implements Serializable {
    private int id;

    private String postTitle;

    private String orderName;

    private Date orderDate;

    private Date factualDate;

    public clPost() {

    }

    public clPost(int id, String postTitle, String orderName, Date orderDate, Date factualDate) {
        this.id = id;
        this.postTitle = postTitle;
        this.orderDate = orderDate;
        this.orderName = orderName;
        this.factualDate = factualDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getFactualDate() {
        return factualDate;
    }

    public void setFactualDate(Date factualDate) {
        this.factualDate = factualDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clPost post = (clPost) o;

        if (id != post.id) return false;
        if (postTitle != null ? !postTitle.equals(post.postTitle) : post.postTitle != null) return false;
        if (orderName != null ? !orderName.equals(post.orderName) : post.orderName != null) return false;
        if (orderDate != null ? !orderDate.equals(post.orderDate) : post.orderDate != null) return false;
        return factualDate != null ? factualDate.equals(post.factualDate) : post.factualDate == null;
    }
}
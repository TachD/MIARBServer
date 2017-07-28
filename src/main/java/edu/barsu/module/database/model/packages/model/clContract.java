package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clContract implements Serializable {
    private int id;

    private String orderName;

    private Date orderDate;

    private Date endDate;

    public clContract() {
    }

    public clContract(int id, String orderName, Date orderDate, Date endDate) {
        this.id = id;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clContract that = (clContract) o;

        if (id != that.id) return false;
        if (orderName != null ? !orderName.equals(that.orderName) : that.orderName != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }
}
package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clRank implements Serializable {
    private int id;

    private String rankTitle;

    private String orderName;

    private Date orderDate;

    private Date factualDate;

    private Date  newRankDate;

    public clRank() {
    }

    public clRank(int id, String rankTitle, String orderName, Date orderDate, Date factualDate, Date newRankDate) {
        this.id = id;
        this.rankTitle = rankTitle;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.factualDate = factualDate;
        this.newRankDate = newRankDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String tankTitle) {
        this.rankTitle = tankTitle;
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

    public void setNewRankDate(Date newRankDate) {
        this.newRankDate = newRankDate;
    }

    public Date getNewRankDate() {
        return newRankDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clRank rank = (clRank) o;

        if (id != rank.id) return false;
        if (rankTitle != null ? !rankTitle.equals(rank.rankTitle) : rank.rankTitle != null) return false;
        if (orderName != null ? !orderName.equals(rank.orderName) : rank.orderName != null) return false;
        if (orderDate != null ? !orderDate.equals(rank.orderDate) : rank.orderDate != null) return false;
        if (factualDate != null ? !factualDate.equals(rank.factualDate) : rank.factualDate != null) return false;
        return newRankDate != null ? newRankDate.equals(rank.newRankDate) : rank.newRankDate == null;
    }
}
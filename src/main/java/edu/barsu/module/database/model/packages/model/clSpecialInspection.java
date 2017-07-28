package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;

public class clSpecialInspection implements Serializable {
    private int id;

    private String specialInspectionDate;

    public clSpecialInspection() {
    }

    public clSpecialInspection(int id, String specialInspectionDate) {
        this.id = id;
        this.specialInspectionDate = specialInspectionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialInspectionDate() {
        return specialInspectionDate;
    }

    public void setSpecialInspectionDate(String specialInspectionDate) {
        this.specialInspectionDate = specialInspectionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clSpecialInspection that = (clSpecialInspection) o;

        if (id != that.id) return false;
        return specialInspectionDate != null ? specialInspectionDate.equals(that.specialInspectionDate) : that.specialInspectionDate == null;
    }
}
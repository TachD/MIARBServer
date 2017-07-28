package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;

public class clDepartament implements Serializable {
    private int id;

    private String departamentTitle;

    public clDepartament() {
    }

    public clDepartament(int id, String departamentTitle) {
        this.id = id;
        this.departamentTitle = departamentTitle;
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getDepartamentTitle() {
        return departamentTitle;
    }

    public final void setDepartamentTitle(String departamentTitle) {
        this.departamentTitle = departamentTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clDepartament that = (clDepartament) o;

        if (id != that.id) return false;
        return departamentTitle != null ? departamentTitle.equals(that.departamentTitle) : that.departamentTitle == null;
    }
}
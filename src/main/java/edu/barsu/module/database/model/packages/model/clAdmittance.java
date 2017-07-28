package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clAdmittance implements Serializable {
    private int id;

    private String admittanceTitle;

    private Date dateGetting;

    private Date dateEnding;

    public clAdmittance() {}

    public clAdmittance(int id, String admittanceTitle, Date dateGetting, Date dateEnding) {
        this.id = id;
        this.admittanceTitle = admittanceTitle;
        this.dateGetting = dateGetting;
        this.dateEnding = dateEnding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public final String getAdmittanceTitle() {
        return admittanceTitle;
    }

    public final void setAdmittanceTitle(String admittanceTitle) {
        this.admittanceTitle = admittanceTitle;
    }

    public final Date getDateGetting() {
        return dateGetting;
    }

    public final void setDateGetting(Date dateGetting) {
        this.dateGetting = dateGetting;
    }

    public final Date getDateEnding() {
        return dateEnding;
    }

    public final void setDateEnding(Date dateEnding) {
        this.dateEnding = dateEnding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clAdmittance that = (clAdmittance) o;

        if (id != that.id) return false;
        if (admittanceTitle != null ? !admittanceTitle.equals(that.admittanceTitle) : that.admittanceTitle != null)
            return false;
        if (dateGetting != null ? !dateGetting.equals(that.dateGetting) : that.dateGetting != null) return false;
        return dateEnding != null ? dateEnding.equals(that.dateEnding) : that.dateEnding == null;
    }
}
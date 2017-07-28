package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clAppraisal implements Serializable {
    private int id;

    private String performanceAppraisalResult;

    private String nextPerformanceAppraisalDate;

    private Date performanceAppraisalDate;

    public clAppraisal() {
    }

    public clAppraisal(int id, String performanceAppraisalResult,
                       String nextPerformanceAppraisalDate, Date performanceAppraisalDate) {
        this.id = id;
        this.performanceAppraisalResult = performanceAppraisalResult;
        this.nextPerformanceAppraisalDate = nextPerformanceAppraisalDate;
        this.performanceAppraisalDate = performanceAppraisalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public final String getPerformanceAppraisalResult() {
        return performanceAppraisalResult;
    }

    public final void setPerformanceAppraisalResult(String performanceAppraisalResult) {
        this.performanceAppraisalResult = performanceAppraisalResult;
    }

    public final String getNextPerformanceAppraisalDate() {
        return nextPerformanceAppraisalDate;
    }

    public final void setNextPerformanceAppraisalDate(String nextPerformanceAppraisalDate) {
        this.nextPerformanceAppraisalDate = nextPerformanceAppraisalDate;
    }

    public final Date getPerformanceAppraisalDate() {
        return performanceAppraisalDate;
    }

    public final void setPerformanceAppraisalDate(Date performanceAppraisalDate) {
        this.performanceAppraisalDate = performanceAppraisalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clAppraisal appraisal = (clAppraisal) o;

        if (id != appraisal.id) return false;
        if (performanceAppraisalResult != null ? !performanceAppraisalResult.equals(appraisal.performanceAppraisalResult) : appraisal.performanceAppraisalResult != null)
            return false;
        if (nextPerformanceAppraisalDate != null ? !nextPerformanceAppraisalDate.equals(appraisal.nextPerformanceAppraisalDate) : appraisal.nextPerformanceAppraisalDate != null)
            return false;
        return performanceAppraisalDate != null ? performanceAppraisalDate.equals(appraisal.performanceAppraisalDate) : appraisal.performanceAppraisalDate == null;
    }
}
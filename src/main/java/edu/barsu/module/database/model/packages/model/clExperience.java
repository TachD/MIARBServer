package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clExperience implements Serializable {
    private int id;

    private String experienceTitle;

    private Date armyStart;

    private Date armyEnd;

    public clExperience() {
    }

    public clExperience(int id, String experienceTitle, Date armyStart, Date armyEnd) {
        this.id = id;
        this.experienceTitle = experienceTitle;
        this.armyStart = armyStart;
        this.armyEnd = armyEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperienceTitle() {
        return experienceTitle;
    }

    public void setExperienceTitle(String experienceTitle) {
        this.experienceTitle = experienceTitle;
    }

    public Date getArmyStart() {
        return armyStart;
    }

    public void setArmyStart(Date armyStart) {
        this.armyStart = armyStart;
    }

    public Date getArmyEnd() {
        return armyEnd;
    }

    public void setArmyEnd(Date armyEnd) {
        this.armyEnd = armyEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clExperience that = (clExperience) o;

        if (id != that.id) return false;
        if (experienceTitle != null ? !experienceTitle.equals(that.experienceTitle) : that.experienceTitle != null)
            return false;
        if (armyStart != null ? !armyStart.equals(that.armyStart) : that.armyStart != null) return false;
        return armyEnd != null ? armyEnd.equals(that.armyEnd) : that.armyEnd == null;
    }
}
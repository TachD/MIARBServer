package edu.barsu.module.database.model.packages.model;

import java.io.Serializable;
import java.sql.Date;

public class clEmployee implements Serializable {
    private static final long serialVersionUID = 1113799434508676095L;

    private int id;

    private String surName;

    private String name;

    private String middleName;

    private String individualNumber;

    private String fileNumber;

    private String education;

    private Date dob;

    private clAdmittance admittance;

    private clAppraisal appraisal;

    private clContract contract;

    private clDepartament departament;

    private clExperience experience;

    private clPost post;

    private clRank rank;

    private clSpecialInspection specialInspection;

    public clEmployee() {
    }

    public clEmployee(int id, String surName, String name, String middleName, String individualNumber,
                      String fileNumber, String education, Date dob, clAdmittance admittance,
                      clAppraisal appraisal, clContract contract, clDepartament departament,
                      clExperience experience, clPost post, clRank rank, clSpecialInspection specialInspection) {
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.middleName = middleName;
        this.individualNumber = individualNumber;
        this.fileNumber = fileNumber;
        this.education = education;
        this.dob = dob;
        this.admittance = admittance;
        this.appraisal = appraisal;
        this.contract = contract;
        this.departament = departament;
        this.experience = experience;
        this.post = post;
        this.rank = rank;
        this.specialInspection = specialInspection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(String individualNumber) {
        this.individualNumber = individualNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public clAdmittance getAdmittance() {
        return admittance;
    }

    public void setAdmittance(clAdmittance admittance) {
        this.admittance = admittance;
    }

    public clAppraisal getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(clAppraisal appraisal) {
        this.appraisal = appraisal;
    }

    public clContract getContract() {
        return contract;
    }

    public void setContract(clContract contract) {
        this.contract = contract;
    }

    public clDepartament getDepartament() {
        return departament;
    }

    public void setDepartament(clDepartament departament) {
        this.departament = departament;
    }

    public clExperience getExperience() {
        return experience;
    }

    public void setExperience(clExperience experience) {
        this.experience = experience;
    }

    public clPost getPost() {
        return post;
    }

    public void setPost(clPost post) {
        this.post = post;
    }

    public clRank getRank() {
        return rank;
    }

    public void setRank(clRank rank) {
        this.rank = rank;
    }

    public clSpecialInspection getSpecialInspection() {
        return specialInspection;
    }

    public void setSpecialInspection(clSpecialInspection specialInspection) {
        this.specialInspection = specialInspection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clEmployee employee = (clEmployee) o;

        if (id != employee.id) return false;
        if (surName != null ? !surName.equals(employee.surName) : employee.surName != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (middleName != null ? !middleName.equals(employee.middleName) : employee.middleName != null) return false;
        if (individualNumber != null ? !individualNumber.equals(employee.individualNumber) : employee.individualNumber != null)
            return false;
        if (fileNumber != null ? !fileNumber.equals(employee.fileNumber) : employee.fileNumber != null) return false;
        if (education != null ? !education.equals(employee.education) : employee.education != null) return false;
        if (dob != null ? !dob.equals(employee.dob) : employee.dob != null) return false;
        if (admittance != null ? !admittance.equals(employee.admittance) : employee.admittance != null) return false;
        if (appraisal != null ? !appraisal.equals(employee.appraisal) : employee.appraisal != null) return false;
        if (contract != null ? !contract.equals(employee.contract) : employee.contract != null) return false;
        if (departament != null ? !departament.equals(employee.departament) : employee.departament != null)
            return false;
        if (experience != null ? !experience.equals(employee.experience) : employee.experience != null) return false;
        if (post != null ? !post.equals(employee.post) : employee.post != null) return false;
        if (rank != null ? !rank.equals(employee.rank) : employee.rank != null) return false;
        return specialInspection != null ? specialInspection.equals(employee.specialInspection) : employee.specialInspection == null;
    }
}
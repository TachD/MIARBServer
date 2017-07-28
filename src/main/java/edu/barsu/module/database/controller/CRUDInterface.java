package edu.barsu.module.database.controller;

import edu.barsu.module.database.model.packages.model.clEmployee;

import java.util.List;

public interface CRUDInterface {
    void addNew(clEmployee newRecord) throws Exception;

    List read() throws Exception;

    void edit(clEmployee editCriterions) throws Exception;

    void del(clEmployee deleteCriterions) throws Exception;
}

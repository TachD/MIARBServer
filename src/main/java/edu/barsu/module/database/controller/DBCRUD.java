package edu.barsu.module.database.controller;

import com.intersys.objects.*;

import edu.barsu.module.database.Util;

import edu.barsu.module.database.model.packages.model.clEmployee;
import edu.barsu.module.database.model.packages.structure.DepartamentSet;
import edu.barsu.module.database.model.packages.structure.clStructDepartament;
import model.*;

import javafx.scene.control.Alert;
import model.Departament;
import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DBCRUD implements CRUDInterface {
    private Database dbConn;

    private byte accessDenied;

    public DBCRUD(String URLConnection, String login, String password) {
        Locale.setDefault(Locale.ENGLISH);

        accessDenied = 1;

        try {
            dbConn = CacheDatabase.getDatabase(URLConnection, login, password);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        accessDenied = 0;
    }

    public final void close() {
        try {
            if (dbConn != null)
                dbConn.close();

            accessDenied = 1;
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
    }

    public final boolean isAccessDenied() {
        return accessDenied == 1;
    }

    public final boolean auth(String login, String password) {
        byte accessSuccess = 0;

        try (CloseableCacheQuery cacheQuery =
                     new CloseableCacheQuery(dbConn, "Select * from users.Users")) {
            try (ResultSet userSet = cacheQuery.execute()) {
                while (userSet.next())
                    if (userSet.getString(2).equals(login))
                        if (userSet.getString(3).equals(password)) {
                            accessSuccess = 1;
                            break;
                        }
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
            e.printStackTrace();
        }

        return accessSuccess != 0;
    }

    @Override
    public  final void addNew(clEmployee newRecord) throws Exception {
        Util.UEmployee.addNew(newRecord, dbConn);
    }

    @Override
    public final List read() throws Exception {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        try (CloseableCacheQuery cacheQuery =
                     new CloseableCacheQuery(dbConn, "Select ID from model.Employee")) {
            try (ResultSet employeeSet = cacheQuery.execute()) {
                while (employeeSet.next())
                    employeeList.add((Employee) Employee.open(dbConn, new Id(employeeSet.getInt(1))));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<clEmployee> clEmployees = new ArrayList<clEmployee>();

        try {
            for (Employee employee : employeeList) {
                clEmployees.add(Util.UEmployee.valueOf(employee));
                dbConn.closeObject(employee.getOref());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clEmployees;
    }

    @Override
    public final void edit(clEmployee data) throws Exception {
        Util.UEmployee.edit(data, dbConn);
    }

    @Override
    public final void del(clEmployee delObject) throws Exception {
        Employee._deleteId(dbConn, new Id(delObject.getId()));

        Admittance._deleteId(dbConn, new Id(delObject.getAdmittance().getId()));
        Appraisal._deleteId(dbConn, new Id(delObject.getAppraisal().getId()));
        Contract._deleteId(dbConn, new Id(delObject.getContract().getId()));
        Departament._deleteId(dbConn, new Id(delObject.getDepartament().getId()));
        Experience._deleteId(dbConn, new Id(delObject.getExperience().getId()));
        Post._deleteId(dbConn, new Id(delObject.getPost().getId()));
        Rank._deleteId(dbConn, new Id(delObject.getRank().getId()));
        SpecialInspection._deleteId(dbConn, new Id(delObject.getSpecialInspection().getId()));
    }

    public final DepartamentSet readStructure() throws Exception {
        ArrayList<clStructDepartament> deprtamentList =
                new ArrayList<clStructDepartament>();

        try (CloseableCacheQuery cacheQuery =
                     new CloseableCacheQuery(dbConn, "Select ID from structure.Departament")) {
            try (ResultSet departamentSet = cacheQuery.execute()) {
                while (departamentSet.next()) {

                    structure.Departament departament =
                            (structure.Departament) structure.Departament.open(
                                    dbConn, new Id(departamentSet.getInt(1)));

                    deprtamentList.add(toStructDepartament(departament));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Util.UDepartamentSet.getDepartamentSet(deprtamentList);
    }

    private clStructDepartament toStructDepartament (structure.Departament departament) throws Exception {
        ArrayList<structure.Post> postList = new ArrayList<structure.Post>();

        try (CloseableCacheQuery postQuery =
                     new CloseableCacheQuery(dbConn, "Select ID from structure.Post " +
                             "WHERE structure.Post.Departament = '" + departament.getId().toString() + "'")) {
            try (ResultSet postSet = postQuery.execute()) {
                while (postSet.next())
                    postList.add((structure.Post) structure.Post.open(dbConn, new Id(postSet.getInt(1))));
            }
        }

        return Util.UStructDepartament.valueOf(departament, postList);
    }
}
package edu.barsu.module.database.model.packages.structure;

import java.io.Serializable;
import java.util.ArrayList;

public class DepartamentSet implements Serializable {
    private ArrayList<clStructDepartament> departamentList;

    public DepartamentSet() {
        departamentList = new ArrayList<clStructDepartament>();
    }

    public DepartamentSet (ArrayList<clStructDepartament> departamentList) {
        this.departamentList = departamentList;
    }

    public void add(clStructDepartament departament) {
        departamentList.add(departament);
    }

    public final String valueOf(int ind) {
        return (departamentList.size() <= ind && ind < 0) ? "" : departamentList.get(ind).getTitle();
    }

    public final int valueOf(String name) {
        for (byte i = 0; i < departamentList.size(); ++i)
            if (departamentList.get(i).getTitle().equals(name))
                return i;

        return -1;
    }

    public final clStructDepartament getDepartament(int ind) {
        return (departamentList.size() <= ind && ind < 0) ? null : departamentList.get(ind);
    }

    public final clStructDepartament getDepartament(String name) {
        for (clStructDepartament departament: departamentList)
            if (departament.getTitle().equals(name))
                return departament;

        return null;
    }

    public final String[] values() {
        String[] departamentArray = new String[departamentList.size()];
        for (byte i = 0; i < departamentList.size(); ++i)
            departamentArray[i] = departamentList.get(i).getTitle();

        return departamentArray;
    }
}
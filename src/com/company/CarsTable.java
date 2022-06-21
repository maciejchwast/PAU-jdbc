package com.company;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Arrays;

public class CarsTable {
    Get_Items getter = new Get_Items();
    Logger logger = new Logger("Cars table");
    String[] columnNames = {"ID","Marka","Model","Nazwisko wlasciciela"};
    String[][] data;
    ResultSet resultSet;
    public void populateTable(){
        try {
            resultSet = getter.getTable("samochody");
            data = new String[getter.getRecordCount("samochody")][4];
            int iterator = 0;
            while (resultSet.next()){
                data[iterator][0] = String.valueOf(resultSet.getInt(1));
                data[iterator][1] = resultSet.getString(2);
                data[iterator][2] = resultSet.getString(3);
                data[iterator][3] = getter.getSpecificItem(Integer.parseInt(resultSet.getString(4)),"klienci",3);
                iterator++;
            }

        }
        catch (Exception e){
            logger.error("Failed!", e);
        }
    }

    public CarsTable(JFrame f){
        logger.info("Loading table");
        populateTable();
        JTable jt = new JTable(data,columnNames);
        //jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(1000,600);
        f.setVisible(true);
        logger.info("Loading done!");
    }

    public void reload(JFrame f){
        logger.info("Rereloading table");
        Arrays.fill(data,null);
        populateTable();
        JTable jt = new JTable(data,columnNames);
        //jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(1000,600);
        f.setVisible(true);
        logger.info("Reloading done!");
    }
}

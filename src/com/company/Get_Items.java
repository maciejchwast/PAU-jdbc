package com.company;

import java.sql.ResultSet;
import java.sql.Statement;

public class Get_Items {
    Logger logger = new Logger("Get Items");
    ResultSet resultSet;
    Statement statement;
    Manager manager = new Manager();
    public int getRecordCount(String table){
        try{
            logger.info("Get record count called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            resultSet =  statement.executeQuery("SELECT COUNT(*) FROM "+table);
            resultSet.next();
            int result = resultSet.getInt(1);
            logger.info("Got "+result+" records");
            return result;

        }
        catch (Exception e) {
            logger.error("Failed!", e);
            resultSet = null;
            return 0;
        }
    }

    public ResultSet getTable(String table){
        try{
            logger.info("Get table called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            resultSet =  statement.executeQuery("SELECT * FROM "+table);
            return resultSet;

        }
        catch (Exception e) {
            logger.error("Failed!", e);
            resultSet = null;
            return resultSet;
        }
    }

    public ResultSet getRecordById(int id, String table){
        logger.info("Get record by id called");

        try{
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            resultSet =  statement.executeQuery("SELECT * FROM "+table+" WHERE id="+String.valueOf(id));
            return resultSet;
        }
        catch (Exception e){
            logger.error("Failed!", e);
            resultSet = null;
            return resultSet;
        }
    }

    public String getSpecificItem(int id, String table, int column){
        logger.info("Get specific item called");

        resultSet = getRecordById(id, table);
        try {
            manager.connect();
            logger.info("Connection established");
            resultSet.next();
            return resultSet.getString(column);
        }
        catch (Exception e){
            logger.error("Failed!", e);
            return "";
        }
    }

 }

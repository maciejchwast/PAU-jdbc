package com.company;

import java.sql.Statement;

public class RemoveItem {

    Logger logger = new Logger("Remove item");
    Statement statement;
    Manager manager = new Manager();

    public void removeClient(int id){
        try{
            logger.info("Remove client called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            statement.executeUpdate("DELETE FROM `klienci` WHERE id="+id);
        }
        catch (Exception e) {
            logger.error("Failed!", e);
        }
    }

    public void removeCar(int id){
        try{
            logger.info("Remove car called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            statement.executeUpdate("DELETE FROM `samochody` WHERE id="+id);
        }
        catch (Exception e) {
            logger.error("Failed!", e);
        }
    }
}

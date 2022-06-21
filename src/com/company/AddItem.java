package com.company;

import java.sql.Statement;

public class AddItem {
    Logger logger = new Logger("Add Items");
    Statement statement;
    Manager manager = new Manager();

    public void addClient(String name, String lastname){
        try{
            logger.info("Add client called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            statement.executeUpdate("INSERT INTO `klienci` (`id`, `imie`, `nazwisko`) VALUES (NULL,'"+name+"', '"+lastname+"')");
           }
        catch (Exception e) {
            logger.error("Failed!", e);
        }
    }

    public void addCar(String marka, String model, int owner){
        try{
            logger.info("Add car called");
            manager.connect();
            logger.info("Connection established");
            statement = manager.connection.createStatement();
            statement.executeUpdate("INSERT INTO `samochody` (`id`, `marka`, `model`, `id_wlasciciela`) VALUES (NULL,'"+marka+"', '"+model+"', '"+owner+"')");
        }
        catch (Exception e) {
            logger.error("Failed!", e);
        }
    }
}

package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class Manager {
    Logger logger = new Logger("Connection manager");
    String url = "jdbc:mysql://mysql.agh.edu.pl:3306/maciejch";
    String username = "maciejch";
    String password = "YqAuZphDTEwr0ak6";
    Connection connection;
    public Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             connection = DriverManager.getConnection(url,username,password);
        }
        catch(Exception e){
            logger.error("Failed!", e);
        }
        return connection;
    }
    public void disconnect(){
        try {
            connection.close();
            logger.info("Connection closed");

        }
        catch (Exception e){
            logger.error("Failed!", e);
        }
    }
}

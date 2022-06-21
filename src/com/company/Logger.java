package com.company;

public class Logger {
    String name;

    public Logger(String name) {
        this.name = name;
    }

    public void info(String message){
        System.out.println("[LOGINFO] "+name+" logger: "+message);
    }

    public void error(String message, Exception e){
        System.out.println("[LOGERROR] "+name+" logger: "+message+" "+e.toString());

    }
}

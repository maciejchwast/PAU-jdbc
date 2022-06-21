package com.company;

import javax.swing.*;
import java.awt.*;

public class WindowLayout {
    JFrame f = new JFrame("Warsztat samochodowy");
    WindowLayout(){
        f.setSize(1000,900);
        f.setVisible(true);
        f.setLayout(new GridLayout(5,2));
        Label l1 = new Label("Klienci",f);
        Button newClient = new Button("Nowy klient", f);
        ClientTable clt = new ClientTable(f);
        Button delClient = new Button("Usun klienta", f);
        Label l2 = new Label("Samochody",f);
        Button newCar = new Button("Nowy samochod", f);
        CarsTable crt = new CarsTable(f);
        Button delCar = new Button("Usun samochod", f);
        Button reset = new Button("Reload", f);

        reset.actionListenerReset(clt,crt, l1, l2, newClient, delClient, newCar, delCar);
        newClient.actionListenerNewClient();
        newCar.actionListenerNewCar();
        delClient.actionListenerRmClient();
        delCar.actionListenerRmCar();
    }
}

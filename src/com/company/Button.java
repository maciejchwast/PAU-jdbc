package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class Button {
    String text;
    JFrame frame;
    JButton button;
    AddItem addItem = new AddItem();
    RemoveItem removeItem = new RemoveItem();
    Logger logger = new Logger("Action logger");

    public Button(String text, JFrame frame) {
        this.text = text;
        this.frame = frame;
        this.button = new JButton(text);
        button.setBounds(50, 50, 150, 30);
        frame.add(button);
    }
    public void actionListenerReset(ClientTable t1, CarsTable t2, Label l1, Label l2, Button b1, Button b2, Button b3, Button b4){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                l1.reload();
                frame.add(b1.button);
                t1.reload(frame);
                frame.add(b2.button);
                l2.reload();
                frame.add(b3.button);
                t2.reload(frame);
                frame.add(b4.button);
                frame.add(button);

            }
        });
    }
    public void actionListenerNewClient(){
        Scanner scn = new Scanner(System.in);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Podaj imie nowego klienta: ");
                String name = scn.nextLine();
                System.out.println("Podaj nazwisko nowego klienta: ");
                String lastname = scn.nextLine();
                addItem.addClient(name,lastname);
                logger.info("New client created");
            }
        });

    }
    public void actionListenerNewCar(){
        Scanner scn = new Scanner(System.in);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Podaj marke nowego samochodu: ");
                String model = scn.nextLine();
                System.out.println("Podaj model nowego samochodu: ");
                String marka = scn.nextLine();
                System.out.println("Podaj id wlasciciela: ");
                int id = Integer.parseInt(scn.nextLine());
                addItem.addCar(model,marka, id);
                logger.info("New car created");

            }
        });

    }
    public void actionListenerRmClient(){
        Scanner scn = new Scanner(System.in);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Podaj id klienta do usuniecia: ");
                String id = scn.nextLine();
                removeItem.removeClient(Integer.parseInt(id));
                logger.info("Client removed");
            }
        });

    }

    public void actionListenerRmCar(){
        Scanner scn = new Scanner(System.in);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Podaj id samochodu do usuniecia: ");
                String id = scn.nextLine();
                removeItem.removeCar(Integer.parseInt(id));
                logger.info("Car removed");
            }
        });

    }
}

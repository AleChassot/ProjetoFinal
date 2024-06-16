package org.example.entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayRentAction extends JFrame {

    private JButton alugar = new JButton("Alugar carros");
    private JButton ver_carros = new JButton("Ver carros Disponíveis");
    private JButton adicionar = new JButton("Adicionar carros");
    private JButton sair = new JButton("Sair");

    public DisplayRentAction(){
        setLayout(null);
        setVisible(true);
        setTitle("Alugar Carros");
        setSize(1200, 700);

        alugar.setSize(300, 70);
        alugar.setVisible(true);
        alugar.setLocation(0, 0);
        getContentPane().add(alugar);

        ver_carros.setSize(300, 70);
        ver_carros.setVisible(true);
        ver_carros.setLocation(300, 0);
        getContentPane().add(ver_carros);

        adicionar.setSize(300, 70);
        adicionar.setVisible(true);
        adicionar.setLocation(600, 0);
        getContentPane().add(adicionar);

        sair.setSize(300, 70);
        sair.setVisible(true);
        sair.setLocation(900, 0);
        getContentPane().add(sair);

        alugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayRentAction();
            }
        });
    }
}


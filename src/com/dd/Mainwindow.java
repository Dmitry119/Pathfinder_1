/**
 *  Реализовать поиск пути по алгоритму "поиск в ширину".
 */


package com.dd;

import javax.swing.*;

public class Mainwindow extends JFrame {

    public Mainwindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1007, 1030); // dont change!
        setResizable(false);
        add(new Field());
        setVisible(true);
    }

    public static void main(String[] args) {

        Mainwindow mainwindow = new Mainwindow();

    }
}

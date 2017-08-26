package com.dd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Field extends JPanel implements MouseListener {

    private int squadSize = 10;
    private squad[][] squads = new squad[100][100];
    private boolean mouseButtonPressed;
    private boolean[][] matrix = new boolean[100][100]; // матрица смежности


    public Field(){

        init();

        addMouseListener(this);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { // движение мыши с зажатой кнопкой
                super.mouseMoved(e);

                chooseSquad(e);
            }
        });

    }

    public void init(){

        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {

                squads[i][j] = new squad(i*squadSize, j*squadSize);

            }

        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for (int i = 0; i < 100; i ++) {

            for (int j = 0; j < 100; j ++) {

                if (squads[i][j].isClicked()) {
                    g.setColor(Color.red);
                    g.fillRect(squads[i][j].getX(), squads[i][j].getY(), squadSize, squadSize);
                } else {
                    g.setColor(Color.gray);
                    g.fillRect(squads[i][j].getX(), squads[i][j].getY(), squadSize, squadSize);
                }

                g.setColor(Color.black);
                g.drawRect(squads[i][j].getX(), squads[i][j].getY(), squadSize, squadSize);

                g.setColor(Color.blue); // start of the path TODO: сделай что бы это не перекрашивались
                g.fillRect(squads[10][50].getX(), squads[10][50].getY(), squadSize, squadSize);

                g.setColor(Color.green); // end of the path TODO: сделай что бы это не перекрашивались
                g.fillRect(squads[90][50].getX(), squads[90][50].getY(), squadSize, squadSize);

            }

        }

    }


    @Override
    public void mousePressed(MouseEvent e) {

        mouseButtonPressed = true;

        chooseSquad(e);
        

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        mouseButtonPressed = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }




    class squad{
        int x, y;

        boolean isClicked = false;

        public squad(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isClicked() {
            return isClicked;
        }

        public void setClicked(boolean clicked) {
            isClicked = clicked;
        }
    }

    public void chooseSquad(MouseEvent e){

        int x,y;
        x = e.getX();
        y = e.getY();

        squads[Math.round(x / squadSize)][y / squadSize].setClicked(true);
        matrix[Math.round(x / squadSize)][y / squadSize] = true;

        repaint();
    }

    public void printMatrix(){

        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {
                if (matrix[j][i]) System.out.print("1"); // тут почему-то надо сначала j потом i в индексе, но зато работает норм.
                else System.out.print("0");
            }
            System.out.println();

        }

        System.out.println("\n\n\n\n\n");
    }


}

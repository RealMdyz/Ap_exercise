package View;


import Model.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputListener {


    InputMap inputMap;
    ActionMap actionMap;
    GameFrame gameFrame;


    public int[] b = new int[2];
    public InputListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        createMouseAction();
    }
    public void createMouseAction() {

        gameFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                Point mousePoint = evt.getPoint();
                b[0] = mousePoint.x;
                b[1] = mousePoint.y;
                gameFrame.onMove = true;
            }
        });

    }

}
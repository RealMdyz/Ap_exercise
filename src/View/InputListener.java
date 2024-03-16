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

    Ball Mainball;

    public InputListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        createMouseAction();
    }
    public void createMouseAction() {
        gameFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                Point mousePoint = evt.getPoint();
                if(mousePoint.y > 650)
                    return;
                double angle = Math.atan2(mousePoint.y - Mainball.getY(), mousePoint.x - Mainball.getX());
                double velocityX = Math.cos(angle) * 5; // Adjust the velocity as needed
                double velocityY = Math.sin(angle) * 5; // Adjust the velocity as needed
                Mainball.setxVelocity((int)velocityX);
                Mainball.setyVelocity((int)velocityY);
               gameFrame.addInThisState = false;
               gameFrame.onMove = true;
            }
        });
    }

    public Ball getMainball() {
        return Mainball;
    }

    public void setMainball(Ball mainball) {
        Mainball = mainball;
    }
}
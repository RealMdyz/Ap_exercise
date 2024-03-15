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

    Ball ball;

    public InputListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        ball = gameFrame.getBall();
        createMouseAction();
    }
    private void createMouseAction() {
        gameFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                Point mousePoint = evt.getPoint();
                if(mousePoint.y > 650)
                    return;
                double angle = Math.atan2(mousePoint.y - ball.getY(), mousePoint.x - ball.getX());
                double velocityX = Math.cos(angle) * 5; // Adjust the velocity as needed
                double velocityY = Math.sin(angle) * 5; // Adjust the velocity as needed
                ball.setxVelocity((int)velocityX);
                ball.setyVelocity((int)velocityY);
               gameFrame.isMoveBall = true;
            }
        });
    }


}
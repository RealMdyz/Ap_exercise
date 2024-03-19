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


    // Flag to indicate if aim mode is enabled
    private boolean aimModeEnabled = false;


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
                if (aimModeEnabled) {
                    drawAimLine(mousePoint);
                }
            }
        });
        gameFrame.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Point mousePoint = evt.getPoint();
                // If aim mode is enabled, calculate and draw the aim line
                if (aimModeEnabled) {
                    drawAimLine(mousePoint);
                }
            }
        });

    }
    // Method to enable or disable aim mode
    public void setAimModeEnabled(boolean enabled) {
        aimModeEnabled = enabled;
    }

    // Method to draw the aim line from mouse to ball
    private void drawAimLine(Point mousePoint) {
        Graphics2D g2d = (Graphics2D) gameFrame.getGraphics();
        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set the color and transparency of the aim line
        g2d.setColor(new Color(255, 0, 0, 128)); // Red color with 50% transparency
        // Draw the aim line
        g2d.setStroke(new BasicStroke(2)); // Set the line thickness
        g2d.drawLine(mousePoint.x, mousePoint.y, gameFrame.getBalls().getFirst().getX() + gameFrame.getBalls().getFirst().getWidth() / 2,
                gameFrame.getBalls().getFirst().getY() + gameFrame.getBalls().getFirst().getHeight() / 2);
        // Dispose the graphics object to release resources
        g2d.dispose();
    }
}
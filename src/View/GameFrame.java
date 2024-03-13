package View;

import Model.Ball;
import Model.Block;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {


    BackGroundPanel backGroundPanel;

    private final static int BallStartX = 270;
    private final static int BallStartY = 50;
    JPanel panel;
    JPanel gamePanel;
    Ball ball;
    public int CountOFBalls = 1;
    private ArrayList<Block> blocks = new ArrayList<>();


    public GameFrame(){
        setTitle("Bricks Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        backGroundPanel = new BackGroundPanel();
        backGroundPanel.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 600, 800);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);

        gamePanel = new JPanel();
        gamePanel.setBounds(0,0, 600, 800);
        gamePanel.setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.requestFocusInWindow();
        gamePanel.setLayout(null);
        gamePanel.setOpaque(false);

        panel.add(gamePanel);
        panel.add(backGroundPanel);

        ball = new Ball(BallStartX, BallStartY);
        ball.setLayout(null);
        gamePanel.add(ball);

    }
}

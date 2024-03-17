package View;

import Model.Ball;
import Model.Block;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class GameFrame extends JFrame {


    BackGroundPanel backGroundPanel;

    private final static int BallStartX = 270;
    private final static int BallStartY = 650;
    public final static int MaxNumberOFballs = 50;

    JPanel panel;
    JPanel gamePanel;
    Ball ball;
    public int CountOFBalls = 1;
    public boolean onMove = false;
    public boolean addInThisState = false;

    public boolean Stop = false;
    public int Level = 0;
    public int Point = 0;
    private JLabel pointsLabel;

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Ball>  balls = new ArrayList<>();

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

        pointsLabel = new JLabel("Points: " + Point);
        pointsLabel.setBounds(500, 700, 100, 50);
        panel.add(pointsLabel);

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

        gamePanel.repaint();
    }

    public void AddballsToPanel(){
        for(Ball ball1 : balls){
            gamePanel.add(ball1);
        }
        gamePanel.repaint();
    }
    public void AddBlocksToPanel(){
        for(Block block : blocks){
            gamePanel.add(block);
        }
        gamePanel.repaint();
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void addRandomBlock(){
        int Cnt = (Level / 50) + 1;
        Level += 1;
        int x = 0;
        for(int i = 0; i < Cnt; i++){
            int u = (int)(Math.random() * 5);
            x += (u * 50);
            Block block = new Block(x, 0, Level);
            blocks.add(block);
            gamePanel.add(block);
        }

    }
    public void addball(int x, int y){
        Ball ball1 = new Ball(x, y);
        ball1.setLayout(null);
        balls.add(ball1);

    }
    public void removeBall(Block block) {
        block.remove(block);
        gamePanel.remove(block);
        gamePanel.repaint();
    }

    // Implement collision detection and point increase here
    // This method should be called when collision occurs
    public void handleCollision(Block block) {
        // Reduce block power
        block.reducePower();

        // Increase points
        Point++;

        // Update points label
        pointsLabel.setText("Points: " + Point);

        // Check if the ball's power reaches zero
        if (block.getPower() <= 0) {
            removeBall(block);
        }
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public void RmB(Block block){
        this.blocks.remove(block);
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }
}

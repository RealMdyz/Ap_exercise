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

    JPanel panel;
    JPanel gamePanel;
    Ball ball;
    public int CountOFBalls = 1;
    public boolean isMoveBall = false;
    public int Level = 0;
    public int Point = 0;

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
            u = 0;
            x += (u * 50);
            Block block = new Block(x, 0, Level);
            blocks.add(block);
            gamePanel.add(block);
        }

    }
    public void removeBlock(){
        for(int i = 0; i < 200; i++){
            Block block1 = new Block(0, 0, 0);
            for(Block block : blocks){
                if(block.Power == 0){
                    block1 = block;
                }
            }
            blocks.remove(block1);
        }
        return;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }
}

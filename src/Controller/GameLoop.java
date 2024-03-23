package Controller;

import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class GameLoop extends Thread{

    private Game game;
    private int HowManyBallShouldAdd = 0;

    int BadAimLevel = -2;
    long startTime_For_Red = -20000;
    long startTime_For_Green = -20000;
    private int Last = 0;

    private int Joooon = 1;
    public GameLoop(Game game){
        this.game = game;
    }
    public void run() {
        while (game.isGameRunning()) {
            update();
        }

    }
    private void update() {
        game.getGameFrame().AddBlocksToPanel();
        game.getGameFrame().AddballsToPanel();
        if(game.getGameFrame().Aim && game.getGameFrame().Stop){
            if(game.getGameFrame().Level - BadAimLevel <= 1){
                game.getInputListener().setRandomAim(true);
            }
            else{
                game.getInputListener().setRandomAim(false);
                game.getInputListener().setAimModeEnabled(true);
            }
        }
        else {
            game.getInputListener().setAimModeEnabled(false);
        }
        if(!game.getGameFrame().onMove){
            if(!game.getGameFrame().addInThisState){
                if(Joooon == 0)
                    game.getGameFrame().resetGame();
                for (Block block : game.getGameFrame().getBlocks()) {
                    block.move();
                    if(block.getY() >= 550)
                        Joooon -= 1;
                }
                for (SpecialItem specialItem : game.getGameFrame().getSpecialItems()) {
                    specialItem.move();
                    if(specialItem.getY() >= 650 )
                        Joooon -= 1;
                }
                for(UsualItem itemBall : game.getGameFrame().getItemBalls()){
                    itemBall.move();
                }
                game.getGameFrame().addInThisState = true;
                game.getGameFrame().Stop = true;
                if(game.getGameFrame().getBalls().size() == 0){
                    for(int q = 0; q < HowManyBallShouldAdd + 1; q++)
                        game.getGameFrame().addball(270, 650);
                }
                else {
                    for(Ball ball : game.getGameFrame().getBalls()){
                        ball.setY(game.getGameFrame().getBalls().getFirst().getY());
                        ball.setX(game.getGameFrame().getBalls().getFirst().getX());
                    }
                    for(int q = 0; q < HowManyBallShouldAdd + 1; q++)
                        game.getGameFrame().addball(game.getGameFrame().getBalls().getFirst().getX(), game.getGameFrame().getBalls().getFirst().getY());
                }
                HowManyBallShouldAdd = 0;

                game.getGameFrame().addRandomBlock();
                game.getGameFrame().repaint();

            }

        }
        else {

            game.getGameFrame().repaint();
            int X, Y;
            X = Y = 0;
            if(game.getGameFrame().Stop){
                ArrayList<Ball> ballsCopy = new ArrayList<>(game.getGameFrame().getBalls());
                for (Ball ball : ballsCopy) {
                    ball.changeBallColor(game.getGameFrame().Color);
                }
                game.getGameFrame().repaint();
                X = game.getInputListener().b[0];
                Y = game.getInputListener().b[1];
                for(Ball ball : game.getGameFrame().getBalls()){
                    ball.SetV(X, Y);
                }
                long LastDis = 0;
                game.getGameFrame().Stop = false;
                int u = game.getGameFrame().getBalls().size() * 2;
                game.getGameFrame().getBalls().getFirst().move();
                Last = 0;
            }
            boolean CheckTheEnd = true;
            int j1 = 0;
            for (Ball ball : game.getGameFrame().getBalls()) {
                if(j1 <= Last){
                    X = ball.getX();
                    Y = ball.getY();
                    ball.move();
                }
                if(j1 == Last + 1){
                    double dis = (ball.getX() - X) *  (ball.getX() - X);
                    dis +=  ((ball.getY() - Y) *  (ball.getY() - Y));
                    if(dis >= 100){
                        Last += 1;
                        break;
                    }
                }
                j1 += 1;
                int CountOfRemovedBlock = 0;
                for(Block block : game.getGameFrame().getBlocks()){
                    if(game.getIntersection().intersect(block, ball)){
                        block.reducePower();
                        if(System.currentTimeMillis() - startTime_For_Red < 15000 && block.Power > 0){
                            block.reducePower();
                        }
                        game.getGameFrame().Point += 1;
                        game.getGameFrame(). pointsLabel.setText("Points: " + game.getGameFrame().Point);
                        if(block.Power == 0)
                            CountOfRemovedBlock += 1;
                    }

                }

                for(int i = 0; i < CountOfRemovedBlock;  i++){
                    Block block = new Block(0, 0, -1);
                    for(Block block1 : game.getGameFrame().getBlocks()){
                        if(block1.Power == 0){
                            block = block1;
                        }
                    }
                    if(block.Power == 0)
                        game.getGameFrame().removeBlock(block);
                }

                if (ball.getyVelocity() != 0 || ball.getxVelocity() != 0)
                    CheckTheEnd = false;
                int CountOfRemovedItemBall = 0;
                for(UsualItem itemBall : game.getGameFrame().getItemBalls()){
                    if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("yellow")){
                        itemBall.Power -= 1;
                        HowManyBallShouldAdd += 1;
                        CountOfRemovedItemBall += 1;
                    }
                    else if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("red")){
                        startTime_For_Red = System.currentTimeMillis();
                        itemBall.Power -= 1;
                        CountOfRemovedItemBall += 1;
                    }
                    else if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("green")){
                        startTime_For_Green = System.currentTimeMillis();
                        itemBall.Power -= 1;
                        CountOfRemovedItemBall += 1;
                    }
                    else if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("purple")){
                        BadAimLevel = game.getGameFrame().Level;
                        itemBall.Power -= 1;
                        CountOfRemovedItemBall += 1;
                    }
                    else if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("orange")){
                        itemBall.Power -= 1;
                        CountOfRemovedItemBall += 1;
                        Joooon += 1;
                    }
                    else if(game.getIntersection().intersect(itemBall, ball) && itemBall.Power == 1 && itemBall.COLOR.equals("blue")){
                        itemBall.Power -= 1;
                        CountOfRemovedItemBall += 1;
                        for (Block block : game.getGameFrame().getBlocks()) {
                            block.MoveBack();
                            block.MoveBack();
                        }
                        for (SpecialItem specialItem : game.getGameFrame().getSpecialItems()) {
                            specialItem.MoveBack();
                            specialItem.MoveBack();
                        }
                        for (UsualItem usualItem : game.getGameFrame().getItemBalls()) {
                            usualItem.MoveBack();
                            usualItem.MoveBack();
                        }
                    }
                }

                for(int i = 0; i < CountOfRemovedItemBall ;  i++){
                    UsualItem itemBall = new UsualItem(0, 0, -2, "red");
                    for(UsualItem itemBall1 : game.getGameFrame().getItemBalls()){
                        if(itemBall1.Power == 0){
                            itemBall = itemBall1;
                        }
                    }
                    if(itemBall.Power == 0){
                        game.getGameFrame().removeItemBall(itemBall);
                    }

                }
                int CountOfRemovedSpecialItme = 0;
                for(SpecialItem specialItem : game.getGameFrame().getSpecialItems()){
                    if(game.getIntersection().intersect(specialItem, ball)){
                        specialItem.reducePower();
                        if(System.currentTimeMillis() - startTime_For_Red < 15000 && specialItem.Power > 0){
                            specialItem.reducePower();
                        }
                        game.getGameFrame().Point += 1;
                        game.getGameFrame(). pointsLabel.setText("Points: " + game.getGameFrame().Point);
                        if(specialItem.Power == 0)
                            CountOfRemovedBlock += 1;
                    }

                }
                for(int i = 0; i < CountOfRemovedBlock;  i++){
                    SpecialItem specialItem = new SpecialItem(0, 0, -1, "red");
                    for(SpecialItem specialItem1 : game.getGameFrame().getSpecialItems()){
                        if(specialItem1.Power == 0 && specialItem1.COLOR.equals("red")){
                            specialItem = specialItem1;
                            long startTime = System.currentTimeMillis();
                            int lx = 0;

                            while (System.currentTimeMillis() - startTime < 10000) { // Activate effect for 10 seconds
                                lx += 1;
                                if(lx % 2 == 0){
                                    for (Block block : game.getGameFrame().getBlocks()) {
                                        block.setVisible(false);
                                    }
                                    for(UsualItem usualItem : game.getGameFrame().getItemBalls()){
                                        usualItem.setVisible(false);
                                    }
                                    for(SpecialItem specialItem2 : game.getGameFrame().getSpecialItems()){
                                        specialItem2.setVisible(false);
                                    }
                                }
                                else{
                                    for (Block block : game.getGameFrame().getBlocks()) {
                                        block.setVisible(true);
                                    }
                                    for(UsualItem usualItem : game.getGameFrame().getItemBalls()){
                                        usualItem.setVisible(true);
                                    }
                                    for(SpecialItem specialItem2 : game.getGameFrame().getSpecialItems()){
                                        specialItem2.setVisible(true);
                                    }
                                }
                                for (Ball ball1 : game.getGameFrame().getBalls()) {
                                    ball1.setColor(getRandomColor());
                                }
                                game.getGameFrame().repaint();
                                try {
                                    Thread.sleep(100); // Adjust the speed of the effect here
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            for (Ball ball1 : game.getGameFrame().getBalls()) {
                                ball1.changeBallColor(game.getGameFrame().Color);
                            }
                            for (Block block : game.getGameFrame().getBlocks()) {
                                block.setVisible(true);
                            }
                            for(UsualItem usualItem : game.getGameFrame().getItemBalls()){
                                usualItem.setVisible(true);
                            }
                            for(SpecialItem specialItem2 : game.getGameFrame().getSpecialItems()){
                                specialItem2.setVisible(true);
                            }

                        }
                        else if(specialItem1.Power == 0 && specialItem1.COLOR.equals("purple")){
                            specialItem = specialItem1;
                            // Explosion effect
                            explode(specialItem.getX(), specialItem.getY());
                            double ids = 0;
                            CountOfRemovedBlock = 0;
                            for(Block block : game.getGameFrame().getBlocks()){
                                ids =  (specialItem.getX() - block.getX()) * (specialItem.getX() - block.getX());
                                ids += ((specialItem.getY() - block.getY()) * (specialItem.getY() - block.getY()));
                                if(Math.sqrt(ids) <= 150){
                                    for(int l = 0; l < 50 && block.Power > 0; l++)
                                        block.reducePower();
                                    if(block.Power == 0){
                                        CountOfRemovedBlock += 1;
                                    }
                                }
                            }
                            for(int j = 0; j < CountOfRemovedBlock; j += 1){
                                Block block = new Block(0, 0, -1);
                                for(Block block1 : game.getGameFrame().getBlocks()){
                                    if(block1.Power == 0){
                                        block = block1;
                                    }
                                }
                                if(block.Power == 0)
                                    game.getGameFrame().removeBlock(block);
                            }

                        }
                    }
                    if(specialItem.Power == 0)
                        game.getGameFrame().RemoveSpecialItem(specialItem);
                }

            }

            if(CheckTheEnd){
                game.getGameFrame().onMove = false;
                game.getGameFrame().addInThisState = false;
            }
        }
        if(System.currentTimeMillis() - startTime_For_Green < 15000){
            try {
                Thread.sleep(6);
            }
            catch (Exception e){

            }
        }
        else {
            try {
                Thread.sleep(12);
            }
            catch (Exception e){

            }
        }




    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }
    private void explode(int x, int y) {
        game.getGameFrame().playSound();
    }
}

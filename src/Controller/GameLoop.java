package Controller;

import Model.Ball;
import Model.Block;
import Model.Game;

import java.awt.*;
import java.util.ArrayList;



public class GameLoop extends Thread{

    private Game game;

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
            game.getInputListener().setAimModeEnabled(true);
        }
        else {
            game.getInputListener().setAimModeEnabled(false);
        }
        if(!game.getGameFrame().onMove){
            if(!game.getGameFrame().addInThisState){

                for (Block block : game.getGameFrame().getBlocks()) {
                    block.move();
                }
                game.getGameFrame().addInThisState = true;
                game.getGameFrame().Stop = true;
                if(game.getGameFrame().getBalls().size() == 0){
                    game.getGameFrame().addball(270, 650);
                }
                else {
                    for(Ball ball : game.getGameFrame().getBalls()){
                        ball.setY(game.getGameFrame().getBalls().getFirst().getY());
                        ball.setX(game.getGameFrame().getBalls().getFirst().getX());
                    }
                    game.getGameFrame().addball(game.getGameFrame().getBalls().getFirst().getX(), game.getGameFrame().getBalls().getFirst().getY());
                }

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
                game.getGameFrame().Stop = false;
                int u = game.getGameFrame().getBalls().size() * 5;
                for (Ball ball : game.getGameFrame().getBalls()) {
                    for(int i = 0; i < u; i++){
                        ball.move();
                        game.getGameFrame().repaint();
                    }
                    u -= 5;
                }
            }
            boolean CheckTheEnd = true;
            for (Ball ball : game.getGameFrame().getBalls()) {
                ball.move();
                int CountOfRemovedBlock = 0;
                for(Block block : game.getGameFrame().getBlocks()){
                    if(game.getIntersection().intersect(block, ball)){
                        block.reducePower();
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
            }

            if(CheckTheEnd){
                game.getGameFrame().onMove = false;
                game.getGameFrame().addInThisState = false;
            }
        }

        try {
            Thread.sleep(4);
        }
        catch (Exception e){

        }
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
}

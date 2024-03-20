package Controller;

import Model.Ball;
import Model.Block;
import Model.Game;
import Model.UsualItem;

import java.util.ArrayList;



public class GameLoop extends Thread{

    private Game game;
    private int HowManyBallShouldAdd = 0;

    int BadAimLevel = -2;
    long startTime_For_Red = -20;
    long startTime_For_Green = -20;

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
                    if(block.getY() >= 650 )
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
                    }
                }

                for(int i = 0; i < CountOfRemovedItemBall ;  i++){
                    UsualItem itemBall = new UsualItem(0, 0, -2, "red");
                    for(UsualItem itemBall1 : game.getGameFrame().getItemBalls()){
                        if(itemBall1.Power == 0){
                            itemBall = itemBall1;
                            System.out.println();
                        }
                    }
                    if(itemBall.Power == 0){
                        game.getGameFrame().removeItemBall(itemBall);
                    }

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
}

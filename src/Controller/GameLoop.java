package Controller;

import Model.Ball;
import Model.Block;
import Model.Game;

import java.awt.*;

public class GameLoop extends Thread{

    private Game game;
    int time = 0;

    public GameLoop(Game game){
        this.game = game;
    }
    public void run() {
        while (game.isGameRunning()) {
            update();
        }

    }
    private void update() {
      /*  game.getGameFrame().getBall().move();
        game.getIntersection().intersectBall(game.getGameFrame().getBall());
        if(game.getGameFrame().getBall().getxVelocity() == game.getGameFrame().getBall().getyVelocity() && game.getGameFrame().getBall().getyVelocity() == 0){
            if (game.getGameFrame().isMoveBall) {
                for (Block block : game.getGameFrame().getBlocks()) {
                    block.move();
                }
                game.getGameFrame().addRandomBlock();
                game.getGameFrame().isMoveBall = false;
            }
            game.getGameFrame().addball();

        }*/
        game.getGameFrame().AddBlocksToPanel();
        game.getGameFrame().AddballsToPanel();

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
                else
                    game.getGameFrame().addball(game.getGameFrame().getBalls().getFirst().getX(), game.getGameFrame().getBalls().getFirst().getY());
                game.getGameFrame().addRandomBlock();

            }

        }
        else {
            game.getGameFrame().removeBlock();
            int X, Y;
            X = Y = 0;
            if(game.getGameFrame().Stop){
                X = game.getInputListener().b[0];
                Y = game.getInputListener().b[1];
                for(Ball ball : game.getGameFrame().getBalls()){
                    ball.SetV(X, Y);
                }
                game.getGameFrame().Stop = false;
                int u = game.getGameFrame().MaxNumberOFballs;
                for (Ball ball : game.getGameFrame().getBalls()) {
                    for(int i = 0; i < u; i++){
                        ball.move();
                        ball.intersectBall();
                        try {
                            Thread.sleep(2);
                        }
                        catch (Exception e){

                        }
                        game.getGameFrame().repaint();
                    }
                    u -= 5;
                }
            }
            boolean CheckTheEnd = true;
            for (Ball ball : game.getGameFrame().getBalls()) {
                ball.move();
                ball.intersectBall();
                if (ball.getyVelocity() != 0 || ball.getxVelocity() != 0)
                    CheckTheEnd = false;
            }

            for(Block block : game.getGameFrame().getBlocks()){
            /*if(game.getIntersection().intersct(block, game.getGameFrame().getBall())){
                game.getGameFrame().Point += 1;

            }*/
            }
            if(CheckTheEnd){
                game.getGameFrame().onMove = false;
                game.getGameFrame().addInThisState = false;
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

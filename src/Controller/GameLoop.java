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
            if(game.getGameFrame().addInThisState == false){
                for (Block block : game.getGameFrame().getBlocks()) {
                    block.move();
                }
                game.getGameFrame().addInThisState = true;
                game.getGameFrame().addball();
                game.getGameFrame().addRandomBlock();
                if(game.getGameFrame().Level == 1){
                    game.getInputListener().setMainball(game.getGameFrame().getBalls().getFirst());
                }
                System.out.println(game.getGameFrame().getBalls().size());
            }


        }
        else{
            game.getGameFrame().removeBlock();
            boolean CheckOne = false;
            int X, Y;
            X = Y = 0;
            for(Ball ball : game.getGameFrame().getBalls()){
                if(!CheckOne){

                    X = ball.getxVelocity();
                    Y = ball.getyVelocity();
                    CheckOne = true;
                }
                ball.setyVelocity(Y);
                ball.setxVelocity(X);

            }
            boolean CheckTheEnd = true;
            for(Ball ball : game.getGameFrame().getBalls()){
                ball.move();
                if(ball.getyVelocity() != 0 || ball.getxVelocity() != 0)
                    CheckTheEnd = false;
                game.getIntersection().intersectBall(ball);
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

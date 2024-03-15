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
        this.game.getGameFrame().addRandomBlock();

    }
    public void run() {
        while (game.isGameRunning()) {
            update();
        }

    }
    private void update() {
        game.getGameFrame().getBall().move();
        game.getIntersection().intersectBall();
        if(game.getGameFrame().getBall().getxVelocity() == game.getGameFrame().getBall().getyVelocity() && game.getGameFrame().getBall().getyVelocity() == 0){
            if (game.getGameFrame().isMoveBall) {
                for (Block block : game.getGameFrame().getBlocks()) {
                    block.move();
                }
                game.getGameFrame().addRandomBlock();
                game.getGameFrame().isMoveBall = false;
            }

        }
        for(Block block : game.getGameFrame().getBlocks()){
            if(game.getIntersection().intersct(block)){
                game.getGameFrame().Point += 1;
            }
        }
        //game.getGameFrame().removeBlock();

        game.getGameFrame().repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }




    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

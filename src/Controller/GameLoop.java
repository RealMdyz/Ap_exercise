package Controller;

import Model.Block;
import Model.Game;

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

        game.getGameFrame().getBall().move();
        game.getGameFrame().repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        time += 100;
        if(time == 500){
            time = 0;
            game.getGameFrame().addRandomBlock();
        }
        if(!game.getGameFrame().isMoveBall){
            for(Block block : game.getGameFrame().getBlocks()){
                block.move();
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

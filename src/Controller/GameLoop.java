package Controller;

import Model.Game;

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

        game.getGameFrame().getBall().move();
        game.getGameFrame().repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Hello");

    }



    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

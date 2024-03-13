package Model;

import View.*;
public class Game {

    protected GameFrame gameFrame;
    private boolean isGameRunning = true;

    public Game(){
        gameFrame = new GameFrame();
    }


    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

}

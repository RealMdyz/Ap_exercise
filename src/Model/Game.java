package Model;

import View.*;
public class Game {

    protected GameFrame gameFrame;
    protected InputListener inputListener;
    private boolean isGameRunning = true;

    public Game(){
        gameFrame = new GameFrame();
        inputListener = new InputListener(gameFrame);
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

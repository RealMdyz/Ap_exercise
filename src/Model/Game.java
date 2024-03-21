package Model;

import View.*;
import Controller.*;
public class Game {

    protected GameFrame gameFrame;
    protected InputListener inputListener;
    private boolean isGameRunning = true;
    protected Intersection intersection;
    public Game(){
        gameFrame = new GameFrame();
        inputListener = new InputListener(gameFrame);
        intersection = new Intersection();
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

    public InputListener getInputListener() {
        return inputListener;
    }

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
    }

}

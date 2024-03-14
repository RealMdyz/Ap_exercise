package MyProject;

import Model.Game;
import Controller.*;
import View.GameFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myproject {

    protected Game game;
    protected GameLoop gameLoop;
    public Myproject(){
        game = new Game();
        gameLoop = new GameLoop(game);
        gameLoop.start();
    }
}

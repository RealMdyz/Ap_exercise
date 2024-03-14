package View;


import Model.Ball;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputListener {


    InputMap inputMap;
    ActionMap actionMap;
    GameFrame gameFrame;

    Ball ball;

    public InputListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        createKeyBindings();
        createKeyActions();
    }


    private void createKeyBindings() {

    }

    private void createKeyActions() {

    }

}
package Model;

import MyProject.*;
import java.awt.*;
public class Ball extends ObjectsInGame{

    private int xVelocity = 0;
    private int yVelocity = 0;

    public Ball(int x, int y){
        super(x, y);
        setX(x);
        setY(y);
        this.setWidth(100);
        this.setHeight(100);
        this.setSize(getWidth(), getHeight());
        setSize(getWidth(), getHeight());
        background = MyProjectData.getProjectData().getBall();

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, 50, 50, null);

    }

}

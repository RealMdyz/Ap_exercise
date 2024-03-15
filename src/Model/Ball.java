package Model;

import MyProject.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;

public class Ball extends ObjectsInGame implements Moveable{

    private int xVelocity = 0;
    private int yVelocity = 0;
    private final int diameter = 50;


    public Ball(int x, int y){
        super(x, y);
        setX(x);
        setY(y);
        this.setWidth(60);
        this.setHeight(60);
        setSize(getWidth(), getHeight());
        background = MyProjectData.getProjectData().getBall();

    }

    @Override
    public void move(){

        this.setX(this.getX() + xVelocity);
        this.setY(this.getY() + yVelocity);
        check();
    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, 50, 40, null);

    }
    public void check(){
        if(getY() > 650){
            xVelocity = 0;
            yVelocity = 0;
            setY(650);
        }

    }

   public void ChangeAngle(int x, int y){
       double angle = Math.atan2(y, x);
       double velocityX = Math.cos(angle) * 5; // Adjust the velocity as needed
       double velocityY = Math.sin(angle) * 5; // Adjust the velocity as needed
       setxVelocity((int)velocityX);
       setyVelocity((int)velocityY);
   }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

}

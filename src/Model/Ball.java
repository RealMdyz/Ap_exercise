package Model;

import MyProject.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.geom.Arc2D;

public class Ball extends ObjectsInGame implements Moveable{

    private int xVelocity = 0;
    private int yVelocity = 0;
    private final int radius = 15;



    private long LastMoveTime = 0;




    public Ball(int x, int y){
        super(x, y);
        setX(x);
        setY(y);
        this.setWidth(30);
        this.setHeight(30);
        setSize(getWidth(), getHeight());
        background = MyProjectData.getProjectData().getBall();

    }

    @Override
    public void move(){

        this.setX(this.getX() + this.xVelocity);
        this.setY(this.getY() + this.yVelocity);
        checkBounds();
        check();

    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, 30, 30, null);
        /*g2D.fill(new Arc2D.Double(getX() - radius, getY() - radius, 2 * radius, 2 * radius, 0, 360, Arc2D.PIE));
        g2D.dispose();*/
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

    public void checkBounds() {
        if (getX() <= 0 || getX() >= 570) { // Adjusted to consider the ball's width
            // Reverse x velocity when hitting side walls
            setxVelocity(-getxVelocity());
        }
        if (getY() <= 10) { // Adjusted to consider the ball's height
            // Reverse y velocity when hitting the top
            setyVelocity(-getyVelocity());
        }
        // No need to handle bottom collision separately as it is handled in the game loop
    }

    public void SetV(int x, int y){
        double angle = Math.atan2(- getY() + y, - getX() + x);
        double velocityX = Math.cos(angle) * 5; // Adjust the velocity as needed
        double velocityY = Math.sin(angle) * 5; // Adjust the velocity as needed
        setxVelocity((int)velocityX);
        setyVelocity((int)velocityY);
    }

    public long getLastMoveTime() {
        return LastMoveTime;
    }

    public void setLastMoveTime(long lastMoveTime) {
        LastMoveTime = lastMoveTime;
    }

    public int getRadius() {
        return radius;
    }

    public void setPosition(int x, int y){
        setX(x);
        setY(y);
    }
}

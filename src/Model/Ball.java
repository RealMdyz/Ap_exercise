package Model;

import MyProject.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.geom.Arc2D;

public class Ball extends ObjectsInGame implements Moveable{

    private int xVelocity = 0;
    private int yVelocity = 0;
    private final int radius = 15;

    public int Power = 1;
    private long LastMoveTime = 0;
    private final int Zarib = 10;


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
       double velocityX = Math.cos(angle) * Zarib; // Adjust the velocity as needed
       double velocityY = Math.sin(angle) * Zarib; // Adjust the velocity as needed
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
        double velocityX = Math.cos(angle) * Zarib; // Adjust the velocity as needed
        double velocityY = Math.sin(angle) * Zarib; // Adjust the velocity as needed
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

    public void changeBallColor(String chosenColor) {
        try {
            BufferedImage ballImage = ImageIO.read(new File("src/Ball1.png"));

            // Iterate over each pixel of the image
            for (int y = 0; y < ballImage.getHeight(); y++) {
                for (int x = 0; x < ballImage.getWidth(); x++) {
                    int pixel = ballImage.getRGB(x, y);
                    // Extract the alpha, red, green, and blue components of the pixel
                    int alpha = (pixel >> 24) & 0xFF;
                    int red = (pixel >> 16) & 0xFF;
                    int green = (pixel >> 8) & 0xFF;
                    int blue = pixel & 0xFF;
                    // Replace all non-transparent pixels with the player's chosen color
                    if (alpha != 0) {
                        Color color = getColorFromString(chosenColor);
                        ballImage.setRGB(x, y, color.getRGB());
                    }
                }
            }

            // Update the background with the modified ball image
            background = ballImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Color getColorFromString(String colorName) {
        // Convert the color name string to a Color object
        switch (colorName.toLowerCase()) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            case "yellow":
                return Color.YELLOW;
            case "orange":
                return Color.ORANGE;
            case "purple":
                return Color.MAGENTA;
            default:
                return Color.RED; // Default to red if the color name is not recognized
        }
    }

    public void setColor(Color color){
        this.background = createBallImageWithColor(color);
    }

    private BufferedImage createBallImageWithColor(Color color) {
        BufferedImage ballImage = null;
        try {
            ballImage = ImageIO.read(new File("src/Ball1.png"));
            for (int y = 0; y < ballImage.getHeight(); y++) {
                for (int x = 0; x < ballImage.getWidth(); x++) {
                    int pixel = ballImage.getRGB(x, y);
                    int alpha = (pixel >> 24) & 0xFF;
                    if (alpha != 0) {
                        ballImage.setRGB(x, y, color.getRGB());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ballImage;
    }

}

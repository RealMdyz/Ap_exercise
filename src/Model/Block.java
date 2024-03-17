package Model;

import java.awt.*;

public class Block extends ObjectsInGame implements Moveable{

    public int Power;
    private int xVelocity = 0;
    private int yVelocity = 50;

    public Block(int x, int y, int Power){
        super(x, y);
        setX(x);
        setY(y);
        this.Power = Power;
        this.setHeight(50);
        this.setWidth(100);
        setSize(getWidth(),getHeight());

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        // Draw rectangle
        g2D.setColor(Color.BLUE);
        g2D.fillRect(0,0 , 100, 50);

        // Draw number
        g2D.setColor(Color.WHITE);
        g2D.setFont(new Font("Arial", Font.BOLD, 20));
        String numberString = String.valueOf(Power);
        FontMetrics fm = g2D.getFontMetrics();
        int x = (100 - fm.stringWidth(numberString)) / 2;
        int y = (50 - fm.getHeight()) / 2 + fm.getAscent();
        g2D.drawString(numberString, x, y);

    }


    @Override
    public void move() {

        this.setX(this.getX() + xVelocity);
        this.repaint();
        this.setY(this.getY() + yVelocity);
        this.repaint();
    }
    public void reducePower(){
        this.Power -= 1;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }
}

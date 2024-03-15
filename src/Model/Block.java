package Model;

import java.awt.*;

public class Block extends ObjectsInGame implements Moveable{

    public int Power;
    private int xVelocity = 0;
    private int yVelocity = 25;

    public Block(int x, int y, int Power){
        super(x, y);
        setX(x);
        setY(y);
        this.Power = Power;
        this.setHeight(800);
        this.setWidth(600);
        this.setSize(getWidth(),getHeight());

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Draw rectangle
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), 100, 50);

        // Draw number
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String numberString = String.valueOf(Power);
        FontMetrics fm = g.getFontMetrics();
        int x = (100 - fm.stringWidth(numberString)) / 2;
        int y = (50 - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(numberString, getX() + x, getY() + y);

    }


    @Override
    public void move() {

        this.setX(this.getX() + xVelocity);
        this.setY(this.getY() + yVelocity);
        repaint();
    }


}

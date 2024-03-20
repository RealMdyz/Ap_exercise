package Model;

import java.awt.*;

public class UsualItem extends ObjectsInGame implements Moveable{
    public int Power;
    private int xVelocity = 0;
    private int yVelocity = 50;
    public String COLOR;

    public UsualItem(int x, int y, int Power, String COLOR){
        super(x, y);
        this.Power = Power;
        this.COLOR = COLOR;
        setHeight(50);
        setWidth(50);
        setSize(getWidth(),getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(getColorFromString(COLOR));
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void move() {
        this.setX(this.getX() + xVelocity);
        this.repaint();
        this.setY(this.getY() + yVelocity);
        this.repaint();
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



}

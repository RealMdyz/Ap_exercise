package Model;

import java.awt.*;

public class SpecialItem extends Block{

    public String COLOR;
    private int xVelocity = 0;
    private int yVelocity = 50;

    public SpecialItem(int x, int y, int Power, String COLOR) {
        super(x, y, Power);
        this.COLOR = COLOR;
        setHeight(50);
        setWidth(100);
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
        Graphics2D g2D = (Graphics2D) g;
        // Draw number
        g2D.setColor(Color.WHITE);
        g2D.setFont(new Font("Arial", Font.BOLD, 20));
        String numberString = String.valueOf(Power);
        FontMetrics fm = g2D.getFontMetrics();
        int x1 = (100 - fm.stringWidth(numberString)) / 2;
        int y1 = (50 - fm.getHeight()) / 2 + fm.getAscent();
        g2D.drawString(numberString, x1, y1);
    }

    @Override
    public void move() {
        this.setX(this.getX() + xVelocity);
        this.repaint();
        this.setY(this.getY() + yVelocity);
        this.repaint();
    }
    public void MoveBack() {
        this.setX(this.getX() - xVelocity);
        this.repaint();
        this.setY(this.getY() - yVelocity);
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

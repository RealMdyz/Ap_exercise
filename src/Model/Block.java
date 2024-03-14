package Model;

import java.awt.*;

public class Block extends ObjectsInGame {

    int Power;

    public Block(int x, int y, int Power){
        super(x, y);
        this.Power = Power;
        this.setHeight(100);
        this.setWidth(150);
        this.setSize(getWidth(),getHeight());

    }

}

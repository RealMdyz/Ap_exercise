package Model;

import java.awt.*;

public class Block extends ObjectsInGame {

    public Block(int x, int y){
        super(x, y);
        this.setHeight(30);
        this.setWidth(40);
        this.setSize(getWidth(),getHeight());

    }

}

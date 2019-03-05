package com.scilonax.games.birbsimulator;

import java.awt.*;

public class Seagle implements Handleable{


    private int x;
    private int y;

    private Image seagle = Util.requestImage("/seagle.jpg");


    public Image getSeagle() {
        return seagle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void handle(HandleEvent event) {

        if(HandleEvent.EventType.MOVE_UP.equals(event.getType())){
            this.y -= 10;
        } else if(HandleEvent.EventType.MOVE_DOWN.equals(event.getType())){
            this.y += 10;
        } else if(HandleEvent.EventType.MOVE_LEFT.equals(event.getType())){
            this.x -= 10;
        } else if(HandleEvent.EventType.MOVE_RIGHT.equals(event.getType())){
            this.x += 10;
        }
    }
}

package com.scilonax.games.birbsimulator;

import java.awt.*;

public class Pidgeon extends Bird {
    private Image seagle = Util.requestImage("/pidgeon.jpg");

    public Pidgeon(Bird nextBird) {
        super(nextBird);
    }

    public Pidgeon(Bird nextBird, int x, int y) {
        super(nextBird);
        this.x = x;
        this.y = y;
    }

    public Image getSeagle() {
        return seagle;
    }

    public void handle(HandleEvent event) {

        if(HandleEvent.EventType.MOVE_UP2.equals(event.getType())){
            this.y -= 10;
        } else if(HandleEvent.EventType.MOVE_DOWN2.equals(event.getType())){
            this.y += 10;
        } else if(HandleEvent.EventType.MOVE_LEFT2.equals(event.getType())){
            this.x -= 10;
        } else if(HandleEvent.EventType.MOVE_RIGHT2.equals(event.getType())){
            this.x += 10;
        }

        if (this.nextBird != null) {
            this.nextBird.handle(event);
        }
    }
}

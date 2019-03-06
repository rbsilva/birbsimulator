package com.scilonax.games.birbsimulator;

public abstract class Bird implements Handleable {
    protected Bird nextBird;
    protected int x;
    protected int y;

    public Bird(Bird nextBird) {
        this.nextBird = nextBird;
    }

    public Bird getNextBird() {
        return nextBird;
    }

    public void setNextBird(Bird nextBird) {
        this.nextBird = nextBird;
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

        if (this.nextBird != null) {
            this.nextBird.handle(event);
        }
    }
}

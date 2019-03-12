package com.scilonax.games.birbsimulator;

public abstract class Bird {
    protected int x;
    protected int y;
    protected Character moveUp;
    protected Character moveDown;
    protected Character moveRight;
    protected Character moveLeft;

    public Bird(int x, int y, Character moveUp, Character moveDown, Character moveRight, Character moveLeft) {
        this.x = x;
        this.y = y;
        this.moveUp = moveUp;
        this.moveDown = moveDown;
        this.moveRight = moveRight;
        this.moveLeft = moveLeft;
    }

    public Bird(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void handle(Character key) {

        if(key == moveUp){
            this.y -= 10;
        } else if(key == moveDown){
            this.y += 10;
        } else if(key  == moveLeft){
            this.x -= 10;
        } else if(key == moveRight){
            this.x += 10;
        }
    }
}

package com.scilonax.games.birbsimulator;

import java.awt.*;

public class Pidgeon extends Bird {
    private Image seagle = Util.requestImage("/pidgeon.jpg");

    public Pidgeon(int x, int y, Character moveUp, Character moveDown, Character moveRight, Character moveLeft) {
        super(x, y, moveUp, moveDown, moveRight, moveLeft);
    }

    public Image getSeagle() {
        return seagle;
    }
}

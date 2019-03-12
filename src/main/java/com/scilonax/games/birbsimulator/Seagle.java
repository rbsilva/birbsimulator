package com.scilonax.games.birbsimulator;

import java.awt.*;

public class Seagle extends Bird {

    private Image seagle = Util.requestImage("/seagle.jpg");

    public Seagle(int x, int y, Character moveUp, Character moveDown, Character moveRight, Character moveLeft) {
        super(x, y, moveUp, moveDown, moveRight, moveLeft);
    }

    public Image getSeagle() {
        return seagle;
    }
}

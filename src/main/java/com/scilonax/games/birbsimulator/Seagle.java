package com.scilonax.games.birbsimulator;

import java.awt.*;

public class Seagle extends Bird {

    private Image seagle = Util.requestImage("/seagle.jpg");

    public Seagle(Bird nextBird) {
        super(nextBird);
    }

    public Seagle(Bird nextBird, int x, int y) {
        super(nextBird);
        this.x = x;
        this.y = y;
    }

    public Image getSeagle() {
        return seagle;
    }
}

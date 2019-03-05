package com.scilonax.games.birbsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlManager implements KeyListener {
    private GamePanel gamePanel;

    public ControlManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'w') {
            getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_UP));
        }

        if (keyEvent.getKeyChar() == 'd') {
            getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_RIGHT));
        }

        if (keyEvent.getKeyChar() == 's') {
            getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_DOWN));
        }

        if (keyEvent.getKeyChar() == 'a') {
            getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_LEFT));
        }
    }

    private Handleable getSeagle() {
        return this.gamePanel.getSeagle();
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {

    }
}

package com.scilonax.games.birbsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class ControlManager implements KeyListener {
    private GamePanel gamePanel;
    private final Set<Character> pressed = new HashSet<Character>();

    public ControlManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void keyPressed(KeyEvent keyEvent) {
        pressed.add(keyEvent.getKeyChar());
        for (Character keyChar : pressed) {
            if (keyChar == 'w') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_UP));
            }

            if (keyChar == 'd') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_RIGHT));
            }

            if (keyChar == 's') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_DOWN));
            }

            if (keyChar == 'a') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_LEFT));
            }

            if (keyChar == 'i') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_UP2));
            }

            if (keyChar == 'l') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_RIGHT2));
            }

            if (keyChar == 'k') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_DOWN2));
            }

            if (keyChar == 'j') {
                getSeagle().handle(new HandleEvent(HandleEvent.EventType.MOVE_LEFT2));
            }
        }


    }

    private Handleable getSeagle() {
        return this.gamePanel.getSeagle();
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {
        pressed.remove(keyEvent.getKeyChar());
    }
}

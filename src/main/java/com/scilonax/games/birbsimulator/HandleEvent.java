package com.scilonax.games.birbsimulator;

public class HandleEvent {


    private EventType type;

    public HandleEvent(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public enum EventType {
        MOVE_UP, MOVE_RIGHT, MOVE_DOWN, MOVE_LEFT
    }
}

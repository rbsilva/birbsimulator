package com.scilonax.games.birbsimulator;

public class Event<T> {
    private T event;
    private String eventType;

    public Event(T event, String eventType) {
        this.event = event;
        this.eventType = eventType;
    }

    public T getEvent() {
        return event;
    }

    public String getEventType() {
        return eventType;
    }
}

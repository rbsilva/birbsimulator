package com.scilonax.games.birbsimulator;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ControlManager implements Runnable{
    private GamePanel gamePanel;
    private final Set<Character> pressed = new HashSet<>();
    private ArrayList<Character> playerOneControls;
    private ArrayList<Character> playerTwoControls;

    public ControlManager(GamePanel gamePanel, ArrayList<Character> playerOneControls, ArrayList<Character> playerTwoControls) {
        this.gamePanel = gamePanel;
        this.playerOneControls = playerOneControls;
        this.playerTwoControls = playerTwoControls;
    }

    @Override
    public void run() {
        while(true){
            if(GamePanel.blockingQueue.size() > 0){
                Event lastEvent = GamePanel.blockingQueue.peek();
                if(lastEvent.getEventType().equals("KeyEvent")){
                    try{
                        Event head = GamePanel.blockingQueue.take();
                        if(playerOneControls.contains(((KeyEvent)head.getEvent()).getKeyChar())){
                            gamePanel.getSeagle().handle(((KeyEvent)head.getEvent()).getKeyChar());
                        } else{
                            gamePanel.getPidgeon().handle(((KeyEvent)head.getEvent()).getKeyChar());
                        }
                    } catch(InterruptedException e) {
                        System.out.println("Unable to take head of the queue!");
                        //TODO handle this better
                    }
                }
            }
        }
    }
}


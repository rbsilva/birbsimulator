package com.scilonax.games.birbsimulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class GamePanel extends JPanel implements Runnable{

    private Thread thread;
    private int x = 0;
    private int y = 0;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    public static  BlockingQueue<Event> blockingQueue = new ArrayBlockingQueue<>(5);
    private Image imageBackground = Util.requestImage("/background.jpg");
    private ArrayList<Character> playerOneControls = new ArrayList<>();
    private ArrayList<Character> playerTwoControls = new ArrayList<>();
    private Seagle seagle = new Seagle(0,0, 'w' , 's', 'd', 'a');
    private Pidgeon pidgeon = new Pidgeon(400, 0 , 'i' , 'k' , 'l' , 'j');


    @Override
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public Seagle getSeagle() {
        return seagle;
    }

    public Pidgeon getPidgeon() {
        return pidgeon;
    }

    public void run() {
        long start;
        long elapsed;
        long wait;

        this.playerOneControls.addAll(Arrays.asList('w', 's', 'd', 'a'));
        addKeyListener(new UserEventListener());

        ExecutorService  executor = Executors.newFixedThreadPool(5);

        ControlManager taskPlayerOne = new ControlManager(this, playerOneControls, playerTwoControls);
        ControlManager taskPlayerTwo = new ControlManager(this, playerOneControls, playerTwoControls);

        GameThreadFactory playersThreads = () -> {
            ArrayList<Thread> threads = new ArrayList<>();
            Thread playerOneThread = new Thread(new ControlManager(this, playerOneControls, playerTwoControls));
            Thread playerTwoThread = new Thread(new ControlManager(this, playerOneControls, playerTwoControls));
            playerOneThread.setName("PlayerOne");
            playerTwoThread.setName("PlayerTwo");
            threads.addAll(Arrays.asList(playerOneThread, playerTwoThread));
            return threads;
        };

            ArrayList<Thread> threads = playersThreads.newThread();
            threads.forEach(thread -> {
                executor.submit(thread);
            });

        if(Window.getWindows().length == 0){
            executor.shutdownNow();
        }


        while (true) {
            start = System.nanoTime();
            final Graphics graphics = this.getGraphics();
            graphics.drawImage(this.imageBackground, 0, 0, 800, 400, null);
            graphics.drawImage(this.seagle.getSeagle(), this.seagle.getX(), this.seagle.getY(), 200, 200, null);
            graphics.drawImage(this.pidgeon.getSeagle(), this.pidgeon.getX(), this.pidgeon.getY(), 200, 200, null);

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}

package com.scilonax.games.birbsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    private int x = 0;
    private int y = 0;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    private Image imageBackground = Util.requestImage("/background.jpg");
    private Seagle seagle = new Seagle();

    @Override
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(new ControlManager(this));
            thread.start();
        }
    }

    public Seagle getSeagle() {
        return seagle;
    }

    public void run() {
        long start;
        long elapsed;
        long wait;

        while (true) {
            start = System.nanoTime();
            final Graphics graphics = this.getGraphics();
            graphics.drawImage(this.imageBackground, 0, 0, 800, 400, null);
            graphics.drawImage(this.seagle.getSeagle(), this.seagle.getX(), this.seagle.getY(), 200, 200, null);

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

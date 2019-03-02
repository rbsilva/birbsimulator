package com.scilonax.games.birbsimulator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    private Thread thread;
    private int x = 0;
    private int y = 0;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    public Image requestImage(String s) {
        BufferedImage read = null;
        try {
            read = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    public void run() {
        long start;
        long elapsed;
        long wait;

        while (true) {
            start = System.nanoTime();
            final Graphics graphics = this.getGraphics();
            graphics.drawImage(this.requestImage("/background.jpg"), 0, 0, 800, 400, null);
            graphics.drawImage(requestImage("/seagle.jpg"), x, y, 200, 200, null);

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

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'w') {
            this.y = this.y - 10;
        }

        if (keyEvent.getKeyChar() == 'd') {
            this.x = this.x + 10;
        }

        if (keyEvent.getKeyChar() == 's') {
            this.y = this.y + 10;
        }

        if (keyEvent.getKeyChar() == 'a') {
            this.x = this.x - 10;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {

    }
}

package com.scilonax.games.birbsimulator;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Birbs!");
        JFrame birbWindow = new JFrame("birbWindow");
        birbWindow.setSize(800, 400);
        birbWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final GamePanel container = new GamePanel();
        container.setPreferredSize(new Dimension(800,400));
        container.setFocusable(true);
        container.requestFocusInWindow();
        birbWindow.setContentPane(container);
        birbWindow.setVisible(true);

    }
}

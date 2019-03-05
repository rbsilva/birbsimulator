package com.scilonax.games.birbsimulator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Util {

    public static Image requestImage(String s) {
        BufferedImage read = null;
        try {
            read = ImageIO.read(Util.class.getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }
}

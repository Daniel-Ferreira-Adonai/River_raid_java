package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Wall extends Elemento {

    private Random rand = new Random();
    private int pixelSize = 5;

    Color color = new Color(0,73,0,255);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Wall(){

    }
    public Wall(int x, int y) {
        setLargura(x);
        setAltura(y);
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void desenha(Graphics2D g) {
        g.setColor(color);
        g.fillRect(getPx() , getPy(), getLargura(), getAltura());
    }

    public static Color getPixelColor(BufferedImage image, int x, int y) {
        int rgb = image.getRGB(x, y);
        return new Color(rgb, true);
    }
}

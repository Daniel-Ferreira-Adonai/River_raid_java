package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RightWall extends Wall {


    public RightWall(int largura, int altura) {
        setLargura(largura);
        setAltura(altura);
    }


    @Override
    public void desenha(Graphics2D g) {
        int xStart = getPx() - getLargura();
        g.setColor(color);
        g.fillRect(xStart, getPy(), getLargura(), getAltura());
    }


}

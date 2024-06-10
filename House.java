package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;

import java.awt.*;

public class House extends Elemento {
    private int pixelSize = 5;
    public House() {
        setLargura(30);
        setAltura(10);
    }
    public void desenha(Graphics2D g) {
        g.setColor(new Color(153,102,0));
        g.fillRect(getPx() + 1 * pixelSize, getPy(), 2 * pixelSize, 1 * pixelSize);
        // lado direto

        g.setColor(Color.green);
        g.fillRect(getPx() + 2 * pixelSize, getPy() -5 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 1 * pixelSize, getPy() -10 , 5 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 2 * pixelSize, getPy() -15 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 1 * pixelSize, getPy() -20 , 2 * pixelSize, 1 * pixelSize);

        // lado esquerdo
        g.setColor(Color.green);
        g.fillRect(getPx() -1 * pixelSize, getPy() -5 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -2 * pixelSize, getPy() -10 , 5 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -1 * pixelSize, getPy() -15 , 3 * pixelSize, 1 * pixelSize);
        g.setColor(Color.white);
        g.fillRect(getPx() + -10 * pixelSize, getPy() -40, 4 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -4 * pixelSize, getPy() -40, 4 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + -10 * pixelSize, getPy() -45, 4 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -4 * pixelSize, getPy() -45, 4 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + -10 * pixelSize, getPy() -50, 4 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -4 * pixelSize, getPy() -50, 4 * pixelSize, 1 * pixelSize);

        g.fillRect(getPx() + -10 * pixelSize, getPy() -55, 10 * pixelSize, 1 * pixelSize);
        g.setColor(Color.black);
        g.fillRect(getPx() + -10 * pixelSize, getPy() -60, 10 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + -8 * pixelSize, getPy() -65, 6 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -7 * pixelSize, getPy() -70, 4 * pixelSize, 1 * pixelSize);









    }
}

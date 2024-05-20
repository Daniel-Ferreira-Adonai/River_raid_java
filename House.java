package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;

import java.awt.*;

public class House extends Elemento {
    private int pixelSize = 5; // Size of each pixel
    public House() {
        setLargura(30);
        setAltura(10);
    }
    public void desenha(Graphics2D g) {
        g.setColor(new Color(153,102,0));
        g.fillRect(getPx() + 1 * pixelSize, getPy(), 2 * pixelSize, 1 * pixelSize);
        // lado direto

        g.setColor(new Color(1,70,32));
        g.fillRect(getPx() + 2 * pixelSize, getPy() -5 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 1 * pixelSize, getPy() -10 , 5 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 2 * pixelSize, getPy() -15 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() + 1 * pixelSize, getPy() -20 , 2 * pixelSize, 1 * pixelSize);

        // lado esquerdo
        g.setColor(new Color(1,70,32));
        g.fillRect(getPx() -1 * pixelSize, getPy() -5 , 3 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -2 * pixelSize, getPy() -10 , 5 * pixelSize, 1 * pixelSize);
        g.fillRect(getPx() -1 * pixelSize, getPy() -15 , 3 * pixelSize, 1 * pixelSize);







    }
}

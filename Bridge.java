package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Bridge extends Elemento {

    private boolean droping = false;

    public boolean isDroping() {
        return droping;
    }

    public void setDroping(boolean droping) {
        this.droping = droping;
    }

    private int pixelSize = 5;

    public Bridge() {
        setLargura(30);
        setAltura(15);
    }

    @Override
    public void atualiza() {
    }


    @Override
    public void desenha(Graphics2D g) {
        if(isAtivo()){
            g.setColor(new Color(124,44,0,255));
            g.fillRect(getPx() -70 , getPy() +6 , 4 * pixelSize, 3 * 2);
            g.fillRect(getPx() + 70 , getPy() +6 , 4 * pixelSize, 3 * 2);
            g.fillRect(getPx() -88 , getPy()  , 41 * pixelSize, 3 * 2);

            g.setColor(new Color(134,134,29,255));
            g.fillRect(getPx() -88 , getPy()- 5, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(105,105,15,255));
            g.fillRect(getPx() -88 , getPy()- 10, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(134,134,29,255));
            g.fillRect(getPx() -88 , getPy()- 15, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(105,105,15,255));
            g.fillRect(getPx() -88 , getPy()- 20, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(187,187,53,255));
            g.fillRect(getPx() -88 , getPy()- 25, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(105,105,15,255));
            g.fillRect(getPx() -88 , getPy()- 30, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(134,134,29,255));
            g.fillRect(getPx() -88 , getPy()- 35, 41 * pixelSize, 3 * 2);
            g.setColor(new Color(124,44,0,255));
            g.fillRect(getPx() -70 , getPy() -45 , 4 * pixelSize, 3 * 2);
            g.fillRect(getPx() + 70 , getPy() -45, 4 * pixelSize, 3 * 2);
            g.fillRect(getPx() -88 , getPy() -40 , 41 * pixelSize, 3 * 2);
        }

        g.setColor(new Color(111,111,111,255));
        //esquerda
        g.fillRect(getPx() - 377, getPy(), 58 * pixelSize, 4 * 2);
        g.setColor(new Color(170,170,170,255));
        g.fillRect(getPx() - 377, getPy()-16, 58 * pixelSize, 8 * 2);
        g.setColor(new Color(232,232,74,255));
        g.fillRect(getPx() - 377, getPy()-20, 58 * pixelSize, 3 * 2);
        g.setColor(new Color(170,170,170,255));
        g.fillRect(getPx() - 377, getPy()-36, 58 * pixelSize, 8 * 2);
        g.setColor(new Color(111,111,111,255));
        g.fillRect(getPx() - 377, getPy() - 42, 58 * pixelSize, 4 * 2);
        //direita
        g.setColor(new Color(111,111,111,255));
        //esquerda
        g.fillRect(getPx() +117, getPy(), 58 * pixelSize, 4 * 2);
        g.setColor(new Color(170,170,170,255));
        g.fillRect(getPx() +117, getPy()-16, 58 * pixelSize, 8 * 2);
        g.setColor(new Color(232,232,74,255));
        g.fillRect(getPx() +117, getPy()-20, 58 * pixelSize, 3 * 2);
        g.setColor(new Color(170,170,170,255));
        g.fillRect(getPx() +117, getPy()-36, 58 * pixelSize, 8 * 2);
        g.setColor(new Color(111,111,111,255));
        g.fillRect(getPx() +117, getPy() - 42, 58 * pixelSize, 4 * 2);

    }


}
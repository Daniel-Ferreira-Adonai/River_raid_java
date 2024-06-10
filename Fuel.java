package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Fuel extends Elemento {
    private boolean dead = false;
    private int deadAnimCount = 0;
    private int combustivel = 530;
    private int pixelSize = 5;

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setDeadAnimCount(int deadAnimCount) {
        this.deadAnimCount = deadAnimCount;
    }

    public Fuel() {
        setLargura(30);
        setAltura(15);
    }

    @Override
    public void atualiza() {
    }


    @Override
    public void desenha(Graphics2D g) {
        if (!isAtivo() && dead){
            deadAnimCount+= 1;
            g.setColor(new Color(214,165,74,255));
            if (deadAnimCount <= 5) {
                g.fillRect(getPx() + 15, getPy() - 15, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 27, getPy() - 20, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 0, getPy() - 30, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 30, getPy() + 0, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 3, getPy() + 10, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 35, getPy() + 20, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() - 10, getPy() + 5, 1 * pixelSize, 1 * pixelSize);
            }
            if (deadAnimCount <= 10) {
                g.fillRect(getPx() + 15, getPy() - 15, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 24, getPy() - 17, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 3, getPy() - 27, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 27, getPy() - 5, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 6, getPy() + 13, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 32, getPy() + 5, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() - 7, getPy() - 5, 1 * pixelSize, 1 * pixelSize);
            }
            if (deadAnimCount <= 15) {
                g.fillRect(getPx() + 15, getPy() - 15, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 21, getPy() - 20, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 6, getPy() - 30, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 24, getPy() + 0, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 9, getPy() + 10, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() + 28, getPy() + 20, 1 * pixelSize, 1 * pixelSize);
                g.fillRect(getPx() - 4, getPy() + 5, 1 * pixelSize, 1 * pixelSize);
            }}

        if (isAtivo()) {
            g.setColor(Color.WHITE);
            g.fillRect(getPx(), getPy(), 12 * pixelSize, 4 * pixelSize);

            g.setColor(new Color(45, 50, 184, 255));
            g.fillRect(getPx() + 15, getPy() + 10, 5 * pixelSize, 1 * pixelSize);
            g.fillRect(getPx() + 15, getPy(), 1 * pixelSize, 2 * pixelSize);
            g.fillRect(getPx() + 20, getPy(), 1 * pixelSize, 2 * pixelSize);


            g.setColor(new Color(214, 92, 92, 255));
            g.fillRect(getPx(), getPy() - 20, 12 * pixelSize, 4 * pixelSize);

            g.setColor(new Color(45, 50, 184, 255));
            g.fillRect(getPx() + 15, getPy() - 8, 5 * pixelSize, 1 * pixelSize);
            g.fillRect(getPx() + 15, getPy() - 15, 1 * pixelSize, 2 * pixelSize);
            g.fillRect(getPx() + 20, getPy() - 15, 1 * pixelSize, 2 * pixelSize);

            g.fillRect(getPx() + 15, getPy() - 18, 5 * pixelSize, 1 * pixelSize);


            g.fillRect(getPx() + 16, getPy() - 12, 5 * pixelSize, 1 * 3);


            g.setColor(Color.WHITE);
            g.fillRect(getPx(), getPy() - 40, 12 * pixelSize, 4 * pixelSize);
            g.setColor(new Color(45, 50, 184, 255));

            g.fillRect(getPx() + 15, getPy() - 25, 5 * pixelSize, 1 * pixelSize);
            g.fillRect(getPx() + 15, getPy() - 35, 1 * pixelSize, 2 * pixelSize);
            g.fillRect(getPx() + 20, getPy() - 35, 1 * pixelSize, 2 * pixelSize);
            g.fillRect(getPx() + 30, getPy() - 35, 1 * pixelSize, 2 * pixelSize);
            g.fillRect(getPx() + 35, getPy() - 35, 1 * pixelSize, 2 * pixelSize);

            g.setColor(new Color(214, 92, 92, 255));
            g.fillRect(getPx(), getPy() - 65, 12 * pixelSize, 5 * pixelSize);
            g.setColor(new Color(45, 50, 184, 255));
            g.fillRect(getPx() + 15, getPy() - 55, 1 * pixelSize, 3 * pixelSize);
            g.fillRect(getPx() + 20, getPy() - 55, 1 * pixelSize, 3 * pixelSize);
            g.fillRect(getPx() + 15, getPy() - 60, 5 * pixelSize, 1 * pixelSize);
            g.fillRect(getPx() + 20, getPy() - 50, 3 * pixelSize, 1 * pixelSize);


        }
    }
    public void desenhaLeft(Graphics2D g) {
    }



}
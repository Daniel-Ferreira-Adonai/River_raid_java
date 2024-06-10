package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;
import br.com.mvbos.lgj.base.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hud extends Elemento {

    private int pontos;
    private int pixelSize = 5;
    BufferedImage ponteiro = null;
    int contadorScore = 0;

    public int getContadorScore() {
        return contadorScore;
    }

    public void setContadorScore(int contadorScore) {
        this.contadorScore = contadorScore;
    }

    public Hud() {

        try {

            ponteiro = ImageIO.read(new File(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\Ponteiro.png"));
            this.image = ImageIO.read(new File(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\Gas.png"));
            if (image == null) {
                throw new IOException("Image not found at specified path.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLargura(image.getWidth());
        setAltura(image.getHeight());
    }

    public void desenha(Graphics2D g, int x) {
        if (this.image != null) {

            g.drawImage(image, getPx(), getPy(), getLargura() * 4, getAltura() * 4, null);
            g.drawImage(ponteiro, x, getPy() + 12, 3 * 4, 12 * 4, null);


        }

    }

    public void handleContadorScore(Ranking ranking) {
        if (contadorScore == 40 && ranking.getCount() < 10) {
            ranking.setCount(ranking.getCount() + 1);
            Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\ScoreboardSound.wav");
            contadorScore = 0;
        }
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    }














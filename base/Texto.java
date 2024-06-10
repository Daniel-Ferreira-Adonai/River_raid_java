package br.com.mvbos.lgj.base;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Texto extends Elemento {

	private Font fonte;

	public Texto() {

		try {
			File fontFile = new File(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\fibberish.ttf");
			fonte = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(50f);
		}
		catch(IOException | FontFormatException e){
			e.printStackTrace();
		}
	}

	public Texto(Font fonte) {
		this.fonte = fonte;
	}

	public void desenha(Graphics2D g, String texto) {
		desenha(g, texto, getPx(), getPy());
	}

	public void desenha(Graphics2D g, String texto, int px, int py) {
		if (getCor() != null)
			g.setColor(getCor());

		g.setFont(fonte);
		g.drawString(texto, px, py);
	}

	public Font getFonte() {
		return fonte;
	}

	public void setFonte(Font fonte) {
		this.fonte = fonte;
	}

}
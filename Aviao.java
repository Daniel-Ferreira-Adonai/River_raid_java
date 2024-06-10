package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Aviao extends Elemento {
	private int vidas = 3;

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
	}

	private int combustivel = 530;
	private int pixelSize = 5;

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public Aviao() {
		setLargura(30);
		setAltura(15);
	}

	@Override
	public void atualiza() {
	}


	@Override
	public void desenha(Graphics2D g) {
		g.setColor(Color.YELLOW);


		g.fillRect(getPx(), getPy(), pixelSize, 8 * pixelSize);

// Lado direito
		g.fillRect(getPx() + 15 + 4 - 14, getPy() + 3 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 2 + 4 - 14, getPy() + 2 * pixelSize, 4 * pixelSize, pixelSize);
		g.fillRect(getPx() + 10 + 4 - 14, getPy() + 4 * pixelSize, 5 * pixelSize, pixelSize);
		g.fillRect(getPx() + 20 + 4 - 14, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 20 + 4 - 14, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 25 + 4 - 14, getPy() + 6 * pixelSize, 2 * pixelSize, pixelSize);
		g.fillRect(getPx() + 2 + 4 - 14, getPy() + 8 * pixelSize, 4 * pixelSize, pixelSize);
		g.fillRect(getPx() + 10 + 4 - 14, getPy() + 9 * pixelSize, 1 * pixelSize, pixelSize);
		g.fillRect(getPx() + 21 + 4 - 14, getPy() + 9 * pixelSize, 2 * pixelSize, pixelSize);

// Lado esquerdo

		g.fillRect(getPx() - 5 + 4 - 14, getPy() + 3 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() - 11 + 4 - 14, getPy() + 4 * pixelSize, 5 * pixelSize, pixelSize);
		g.fillRect(getPx() - 11 + 4 - 14, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() - 2 + 4 - 14, getPy() + 5 * pixelSize, 1 * pixelSize, pixelSize);
		g.fillRect(getPx() - 11 + 4 - 14, getPy() + 6 * pixelSize, 2 * pixelSize, pixelSize);
		g.fillRect(getPx() - 6 + 4 - 14, getPy() + 9 * pixelSize, 2 * pixelSize, pixelSize);
	}
		public void desenhaLeft(Graphics2D g) {
	}
	public int getCombustivel(){
		return this.combustivel;
	}
	public void diminui(){
		this.combustivel--;
	}
	public void aumenta(){
		this.combustivel++;
	}


}
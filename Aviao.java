package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Aviao extends Elemento {

	private int pixelSize = 5; // Size of each pixel

	public Aviao() {
		setLargura(50);
		setAltura(15);
	}

	@Override
	public void atualiza() {
	}

	@Override
	public void desenha(Graphics2D g) {
		g.setColor(Color.YELLOW);

		// Fuselage
		g.fillRect(getPx() + 2 * pixelSize, getPy(), pixelSize, 8 * pixelSize);
		// lado direito
		g.fillRect(getPx() + +15, getPy() +3 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 2, getPy() + 2 * pixelSize, 4 * pixelSize, pixelSize);
		g.fillRect(getPx() + +10, getPy() +4 * pixelSize, 5 * pixelSize, pixelSize);
		g.fillRect(getPx() + 20, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 20, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + 25, getPy() + 6 * pixelSize, 2 * pixelSize, pixelSize);
		g.fillRect(getPx() + 2, getPy() + 8 * pixelSize, 4 * pixelSize, pixelSize);
		g.fillRect(getPx() +10, getPy() + 9 * pixelSize, 1 * pixelSize, pixelSize);
		g.fillRect(getPx() +21, getPy() + 9 * pixelSize, 2 * pixelSize, pixelSize);

		// lado esquerdo
		g.fillRect(getPx() + -5, getPy() +3 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() + -11, getPy() +4 * pixelSize, 5 * pixelSize, pixelSize);
		g.fillRect(getPx() - 11, getPy() + 5 * pixelSize, 3 * pixelSize, pixelSize);
		g.fillRect(getPx() -2, getPy() + 5 * pixelSize, 1 * pixelSize, pixelSize);
		g.fillRect(getPx() - 11, getPy() + 6 * pixelSize, 2 * pixelSize, pixelSize);
		g.fillRect(getPx() -6, getPy() + 9 * pixelSize, 2 * pixelSize, pixelSize);


	}
	public void desenhaLeft(Graphics2D g) {
		}
}

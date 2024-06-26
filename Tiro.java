package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.Elemento;

public class Tiro extends Elemento {

	private boolean inimigo;

	public Tiro() {
		setLargura(5);
		setAltura(30);
	}

	public Tiro(boolean inimigo) {
		this();
		this.inimigo = inimigo;
	}

	@Override
	public void atualiza() {
	}

	@Override
	public void desenha(Graphics2D g) {
		if (!isAtivo())
			return;

		g.setColor(Color.yellow);

		g.fillRect(getPx(), getPy(), getLargura(), getAltura());
	}

}

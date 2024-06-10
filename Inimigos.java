package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import br.com.mvbos.lgj.base.Elemento;
import br.com.mvbos.lgj.base.Util;

public class Inimigos extends Elemento {
	private boolean dead = false;
	private boolean move = false;
	private int dir = 1;
	private int deadAnimCount = 0;
	private int animCount = 0;
	private boolean anim = false;

	private int pixelSize = 5;
	public void changeDir(){
		this.dir = dir * -1;
	}
	public void changeDirTo(int dir){
		this.dir = dir ;
	}
	public void shouldMove(Aviao aviao){
		if((py+ 300) > aviao.getPy() && !move && isAtivo()){
			if(aviao.getPx() > 400) {
				if(px > aviao.getPx())
					dir = -1;
				else{
					dir = 1;
				}
			}
			else{
				if(px < aviao.getPx())
					dir = 1;
				else{
					dir = -1;
				}
			}
			move = true;
		}
		if(move == true && isAtivo()){
			if(getTipo() == tipo.PASSARO){
				setPx(getPx() + (8 * dir) );
			}
			else{
				setPx(getPx() + (5 * dir) );
			}
		}
	}
	public void setMove(boolean move){
		this.move = move;
	}
	public enum Tipos {
		HELICOPTERO, COMBUSTIVEL, BARCO, PASSARO
	}
	public static Tipos getRandomTipos() {
		Tipos[] values = Tipos.values();
		Random rand = new Random();
		int randomIndex = rand.nextInt(values.length);
		return values[randomIndex];
	}
	private Tipos tipo;
	private boolean aberto;

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}

	public Inimigos(Tipos t) {
		this.tipo = t;
		if(this.tipo == Tipos.BARCO){
			setLargura(100);
			setAltura(200);
		}
		setLargura(20);
		setAltura(20);
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public void atualiza() {
		aberto = !aberto;
	}

	public void setDeadAnimCount(int deadAnimCount) {
		this.deadAnimCount = deadAnimCount;
	}

	@Override
	public void desenha(Graphics2D g) {
		if (!isAtivo() && dead){
			deadAnimCount+= 1;
			g.setColor(new Color(214,165,74,255));
			if(deadAnimCount <= 5 ) {
				g.fillRect(getPx(), getPy(), 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 12, getPy() - 5, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -15 , getPy() - 15, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 15, getPy() + 15, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -12, getPy() + 25, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 20, getPy() + 35, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() - 25, getPy() + 20, 1 * pixelSize, 1 * pixelSize);
			}
			if(deadAnimCount <= 10 ) {
				g.fillRect(getPx(), getPy(), 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 9, getPy() - 2, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -12 , getPy() - 12, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 12, getPy() + 10, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -9, getPy() + 28, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 17, getPy() + 20, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() - 22, getPy() + 10, 1 * pixelSize, 1 * pixelSize);
			}
			if(deadAnimCount <= 15 ) {
				g.fillRect(getPx(), getPy(), 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 6, getPy() - 5, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -9 , getPy() - 15, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 9, getPy() + 15, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() -6, getPy() + 25, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 13, getPy() + 35, 1 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() - 19, getPy() + 20, 1 * pixelSize, 1 * pixelSize);
			}

		}
		if (!isAtivo())
			return;

		int larg = getLargura();

		if (tipo == Tipos.BARCO) {

			larg = larg - 2;

			g.setColor(new Color(82,165,198,255));
			g.fillRect(getPx(), getPy(), 12 * pixelSize, 1 * pixelSize);
			g.fillRect( getPx() - 20, getPy() - 5, 16 * pixelSize, 1 * pixelSize);
			g.setColor(new Color(155,57,16,255));
			g.fillRect(getPx() - 20, getPy() -10, 20 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() - 20, getPy() -13, 24 * pixelSize, 1 * pixelSize);
			g.setColor(Color.black);
			g.fillRect(getPx() - 10, getPy() -18, 14 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() , getPy() -21, 8 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx()  + 10, getPy() -30, 4 * pixelSize, 2 * pixelSize);

			/*if (aberto) {
				// Desenha um circulo azul com quadrados ao redor
				g.fillOval(getPx(), getPy(), larg, getAltura());

				g.fillRect(getPx() - 5, getPy() - 5, 5, 5);
				g.fillRect(getPx() + larg, getPy() - 5, 5, 5);

				g.fillRect(getPx() - 5, getPy() + getLargura(), 5, 5);
				g.fillRect(getPx() + larg, getPy() + larg, 5, 5);

			} else {
				// Desenha um quadrado azul
				g.fillRect(getPx(), getPy(), larg, getAltura());
			}*/

		} else if (tipo == Tipos.HELICOPTERO) {
			animCount+= 1;
			if(animCount <= 10) {
				g.setColor(new Color(0,66,49,255));
				g.fillRect(getPx(), getPy(), 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 10, getPy() -5 , 2 * pixelSize, 1 * pixelSize);
				// altura da ponta de baixo
				g.fillRect(getPx(), getPy() - 10, 6 * pixelSize, 1 * pixelSize);
				// altura da ponta de baixo
				g.setColor(new Color(0,0,148,255));
				g.fillRect(getPx()- 30, getPy() - 13, 14 * pixelSize, 1 * 4);
				g.fillRect(getPx()- 30, getPy() - 16, 14 * pixelSize, 1 * 4);
				g.setColor(new Color(0,66,49,255));
				g.fillRect(getPx() -10 , getPy() - 20, 10 * pixelSize, 1 * pixelSize);

				g.fillRect(getPx() -30 , getPy() - 20, 2 * pixelSize, 1 * pixelSize); // ponta de cima
				g.fillRect(getPx() -30 , getPy() - 10, 2 * pixelSize, 1 * pixelSize); // ponta de baixo


				g.fillRect(getPx()  , getPy() - 20, 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx(), getPy() - 25, 6 * pixelSize, 1 * pixelSize);

				g.setColor(new Color(214,165,74,255));
				g.fillRect(getPx() + 10, getPy() - 30, 2 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() - 10, getPy() - 35, 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 10, getPy() - 40, 6 * pixelSize, 1 * pixelSize);
				anim = true;
			}

			if( animCount >= 11) {
				g.setColor(new Color(0,66,49,255));
				g.fillRect(getPx(), getPy(), 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 10, getPy() -5 , 2 * pixelSize, 1 * pixelSize);
				// altura da ponta de baixo
				g.fillRect(getPx(), getPy() - 10, 6 * pixelSize, 1 * pixelSize);
				// altura da ponta de baixo
				g.setColor(new Color(0,0,148,255));
				g.fillRect(getPx()- 30, getPy() - 13, 14 * pixelSize, 1 * 4);
				g.fillRect(getPx()- 30, getPy() - 16, 14 * pixelSize, 1 * 4);
				g.setColor(new Color(0,66,49,255));
				g.fillRect(getPx() -10 , getPy() - 20, 10 * pixelSize, 1 * pixelSize);

				g.fillRect(getPx() -30 , getPy() - 20, 2 * pixelSize, 1 * pixelSize); // ponta de cima
				g.fillRect(getPx() -30 , getPy() - 10, 2 * pixelSize, 1 * pixelSize); // ponta de baixo


				g.fillRect(getPx()  , getPy() - 20, 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx(), getPy() - 25, 6 * pixelSize, 1 * pixelSize);

				g.setColor(new Color(214,165,74,255));
				g.fillRect(getPx() + 10, getPy() - 30, 2 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() - 10, getPy() - 40, 6 * pixelSize, 1 * pixelSize);
				g.fillRect(getPx() + 10, getPy() - 35, 6 * pixelSize, 1 * pixelSize);
				if(animCount>13){
					animCount = 0;
				}
			}




		} else if (tipo == Tipos.PASSARO) {
			g.setColor(new Color(117,204,235,255));
			larg = larg + 4;
			g.fillRect(getPx(), getPy(), 4 * pixelSize, 1 * 3);
			g.fillRect(getPx() - 10, getPy() - 5, 6 * pixelSize, 1 * pixelSize);
			g.setColor(new Color(117,204,235,255));
			g.setColor(new Color(117,181,235,255));
			g.fillRect(getPx() + 20, getPy() - 10, 2 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() -40, getPy() - 10, 8 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() -40, getPy() - 15, 16 * pixelSize, 1 * pixelSize);
			g.setColor(new Color(117,128,240,255));
			g.fillRect(getPx() -30, getPy() - 20, 4 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() +20, getPy() - 20, 4 * pixelSize, 1 * pixelSize);
			g.fillRect(getPx() +30, getPy() - 25, 2 * pixelSize, 1 * pixelSize);




		}

	}

	public int getPremio() {
		switch (tipo) {
			case BARCO:
				return 300;

			case HELICOPTERO:
				return 200;

			case PASSARO:
				return 100;

			default:
				return 1000;
		}
	}

}

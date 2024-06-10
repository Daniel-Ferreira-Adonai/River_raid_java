package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.sound.sampled.Clip;
import javax.swing.*;

import br.com.mvbos.lgj.Inimigos.Tipos;
import br.com.mvbos.lgj.base.Elemento;
import br.com.mvbos.lgj.base.Texto;
import br.com.mvbos.lgj.base.Util;

public class Jogo extends JFrame {
	Ranking ranking = new Ranking();
	private boolean gameOver = false;


	//Settings da janela
	private static final long serialVersionUID = 1L;

	private static int FPS = 800 / 20;

	private static final int JANELA_ALTURA = 800;
	private static final int JANELA_LARGURA = 800;
	//Settings da janela

	//declarando variaveis graficas
	private JPanel tela; // -> Janela
	private Graphics2D g2d;

	private BufferedImage buffer; // -> Buffer

	private boolean[] controleTecla = new boolean[5]; // -> array de controles, vai ser usado para definir oq vai acontecer

	//declarando variaveis graficas
	//declarando variaveis uteis

	// Elementos do jogo




	private Texto texto = new Texto();

	private ArrayList<Inimigos> listaDeInimigos = new ArrayList<Inimigos>();

	private int linhaBase = 60;


	private LeftWall leftWall;
	private RightWall rightWall;
	private Random rand = new Random();
	private House house;
	private Aviao aviao;
	private Timer timer;

	private ArrayList<House> housesLeft = new ArrayList<>();
	private ArrayList<House> housesRight = new ArrayList<>();

	private ArrayList<LeftWall> paredesEsquerda = new ArrayList<>();
	private LeftWall paredePassada;
	private RightWall paredePassadaDireita;
	private ArrayList<RightWall> paredesDireitas = new ArrayList<>();
	private ArrayList<Fuel> fuelList = new ArrayList<>();

	private int contadorCombustivel = 0;

	private Hud hud;

	private Inimigos x2;
	private Tiro tiro;
	Color fundo = new Color(0, 65, 210, 255);
	int contadorFundoInteiro = 0;


	boolean colorChange = false;

	Boolean contadorFundo = false;
	Bridge bridge = new Bridge();

	Clip sound = null;




	public void changeFundoCor() {
		contadorFundoInteiro += 1;
		if (contadorFundoInteiro == 5) {
			fundo = new Color(0, 65, 210, 255);

		}
		if (contadorFundoInteiro == 10) {
			fundo = Color.red;

		}
		if (contadorFundoInteiro == 12) {
			fundo = new Color(0, 65, 210, 255);
			contadorFundoInteiro = 0;
			contadorFundo = false;
		}
	}

	public Jogo() {

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				setaTecla(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				setaTecla(e.getKeyCode(), true);
			}
		});

		buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, BufferedImage.TYPE_INT_RGB);
		g2d = buffer.createGraphics();

		tela = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(buffer, 0, 0, null);

			}
		};

		getContentPane().add(tela);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(JANELA_LARGURA, JANELA_ALTURA);
		setVisible(true);

		// Toda vez q o timer toca, a função gameLoop é chamada
		timer = new Timer(FPS, e -> gameLoop());

		timer.start();
	}

	private void setaTecla(int tecla, boolean pressionada) {
		switch (tecla) {
			case KeyEvent.VK_UP:
				controleTecla[0] = pressionada;
				break;
			case KeyEvent.VK_DOWN:
				controleTecla[1] = pressionada;
				break;
			case KeyEvent.VK_LEFT:
				controleTecla[2] = pressionada;
				break;
			case KeyEvent.VK_RIGHT:
				controleTecla[3] = pressionada;
				break;
			case KeyEvent.VK_SPACE:
				controleTecla[4] = pressionada;
				break;
		}
	}

	private void carregarJogo() {

		tiro = new Tiro();

		for (int i = 0; i < 3; i++) {
			house = new House();

			house.setAtivo(true);
			house.setPx(rand.nextInt(20) + 1);
			house.setPy(-rand.nextInt(3000));
			housesLeft.add(house);
		}
		for (int i = 0; i < 3; i++) {
			house = new House();

			house.setAtivo(true);
			house.setPx(rand.nextInt(780, 800));
			house.setPy(-rand.nextInt(3000));
			housesRight.add(house);
		}

		aviao = new Aviao();
		aviao.setVel(3);
		aviao.setAtivo(true);
		aviao.setPx(tela.getWidth() / 2 - aviao.getLargura() / 2);
		aviao.setPy(tela.getHeight() - 150 - aviao.getAltura() - linhaBase);


		for (int i = 0; i < 81; i++) {
			if (paredePassada == null) {
				paredePassada = new LeftWall(200, 10);
				paredePassada.setPx(0);
				paredePassada.setPy(-10);
				paredePassada.setAtivo(true);
				paredesEsquerda.add(paredePassada);

			} else {
				leftWall = new LeftWall(rand.nextInt(paredePassada.getLargura() - 10, paredePassada.getLargura() + 10), 10);
				leftWall.setPx(0);
				leftWall.setPy(paredePassada.getPy() + 10);
				paredesEsquerda.add(leftWall);
				paredePassada = leftWall;

			}
		}
		for (int i = 0; i < 81; i++) {
			if (paredePassadaDireita == null) {
				paredePassadaDireita = new RightWall(200, 10);
				paredePassadaDireita.setPx(800);
				paredePassadaDireita.setPy(-10);
				paredesDireitas.add(paredePassadaDireita);

			} else {
				rightWall = new RightWall(rand.nextInt(paredePassadaDireita.getLargura() - 10, paredePassadaDireita.getLargura() + 10), 10);
				rightWall.setPx(800);
				rightWall.setPy(paredePassadaDireita.getPy() + 10);
				rightWall.setAtivo(true);
				paredesDireitas.add(rightWall);
				paredePassadaDireita = rightWall;

			}
		}


		for (int i = 0; i < 8; i++) {
			Inimigos inimigo = new Inimigos(Inimigos.getRandomTipos());

			inimigo.setPx(rand.nextInt(240, 600) + 1);

			inimigo.setPy(-rand.nextInt(800));
			inimigo.setAtivo(true);
			listaDeInimigos.add(inimigo);
		}
		for (int i = 0; i < 3; i++) {
			Fuel fuel = new Fuel();
			fuel.setAtivo(true);
			fuel.setPx(rand.nextInt(240, 400) + 1);
			fuel.setPy(-rand.nextInt(3000));
			fuelList.add(fuel);
		}
		hud = new Hud();
		hud.setPx(230);
		hud.setPy(680);
		hud.setAtivo(true);
		texto.setAtivo(true);

		bridge.setPx(tela.getWidth() / 2 - aviao.getLargura() / 2);
		bridge.setPy(-10000);
		bridge.setAtivo(true);

		sound = Util.playSoundLoop(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\PlaneNormalSound.wav");

	}

	private void gameLoop() {
		updateGame();
		renderGame();
		tela.repaint();
	}


	private void updateGame() {

		if (controleTecla[0]) {
			timer.setDelay(10);


		} else if (controleTecla[1]) {
			timer.setDelay(70);

		} else {
			timer.setDelay(20);
		}

		if (controleTecla[2]) {
			aviao.setPx(aviao.getPx() - 5);
		}
		if (controleTecla[3]) {
			aviao.setPx(aviao.getPx() + 5);
		}
		if (controleTecla[4] && !tiro.isAtivo()) {
			tiro.setAtivo(true);
			tiro.setPx(aviao.getPx() + 20);
			tiro.setPy(aviao.getPy() + 10);
			if(!gameOver) {
				Util.playSound2(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\shoot.wav");
			}
		}
		if (Util.colide(aviao, house)) {
			System.out.println("bateu :) ");
			gameOver = true;

		}
		for (House x : housesLeft) {
			if (x.getPy() > 800) {
				x.setPx(rand.nextInt(100) + 1);

				x.setPy(-rand.nextInt(3000));
			}
			x.setPy(x.getPy() + 10);
		}
		for (House x : housesRight) {
			if (x.getPy() > 800) {
				house.setPx(rand.nextInt(780, 800));
				x.setPy(-rand.nextInt(3000));

			}
			x.setPy(x.getPy() + 5);
		}
		for (Inimigos x : listaDeInimigos) {
			x.setPy(x.getMovPy() + 3);


		}


		if (tiro != null) {
			tiro.setPy(tiro.getMovPy() - 30);
			tiro.setPx(aviao.getPx() + 10);
		}
		if (Util.colide(tiro, house) || tiro.getPy() < 0) {
			tiro.setAtivo(false);
		}

		if (Util.colideX(rightWall, aviao)) {
			System.out.println("bateu direita");
			gameOver = true;

		}
		if (aviao.getCombustivel() > 240 && aviao.getCombustivel() < 600 && contadorCombustivel == 5) {
			aviao.diminui();
			contadorCombustivel = 0;
		}
		contadorCombustivel += 1;
		if(!gameOver) {
			hud.setPontos(hud.getPontos() + 1);
		}
		if (aviao.getVidas() == 0) {
			gameOver = true;

		}
		//System.out.println(aviao.getPx() + 20);
		for (RightWall x : paredesDireitas) {


			x.setPy(x.getPy() + 10);
			for (Inimigos y : listaDeInimigos) {
				int larg = 0;
				if (y.getTipo() == Tipos.BARCO) {
					larg = 60;
				}
				if (y.getPx() + larg > x.getPx() - x.getLargura() && y.getTipo() != Tipos.PASSARO) {
					//System.out.println(y.getPx());
					y.changeDir();
				}
			}
			if (Util.colideX(x, aviao)) {
				System.out.println("bateu esquerda");
				gameOver = true;


			}

			if (x.getPy() > 800) {
				x.setPy(-8);

				int novaLargura = rand.nextInt(paredePassada.getLargura() - 10, paredePassada.getLargura() + 10);

				int larguraMinima = 100;
				if (novaLargura < larguraMinima) {
					novaLargura = larguraMinima;
				}
				x.setLargura(novaLargura);

				paredePassadaDireita = x;
				if (colorChange == true) {
					x.setColor(new Color(110, 156, 66, 255));
				} else if (colorChange == false) {
					x.setColor(new Color(0, 73, 0, 255));
				}
			}

		}


		for (LeftWall x : paredesEsquerda) {
			x.setPy(x.getPy() + 10);
			for (Inimigos y : listaDeInimigos) {
				if (y.getPx() < x.getPx() + x.getLargura() && y.getTipo() != Tipos.PASSARO) {

					y.changeDir();
				}
			}

			if (Util.colideX(x, aviao)) {
				System.out.println("bateu esquerda");
				gameOver = true;


			}
			if (x.getPy() > 800) {
				x.setPy(-8);

				int novaLargura = rand.nextInt(paredePassada.getLargura() - 10, paredePassada.getLargura() + 10);

				int larguraMinima = 100;
				if (novaLargura < larguraMinima) {
					novaLargura = larguraMinima;
				}
				x.setLargura(novaLargura);

				paredePassada = x;
				if (colorChange == true) {
					x.setColor(new Color(110, 156, 66, 255));
				} else if (colorChange == false) {
					x.setColor(new Color(0, 73, 0, 255));
				}
			}

		}
		for (Fuel x : fuelList) {
			if (x.getPy() > 800) {
				x.setPy(-rand.nextInt(3000));
				x.setPx(rand.nextInt(240, 400) + 1);
				x.setDead(false);
				x.setDeadAnimCount(0);
				x.setAtivo(true);
			}
			x.setPy(x.getPy() + 5);
			if (Util.colideFuel(aviao, x)) {
				if (aviao.getCombustivel() < 530)
					aviao.aumenta();
					Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\GasSound.wav");
			}
			if (aviao.getCombustivel() == 240) {
				aviao.setCombustivel(530);
				aviao.setVidas(aviao.getVidas() - 1);
			}
			if (Util.colideFuel(tiro, x)) {
				x.setAtivo(false);
				x.setDead(true);
				Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\explosion.wav");
				tiro.setAtivo(false);
			}
		}
		for (Inimigos x : listaDeInimigos) {
			x2 = x;
			x.shouldMove(aviao);
			if (Util.colideInimigo(tiro, x)) {
				hud.setPontos(hud.getPontos() + x.getPremio());
				x.setAtivo(false);
				tiro.setAtivo(false);

				x.setDead(true);
				Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\explosion.wav");
			}
			if (Util.colideInimigo(aviao, x)) {
				aviao.setVidas(aviao.getVidas() - 1);
				x.setDead(true);
				x.setAtivo(false);
			}
			g2d.setColor(Color.RED);

			if (x.getTipo() == Tipos.PASSARO) {
				if (x.getPx() > 840) {
					x.setPx(-20);
					x.changeDirTo(1);

				} else if (x.getPx() < -40) {
					x.setPx(819);
					x.changeDirTo(-1);

				}

			}


			if (x.getPy() > 800) {
				x.setMove(false);
				x.setPy(-rand.nextInt(800));
				x.setPx(rand.nextInt(200, 580) + 1);
				x.setDead(false);
				x.setAtivo(true);
				x.setDeadAnimCount(0 );
				x.setTipo(Inimigos.getRandomTipos());
			}
		}
		bridge.setPy(bridge.getPy() + 10);
		if (bridge.getPy() > 800) {
			bridge.setPy(-10000);
			bridge.setAtivo(true);

		}
		if (bridge.getPy() > 0 && bridge.getPy() < 11) {
			if (colorChange == false) {
				colorChange = true;
			} else if (colorChange == true) {
				colorChange = false;
			}
		}
		if (Util.colideBridge(aviao, bridge)) {
			Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\explosion.wav");
			gameOver();
		}
		if (bridge.getPy() > 0) {
			if (Util.colideBridge(tiro, bridge)) {
				bridge.setAtivo(false);
				tiro.setAtivo(false);
				fundo = Color.red;
				contadorFundo = true;
				Util.playSound(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\bridgeDestroy.wav");
			}
		}
		if (contadorFundo == true) {
			changeFundoCor();
		}
	}

	private void renderGame() {
		if(!gameOver) {
			// Clear the buffer
			g2d.setColor(fundo);
			g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);

			for (LeftWall x : paredesEsquerda) {
				x.desenha(g2d);
			}
			for (RightWall x : paredesDireitas) {
				x.desenha(g2d);
			}

			for (House x : housesLeft) {
				x.desenha(g2d);
			}
			for (House x : housesRight) {
				x.desenha(g2d);
			}
			for (Fuel x : fuelList) {

				x.desenha(g2d);
			}
			tiro.desenha(g2d);

			aviao.desenha(g2d);


			for (Inimigos x : listaDeInimigos) {
				x.desenha(g2d);
			}

			bridge.desenha(g2d);
			g2d.setColor(new Color(142, 142, 142, 255));
			g2d.fillRect(0, 620, 800, 150);
			hud.desenha(g2d, aviao.getCombustivel());
			g2d.setColor(Color.yellow);
			texto.desenha(g2d, String.valueOf(hud.getPontos()), 355, 660);
			texto.desenha(g2d, String.valueOf(aviao.getVidas()), 570, 720);
		}
		else {
			gameOver();
			hud.setContadorScore(hud.getContadorScore() + 1);
			hud.handleContadorScore(ranking);
		}



	}

	private void gameOver() {
		gameOver = true;

		System.out.println(hud.getPontos());
		sound.stop();
		try {
			ranking.updateRanking(hud.getPontos()); // Primeiro atualiza o ranking
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);
			ranking.setPx(150);
			ranking.setPy(150);
			ranking.desenharRanking(g2d, hud); // Depois desenha o ranking
			tela.repaint();
			//timer.stop();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in gameOver: " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.carregarJogo();
	}
}
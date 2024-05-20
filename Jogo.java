package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.com.mvbos.lgj.Inimigos.Tipos;
import br.com.mvbos.lgj.base.Elemento;
import br.com.mvbos.lgj.base.Texto;
import br.com.mvbos.lgj.base.Util;

public class Jogo extends JFrame {

	//Settings da janela
	private static final long serialVersionUID = 1L;

	private static  int FPS = 800 / 20;

	private static final int JANELA_ALTURA = 800;
	private static final int JANELA_LARGURA = 800;
	//Settings da janela

	//declarando variaveis graficas
	private JPanel tela; // -> Janela
	private Graphics2D g2d; // -> PLAYER
	private BufferedImage buffer; // -> Buffer

	private boolean[] controleTecla = new boolean[5]; // -> array de controles, vai ser usado para definir oq vai acontecer

	//declarando variaveis graficas
	//declarando variaveis uteis

	// Elementos do jogo
	private int vidas = 3;


	private Elemento tiroTanque;
	private Elemento tiroChefe;
	private Elemento[] tiros = new Tiro[3];

	private Texto texto = new Texto();
	private Inimigos chefe;
	private Elemento tanque;

	private Inimigos[][] invasores = new Inimigos[1][1];
	private Inimigos.Tipos[] tipoPorLinha = { Tipos.COMBUSTIVEL, Tipos.AVIAO, Tipos.BARCO, Tipos.PASSARO };

	private int linhaBase = 60;
	private int espacamento = 15;
	private int destruidos = 0;
	private int dir;
	private int totalInimigos;
	private int contadorEspera;
	boolean novaLinha;
	boolean moverInimigos;
	private int contador;
	private int pontos;
	private int level = 1;
	private Random rand = new Random();
	private House house;
	private Elemento aviao;
	private Timer timer;

	private Tiro tiro;
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
		house = new House();
		house.setVel(3);
		house.setAtivo(true);
		house.setPx(rand.nextInt(20) + 1);
		house.setPy(rand.nextInt(20) + 1);
		aviao = new Aviao();
		aviao.setVel(3);
		aviao.setAtivo(true);
		aviao.setPx(tela.getWidth() / 2 - aviao.getLargura() / 2);
		aviao.setPy(tela.getHeight() - aviao.getAltura() - linhaBase);
	}

	private void gameLoop() {
		updateGame();
		renderGame();
		tela.repaint();
	}

	private void updateGame() {
		if (controleTecla[0]) {
			timer.setDelay(10);
		}

		else if (controleTecla[1]) {
			timer.setDelay(70);
		}
		else{
			timer.setDelay(FPS);
		}

		if (controleTecla[2]) {
			aviao.setPx(aviao.getPx() - 5); // Move left
		}
		if (controleTecla[3] ) {
			aviao.setPx(aviao.getPx() + 5); // Move right
		}
		if (controleTecla[4] && !tiro.isAtivo()) {
			tiro.setAtivo(true);
			tiro.setPx(aviao.getPx() + 20);
			tiro.setPy(aviao.getPy() + 10);
		}
		if(Util.colide(aviao,house)){
			System.out.println("AI AI BATEU PORRA");
		}
		if(house.getPy() > 800){
			house.setPx(rand.nextInt(150) + 1);
			house.setPy(0);

		}

		house.setPy(house.getPy()+ 5);
		if(tiro != null ){
			tiro.setPy(tiro.getMovPy() - 30);
			tiro.setPx(aviao.getPx() + 10);
		}
		if(Util.colide(tiro,house) || tiro.getPy() < 0){
			tiro.setAtivo(false);
		}
	}

	private void renderGame() {
		// Clear the buffer
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);


		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, 180, 800);
		g2d.fillRect(604, 0, 180, 800);
		aviao.desenha(g2d);
		house.desenha(g2d);
		tiro.desenha(g2d);

	}


	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.carregarJogo();
	}
}

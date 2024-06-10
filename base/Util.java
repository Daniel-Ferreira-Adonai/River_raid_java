package br.com.mvbos.lgj.base;

import br.com.mvbos.lgj.*;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class Util {

	public static boolean colide(Elemento a, Elemento b) {
		if (!a.isAtivo() || !b.isAtivo())
			return false;

		final int plA = a.getPx() + a.getLargura();
		final int plB = b.getPx() + b.getLargura();
		final int paA = a.getPy() + a.getAltura();
		final int paB = b.getPy() + b.getAltura();

		if (plA > b.getPx() && a.getPx() < plB && paA > b.getPy() && a.getPy() < paB) {
			return true;
		}

		return false;
	}
	public static boolean colideBridge(Elemento a, Bridge b) {

if(b.isAtivo()) {
	if (a instanceof Aviao) {
		int boatWidth = b.getLargura();
		int boatHeight = b.getAltura();

		// Check horizontal collision
		boolean horizontalCollision = a.getPx() < b.getPx() + 800 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 800;

		// Check vertical collision
		boolean verticalCollision = a.getPy() < b.getPy() - 10 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 100;

		if (horizontalCollision && verticalCollision) {
			return true;
		}
	}
	if (a instanceof Tiro) {
		int boatWidth = b.getLargura();
		int boatHeight = b.getAltura();

		// Check horizontal collision
		boolean horizontalCollision = a.getPx() < b.getPx() +100 + boatWidth && a.getPx() + a.getLargura() > b.getPx() -100;

		// Check vertical collision
		boolean verticalCollision = a.getPy() < b.getPy()  + boatHeight && a.getPy() + a.getAltura() > b.getPy()  ;

		if (horizontalCollision && verticalCollision) {
			return true;
		}
	}


}
		if(!b.isAtivo()) {
			if (a instanceof Aviao) {

				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision ;
				if(a.getPx() > 480){
					horizontalCollision = true;
				}

				else if(a.getPx() < 300){
					horizontalCollision = true;
				}
				else{
					horizontalCollision = false;
				}
				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() - 10 + boatHeight && a.getPy() + a.getAltura() > b.getPy() ;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean colideFuel(Elemento a, Fuel b) {
		if (!a.isAtivo() || !b.isAtivo()) {
			return false;
		}

		if (a instanceof Aviao) {
			int boatWidth = b.getLargura();
			int boatHeight = b.getAltura();

			// Check horizontal collision
			boolean horizontalCollision = a.getPx() < b.getPx() + 30 + boatWidth && a.getPx() + a.getLargura() > b.getPx() + 10 ;

			// Check vertical collision
			boolean verticalCollision = a.getPy() < b.getPy() + 40 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 100;

			if (horizontalCollision && verticalCollision) {
				return true;
			}
		}
		if (a instanceof Tiro) {
			int boatWidth = b.getLargura();
			int boatHeight = b.getAltura();

			// Check horizontal collision
			boolean horizontalCollision = a.getPx() < b.getPx() + 30 + boatWidth && a.getPx() + a.getLargura() > b.getPx() + 10 ;

			// Check vertical collision
			boolean verticalCollision = a.getPy() < b.getPy()  + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 30;

			if (horizontalCollision && verticalCollision) {
				return true;
			}
		}
	return false;
	}

	public static boolean colideInimigo(Elemento a, Inimigos b) {
		if (!a.isAtivo() || !b.isAtivo()) {
			return false;
		}

		if(a instanceof Aviao){
			if (b.getTipo() == Inimigos.Tipos.BARCO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 80 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 20;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() + boatHeight && a.getPy() + a.getAltura() > b.getPy();

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}
			if (b.getTipo() == Inimigos.Tipos.PASSARO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 55 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 60;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() + 20 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 20;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}
			if (b.getTipo() == Inimigos.Tipos.HELICOPTERO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 20 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 30;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() + 4 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 60;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}

		}
		if(a instanceof Tiro){
			if (b.getTipo() == Inimigos.Tipos.BARCO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 80 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 20;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() - 25 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 20;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}
			if (b.getTipo() == Inimigos.Tipos.PASSARO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 55 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 60;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() -30 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 20;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}
			if (b.getTipo() == Inimigos.Tipos.HELICOPTERO) {
				int boatWidth = b.getLargura();
				int boatHeight = b.getAltura();

				// Check horizontal collision
				boolean horizontalCollision = a.getPx() < b.getPx() + 20 + boatWidth && a.getPx() + a.getLargura() > b.getPx() - 30;

				// Check vertical collision
				boolean verticalCollision = a.getPy() < b.getPy() -30 + boatHeight && a.getPy() + a.getAltura() > b.getPy() - 60;

				if (horizontalCollision && verticalCollision) {
					return true;
				}
			}

		}
		return false;
	}


	public static boolean colideX(Elemento a, Elemento b) {
		if (!a.isAtivo() || !b.isAtivo())
			return false;


		if(b instanceof Aviao) {
			if(b.getPx() < 400){
				if (a.getPx() + a.getLargura() >= b.getPx() - 20 && a.getPx() <= b.getPx() - 20 + b.getLargura()) {
					return true;

				}
				else{
					return false;
				}
			}
			if (b.getPx() > 400) {
				if(b.getPx() -15 == a.getPx() - a.getLargura() ){
					return  true;
				}
				else {
					return false;
				}
			}

		}
		if (a.getPx() + a.getLargura() >= b.getPx() && a.getPx() <= b.getPx() + b.getLargura()) {
			return true;
		}


		return false;
	}

	public static void centraliza(Elemento el, int larg, int alt) {
		if (alt > 0)
			el.setPy(alt / 2 - el.getAltura() / 2);

		if (larg > 0)
			el.setPx(larg / 2 - el.getLargura() / 2);

	}

	public static void centraliza(Elemento el, Elemento elReferente) {
		el.setPx(elReferente.getPx() + elReferente.getLargura() / 2 - el.getLargura() / 2);
		el.setPy(elReferente.getPy() + elReferente.getAltura() / 2 - el.getAltura() / 2);
	}

	public static boolean saiu(Elemento e, int largura, int altura) {
		return saiu(e, largura, altura, 0);
	}

	public static boolean saiu(Elemento e, int largura, int altura, int margem) {
		if (e.getPx() < -margem || e.getPx() + e.getLargura() > largura + margem)
			return true;

		if (e.getPy() < -margem || e.getPy() + e.getAltura() > altura + margem)
			return true;

		return false;
	}

	/**
	 * Teletransporte
	 */
	public static void corrigePosicao(Elemento el, int limiteX, int limitY) {
		float nx = el.getMovPx(); // Nova posi��o x
		float ny = el.getMovPy(); // Nova posi��o y

		if (nx + el.getLargura() < 0)
			nx = limiteX;
		else if (nx > limiteX)
			nx = -el.getLargura();

		if (ny + el.getAltura() < 0)
			ny = limitY;
		else if (ny > limitY)
			ny = -el.getAltura();

		el.setPx(nx);
		el.setPy(ny);
	}
	public static void playSound(String soundFileName) {
		try {
			File soundFile = new File(soundFileName);
			if (soundFile.exists()) {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				clip.drain();
			} else {
				System.out.println("Sound file not found: " + soundFileName);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}
	public static void playSound2(String soundFileName) {
		try {
			File soundFile = new File(soundFileName);
			if (soundFile.exists()) {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();

			} else {
				System.out.println("Sound file not found: " + soundFileName);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}
	public static Clip playSoundLoop(String soundFileName) {
		try {
			File soundFile = new File(soundFileName);


			if (soundFile.exists()) {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
				return clip;
			} else {
				System.out.println("Sound file not found: " + soundFileName);

			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
			return null;
		}
        return null;
    }

}

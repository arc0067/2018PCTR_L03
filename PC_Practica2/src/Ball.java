package src;

import java.awt.Image;
import javax.swing.ImageIcon;

//TODO Transform the code to be used safely in a concurrent context.  
public class Ball {
	// TODO Find an archive named Ball.png
	/**
	 * Enlazamos la imagen de la bola con el programa.
	 */
	private String Ball = "ball.png";

	private double x, y, dx, dy;
	private double v, fi;
	private Image image;
	private final int IMG_TAM_X, IMG_TAM_Y;

	public Ball() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(Ball));
		image = ii.getImage();

		// TODO Depend of image size
		/**
		 * Hemos redimensionado nuestra imagen original a 32x32 con una herramienta de
		 * Internet.
		 */
		IMG_TAM_X = 32;
		IMG_TAM_Y = 32;

		x = Billiards.Width / 4 - 16;
		y = Billiards.Height / 2 - 16;
		v = 5;
		fi = Math.random() * Math.PI * 2;
	}

	public void move() {
		v = v * Math.exp(-v / 1000);
		dx = v * Math.cos(fi);
		dy = v * Math.sin(fi);
		if (Math.abs(dx) < 1 && Math.abs(dy) < 1) {
			dx = 0;
			dy = 0;
		}
		x += dx;
		y += dy;

		reflect();

		// TODO Check postcondition
		/**
		 * Hacemos las postcondiciones en el movimiento de las bolas.
		 */
		assert x < Board.RIGHTBOARD : "INV: La bola se salio por el lado derecho ";
		assert x > Board.LEFTBOARD : "INV: La bola se salio por el lado izquierdo ";
		assert y < Board.TOPBOARD : "INV: La bola se salio por arriba ";
		assert y > Board.BOTTOMBOARD : "INV: La bola se salio por abajo ";
	}

	private void reflect() {
		if (Math.abs(x + IMG_TAM_X - Board.RIGHTBOARD) < Math.abs(dx)) {
			fi = Math.PI - fi;
		}
		if (Math.abs(y + IMG_TAM_Y - Board.BOTTOMBOARD) < Math.abs(dy)) {
			fi = -fi;
		}
		if (Math.abs(x - Board.LEFTBOARD) < Math.abs(dx)) {
			fi = Math.PI - fi;
		}
		if (Math.abs(y - Board.TOPBOARD) < Math.abs(dy)) {
			fi = -fi;
		}
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public double getFi() {
		return fi;
	}

	public double getdr() {
		return Math.sqrt(dx * dx + dy * dy);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

}

package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Billiards extends JFrame {

	public static int Width = 800;
	public static int Height = 600;

	private JButton b_start, b_stop;

	private Board board;

	// TODO update with number of group label. See practice statement.
	private final int N_BALL = 6;
	private Ball[] balls;
	private Thread[] hilos;

	public Billiards() {

		board = new Board();
		board.setForeground(new Color(0, 128, 0));
		board.setBackground(new Color(0, 128, 0));

		initBalls();

		b_start = new JButton("Empezar");
		b_start.addActionListener(new StartListener());
		b_stop = new JButton("Parar");
		b_stop.addActionListener(new StopListener());

		JPanel p_Botton = new JPanel();
		p_Botton.setLayout(new FlowLayout());
		p_Botton.add(b_start);
		p_Botton.add(b_stop);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(board, BorderLayout.CENTER);
		getContentPane().add(p_Botton, BorderLayout.PAGE_END);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Width, Height);
		setLocationRelativeTo(null);
		setTitle("Pr�ctica programaci�n concurrente objetos m�viles independientes");
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Metodo en el que inicializamos las bolas y declaramos los hilos.
	 */
	private void initBalls() {
		// TODO init balls
		balls = new Ball[N_BALL];
		hilos = new Thread[N_BALL];
		for (int i = 0; i < balls.length; i++) {
			balls[i] = new Ball();
		}
		board.setBalls(balls);

	}

	/**
	 * Subclase en la que iniciamos el programa inicializando los hilos para que
	 * funcione el boton Empezar.
	 */
	private class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Code is executed when start button is pushed
			for (int j = 0; j < N_BALL; j++) {
				hilos[j] = new Thread(new MovimientoHilos(balls[j], board));

			}

			for (int k = 0; k < hilos.length; k++) {
				hilos[k].start();
			}
		}
	}

	/**
	 * Subclase en la que paramos el programa con la excepcion interrupt que
	 * recogemos en run(). Lanza una excepcion por cada hilo que hayamos
	 * inicializado.
	 */
	private class StopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Code is executed when stop button is pushed
			for (int i = 0; i < hilos.length; i++) {
				hilos[i].interrupt();
			}

		}
	}

	public static void main(String[] args) {
		new Billiards();
	}
}
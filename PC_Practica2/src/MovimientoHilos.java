package src;
/***
 * 
 * @author Alisson Romero Chila
 * @author Daniel Beato de la Torre
 *
 */

public class MovimientoHilos implements Runnable{
	
	/**
	 * Declaracion variables bola y tablero.
	 */
	private Ball bola;
	private Board board;
	
	/**
	 * Constructor sin parametros.
	 */
	public MovimientoHilos() {
		
	}
	
	/**
	 * Constructor con dos parametros.
	 * @param bola
	 * @param board
	 */
	public MovimientoHilos(Ball bola, Board board) {
		this.bola =bola;
		this.board = board;
	}
	
	/**
	 * Metodo run() que ejecutara el estado del programa para cada bola y controla las excepciones.
	 */
	@Override
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				bola.move();
				board.repaint();
				//TimeUnit.MILLISECONDS.sleep(10);
				Thread.sleep(10);
			}
		
		}catch (InterruptedException ex) {
			//ex.printStackTrace();
			System.err.println("Don't worry, le has dado al botón Parar: "+ex);
		}
		
	}
}

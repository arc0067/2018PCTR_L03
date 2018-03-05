package src;

import java.util.concurrent.TimeUnit;

public class MovimientoHilos extends Thread {
	
	private Ball bola;
	private Board board;
	
	public MovimientoHilos(Ball bola, Board board) {
		this.bola =bola;
		this.board = board;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				bola.move();
				board.repaint();
				TimeUnit.MILLISECONDS.sleep(1000);
			
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}


}

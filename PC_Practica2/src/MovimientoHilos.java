package src;

import java.util.concurrent.TimeUnit;

public class MovimientoHilos implements Runnable{
	
	private Ball bola;
	private Board board;
	
	public MovimientoHilos() {
		
	}
	
	public MovimientoHilos(Ball bola, Board board) {
		this.bola =bola;
		this.board = board;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				bola.move();
				board.repaint();
				TimeUnit.MILLISECONDS.sleep(10);
			
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

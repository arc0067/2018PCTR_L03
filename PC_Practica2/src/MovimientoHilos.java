package src;


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

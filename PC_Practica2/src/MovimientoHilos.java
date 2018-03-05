package src;

public class MovimientoHilos extends Thread {
	
	private Ball bola;
	
	public MovimientoHilos() {
		// TODO Auto-generated constructor stub
	}

	public MovimientoHilos(Ball bola) {
		this.bola =bola;
	}
	
	public void run() {
		try {
			for(;;) {
				bola.move();
				Thread.sleep(1000);
			}
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}


}

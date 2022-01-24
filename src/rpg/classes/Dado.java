package rpg.classes;

import java.util.Random;

public abstract class Dado {
	private Random sorteio;
	private int valorMax;

	public Dado(int valorMax) {
		this.sorteio = new Random();
		this.valorMax = valorMax;
	}

	public int getValorMax() {
		return this.valorMax;
	}

	public int rolagem() {
		return sorteio.nextInt(valorMax) + 1;
	}
}

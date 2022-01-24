package rpg.classes;

public class Cajado extends Arma {
	private final static int DANO = 9;

	public Cajado() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com seu cajado, lançando uma bola de fogo";
	}

	@Override
	public String toString() {
		return "Cajado";
	}
}

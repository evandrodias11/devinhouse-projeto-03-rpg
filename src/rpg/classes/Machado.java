package rpg.classes;

public class Machado extends Arma {
	private final static int DANO = 7;

	public Machado() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com seu machado";
	}

	@Override
	public String toString() {
		return "Machado";
	}
}

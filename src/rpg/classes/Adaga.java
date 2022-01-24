package rpg.classes;

public class Adaga extends Arma {
	private final static int DANO = 9;

	public Adaga() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com sua adaga";
	}

	@Override
	public String toString() {
		return "Adaga";
	}
}
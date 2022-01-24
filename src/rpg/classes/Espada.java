package rpg.classes;

public class Espada extends Arma {
	private final static int DANO = 5;

	public Espada() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com sua espada";
	}

	@Override
	public String toString() {
		return "Espada";
	}
}

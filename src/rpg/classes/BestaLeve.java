package rpg.classes;

public class BestaLeve extends Arma {
	private final static int DANO = 9;

	public BestaLeve() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com sua besta";
	}

	@Override
	public String toString() {
		return "Besta leve";
	}
}
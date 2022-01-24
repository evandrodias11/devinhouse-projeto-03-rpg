package rpg.classes;

public class Atirador extends ClasseDeCombate {
	private final static int ATAQUE = 14;
	private final static int DEFESA = 30;
	private final static Arma[] ARMA = { new Adaga(), new BestaLeve() };

	public Atirador() {
		super(ATAQUE, DEFESA, ARMA);
	}
}

package rpg.classes;

public class Lutador extends ClasseDeCombate {
	private final static int ATAQUE = 10;
	private final static int DEFESA = 40;
	private final static Arma[] ARMAS = { new Espada(), new Machado() };

	public Lutador() {
		super(ATAQUE, DEFESA, ARMAS);
	}

}

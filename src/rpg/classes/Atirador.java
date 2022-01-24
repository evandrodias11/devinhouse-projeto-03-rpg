package rpg.classes;

public class Atirador extends ClasseDeCombate {
	private static final String NOME = "Atirador(a)";
	private final static int ATAQUE = 14;
	private final static int DEFESA = 30;
	private final static Arma[] ARMA = { new Adaga(), new BestaLeve() };	

	public Atirador() {
		super(NOME, ATAQUE, DEFESA, ARMA);
	}
}

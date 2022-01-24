package rpg.classes;

public class Bruxo extends ClasseDeCombate {
	private static String NOME = "Bruxo(a)";
	private final static int ATAQUE = 20;
	private final static int DEFESA = 15;
	private final static Arma[] ARMA = { new Cajado(), new VarinhaMagica() };	

	public Bruxo() {
		super(NOME , ATAQUE, DEFESA, ARMA);
	}
}

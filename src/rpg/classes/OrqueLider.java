package rpg.classes;

public class OrqueLider extends Inimigo {
	private final static ClasseDeCombate CLASSE_DE_COMBATE = new Lutador();
	private final static int VIDA_MAX = 85;
	private final static int ATAQUE_BASE = 12;
	private final static int DEFESA_BASE = 12;
	private final static int ARMA_ESCOLHIDA = 1;
	private final static Genero GENERO = Genero.MASCULINO;
	private final static String NOME = "Orque Líder";

	public OrqueLider() throws IndexOutOfBoundsException {
		super(VIDA_MAX, ATAQUE_BASE, DEFESA_BASE, CLASSE_DE_COMBATE, ARMA_ESCOLHIDA, NOME, GENERO);
	}
}

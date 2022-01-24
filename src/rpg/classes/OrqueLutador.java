package rpg.classes;

public class OrqueLutador extends Inimigo {
	private final static ClasseDeCombate CLASSE_DE_COMBATE = new Lutador();
	private final static int VIDA_MAX = 50;
	private final static int ATAQUE_BASE = 4;
	private final static int DEFESA_BASE = 4;
	private final static int ARMA_ESCOLHIDA = 0;
	private final static Genero GENERO = Genero.MASCULINO;
	private final static String NOME = "Orque Lutador";

	public OrqueLutador() {
		super(VIDA_MAX, ATAQUE_BASE, DEFESA_BASE, CLASSE_DE_COMBATE, ARMA_ESCOLHIDA, NOME, GENERO);
	}
}

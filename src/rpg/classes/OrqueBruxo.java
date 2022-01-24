package rpg.classes;

public class OrqueBruxo extends Inimigo {
	private final static ClasseDeCombate CLASSE_DE_COMBATE = new Bruxo();
	private final static int VIDA_MAX = 55;
	private final static int ATAQUE_BASE = 8;
	private final static int DEFESA_BASE = 8;
	private final static int ARMA_ESCOLHIDA = 0;
	private final static Genero GENERO = Genero.MASCULINO;
	private final static String NOME = "Orque Mago";

	public OrqueBruxo() throws IndexOutOfBoundsException {
		super(VIDA_MAX, ATAQUE_BASE, DEFESA_BASE, CLASSE_DE_COMBATE, ARMA_ESCOLHIDA, NOME, GENERO);
	}
}

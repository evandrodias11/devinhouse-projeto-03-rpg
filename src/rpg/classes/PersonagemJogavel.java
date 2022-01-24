package rpg.classes;

public class PersonagemJogavel extends PersonagensDeCombate {
	public enum Motivacao {
		VINGANCA("Vingança"), GLORIA("Glória");

		private String nome;

		private Motivacao(String name) {
			this.nome = name;
		}

		public String getNome() {
			return this.nome;
		}
	}

	private final static int ATAQUE_BASE = 10;
	private final static int DEFESA_BASE = 10;
	private final static int VIDA_MAX = 100;
	private Motivacao motivacao;

	public PersonagemJogavel(ClasseDeCombate classeDeCombate, int armaEscolhida, String nome, Genero genero)
			throws IndexOutOfBoundsException {
		super(VIDA_MAX, ATAQUE_BASE, DEFESA_BASE, classeDeCombate, armaEscolhida, nome, genero);
	}

	public Motivacao getMotivacao() {
		return this.motivacao;
	}

	public void setMotivation(Motivacao motivacao) {
		this.motivacao = motivacao;
	}
}

package rpg.classes;

public abstract class PersonagensDeCombate {
	public enum Genero {
		MASCULINO, FEMININO;
	}

	public ClasseDeCombate classeDeCombate;
	private String nome;
	private Arma arma;
	private Genero genero;
	private int vidaMaxima;
	private int vidaAtual;
	private int ataqueBase;
	private int defesaBase;

	public PersonagensDeCombate(int vidaMaxima, int ataqueBase, int defesaBase, ClasseDeCombate classeDeCombate,
			int armaEscolhida, String nome, Genero genero) throws IndexOutOfBoundsException {
		this.vidaMaxima = vidaMaxima;
		this.vidaAtual = vidaMaxima;
		this.ataqueBase = ataqueBase;
		this.defesaBase = defesaBase;
		this.classeDeCombate = classeDeCombate;
		this.arma = classeDeCombate.getArma()[armaEscolhida];
		this.nome = nome;
		this.genero = genero;
	}

	public int getVidaAtual() {
		return this.vidaAtual;
	}

	public int getVidaMaxima() {
		return this.vidaMaxima;
	}

	public void modificarVidaAtual(int value) {
		this.vidaAtual += value;
		if (this.vidaAtual > this.getVidaMaxima()) {
			this.vidaAtual = this.getVidaMaxima();
		} else if (this.vidaAtual < 0) {
			this.vidaAtual = 0;
		}
	}

	public void levarDano(int dano) {
		this.vidaAtual -= dano;
		if (this.vidaAtual < 0) {
			this.vidaAtual = 0;
		}
	}

	public void beberPocao(Pocao pocao) {
		pocao.aplicarEfeito(this);
	}

	public int getAtaqueBase() {
		return this.ataqueBase;
	}

	public int getDefesaBase() {
		return this.defesaBase;
	}

	public void setDefesaBase(int defesaBase) {
		this.defesaBase = defesaBase;
	}

	public int getAtaqueTotal() {
		return this.getAtaqueBase() + this.getClasseDeCombate().getAtaque();
	}

	public int getDefesaTotal() {
		return this.getDefesaBase() + this.getClasseDeCombate().getDefesa();
	}

	public Arma getArma() {
		return this.arma;
	}

	public String getNome() {
		return this.nome;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public ClasseDeCombate getClasseDeCombate() {
		return this.classeDeCombate;
	}
}

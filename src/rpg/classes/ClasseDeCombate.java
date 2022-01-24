package rpg.classes;

public abstract class ClasseDeCombate {
	public String nome;
	private int ataque;
	private int defesa;
	private Arma[] arma;

	public ClasseDeCombate(String nome, int ataque, int defesa, Arma[] arma) {
		this.nome = nome;
		this.ataque = ataque;
		this.defesa = defesa;
		this.arma = arma;
	}

	public int getAtaque() {
		return this.ataque;
	}

	public int getDefesa() {
		return this.defesa;
	}

	public Arma[] getArma() {
		return this.arma;
	}
	
	public String getNome() {
		return this.nome;
	}

}

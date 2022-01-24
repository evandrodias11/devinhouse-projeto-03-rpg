package rpg.classes;

public abstract class ClasseDeCombate {
	private int ataque;
	private int defesa;
	private Arma[] arma;

	public ClasseDeCombate(int ataque, int defesa, Arma[] arma) {
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

}

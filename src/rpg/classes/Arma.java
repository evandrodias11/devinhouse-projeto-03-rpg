package rpg.classes;

public abstract class Arma {
	private int dano;

	public abstract String textoAtaque();

	public Arma(int dano) {
		this.dano = dano;
	}

	public int getDano() {
		return this.dano;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

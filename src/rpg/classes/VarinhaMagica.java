package rpg.classes;

public class VarinhaMagica extends Arma {
	private final static int DANO = 9;

	public VarinhaMagica() {
		super(DANO);
	}

	public String textoAtaque() {
		return "com sua varinha mágica, lançando um feitiço";
	}

	@Override
	public String toString() {
		return "Varinha Mágica";
	}
}

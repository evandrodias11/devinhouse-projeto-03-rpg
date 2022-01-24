package rpg.classes;

public class Pocao {
	private int valor;

	public Pocao(int valor) {
		this.valor = valor;
	}

	public int getValue() {
		return this.valor;
	}

	public void aplicarEfeito(PersonagensDeCombate personagem) {
		personagem.modificarVidaAtual(this.getValue());
	}
}

package rpg.classes;

public enum NivelDificuldade {
	FACIL(0.8), // Inimigos causam 80% de dano;
	NORMAL(1), // sem modificações de dano;
	DIFICIL(0.9); // Jogador causa 90% de dano;

	private double danoPercentual;

	private NivelDificuldade(double danoPercentual) {
		this.danoPercentual = danoPercentual;
	}

	public double getDamagePercentual() {
		return this.danoPercentual;
	}
}

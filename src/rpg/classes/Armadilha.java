package rpg.classes;

public class Armadilha {
	private Dado dado;

	public Armadilha(Dado dice) {
		this.dado = dice;
	}

	public int getDamage(PersonagensDeCombate personagem) {
		int dano = dado.rolagem();
		personagem.levarDano(dano);
		System.out.printf("%s tomou %d de dano pela armadilha, e agora possui %d pontos de vida.%n",
				personagem.getNome(), dano, personagem.getVidaAtual());
		return dano;
	}
}

package rpg.classes;

public abstract class Inimigo extends PersonagensDeCombate {
	public Inimigo(int vidaMax, int ataqueBase, int defesaBase, ClasseDeCombate classeDeCombate, int armaEscolhida,
			String nome, Genero genero) throws IndexOutOfBoundsException {
		super(vidaMax, ataqueBase, defesaBase, classeDeCombate, armaEscolhida, nome, genero);
	}
}

import rpg.classes.EntradaDeDados;
import rpg.classes.Historia;

public class App {
	public static void main(String[] args) throws Exception {
		try {
			Historia jogo = EntradaDeDados.criarJogo();
			jogo.comecar();
			System.out.println("FIM DO JOGO");
		} catch (NullPointerException e) {
			System.out.println("Erro ao criar jogo!");
			return;
		}
	}
}

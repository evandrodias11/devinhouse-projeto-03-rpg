package rpg.classes;

import java.util.Scanner;

import rpg.classes.PersonagensDeCombate.Genero;

public class EntradaDeDados {
	private EntradaDeDados() {

	}

	public static Historia criarJogo() {
		Scanner in = new Scanner(System.in);
		Diversos.linhaSeparadora();
		System.out.println("            Seja bem vindo(a) à BATALHA FINAL !");
		System.out.println("RPG desenvolvido por Evandro Dias no curso DEVinHouse/Senai");
		Diversos.linhaSeparadora();
		NivelDificuldade nivelDeDificuldade = null;
		do {
			try {
				System.out.println("Escolha o nível de dificuldade do jogo:");
				System.out.println("1 - Fácil");
				System.out.println("2 - Normal");
				System.out.println("3 - Difícil");
				int opcao = in.nextInt();
				switch (opcao) {
				case 1: {
					nivelDeDificuldade = NivelDificuldade.FACIL;
					break;
				}
				case 2: {
					nivelDeDificuldade = NivelDificuldade.NORMAL;
					break;
				}
				case 3: {
					nivelDeDificuldade = NivelDificuldade.DIFICIL;
					break;
				}
				default: {
					System.out.println("Opção inválida.");
				}
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				in.next();
			}
		} while (nivelDeDificuldade == null);
		in.nextLine();
		Diversos.linhaSeparadora();
		System.out.print("Digite o nome do seu personagem: ");
		String nome = in.nextLine();
		Genero genero = null;
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("Escolha o gênero do seu personagem:");
				System.out.println("1 - Masculino");
				System.out.println("2 - Feminino");
				int opcao = in.nextInt();
				switch (opcao) {
				case 1: {
					genero = Genero.MASCULINO;
					break;
				}
				case 2: {
					genero = Genero.FEMININO;
					break;
				}
				default: {
					System.out.println("Opção inválida.");
				}
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				in.next();
			}
		} while (genero == null);
		ClasseDeCombate classeDeCombate = null;
		do {
			try {
				switch (genero) {
				case MASCULINO: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Escolha a classe de combate do seu herói:");
					System.out.println("1 - Lutador");
					System.out.println("2 - Atirador");
					System.out.println("3 - Bruxo");
					break;
				}
				case FEMININO: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Escolha a classe de combate da sua heroína:");
					System.out.println("1 - Lutadora");
					System.out.println("2 - Atiradora");
					System.out.println("3 - Bruxa");
					break;
				}
				}
				int opcao = in.nextInt();
				switch (opcao) {
				case 1: {
					classeDeCombate = new Lutador();
					break;
				}
				case 2: {
					classeDeCombate = new Atirador();
					break;
				}
				case 3: {
					classeDeCombate = new Bruxo();
					break;
				}
				default: {
					System.out.println("Opção inválida.");
				}
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				in.next();
			}
		} while (classeDeCombate == null);
		int armaEscolhida = -1;
		do {
			try {
				switch (genero) {
				case MASCULINO: {
					Diversos.linhaSeparadora();
					System.out.println("Escolha a arma do seu herói:");
					break;
				}
				case FEMININO: {
					Diversos.linhaSeparadora();
					System.out.println("Escolha a arma da sua heroína:");
					break;
				}
				}
				Arma[] armasDisponiveis = classeDeCombate.getArma();
				if (armasDisponiveis.length == 0) {
					System.out.println("Erro: Classe de combate não possui armas!");
					return null;
				}
				for (int i = 0; i < armasDisponiveis.length; i++) {
					System.out.printf("%d - %s%n", (i + 1), armasDisponiveis[i]);
				}
				int opcao = in.nextInt();
				if (opcao > 0 && opcao <= armasDisponiveis.length) {
					armaEscolhida = opcao - 1; // índice do array da arma escolhida é - 1
				} else {
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				in.next();
			}
		} while (armaEscolhida == -1);
		PersonagemJogavel personagem = new PersonagemJogavel(classeDeCombate, armaEscolhida, nome, genero);
		Historia jogo = new Historia(nivelDeDificuldade, personagem);
		return jogo;
	}
}

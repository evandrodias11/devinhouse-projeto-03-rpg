package rpg.classes;

import java.util.Scanner;

import rpg.classes.Combate.VencedorDoCombate;
import rpg.classes.PersonagemJogavel.Motivacao;

public class Historia {
	private final static int NEW_ARMOR = 5;
	private NivelDificuldade nivelDeDificuldade;
	private PersonagemJogavel personagem;

	public Historia(NivelDificuldade nivelDeDificuldade, PersonagemJogavel personagem) {
		this.nivelDeDificuldade = nivelDeDificuldade;
		this.personagem = personagem;
	}

	public NivelDificuldade getLevelDeDificuldade() {
		return this.nivelDeDificuldade;
	}

	public PersonagemJogavel getPersonagem() {
		return this.personagem;
	}

	public void comecar() {
		Scanner entrada = new Scanner(System.in);
		Diversos.limparConsole();
		Diversos.linhaSeparadora();
		System.out.println("PREPARE-SE, O JOGO VAI COMEÇAR ! ");
		Diversos.linhaSeparadora();
		System.out.println("Nome do(a) jogador(a): " + this.personagem.getNome());
		System.out.println("Classe de combate: " + this.personagem.classeDeCombate.getNome());
		System.out.println("Arma: " + this.personagem.getArma());
		System.out.println("Vida: " + this.personagem.getVidaMaxima());
		System.out.println("Ataque total: " + this.personagem.getAtaqueTotal());
		System.out.println("Defesa total: " + this.personagem.getDefesaTotal());
		System.out.println("Level de Dificuldade do jogo: " + this.nivelDeDificuldade);
		Diversos.linhaSeparadora();
		Diversos.continuar();
		Diversos.limparConsole();
		Diversos.linhaSeparadora();
		System.out.println("                                           CAPÍTULO 1");
		Diversos.linhaSeparadora();
		System.out.println(
				"A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.");
		System.out.println(
				"Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");
		System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.");
		System.out.println("Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.");
		System.out.println(
				"Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.");
		System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
		Motivacao motivacao = null;
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:");
				Diversos.linhaSeparadora();
				Motivacao[] motivacoes = Motivacao.values();
				for (int i = 0; i < motivacoes.length; i++) {
					System.out.printf("%d - %s%n", (i + 1), motivacoes[i].getNome());
				}
				int opcao = entrada.nextInt();
				if (opcao > 0 && opcao <= motivacoes.length) {
					motivacao = motivacoes[opcao - 1]; // índice do array da arma escolhida é opcao - 1
				} else {
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				entrada.next();
			}
		} while (motivacao == null);
		this.getPersonagem().setMotivation(motivacao);
		motivacao = this.getPersonagem().getMotivacao();
		switch (motivacao) {
		case VINGANCA: {
			Diversos.limparConsole();
			Diversos.linhaSeparadora();
			System.out.println(
					"Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para lembrar,");
			System.out.println(
					"pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.");
			System.out.println("Elas são o combustível que te fizeram chegar até aqui.");
			System.out.println(
					"E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.");
			System.out.println(
					"O maldito líder finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).");
			break;
		}
		case GLORIA: {
			Diversos.limparConsole();
			Diversos.linhaSeparadora();
			System.out.println(
					"Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, bardos criando canções sobre seus feitos heróicos,");
			System.out.println(
					"nobres te presenteando com jóias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças.");
			System.out.println(
					"Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto assombrou a paz de todos.");
			System.out.println(
					"Porém, você sabe que ainda falta o último ato dessa história. Você se concentra na missão. A glória o aguarda, mas não antes da última batalha.");
			break;
		}
		}
		Diversos.linhaSeparadora();
		System.out.println(
				"Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza.");
		System.out.println("Seu foco está renovado. Você avança pelo portal.");
		System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.");
		System.out.println(
				"À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.");
		int opcao = 0;
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("1 - Seguir em frente");
				System.out.println("2 - Desistir");
				opcao = entrada.nextInt();
				switch (opcao) {
				case 1:
					break;
				case 2: {
					System.out.println(
							"O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
					return;
				}
				default: {
					System.out.println("Opção inválida.");
					opcao = 0;
				}
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				entrada.next();
				opcao = 0;
			}
		} while (opcao == 0);
		Diversos.limparConsole();
		Diversos.linhaSeparadora();
		System.out.println("                                           CAPÍTULO 2");
		Diversos.linhaSeparadora();
		System.out.println(
				"Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz,");
		System.out.println("que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
		System.out.println(
				"Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.");
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("1 - Andando cuidadosamente");
				System.out.println("2 - Correndo");
				System.out.println("3 - Saltando");
				opcao = entrada.nextInt();
				switch (opcao) {
				case 1: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println(
							"Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta,");
					System.out.println("você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.");
					System.out.println(
							"Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.");
					System.out.println(
							"Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
					Armadilha arrow = new Armadilha(new Dado10());
					arrow.getDamage(this.getPersonagem()); // considerando o dano verdadeiro baseado na rolagem dos
															// dados. Ele passa pela armadura.
					break;
				}
				case 2: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println(
							"Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta,");
					System.out.println(
							"mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.");
					System.out.println(
							"Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão.");
					System.out.println(
							"Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,");
					System.out.println("mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
					break;
				}
				case 3: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println(
							"Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Opção inválida.");
				entrada.next();
				opcao = 0;
			}
		} while (opcao == 0);
		Diversos.linhaSeparadora();
		System.out.println(
				"Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.");
		System.out.println(
				"A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas reconhece como sendo a língua antiga utilizada pelo inimigo.");
		System.out.println("Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,");
		System.out.println(
				"e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.");
		System.out.println("Você se dirige para a porta à direita.");
		System.out.println(
				"Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.");
		System.out.println(
				"Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.");
		System.out.println(
				"Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.");
		System.out.println(
				"Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino,");
		System.out.println(
				"está um dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.");
		Diversos.linhaSeparadora();
		boolean shouldContinue = entrarEmCombate(this, new OrqueLutador(), true);
		if (!shouldContinue) {
			return;
		}
		Diversos.linhaSeparadora();
		System.out.println(
				"Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("1 - Pegar armaduras novas");
				System.out.println("2 - Não pegar armaduras novas");
				opcao = entrada.nextInt();
				switch (opcao) {
				case 1: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println(
							"Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala.");
					System.out.println("De armadura nova, você se sente mais protegido para os desafios à sua frente.");
					int characterBaseDef = this.getPersonagem().getDefesaBase();
					this.getPersonagem().setDefesaBase(characterBaseDef + NEW_ARMOR);
					break;
				}
				case 2: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
					break;
				}
				default: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Opção inválida.");
					opcao = 0;
				}
				}
			} catch (Exception e) {
				Diversos.linhaSeparadora();
				System.out.println("Opção inválida.");
				entrada.next();
				opcao = 0;
			}
		} while (opcao == 0);
		Diversos.linhaSeparadora();
		System.out.println("                                           CAPÍTULO 3");
		Diversos.linhaSeparadora();
		System.out.println(
				"Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.");
		System.out.println("Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");
		System.out.println(
				"Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.");
		System.out.println(
				"Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal,");
		System.out.println(
				"mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,");
		System.out.println(
				"e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.");
		System.out.println(
				"No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");
		shouldContinue = entrarEmCombate(this, new OrqueBruxo(), true);
		if (!shouldContinue) {
			return;
		}
		Diversos.linhaSeparadora();
		System.out.println(
				"Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. Em uma mesa,");
		System.out.println(
				"você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se deve beber um gole.");
		Pocao potion = new Pocao(this.getPersonagem().getVidaMaxima());
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("1 - Beber poção");
				System.out.println("2 - Não beber poção");
				opcao = entrada.nextInt();
				switch (opcao) {
				case 1: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println(
							"Você se sente revigorado para seguir adiante! Seus pontos de vida foram restaurados!");
					this.getPersonagem().beberPocao(potion);
					break;
				}
				case 2: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
					break;
				}
				default: {
					Diversos.limparConsole();
					Diversos.linhaSeparadora();
					System.out.println("Opção inválida.");
					opcao = 0;
				}
				}
			} catch (Exception e) {
				Diversos.linhaSeparadora();
				System.out.println("Opção inválida.");
				entrada.next();
				opcao = 0;
			}
		} while (opcao == 0);
		Diversos.linhaSeparadora();
		System.out.println("                                           CAPÍTULO 4");
		Diversos.linhaSeparadora();
		System.out.println(
				"Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.");
		System.out.println("Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");
		System.out.println(
				"De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre.");
		System.out.println(
				"Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final.");
		System.out.println(
				"Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");
		System.out.println(
				"Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");
		System.out.println(
				"Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");
		do {
			try {
				Diversos.linhaSeparadora();
				System.out.println("1 - Iniciar ataque");
				System.out.println("2 - Esperar");
				opcao = entrada.nextInt();
				switch (opcao) {
				case 1: {
					shouldContinue = entrarEmCombate(this, new OrqueLider(), true);
					break;
				}
				case 2: {
					shouldContinue = entrarEmCombate(this, new OrqueLider(), false);
					break;
				}
				default: {
					Diversos.linhaSeparadora();
					System.out.println("Opção inválida.");
					opcao = 0;
				}
				}
			} catch (Exception e) {
				Diversos.linhaSeparadora();
				System.out.println("Opção inválida.");
				entrada.next();
				opcao = 0;
			}
		} while (opcao == 0);
		if (!shouldContinue) {
			return;
		}
		Diversos.linhaSeparadora();
		System.out.println("VOCÊ CONSEGUIU!");
		switch (motivacao) {
		case VINGANCA: {
			Diversos.linhaSeparadora();
			System.out.println(
					"Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade.");
			System.out.println("Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
			break;
		}
		case GLORIA: {
			Diversos.linhaSeparadora();
			System.out.println(
					"O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
			break;
		}
		}
		Diversos.linhaSeparadora();
		System.out.println(
				"Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");
		Diversos.linhaSeparadora();
		return;
	}

	private boolean entrarEmCombate(Historia jogo, Inimigo inimigo, boolean iniciativaJogador) {
		Combate combate = new Combate(jogo, inimigo);
		try {
			VencedorDoCombate vencedor = combate.luta(iniciativaJogador);
			if (vencedor == VencedorDoCombate.INIMIGO) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println("opção inválida");
			return false;
		} 
	}
}

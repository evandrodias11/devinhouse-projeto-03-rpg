package rpg.classes;

import java.util.Scanner;

import rpg.classes.PersonagemJogavel.Motivacao;
import rpg.excecao.ExecaoDeGenero;
import rpg.excecao.ExecaoDeMotivacao;

public class Combate {
	public enum VencedorDoCombate {
		JOGADOR, INIMIGO
	}

	private final static int MODIFICADOR_DANO = 50;
	private Historia jogo;
	private Inimigo inimigo;

	public Combate(Historia jogo, Inimigo inimigo) {
		this.jogo = jogo;
		this.inimigo = inimigo;
	}

	public Historia getJogo() {
		return this.jogo;
	}

	public Inimigo getInimigo() {
		return this.inimigo;
	}

	public VencedorDoCombate luta(boolean turnoDojogador) throws ExecaoDeGenero, ExecaoDeMotivacao {
		PersonagemJogavel jogador = this.getJogo().getPersonagem();
		Inimigo inimigo = this.getInimigo();
		Dado d20 = new Dado20();
		NivelDificuldade difficultyLevel = this.getJogo().getLevelDeDificuldade();
		Scanner in = new Scanner(System.in);
		while (jogador.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
			if (turnoDojogador) {
				int option = 0;
				do {
					try {
						Diversos.linhaSeparadora();
						System.out.println("É sua vez! Atacar ou fugir?");
						System.out.println("1 - Atacar");
						System.out.println("2 - Fugir");
						option = in.nextInt();
						switch (option) {
						case 1:
							break;
						case 2: {
							Diversos.linhaSeparadora();
							System.out.println(
									"Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
							return VencedorDoCombate.INIMIGO;
						}
						default: {
							System.out.println("Opção inválida.");
							option = 0;
						}
						}
					} catch (Exception e) {
						System.out.println("Opção inválida.");
						option = 0;
					}
				} while (option == 0);
				this.ataque(jogador, inimigo, d20, difficultyLevel);
				turnoDojogador = !turnoDojogador;
			} else {
				this.ataque(inimigo, jogador, d20, difficultyLevel);
				turnoDojogador = !turnoDojogador;
			}
		}
		if (inimigo.getVidaAtual() <= 0) {
			Diversos.linhaSeparadora();
			System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
			return VencedorDoCombate.JOGADOR;
		} else {
			Diversos.linhaSeparadora();
			System.out.print("Você não estava preparado para a força do inimigo. ");
			Motivacao motivation = jogador.getMotivacao();
			switch (motivation) {
			case VINGANCA: {
				System.out.println(
						"Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
				break;
			}
			case GLORIA: {
				switch (jogador.getGenero()) {
				case MASCULINO: {
					System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
					break;
				}
				case FEMININO: {
					System.out
							.println("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heróina.");
					break;
				}
				default:
					throw new ExecaoDeGenero("Gênero do personagem inválido.");
				}
			}
			default:
				throw new ExecaoDeMotivacao("Motivação do personagem inválida.");
			}
			return VencedorDoCombate.INIMIGO;
		}
	}

	private void ataque(PersonagensDeCombate atacante, PersonagensDeCombate defensor, Dado dado,
			NivelDificuldade nivelDeDificuldade) {
		int rolagemDado = dado.rolagem();
		if (rolagemDado == 1) {
			Diversos.linhaSeparadora();
			System.out.printf("%s atacou %s e errou o ataque! %s não sofreu dano e continua com %d pontos de vida.%n",
					atacante.getNome(), atacante.getArma().textoAtaque(), defensor.getNome(), defensor.getVidaAtual());
		} else if (rolagemDado == dado.getValorMax()) {
			this.acertoDanoCritico(atacante, defensor, rolagemDado, nivelDeDificuldade);

		} else {
			this.acertoDanoNormal(atacante, defensor, rolagemDado, nivelDeDificuldade);
		}
	}

	private void acertoDanoCritico(PersonagensDeCombate atacante, PersonagensDeCombate defensor, int rolagemDado,
			NivelDificuldade nivelDeDificuldade) {
		int dano = this.acertoDano(atacante, defensor, 0, rolagemDado, nivelDeDificuldade); // 0 defense: true damage
		Diversos.linhaSeparadora();
		System.out.printf(
				"%s atacou %s e acertou um ataque crítico! %s sofreu %d de dano e agora possui %d pontos de vida.%n",
				atacante.getNome(), atacante.getArma().textoAtaque(), defensor.getNome(), dano,
				defensor.getVidaAtual());
	}

	private void acertoDanoNormal(PersonagensDeCombate atacante, PersonagensDeCombate defensor, int rolagemDado,
			NivelDificuldade nivelDeDificuldade) {
		int dano = this.acertoDano(atacante, defensor, defensor.getDefesaTotal(), rolagemDado, nivelDeDificuldade); // considers
																													// defender's
																													// defense
		Diversos.linhaSeparadora();
		System.out.printf("%s atacou %s! %s sofreu %d de dano e agora possui %d pontos de vida.%n", atacante.getNome(),
				atacante.getArma().textoAtaque(), defensor.getNome(), dano, defensor.getVidaAtual());
	}

	private int acertoDano(PersonagensDeCombate atacante, PersonagensDeCombate defensor, int defesa, int rolagemDado,
			NivelDificuldade difficultyLevel) {
		int dano = (int) Math
				.floor((atacante.getAtaqueTotal() + rolagemDado) * MODIFICADOR_DANO / (MODIFICADOR_DANO + defesa));
		if (atacante instanceof Inimigo) {
			if (difficultyLevel == NivelDificuldade.FACIL) {
				dano = (int) Math.round(dano * NivelDificuldade.FACIL.getDamagePercentual());
			}
		} else {
			if (difficultyLevel == NivelDificuldade.DIFICIL) {
				dano = (int) Math.round(dano * NivelDificuldade.DIFICIL.getDamagePercentual());
			}
		}
		defensor.levarDano(dano);
		return dano;
	}
}

package rpg.classes;

import java.util.Scanner;

public class Diversos {

	static Scanner input = new Scanner(System.in);

	// Enter para continuar
	public static void continuar() {
		System.out.println("Pressione ENTER para continuar...");
		input.nextLine();
	}

	// limpar console
	public static void limparConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}

	}

	// linha pontilhada para separar/formatar a história
	public static void linhaSeparadora() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}

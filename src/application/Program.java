package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import tabuleiro.ExcecaoDeTabuleiro;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDeXadrez;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaXadrez = new PartidaDeXadrez();

		while (true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoDeXadrez origem = UI.lerPosicao(sc);

				System.out.println();
				System.out.print("Alvo: ");
				PosicaoDeXadrez alvo = UI.lerPosicao(sc);
				PecaDeXadrez pecaCapturada = partidaXadrez.executarMovimento(origem, alvo);

			} catch (ExcecaoDeTabuleiro e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

		}

	}

}

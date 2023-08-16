package application;

import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		PartidaDeXadrez partidaXadrez = new PartidaDeXadrez();
		UI.printTabuleiro(partidaXadrez.getPecas());
		

	}

}

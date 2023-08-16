package xadrez;

import java.awt.datatransfer.Clipboard;

import tabuleiro.Tabuleiro;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		// quem precisa definir o tamanho do tabuleiro é a classe partida
		tabuleiro = new Tabuleiro(8, 8);

	}

	public PecaDeXadrez[][] getPecas() {
		// precisa retornar uma matriz de peça de xadrez da partida
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
		for (int i = 0; i < tabuleiro.getLinha(); i++) {
			//para cada peçadexadrez encontrada fazer uma downcasting para peca
			for (int j = 0; j < tabuleiro.getColuna(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i,j);
			} 
		}
		return mat;
	} 
}

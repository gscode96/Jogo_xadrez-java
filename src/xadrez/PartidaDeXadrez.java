package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		// quem precisa definir o tamanho do tabuleiro é a classe partida
		tabuleiro = new Tabuleiro(8, 8);
		// metodo para iniciar as pecas nas sua posicoes ao criar a partida
		setupInicial();

	}

	public PecaDeXadrez[][] getPecas() {
		// precisa retornar uma matriz de peça de xadrez da partida
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
		for (int i = 0; i < tabuleiro.getLinha(); i++) {
			// para cada peçadexadrez encontrada fazer uma downcasting para peca
			for (int j = 0; j < tabuleiro.getColuna(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

	private void setupInicial() {
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
	}
}

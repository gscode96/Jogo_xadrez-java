package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

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

	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoDeXadrez(coluna, linha).paraPosicao());

	}

	private void setupInicial() {
		colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));

	}
}

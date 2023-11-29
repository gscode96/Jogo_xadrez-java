package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
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
			// para cada peça de xadrez encontrada fazer uma downcasting para peca
			for (int j = 0; j < tabuleiro.getColuna(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

	public PecaDeXadrez executarMovimento(PosicaoDeXadrez posicaoInicial, PosicaoDeXadrez posicaoFinal) {

		Posicao pinicial = posicaoInicial.paraPosicao();
		Posicao pfinal = posicaoInicial.paraPosicao();
		validarPosicaoInicial(pinicial);
		validarPosicaoFinal(pinicial, pfinal);
		Peca pecaCapturada = fazerMovimento(pinicial, pfinal);
		return (PecaDeXadrez) pecaCapturada;

	}

	private void validarPosicaoInicial(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new ExcecaoDeXadrez("Não existe peca na posicao de origem");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new ExcecaoDeXadrez("Não existe movimentos para a peça escolhida");
		}

	}
	
	private void validarPosicaoFinal (Posicao pinicial, Posicao pfinal) {
		if (tabuleiro.peca(pinicial).movimentoPossivel(pfinal)) {
			throw new ExcecaoDeXadrez("A peça escolhida não pode se mover para a posição de destino");
		}
		
	}

	private Peca fazerMovimento(Posicao posicaoInicial, Posicao posicaoFinal) {
		Peca p = tabuleiro.removerPeca(posicaoInicial);
		Peca capturada = tabuleiro.removerPeca(posicaoFinal);
		tabuleiro.colocarPeca(p, posicaoFinal);
		return capturada;

	}

	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoDeXadrez(coluna, linha).paraPosicao());

	}

	private void setupInicial() {
		colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));

	}
}

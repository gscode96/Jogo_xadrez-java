package xadrez;

import tabuleiro.Posicao;

public class PosicaoDeXadrez {

	private char coluna;
	private int linha;

	public PosicaoDeXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExcecaoDeXadrez("Erro ao instanciar a posicao do xadrez. Valores validos são de a1 ate a8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posicao paraPosicao() {
		// converte de matriz para possicao do tabuleiro
		return new Posicao(8 - linha, coluna - 'a');

	}

	protected static PosicaoDeXadrez dePosicao(Posicao posicao) {
		//converte de posicao do tabuleiro para matriz
		return new PosicaoDeXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());

	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
		
	}

}

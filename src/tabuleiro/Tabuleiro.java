package tabuleiro;

public class Tabuleiro {

	private int linha;
	private int coluna;
	private Peca[][] pecas;

	public Tabuleiro(int linha, int coluna) {
		if (linha < 1 || coluna < 1) {
			throw new ExcecaoDeTabuleiro("Erro ao criar o tabuleiro. É necessario pelo menos 1 linha e 1 coluna.");
		}
		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new ExcecaoDeTabuleiro("Posição não esta no tabuleiro");
		}
		return pecas[linha][coluna];

	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExcecaoDeTabuleiro("Posição não esta no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];

	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new ExcecaoDeTabuleiro("Já existe uma peça nesta posição " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;

	}

	private boolean posicaoExiste(int linha, int coluna) {
		// valida se a posicao tem no tamanho do tabuleiro
		return linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna;

	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temUmaPeca(Posicao posicao) {
		// valida se tem uma peca na posicao escolhida
		if (!posicaoExiste(posicao)) {
			throw new ExcecaoDeTabuleiro("Posição não esta no tabuleiro");
		}
		return peca(posicao) != null;

	}

}

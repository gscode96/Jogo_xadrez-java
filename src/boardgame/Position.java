package boardgame;

public class Position {

	private int row;
	private int column;

	public Position(int linha, int coluna) {

		this.row = linha;
		this.column = coluna;
	}

	public int getLinha() {
		return row;
	}

	public void setLinha(int linha) {
		this.row = linha;
	}

	public int getColuna() {
		return column;
	}

	public void setColuna(int coluna) {
		this.column = coluna;
	}

	@Override
	public String toString() {
		return row + ", " + column ;
	}
	
	

}

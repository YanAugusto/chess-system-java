package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {

		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	//retorna os possiveis movimentos de uma pe�a
	
	public boolean possibleMove(Position position) {

		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	//ele testa num vetor booleano se � possivel fazer qualquer movimento de uma pe�a
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}

			}
		}
		return false;
	}

}

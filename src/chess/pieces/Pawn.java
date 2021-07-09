package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}
	
	
	@Override
	public boolean[][] possibleMoves(){
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//movimento do peão após ele se mexer da primeira vez
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() -1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//primeira jogada do peão na qual ele vai avança duas casas
			
			p.setValues(position.getRow() -2, position.getColumn());
			Position p2 = new Position(position.getRow()-1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount()==0){
				mat[p.getRow()][p.getColumn()] = true;
				}
			
			//capturar na diagonal esquerda
			
			p.setValues(position.getRow() -1, position.getColumn() -1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//capturar na diagonal direita
			
			p.setValues(position.getRow() -1, position.getColumn() +1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			}
			
		else {
			
			p.setValues(position.getRow() +1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//primeira jogada do peão na qual ele vai avança duas casas
			
			p.setValues(position.getRow() +2, position.getColumn());
			Position p2 = new Position(position.getRow()+1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount()==0){
				mat[p.getRow()][p.getColumn()] = true;
				}
			
			//capturar na diagonal esquerda
			
			p.setValues(position.getRow() +1, position.getColumn() -1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//capturar na diagonal direita
			
			p.setValues(position.getRow() +1, position.getColumn() +1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
		}
		return mat;
		}
	
	
	@Override
	public String toString() {
		return "P";
	}

}

package code.fun.chess.Coins;

import code.fun.chess.board.Cell;

public class Horse extends Coin {

	String coinType = "Horse";

	@Override
	Boolean isValidMovement(Cell source, Cell destination) {
		// TODO Auto-generated method stub
		/*
		 * You dont have to check whether there is some coin in the path
		 * 
		 * Because Horse can jump :-)*
		 * 
		 * One useful way to verify is horse in the white will move to Black
		 */
		int srcRow,srcCol,desRow,desCol;
		srcRow = source.getCellId()[0];
		srcCol = source.getCellId()[1];
		desRow = destination.getCellId()[0];
		desCol = destination.getCellId()[1];
		if((Math.abs(srcRow - desRow) == 1) && (Math.abs(srcCol - desCol) == 2))
		{
			return true;
		}
		else if((Math.abs(srcRow - desRow) == 2) && (Math.abs(srcCol - desCol) == 1))
		{
			return true;
		}
		return false;
	}

	@Override
	Boolean isPathValid(int srcRow, int srcCol, int desRow, int desCol) {
		return true;
	}
}

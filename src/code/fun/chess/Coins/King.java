package code.fun.chess.Coins;

import code.fun.chess.board.Cell;

public class King extends Coin{

	String coinType = "King";

	@Override
	Boolean isValidMovement(Cell source, Cell destination) {
		int srcRow,srcCol,desRow,desCol;
		srcRow = source.getCellId()[0];
		srcCol = source.getCellId()[1];
		desRow = destination.getCellId()[0];
		desCol = destination.getCellId()[1];
		
		if((srcRow == desRow)&&(Math.abs(srcCol - desCol) == 1))
		{
			return true;
		}
		else if((srcCol == desCol) && (Math.abs(srcRow - desRow) == 1))
		{
			return true;
		}
		else if((Math.abs(srcCol-desCol) == 1) &&(Math.abs(srcRow-desRow) == 1))
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

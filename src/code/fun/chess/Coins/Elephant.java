package code.fun.chess.Coins;

import code.fun.chess.board.Board;
import code.fun.chess.board.Cell;

public class Elephant extends Coin {

	String coinType = "Elephant";

	@Override
	Boolean isValidMovement(Cell source, Cell destination) 
	{
		int srcRow,srcCol,desRow,desCol;
		srcRow = source.getCellId()[0];
		srcCol = source.getCellId()[1];
		desRow = destination.getCellId()[0];
		desCol = destination.getCellId()[1];
		
		if((srcRow == desRow) && (srcCol != desCol))
		{
			return true;
		}
		else if((srcCol == desCol) && (srcRow != desRow))
		{
			return true;
		}
		return false;
	}

	@Override
	Boolean isPathValid(int srcRow, int srcCol, int desRow, int desCol) {
		if(srcRow == desRow)
		{
			if(desCol - srcCol <0)
			{
				for(int i=srcCol-1;i>desCol;i--)
				{
					if(Board.getCoin(srcRow,i) != null)
						return false;
				}
			}
			else
			{
				for(int i=srcCol+1;i<desCol;i++)
				{
					if(Board.getCoin(srcRow,i) != null)
						return false;
				}
			}
		}else
		{
			if(desRow - srcRow <0)
			{
				for(int i=srcRow-1;i>desRow;i--)
				{
					if(Board.getCoin(i,srcCol) != null)
						return false;
				}
			}
			else
			{
			for(int i=srcRow+1;i<desRow;i++)
			{
				if(Board.getCoin(i,srcCol) != null)
					return false;
			}
			}
			
		}
		return true;
	}


}

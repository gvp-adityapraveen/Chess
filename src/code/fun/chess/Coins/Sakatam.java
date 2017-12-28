package code.fun.chess.Coins;

import code.fun.chess.board.Board;
import code.fun.chess.board.Cell;

public class Sakatam extends Coin{

	String coinType = "Sakatam";

	@Override
	Boolean isValidMovement(Cell source, Cell destination) 
	{
		int srcRow,srcCol,desRow,desCol;
		srcRow = source.getCellId()[0];
		srcCol = source.getCellId()[1];
		desRow = destination.getCellId()[0];
		desCol = destination.getCellId()[1];
		
		if(Math.abs(srcRow-desRow) ==  Math.abs(srcCol - desCol))
		{
			return true;
		}		
		return false;
		
	}

	@Override
	Boolean isPathValid(int srcRow, int srcCol, int desRow, int desCol) {
		if(srcRow - desRow > 0)
		{
			if(srcCol-desCol > 0)
			{
				for(int i=srcRow-1,j=srcCol-1;i>desRow && j>desCol;i--,j--)
				{
					if(Board.getCoin(i,j) != null)
						return false;
				}
			}
			else
			{
				for(int i=srcRow-1,j=srcCol+1;i>desRow && j<desCol;i--,j++)
				{
					if(Board.getCoin(i,j) != null)
						return false;
				}
			}
		}
		else
		{
			if(srcCol-desCol > 0)
			{
				for(int i=srcRow+1,j=srcCol-1;i<desRow && j>desCol;i++,j--)
				{
					if(Board.getCoin(i,j) != null)
						return false;
				}
			}
			else
			{
				for(int i=srcRow+1,j=srcCol+1;i<desRow && j<desCol;i++,j++)
				{
					if(Board.getCoin(i,j) != null)
						return false;
				}
			}
		}
		return true;
	}
	


}

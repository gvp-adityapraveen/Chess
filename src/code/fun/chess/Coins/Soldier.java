package code.fun.chess.Coins;

import code.fun.chess.board.Board;
import code.fun.chess.board.Cell;
import code.fun.chess.constants.ColorEnum;

public class Soldier  extends Coin{
	
	String coinType = "Soldier";
	
	private Boolean firstMoveDone=false;
	
	public boolean isFirstMoveDone()
	{
		return firstMoveDone;
	}
	
	public void setFirstMoveDone(boolean val)
	{
		firstMoveDone = val;
	}

	// Need to check if something appears in the path
	@Override
	Boolean isValidMovement(Cell source, Cell destination) {
		int srcRow,srcCol,desRow,desCol;
		srcRow = source.getCellId()[0];
		srcCol = source.getCellId()[1];
		desRow = destination.getCellId()[0];
		desCol = destination.getCellId()[1];
		if(source.getCoin().getColor() == ColorEnum.White)
		{
			if(!firstMoveDone)
			{
				if(((srcCol == desCol) &&(desRow-srcRow == -1 || desRow-srcRow == -2))||(desRow-srcRow == -1 && (Math.abs(desCol-srcCol) == 1)))
				{
					return true;
				}
				return false;
			}else
			{
				if(((srcCol == desCol) &&(desRow-srcRow == -1))||(desRow-srcRow == -1 && (Math.abs(desCol-srcCol) == 1)))
				{
					return true;
				}
				return false;
			}
		}
		else if(source.getCoin().getColor() == ColorEnum.Black)
		{
			if(!firstMoveDone)
			{
				if(((srcCol == desCol) &&(desRow-srcRow == 1 || desRow-srcRow == 2))||(desRow-srcRow == 1 && (Math.abs(desCol-srcCol) == 1)))
				{
					return true;
				}
				return false;
			}else
			{
				if(((srcCol == desCol) &&(desRow-srcRow == 1))||(desRow-srcRow == 1 && (Math.abs(desCol-srcCol) == 1)))
				{
					return true;
				}
				return false;
				}
			}
		return false;
		}

	/*
	 * For cross that is killing move , you dont have to worry if its valid or
	 * not
	 * */
	@Override
	Boolean isPathValid(int srcRow , int srcCol, int desRow, int desCol) {
		if(srcCol != desCol)
		{
			if(Board.getCoin(desRow,desCol) != null)
				return true;
			return false;
		}
		if(desRow-srcRow > 0)
		{
			for(int i=srcRow+1;i<=desRow;i++)
			{
				if(Board.getCoin(i, srcCol) != null)
				{
					return false;
				}
			}
		}
		else if(desRow-srcRow < 0)
		{
			for(int i=srcRow-1;i>=desRow;i--)
			{
				if(Board.getCoin(i, srcCol) != null)
				{
					return false;
				}
			}
		}
		return true;
	}
}

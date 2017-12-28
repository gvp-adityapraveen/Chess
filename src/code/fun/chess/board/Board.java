package code.fun.chess.board;

import code.fun.chess.Coins.Coin;
import code.fun.chess.Coins.Elephant;
import code.fun.chess.Coins.Horse;
import code.fun.chess.Coins.King;
import code.fun.chess.Coins.Mantri;
import code.fun.chess.Coins.Sakatam;
import code.fun.chess.Coins.Soldier;
import code.fun.chess.constants.ColorEnum;

/* Top side of the board is Black 0
 * 
 * Bottom side of the board is white 63
 */

public class Board {

// This is the actual Board in memory
 public static Cell[][] cellsOnTheBoard;
 
 //Positions of king is always maintained
 // 0 is black
 //1 is white
 public static Cell[] Kings= new Cell[2]; 
 
 
 // id is of the format 0:0 to 7:7
 public static Cell getCell(String id)
 {
	 return cellsOnTheBoard [Integer.parseInt(id.substring(0, 1))][Integer.parseInt(id.substring(2, 3))];
 }
 
 public static void setCell(Cell src,String id)
 {
	 cellsOnTheBoard[Integer.parseInt(id.substring(0, 0))][Integer.parseInt(id.substring(2,2))] = src;
 }
	
 public void createBoard()
	{
		cellsOnTheBoard = new Cell[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				cellsOnTheBoard[i][j] = new Cell();
				cellsOnTheBoard[i][j].setCellId(i,j);
				if((i+j)%2 == 0)
					cellsOnTheBoard[i][j].setColor(ColorEnum.White);
				else
					cellsOnTheBoard[i][j].setColor(ColorEnum.Black);
				if((i == 1)||(i == 6))
				{
					cellsOnTheBoard[i][j].setCoin(new Soldier());
					if(i == 1)
					{
						cellsOnTheBoard[i][j].getCoin().setColor(ColorEnum.Black);
					}
					else if(i == 6)
					{
						cellsOnTheBoard[i][j].getCoin().setColor(ColorEnum.White);
					}
				}
				else if((i == 0)||(i == 7))
				{
					if((j == 0)||(j == 7))
					{
						cellsOnTheBoard[i][j].setCoin(new Elephant());
					}
					else if((j == 1)||(j == 6))
					{
						cellsOnTheBoard[i][j].setCoin(new Horse());
					}
					else if((j == 2)||(j == 5))
					{
						cellsOnTheBoard[i][j].setCoin(new Sakatam());
					}
					else if(j == 3)
					{
						cellsOnTheBoard[i][j].setCoin(new Mantri());
					}
					else if(j == 4)
					{
						cellsOnTheBoard[i][j].setCoin(new King());
						//Black King in 0
						//White king in 1
						Kings[(8-i)%8]= cellsOnTheBoard[i][j];
					
					}
					
					if(i == 0)
					{
						cellsOnTheBoard[i][j].getCoin().setColor(ColorEnum.Black);
					}
					else if(i == 7)
					{
						cellsOnTheBoard[i][j].getCoin().setColor(ColorEnum.White);
					}

				}
			}
		}
	}

 
	void getInstanceOfBoard()
	{
		
	}
	
	public static Coin getCoin(int row, int col)
	{
		return cellsOnTheBoard[row][col].coin;
	}
}

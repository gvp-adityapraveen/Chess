package code.fun.chess.board;

import code.fun.chess.Coins.Coin;
import code.fun.chess.constants.ColorEnum;

public class Cell 
{
	public ColorEnum cellColor=null;
	public int row,col;
	Coin coin = null;
	
	public void setCoin(Coin coin)
	{
		this.coin = coin;
	}
	
	public Coin getCoin()
	{
		return this.coin;
	}
	
	void setColor(ColorEnum color)
	{
		this.cellColor = color;
	}
	
	ColorEnum getColor()
	{
		return this.cellColor;
	}
	
	public int[] getCellId()
	{
		return new int[]{this.row,this.col};
	}
	
	public void setCellId(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
}

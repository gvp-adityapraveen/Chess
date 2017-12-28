package code.fun.chess.Coins;

import javax.swing.ImageIcon;

import code.fun.chess.board.Board;
import code.fun.chess.board.Cell;
import code.fun.chess.constants.ColorEnum;
import code.fun.chess.gui.ChessProgramMainEntry;
import code.fun.chess.gui.ImageLocation;

public abstract class Coin{

	//Deprecated for now	
	//String coinId;
	public ColorEnum coinColor;
	String coinType;

	abstract Boolean isValidMovement(Cell source,Cell destination);
	
	abstract Boolean isPathValid(int srcRow, int srcCol, int desRow, int desCol);
	
	public void setColor(ColorEnum color)
	{
		this.coinColor = color;
	}
	
	public ColorEnum getColor()
	{
		return this.coinColor;
	}

	public  static Boolean move(Cell Source,Cell Destination) {
		Coin sourceCoin = Source.getCoin(); 
		// This is for ensuring the coins of same color doesnt kill each other
		if(Destination.getCoin() != null && sourceCoin.coinColor == Destination.getCoin().coinColor)
		{
			return false;
		}
		/*
		 * Check whether source coin is null or not
		 * */
		Boolean validity = sourceCoin.isValidMovement(Source,Destination);
		/*
		 *  One more thing to check here would be 
		 *  whether the move can cause check to King
		 * */
		int sourceRow = Source.getCellId()[0];
		int sourceCol = Source.getCellId()[1];
		int destRow =  Destination.getCellId()[0];
		int destCol =  Destination.getCellId()[1];
		if (validity) {
			validity = sourceCoin.isPathValid(sourceRow,sourceCol,destRow,destCol);
			if(!validity)
			{
				System.out.println("Invalid Path Movement . There are some blocks in the passage");
				return false;
			}
			
			
			/*
			 * Move the coin in the cellPlaced Array also to maintain the
			 * snapshot
			 */
			Coin src = Board.getCell(String.valueOf(sourceRow)+":"+String.valueOf(sourceCol)).getCoin();
			Board.getCell(String.valueOf(destRow)+":"+String.valueOf(destCol)).setCoin(src);
			Board.getCell(String.valueOf(sourceRow)+":"+String.valueOf(sourceCol)).setCoin(null);
			
			
			if(sourceCoin instanceof King)
			{
				if(sourceCoin.getColor() == ColorEnum.Black)
				{
					Board.Kings[0] = Board.getCell(
							String.valueOf(destRow)+":"+String.valueOf(destCol));
				}
				else if(sourceCoin.getColor() == ColorEnum.White)
				{
					Board.Kings[1] = Board.getCell(
							String.valueOf(destRow)+":"+String.valueOf(destCol));
				}
			}

			
			//Check for CHECKS to kings
			boolean valid = checkIfTheMoveCausesProblemToKing(src.coinColor);
			if(valid)
			{
				Board.getCell(String.valueOf(destRow)+":"+String.valueOf(destCol)).setCoin(null);
				Board.getCell(String.valueOf(sourceRow)+":"+String.valueOf(sourceCol)).setCoin(src);
				
				if(sourceCoin instanceof King)
				{
					if(sourceCoin.getColor() == ColorEnum.Black)
					{
						Board.Kings[0] = Board.getCell(
								String.valueOf(sourceRow)+":"+String.valueOf(sourceCol));
					}
					else if(sourceCoin.getColor() == ColorEnum.White)
					{
						Board.Kings[1] = Board.getCell(
								String.valueOf(sourceRow)+":"+String.valueOf(sourceCol));
					}
				}

				
				return false;
			}
			
			if(sourceCoin instanceof Soldier && !((Soldier) sourceCoin).isFirstMoveDone())
			{
				((Soldier) sourceCoin).setFirstMoveDone(true);
			}
			
			if(sourceCoin instanceof Soldier)
			{
				if(sourceCoin.coinColor == ColorEnum.White && destRow == 0)
				{
					Mantri m = new Mantri();
					m.setColor(ColorEnum.White);
					Board.getCell(String.valueOf(destRow)+":"+String.valueOf(destCol)).setCoin(m);
					ChessProgramMainEntry entry = ChessProgramMainEntry.getInstance();
					ImageLocation location = new ImageLocation();
					entry.clickedImage = (ImageIcon)location.getImage("Queen", ColorEnum.White);
				}
				else if(sourceCoin.coinColor == ColorEnum.Black && destRow == 7)
				{
					Mantri m = new Mantri();
					m.setColor(ColorEnum.Black);
					Board.getCell(String.valueOf(destRow)+":"+String.valueOf(destCol)).setCoin(m);
					ChessProgramMainEntry entry = ChessProgramMainEntry.getInstance();
					ImageLocation location = new ImageLocation();
					entry.clickedImage = (ImageIcon)location.getImage("Queen", ColorEnum.Black);

				}
			}
			
		} 
		return validity;
	}
	
	// If the move doesnt cause any problems , 
	//Update the location of king  If king is moving
	private static boolean checkIfTheMoveCausesProblemToKing(ColorEnum srcCoinColor)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				Cell verify = Board.getCell(i+":"+j);
				Coin coinToVerify = verify.getCoin(); 
				if(coinToVerify != null)
				{
					if(coinToVerify.coinColor == ColorEnum.White && srcCoinColor != ColorEnum.White)
					{
						boolean possible = coinToVerify.isValidMovement(verify, Board.Kings[0]);
						if(possible)
						{
							possible = coinToVerify.isPathValid(verify.getCellId()[0], verify.getCellId()[1], Board.Kings[0].getCellId()[0], Board.Kings[0].getCellId()[1]);
							if(possible)
								return true;
						}
					}
					else if(coinToVerify.coinColor == ColorEnum.Black && srcCoinColor != ColorEnum.Black)
					{
						boolean possible = coinToVerify.isValidMovement(verify, Board.Kings[1]);
						if(possible)
						{
							possible = coinToVerify.isPathValid(verify.getCellId()[0], verify.getCellId()[1], Board.Kings[1].getCellId()[0], Board.Kings[1].getCellId()[1]);
							if(possible)
								return true;
						}
					}
				}
			}
		}
		return false;
	}

}

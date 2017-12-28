package code.fun.chess.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import code.fun.chess.Coins.Coin;
import code.fun.chess.board.Board;
import code.fun.chess.board.Cell;
import code.fun.chess.constants.ColorEnum;

public class ChessProgramMainEntry extends JPanel implements ActionListener {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int rows = 8;
	final int columns = 8;
	
	static ChessProgramMainEntry mainEntry = null;
	
	//The color coin for which step has to be made
	// First Step to be made is White
	private ColorEnum selectCoinColor = ColorEnum.White;
	
	//If chooseCoin is set to true , you have to choose a coin
	// If it is set to false , you have to Place coin
	private Boolean chooseCoin = true;
	private JButton sourceCellClicked = null;
	private JButton destinationClicked = null;
	
	int sourceRow,sourceColumn,destRow,destColumn;
	public ImageIcon clickedImage = null;
	
// This is required for GUI Handling
	JButton button[][];
	
	
	Cell Source = null,Destination =null;
	
	private ChessProgramMainEntry()
	{
		
	}
	
	
	public static ChessProgramMainEntry getInstance()
	{
		if(mainEntry == null)
		{
			mainEntry = new ChessProgramMainEntry();
		}
		return mainEntry;
	}

	public void createBoard() throws IOException {
		Board board = new Board();
		board.createBoard();
		button = new JButton[rows][columns];
		GridLayout layout = new GridLayout(rows, columns);
		this.setLayout(layout);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				button[i][j] = new JButton();
				//Setting the name for Chess Coins
				// Setting the name to be 0:0 to 7:7 from the bottom
				button[i][j].setName(String.valueOf(i)+":"+String.valueOf(j));
				if ((i + j) % 2 == 0) {
					button[i][j].setBackground(Color.white);
				} else {
					button[i][j].setBackground(Color.black);
				}
			button[i][j].setBorder(BorderFactory
						.createLineBorder(Color.black));
				if (i == 1) {
						ImageLocation location = new ImageLocation();
					ImageIcon img = location
							.getImage("Soldier", ColorEnum.Black);
					button[i][j].setIcon(img);
				} else if (i == 6) {
					ImageLocation location = new ImageLocation();
					ImageIcon img = location
							.getImage("Soldier", ColorEnum.White);
					button[i][j].setIcon(img);
				}
				else if (i==0)
				{
					ImageLocation location = new ImageLocation();
					ImageIcon img=null;
					if((j==0)||(j==7))
					{
						img = location.getImage("Elephant", ColorEnum.Black);
					}
					else if((j==1)||(j==6))
					{
						img = location.getImage("Horse", ColorEnum.Black);
					}
					else if((j==2)||(j==5))
					{
						img = location.getImage("Sakatam", ColorEnum.Black);
					}
					else if(j==3)
					{
						img = location.getImage("Queen", ColorEnum.Black);
					}
					else if(j == 4)
					{
						img = location.getImage("King", ColorEnum.Black);
					}
					button[i][j].setIcon(img);
				}
				else if (i==7)
				{
					ImageLocation location = new ImageLocation();
					ImageIcon img=null;
					if((j==0)||(j==7))
					{
						img = location.getImage("Elephant", ColorEnum.White);
					}
					else if((j==1)||(j==6))
					{
						img = location.getImage("Horse", ColorEnum.White);
					}
					else if((j==2)||(j==5))
					{
						img = location.getImage("Sakatam", ColorEnum.White);
					}
					else if(j==3)
					{
						img = location.getImage("Queen", ColorEnum.White);
					}
					else if(j == 4)
					{
						img = location.getImage("King", ColorEnum.White);
					}
					button[i][j].setIcon(img);
				}
				button[i][j].addActionListener(this);
				this.add(button[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(chooseCoin)
		{
			sourceCellClicked=((JButton)e.getSource());
			//System.out.println(sourceCellClicked);
			//System.out.println("Id of the Buton clicked:"+sourceCellClicked.getName());
			Source = Board.getCell(sourceCellClicked.getName());
			if(Source.getCoin() != null)
			{
				chooseCoin = false;
				if(Source.getCoin().getColor() != selectCoinColor)
				{
					chooseCoin = true;
				}
			}
			clickedImage = (ImageIcon) sourceCellClicked.getIcon();
		}
		else
		{
			destinationClicked = ((JButton)e.getSource());
			//System.out.println(destinationClicked);
			//System.out.println("Id of the Buton clicked:"+destinationClicked.getName());
			Destination = Board.getCell(destinationClicked.getName());
			Boolean status = Coin.move(Source,Destination);
			if(status)
			{
				sourceCellClicked.setIcon(null);
				destinationClicked.setIcon(clickedImage);
				//
				
				if(selectCoinColor == ColorEnum.White)
				{
					selectCoinColor = ColorEnum.Black;
				}
				else
				{
					selectCoinColor = ColorEnum.White;
				}
			}
			else
			{
				System.out.println("Invalid Move");
			}
			chooseCoin = true;
		}
		
	}

}

package code.fun.chess.gui;

import java.awt.Color;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class ChessBoardGUI  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChessBoardGUI() throws IOException
	{
		setTitle("Chess By Aditya !! :D") ;
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ChessProgramMainEntry p = ChessProgramMainEntry.getInstance();
	    p.createBoard();
	    p.setBorder(BorderFactory.createLineBorder(Color.black));
	    this.add(p);
	 }
	
	public static void main(String args[]) throws IOException
	{
		new ChessBoardGUI().setVisible(true);
	}


}
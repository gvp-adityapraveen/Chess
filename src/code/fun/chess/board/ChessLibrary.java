package code.fun.chess.board;

public class ChessLibrary {
	
	public static int[] getRowColumnFromId(int id)
	{
		int array[]= new int [2];
		array[0]=id/8;
		array[1]=id%8;
		return array;
		
	}

}

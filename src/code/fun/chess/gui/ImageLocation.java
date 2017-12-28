package code.fun.chess.gui;

import javax.swing.ImageIcon;

import code.fun.chess.constants.ColorEnum;

	public class ImageLocation {
	
	// Change coinType to enum
	public ImageIcon getImage(String coinType,ColorEnum color)
	{
		ImageIcon img = null;
		if(color == ColorEnum.White)
		{
			img = new ImageIcon(getClass().getResource("../../../../resources/white/"+coinType+".png"));
		}
		else if(color == ColorEnum.Black)
		{
			img = new ImageIcon(getClass().getResource("../../../../resources/black/"+coinType+".png"));
		}

		return img;
	}

}

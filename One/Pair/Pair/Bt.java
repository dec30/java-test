package Pair;

import java.awt.event.*;
import javax.swing.ImageIcon;

public class Bt implements ActionListener {				//«ö¶s±±¨î
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==First.Bt)
		{
			First.Bt.setVisible(false);
			End.Bt2.setVisible(false);
			Timerr.s=0;	First.G.gridy = 0;
			for(int i=0; i<First.L.length ;i++)
			{
				First.L[i].setVisible(true);
				First.L[i].setIcon(First.image0);
			}
			First.image = RandomArray(First.image);
			new Timerr();
		}  
		else if(e.getSource()==End.Bt2)
		{
			First.Board.setVisible(false);
			Text.Lb.setVisible(true);
		}
		else if(e.getSource()==Text.Back)
		{
			First.Board.setVisible(true);
			Text.Lb.setVisible(false);
		}	
	}	
	private ImageIcon[] RandomArray(ImageIcon[] image)
	{      
		int imageLength = image.length;
		int image_1;																
		ImageIcon image_2;

		for(int i = 0; i < imageLength; i++) 
		{      
			image_1 = (int)(Math.random() * imageLength);
			image_2 = image[i];
			image[i] = image[image_1];
			image[image_1] = image_2;
		}
		return image;
	}
}	

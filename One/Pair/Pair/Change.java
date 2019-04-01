package Pair;

import java.awt.event.*;

public class Change implements MouseListener{			//·Æ¹«±±¨î
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(Judge.W==2)
		{
			return;
		}
		for(int i=0; i<First.L.length;i++)
		{
			if(e.getSource()==First.L[i] &(e.getSource()!=Judge.Li1 | Judge.W==0))
			{
				First.L[i].setIcon(First.image[i]);
				new Judge(Judge.I[i],First.L[i]);
			}
		}	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
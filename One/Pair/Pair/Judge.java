package Pair;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Judge {												//比對是否一樣
	Timer timer=new Timer();
	static int[] I= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};	
	static int W=0;
	static int I1;
	static JLabel Li1=new JLabel();
	
	public Judge(int I,JLabel Li) {
		W++;
		if(W==1) {
			I1=I;
			Li1=Li;
		}
		if(W==2) {
			timer.schedule(new TimerTask(){
				public void run(){
					if(First.image[I] ==First.image[I1])
					{
						Li.setVisible(false);
						Li1.setVisible(false);		
						new End();
					}
					else
					{
						Li.setIcon(First.image0);
						Li1.setIcon(First.image0);
					}
					I1=-1;
					W=0;
				}
			},300);
		}
	}
}

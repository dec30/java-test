package Pair;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Timerr  extends TimerTask{								//�ɶ��]�w��
	Timer timer=new Timer();
	static JPanel Other=new JPanel();
	static JLabel Time = new JLabel();
	static int s=0;	int m=0;
	static Date date;
	
	public Timerr() {	
		Other.setLayout(new GridBagLayout());	Other.setOpaque(false);
		Other.setPreferredSize(new Dimension(250, 936));	Other.setBounds(0, 0, 250, 936);
		Other.add(Time,First.G);
		timer.schedule(this, 0, 1000);
	}
	public void run() {
		m=s%60;
		if(s<=59)
		{
			Time.setText("�i��F:"+s+"��");
		}
		else
		{
			Time.setText("�i��F:"+(s/60)+"��"+m+"��");
		}
		if(End.Correct==9) {
			timer.cancel();	
			date=new Date();
			if(s<=59)
			{
				Time.setText("�A�`�@��F:"+s+"��");
			}
			else
			{
				Time.setText("�A�`�@��F:"+(s/60)+"��"+m+"��");
			}
		}
		s++;
	}
}
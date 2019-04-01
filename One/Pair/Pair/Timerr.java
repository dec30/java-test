package Pair;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Timerr  extends TimerTask{								//時間設定區
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
			Time.setText("進行了:"+s+"秒");
		}
		else
		{
			Time.setText("進行了:"+(s/60)+"分"+m+"秒");
		}
		if(End.Correct==9) {
			timer.cancel();	
			date=new Date();
			if(s<=59)
			{
				Time.setText("你總共花了:"+s+"秒");
			}
			else
			{
				Time.setText("你總共花了:"+(s/60)+"分"+m+"秒");
			}
		}
		s++;
	}
}
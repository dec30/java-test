package Pair;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class End {										//結尾
	static int Correct=0;	
	JLabel Massage=new JLabel("恭喜成功");	
	static JButton Bt2=new JButton("顯示紀錄");

	public End() {
		Correct++;
		if(Correct<=8)
		{
			try {
				FileInputStream music=new FileInputStream("success.wav");
				AudioStream Music=new AudioStream(music);
				AudioPlayer.player.start(Music);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		if(Correct==9) {
			Massage.setVisible(true);	Massage.setFont(new Font("標楷體", Font.BOLD, 32));
			First.Board.add(Massage,First.G);
			try {
				FileInputStream music=new FileInputStream("d.wav");
				AudioStream Music=new AudioStream(music);
				AudioPlayer.player.start(Music);	
			}catch (Exception e){
				e.printStackTrace();
			}
			try {
				Thread.sleep(1100);
			} catch (InterruptedException e) {
			}
			Massage.setVisible(false);
			First.Bt.setText("再來一次");
			First.Bt.setVisible(true);
			Bt2.addActionListener(new Bt());	First.G.gridy = 1;
			Bt2.setVisible(true);	Timerr.Other.add(Bt2,First.G);	
			Correct=0;
			Text.Lb.removeAll();
			Text t=new Text();
			try {
				t.Writetext();
				t.Readtext();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

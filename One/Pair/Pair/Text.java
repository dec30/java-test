package Pair;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import javax.swing.*;


public class Text {													//紀錄
	Path Path = Paths.get("test.txt");

	String str;
	String[][] txt;
	Vector<String []> str_vec = new Vector<String []>();
	String text="";


	JLabel T1=new JLabel();		JLabel T2=new JLabel();		JLabel T3=new JLabel();
	JLabel T4=new JLabel();		JLabel T5=new JLabel();		JLabel T6=new JLabel();
	JLabel T7=new JLabel();		JLabel T8=new JLabel();		JLabel T9=new JLabel();
	JLabel T10=new JLabel();
	JLabel[] Text= {T1,T2,T3,T4,T5,T6,T7,T8,T9,T10};
	static JButton Back=new JButton("返回");

	SimpleDateFormat dt = new SimpleDateFormat ("MM dd HH mm ss");

	static JPanel Lb = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon ii = new ImageIcon("Back.jpg");
			g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		}
	};
	


	public void Writetext() throws IOException {	
		Lb.setLayout(new GridBagLayout());	Lb.setOpaque(false);	Lb.setVisible(false);
		Lb.setPreferredSize(new Dimension(500, 600));	Lb.setBounds(530, 168, 500, 600);
		if(Files.exists(Path)) {
			BufferedWriter Bw = new BufferedWriter(new FileWriter("test.txt",true));
			Bw.write("\r\n");
			Bw.write((Timerr.s-1)+" "+dt.format(Timerr.date));
			Bw.flush();	Bw.close();
		}
		else if(!Files.exists(Path)) {
			BufferedWriter Bw = new BufferedWriter(new FileWriter("test.txt"));
			Bw.write((Timerr.s-1)+" "+dt.format(Timerr.date));
			Bw.flush();	Bw.close();
		}
	}
	
	public void Readtext() throws IOException {
		if(Files.exists(Path)) {
			BufferedReader Br=new BufferedReader(new FileReader("test.txt"));
			while ((str = Br.readLine()) != null) {
				str_vec.add(str.split(" "));
			}
			Br.close();
			txt = new String [str_vec.size()][];
			for (int i = 0; i < str_vec.size(); i++) 
				txt[i] = str_vec.elementAt(i);

			int ttt[][]=new int[txt.length][txt[txt.length-1].length];
			for (int i = 0; i < txt.length; i++) { 
				for (int j = 0; j < txt[i].length; j++) { 
					ttt[i][j]=Integer.parseInt(txt[i][j]);
				} 
			} 
			sort(ttt, new int[] {0,1});
			if(txt.length>10) {
				for (int i = 0;  i < 10; i++) {
					Text[i].setFont(new Font("標楷體", Font.BOLD, 20));
					text=String.format("第%-2d名:總計%02d秒　　日期%02d月%02d日%02d點%02d分%02d秒",
							(i+1),ttt[i][0],ttt[i][1],ttt[i][2],ttt[i][3],ttt[i][4],ttt[i][5]);
					Text[i].setText(text);
					First.G.gridy = i;
					Lb.add(Text[i],First.G);
				} 
			}
			else
				for (int i = 0;  i < txt.length; i++) {    
					Text[i].setFont(new Font("標楷體", Font.BOLD, 20));
					text=String.format("第%-2d名:總計%02d秒　　日期%02d月%02d日%02d點%02d分%02d秒",
							(i+1),ttt[i][0],ttt[i][1],ttt[i][2],ttt[i][3],ttt[i][4],ttt[i][5]);
					Text[i].setText(text);
					First.G.gridy = i;
					Lb.add(Text[i],First.G);
				} 
			Back.addActionListener(new Bt());
			First.G.gridy++;	First.G.anchor = GridBagConstraints.SOUTH;
			Lb.add(Back,First.G);
		}
		else if(!Files.exists(Path)) {
			System.out.print("你沒有紀錄");
		}
	}
	
	public void sort(int[][] ob, final int[] order) {    
		Arrays.sort(ob, new Comparator<Object>() {    
			public int compare(Object o1, Object o2) {    
				int[] one = (int[]) o1;    
				int[] two = (int[]) o2;    
				for (int i = 0; i < order.length; i++) {    
					int k = order[i];    
					if (one[k] > two[k]) {    
						return 1;    
					} else if (one[k] < two[k]) {    
						return -1;    
					} else {    
						continue; 
					}    
				}    
				return 0;    
			}    
		});   
	} 
}

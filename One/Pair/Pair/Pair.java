package Pair;

import javax.swing.*;
//�I���M���֯����Ӧ�ĥ�����ê������C��
public class Pair {							//�e���]�w
	static JFrame Frame=new JFrame();
	static JPanel P =new JPanel();		
	static JLabel Bg=new JLabel();		
	static ImageIcon Background=new ImageIcon("Error.png");
	
	public static void main(String[] args) {
		Frame.setLayout(null);	
		Frame.setTitle("½�P�C��");
		Bg=new JLabel(Background);
		Bg.setBounds(0,0, Background.getIconWidth(), Background.getIconHeight());	
		P=(JPanel) Frame.getContentPane();
		P.setOpaque(false);															
		Frame.getLayeredPane().add(Bg, new Integer(Integer.MIN_VALUE));	
		
		new First();
		
		Frame.add(First.Board);
		Frame.add(First.Picture);
		Frame.add(Timerr.Other);
		Frame.add(Text.Lb);	
		Frame.setSize(1560, 936);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
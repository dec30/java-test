package Pair;

import javax.swing.*;
//背景和音樂素材來自艦隊收藏的網頁遊戲
public class Pair {							//畫面設定
	static JFrame Frame=new JFrame();
	static JPanel P =new JPanel();		
	static JLabel Bg=new JLabel();		
	static ImageIcon Background=new ImageIcon("Error.png");
	
	public static void main(String[] args) {
		Frame.setLayout(null);	
		Frame.setTitle("翻牌遊戲");
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
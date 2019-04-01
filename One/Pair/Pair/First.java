package Pair;

import java.awt.*;
import javax.swing.*;

public class First {									//開始按紐和產生圖片
	static JPanel Board=new JPanel();
	static JButton Bt=new JButton("開始遊戲");
	static ImageIcon image0=new ImageIcon("seal.png");
	static ImageIcon image1=new ImageIcon("1.jpg");
	static ImageIcon image2=new ImageIcon("2.jpg");
	static ImageIcon image3=new ImageIcon("3.jpg");
	static ImageIcon image4=new ImageIcon("4.jpg");
	static ImageIcon image5=new ImageIcon("5.jpg");
	static ImageIcon image6=new ImageIcon("6.jpg");
	static ImageIcon image7=new ImageIcon("7.jpg");
	static ImageIcon image8=new ImageIcon("8.jpg");
	static ImageIcon image9=new ImageIcon("9.jpg");
	static ImageIcon[] image= {image1,image1,image2,image2,image3,image3,image4,image4,
			image5,image5,image6,image6,image7,image7,image8,image8,image9,image9};	
	final int width=188;	final int height=282;
	static JPanel Picture=new JPanel();
	static JLabel L1=new JLabel();		static JLabel L2=new JLabel();		static JLabel L3=new JLabel();		
	static JLabel L4=new JLabel();		static JLabel L5=new JLabel();		static JLabel L6=new JLabel();
	static JLabel L7=new JLabel();		static JLabel L8=new JLabel();		static JLabel L9=new JLabel();
	static JLabel L10=new JLabel();		static JLabel L11=new JLabel();		static JLabel L12=new JLabel();
	static JLabel L13=new JLabel();		static JLabel L14=new JLabel();		static JLabel L15=new JLabel();
	static JLabel L16=new JLabel();		static JLabel L17=new JLabel();		static JLabel L18=new JLabel();
	static JLabel[] L= {L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18};
	static GridBagConstraints G = new GridBagConstraints();
	
	public First() {
		G.gridx = 0; G.gridy = 0; G.gridheight=1;
		G.fill = GridBagConstraints.NONE; G.anchor = GridBagConstraints.CENTER; 	
		Bt.addActionListener(new Bt());
		Board.setLayout(new GridBagLayout());	Board.setOpaque(false);	
		Board.setPreferredSize(new Dimension(1560, 936));	Board.setBounds(0, 0, 1560, 936);
		Picture.setLayout(null);	Picture.setOpaque(false);
		Picture.setPreferredSize(new Dimension(1310, 936));	Picture.setBounds(250, 0, 1310, 936);
		Board.add(Bt,G);
		image0.setImage(image0.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
		for(int i=0;i<image.length;i++) {
			image[i].setImage(image[i].getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	
			L[i].addMouseListener(new Change());
			int j=i%6;
			if(i<6) {
				L[i].setBounds(20+(20+width)*i,10,width,height);
			}
			else if(i<12) {
				L[i].setBounds(20+(20+width)*j,10+(20+height),width,height);
			}
			else if(i<18) {
				L[i].setBounds(20+(20+width)*j,10+(20+height)*2,width,height);
			}
			L[i].setVisible(false);
			Picture.add(L[i]);	
		}	
	}
}
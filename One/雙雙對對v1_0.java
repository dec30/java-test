

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class 雙雙對對v1_0 {
	JFrame Frame=new JFrame(); 														//頁面
	JPanel P =new JPanel();		
	JLabel Bg=new JLabel();		
	ImageIcon Background=new ImageIcon("Error.png");								//背景圖

	ImageIcon image0=new ImageIcon("seal.png");										//問號圖
	ImageIcon image1=new ImageIcon("1.jpg");										//以下猜謎圖
	ImageIcon image2=new ImageIcon("2.jpg");
	ImageIcon image3=new ImageIcon("3.jpg");
	ImageIcon image4=new ImageIcon("4.jpg");
	ImageIcon image5=new ImageIcon("5.jpg");
	ImageIcon image6=new ImageIcon("6.jpg");
	ImageIcon image7=new ImageIcon("7.jpg");
	ImageIcon image8=new ImageIcon("8.jpg");
	ImageIcon image9=new ImageIcon("9.jpg");										//下面一行猜謎圖陣列
	ImageIcon[] image= {image1,image1,image2,image2,image3,image3,image4,image4,
			image5,image5,image6,image6,image7,image7,image8,image8,image9,image9};	
	int width=188;	int height=282;													//固定圖片大小

	GridBagConstraints c = new GridBagConstraints();								//排版
	JLabel L1=new JLabel();		JLabel L2=new JLabel();		JLabel L3=new JLabel();		JLabel L4=new JLabel();
	JLabel L5=new JLabel();		JLabel L6=new JLabel();		JLabel L7=new JLabel();		JLabel L8=new JLabel();
	JLabel L9=new JLabel();		JLabel L10=new JLabel();	JLabel L11=new JLabel();	JLabel L12=new JLabel();
	JLabel L13=new JLabel();	JLabel L14=new JLabel();	JLabel L15=new JLabel();	JLabel L16=new JLabel();
	JLabel L17=new JLabel();	JLabel L18=new JLabel();							//放上圖的格子 下面一行是陣列上面這些東西
	JLabel[] L= {L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18};

	int[] I= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};							//圖片順序判定 用於判斷區 	141行
	int I1=-1;																		//第一張比較的圖 設負數不和上方數字衝突
	JLabel Li1=new JLabel();														//和上方一樣
	int W=0;																		//單純判定用

	JButton Bt=new JButton("開始遊戲");													//單純的按鈕
	JLabel Text=new JLabel("恭喜成功");													//單純的文字
	int Correct=0;																	//計算成功次數
	Timer timer=new Timer();														//時間

	public 雙雙對對v1_0() {
		Frame.setLayout(new GridBagLayout());										//頁面和背景設定
		Frame.setTitle("翻牌遊戲");
		Bg=new JLabel(Background);
		Bg.setBounds(0,0, Background.getIconWidth(), Background.getIconHeight());	
		P=(JPanel) Frame.getContentPane();
		P.setOpaque(false);															
		Frame.getLayeredPane().add(Bg, new Integer(Integer.MIN_VALUE));				

		c.gridx = 0; c.gridy = 0; c.weightx = 0; c.weighty = 1;
		c.fill = GridBagConstraints.NONE; c.anchor = GridBagConstraints.CENTER; 	//設定排版

		Bt.addActionListener(new Bt());												//按鈕的事件控制 			84行
		Frame.add(Bt,c);

		image0.setImage(image0.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	//設定圖片的長寬
		for(int i=0;i<image.length;i++) {
			image[i].setImage(image[i].getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	
			L[i].addMouseListener(new Change());									//設定每一張圖的滑鼠事件	115行
			if(i%6 !=0) {
				c.gridx += 1;														//同一排六張圖
			}
			else {
				c.gridx = 1;														//滿六張圖後往下一層
				c.gridy += 1;
			}			
			L[i].setVisible(false);													//先隱藏圖片
			Frame.add(L[i],c);														//先放入圖片
		}	

		Frame.setSize(1560, 936);													//頁面的其他設定
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class Bt implements ActionListener {										//按下按鈕的設定
		public void actionPerformed(ActionEvent e) {
			Bt.setVisible(false);													//按鈕隱藏
			Text.setVisible(false);													//最後通關文字隱藏
			for(int i=0; i<L.length ;i++)
			{
				L[i].setVisible(true);												//現在顯示圖片
				L[i].setIcon(image0);												//將所有圖片變成問號圖
			}
			image = RandomArray(image);												//圖片陣列的隨機擺放		97行
		}  
	}

	private ImageIcon[] RandomArray(ImageIcon[] image)								//圖片陣列隨機設定
	{      
		int imageLength = image.length;												//先設定圖片數量
		int image_1;																
		ImageIcon image_2;															//額外設定替換的圖片暫存位子

		for(int i = 0; i < imageLength; i++) 
		{      
			image_1 = (int)(Math.random() * imageLength);							//隨機的號碼
			image_2 = image[i];														//第一張圖放到暫存位子
			image[i] = image[image_1];												//第一張圖現在是隨機號碼
			image[image_1] = image_2;												//隨機的號碼現在是第一張圖
		}
		return image;																//傳回打亂的陣列
	}



	public class Change implements MouseListener{									//滑鼠事件區
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
		public void mousePressed(MouseEvent e) {									//壓下去後會觸發
			for(int i=0; i<L.length;i++)
			{
				if(e.getSource()==L[i])												//接取第?張圖
				{
					L[i].setIcon(image[i]);											//第?張圖顯示原本的樣子
					new Judge(I[i],L[i]);											//將第?張圖和原本的樣子傳入判斷區
				}
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public class Judge{																//判斷區
		public Judge(int I,JLabel Li) {
			timer.schedule(new TimerTask(){ 										//延遲一段時間執行 方便使用者比對兩張圖
				public void run(){ 							
					if(I!=I1)														//第二張圖和第一張圖不同的情況往下執行 確保不能重複點擊
					{
						W++;														//點擊判定+1
						if(W==1) {													//第一次點擊會執行的地方
							I1=I;													//暫存第?張圖
							Li1=Li;													//暫存圖片原本的樣子
						}
						if(W==2) {													//第二次點擊會執行的地方
							if(image[I] ==image[I1])								//比對兩張圖片原本的樣子
							{
								Li.setIcon(null);									//成功將兩張圖消失
								Li1.setIcon(null);
								new end();											//結束區					172行
							}
							else													//失敗兩張圖變回問號圖
							{
								Li.setIcon(image0);
								Li1.setIcon(image0);
							}
							I1=-1;													//重設暫存圖
							W=0;													//重設點擊次數
						}
					}
				}},350);															//延遲0.35s
		}
	}

	public class end {																//結束區
		public end() {
			Correct++;																//正確數+1

			if(Correct==9) {														//正確數等於九執行下面
				Text.setVisible(true);												//跳出完成訊息
				Frame.add(Text);
				Bt.setText("再來一次");													//按鈕改名並重新開始
				Bt.setVisible(true);
				Correct=0;															//正確數歸零
			}
		}
	}
	public static void main(String args[]) {										//主執行
		new 雙雙對對v1_0();
	}
}

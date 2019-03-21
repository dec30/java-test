

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class 雙雙對對v1_1 {
	JFrame Frame=new JFrame(); 														//頁面
	JPanel P =new JPanel();		
	JLabel Bg=new JLabel();		
	ImageIcon Background=new ImageIcon("Error.png");								//背景圖

	ImageIcon image0=new ImageIcon("seal.png");										//問號圖
	ImageIcon image1=new ImageIcon("1.jpg");										//以下原本的圖
	ImageIcon image2=new ImageIcon("2.jpg");
	ImageIcon image3=new ImageIcon("3.jpg");
	ImageIcon image4=new ImageIcon("4.jpg");
	ImageIcon image5=new ImageIcon("5.jpg");
	ImageIcon image6=new ImageIcon("6.jpg");
	ImageIcon image7=new ImageIcon("7.jpg");
	ImageIcon image8=new ImageIcon("8.jpg");
	ImageIcon image9=new ImageIcon("9.jpg");										//下面一行原本的圖陣列
	ImageIcon[] image= {image1,image1,image2,image2,image3,image3,image4,image4,
			image5,image5,image6,image6,image7,image7,image8,image8,image9,image9};	
	int width=188;	int height=282;													//固定圖片大小

	JPanel Picture=new JPanel();													//主要畫面設定
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

	GridBagConstraints c = new GridBagConstraints();								//排版

	JPanel Other=new JPanel();														//左半部設定
	JLabel Time = new JLabel();														//顯示時間的文字

	JPanel Board=new JPanel();														//中央設定
	JButton Bt=new JButton("開始遊戲");												//單純的按鈕
	JLabel Text=new JLabel("恭喜成功");												//單純的文字
	int Correct=0;																	//計算成功次數

	public 雙雙對對v1_1() {
		Frame.setLayout(null);														//頁面和背景設定
		Frame.setTitle("翻牌遊戲");
		Bg=new JLabel(Background);
		Bg.setBounds(0,0, Background.getIconWidth(), Background.getIconHeight());	
		P=(JPanel) Frame.getContentPane();
		P.setOpaque(false);															
		Frame.getLayeredPane().add(Bg, new Integer(Integer.MIN_VALUE));	
																					//下面都是版面設定
		Board.setLayout(new GridBagLayout());	Board.setOpaque(false);	
		Board.setPreferredSize(new Dimension(1560, 936));	Board.setBounds(0, 0, 1560, 936);
		Picture.setLayout(null);	Picture.setOpaque(false);
		Picture.setPreferredSize(new Dimension(1310, 936));	Picture.setBounds(250, 0, 1310, 936);
		Other.setLayout(new GridBagLayout());	Other.setOpaque(false);
		Other.setPreferredSize(new Dimension(250, 936));	Other.setBounds(0, 0, 250, 936);					
		c.gridx = 0; c.gridy = 0; c.gridheight=1;
		c.fill = GridBagConstraints.NONE; c.anchor = GridBagConstraints.CENTER; 	
		/*	setLayout:排版方式		setOpaque:是否透明	setPreferredSize:設定大小	setBounds:設定固定位子
			GridBagLayout的設定:	x.grid:xy座標位子 	x.gridheight:高度設定	x.fill:是否填滿	x.anchor:擺放位子*/

		new Main();																	//執行區 	第83行

		Frame.add(Board);															//新增物件進入頁面
		Frame.add(Picture);
		Frame.add(Other);

		Frame.setSize(1560, 936);													//頁面的其他設定
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class Main{	
		public Main() {
			Bt.addActionListener(new Bt());											//按鈕的事件控制	 	第111行
			Board.add(Bt,c);
			Text.setFont(new Font("標楷體", Font.BOLD, 32));	Text.setVisible(false);	//文字設定
			Board.add(Text,c);
																					//設定圖片的長寬
			image0.setImage(image0.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
			for(int i=0;i<image.length;i++) {
				image[i].setImage(image[i].getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	
				L[i].addMouseListener(new Change());								//設定滑鼠事件		第142行
				int j=i%6;															//以下是設定圖片的固定位子
				if(i<6) {
					L[i].setBounds(20+(20+width)*i,10,width,height);
				}
				else if(i<12) {
					L[i].setBounds(20+(20+width)*j,10+(20+height),width,height);
				}
				else if(i<18) {
					L[i].setBounds(20+(20+width)*j,10+(20+height)*2,width,height);
				}
				L[i].setVisible(false);												//先隱藏圖片
				Picture.add(L[i]);
			}	
		}
	}

	public class Bt implements ActionListener {										//按下按鈕的設定
		public void actionPerformed(ActionEvent e) {
			Bt.setVisible(false);													//按鈕隱藏
			for(int i=0; i<L.length ;i++)
			{
				L[i].setVisible(true);												//現在顯示圖片
				L[i].setIcon(image0);												//將所有圖片變成問號圖
			}
			image = RandomArray(image);												//圖片陣列的隨機擺放	第125行
			new timerr();															//計時區			第202行
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
			if(W==2)																//判斷時間禁止點選
			{
				return;
			}
			for(int i=0; i<L.length;i++)
			{
				if(e.getSource()==L[i] &(e.getSource()!=Li1 | W==0))				//接取第?張圖
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
		Timer timer=new Timer();
		public Judge(int I,JLabel Li) {
			W++;																	//點擊判定+1
			if(W==1) {																//第一次點擊會執行的地方
				I1=I;																//暫存第?張圖
				Li1=Li;																//暫存圖片原本的樣子
			}
			if(W==2) {
				timer.schedule(new TimerTask(){ 									//延遲一段時間執行 方便使用者比對兩張圖
					public void run(){
						if(image[I] ==image[I1])									//比對兩張圖片原本的樣子
						{
							Li.setVisible(false);									//成功將兩張圖消失
							Li1.setVisible(false);		
							new end();												//結束區	第237行
						}
						else														//失敗兩張圖變回問號圖
						{
							Li.setIcon(image0);
							Li1.setIcon(image0);
						}
						I1=-1;														//重設暫存圖
						W=0;														//重設點擊次數
					}
				},500);																//延遲0.5s
			}
		}
	}

	public class timerr extends TimerTask{											//計時區
		int s=0;																	//秒
		int m=0;																	//分
		Timer timerr=new Timer();
		public timerr() {		
			Other.add(Time,c);
			timerr.schedule(this, 0, 1000);											//每一秒執行下面一次
		}
		public void run() {															//下面是顯示時間的設定
			m=s%60;
			if(s<=59)																//小於1分鐘的顯示方式
			{
				Time.setText("進行了:"+s+"秒");
			}
			else																	//1分鐘以上的顯示方式
			{
				Time.setText("進行了:"+(s/60)+"分"+m+"秒");
			}
			if(Correct==9) {														//結算的顯示設定
				timerr.cancel();													//第208行的執行結束
				if(s<=59)
				{
					Time.setText("你總共花了:"+s+"秒");
				}
				else
				{
					Time.setText("你總共花了:"+(s/60)+"分"+m+"秒");
				}
				s=0;																//秒數歸零
			}
			s++;																	//每執行一次+1秒
		}
	}

	public class end {																//結束區
		public end() {
			Correct++;																//正確數+1
			if(Correct==9) {														//正確數等於九執行下面
				Text.setVisible(true);												//跳出訊息
				try {																//暫停三秒
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				Text.setVisible(false);												//隱藏訊息
				Bt.setText("再來一次");												//按鈕改名並重新開始
				Bt.setVisible(true);												//按鈕再次顯示
				Correct=0;															//正確數歸零
			}
		}
	}
	public static void main(String args[]) {										//主執行
		new 雙雙對對v1_1();
	}
}



import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class �������v1_1 {
	JFrame Frame=new JFrame(); 														//����
	JPanel P =new JPanel();		
	JLabel Bg=new JLabel();		
	ImageIcon Background=new ImageIcon("Error.png");								//�I����

	ImageIcon image0=new ImageIcon("seal.png");										//�ݸ���
	ImageIcon image1=new ImageIcon("1.jpg");										//�H�U�쥻����
	ImageIcon image2=new ImageIcon("2.jpg");
	ImageIcon image3=new ImageIcon("3.jpg");
	ImageIcon image4=new ImageIcon("4.jpg");
	ImageIcon image5=new ImageIcon("5.jpg");
	ImageIcon image6=new ImageIcon("6.jpg");
	ImageIcon image7=new ImageIcon("7.jpg");
	ImageIcon image8=new ImageIcon("8.jpg");
	ImageIcon image9=new ImageIcon("9.jpg");										//�U���@��쥻���ϰ}�C
	ImageIcon[] image= {image1,image1,image2,image2,image3,image3,image4,image4,
			image5,image5,image6,image6,image7,image7,image8,image8,image9,image9};	
	int width=188;	int height=282;													//�T�w�Ϥ��j�p

	JPanel Picture=new JPanel();													//�D�n�e���]�w
	JLabel L1=new JLabel();		JLabel L2=new JLabel();		JLabel L3=new JLabel();		JLabel L4=new JLabel();
	JLabel L5=new JLabel();		JLabel L6=new JLabel();		JLabel L7=new JLabel();		JLabel L8=new JLabel();
	JLabel L9=new JLabel();		JLabel L10=new JLabel();	JLabel L11=new JLabel();	JLabel L12=new JLabel();
	JLabel L13=new JLabel();	JLabel L14=new JLabel();	JLabel L15=new JLabel();	JLabel L16=new JLabel();
	JLabel L17=new JLabel();	JLabel L18=new JLabel();							//��W�Ϫ���l �U���@��O�}�C�W���o�ǪF��
	JLabel[] L= {L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18};
	int[] I= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};							//�Ϥ����ǧP�w �Ω�P�_�� 	141��
	int I1=-1;																		//�Ĥ@�i������� �]�t�Ƥ��M�W��Ʀr�Ĭ�
	JLabel Li1=new JLabel();														//�M�W��@��
	int W=0;																		//��§P�w��

	GridBagConstraints c = new GridBagConstraints();								//�ƪ�

	JPanel Other=new JPanel();														//���b���]�w
	JLabel Time = new JLabel();														//��ܮɶ�����r

	JPanel Board=new JPanel();														//�����]�w
	JButton Bt=new JButton("�}�l�C��");												//��ª����s
	JLabel Text=new JLabel("���ߦ��\");												//��ª���r
	int Correct=0;																	//�p�⦨�\����

	public �������v1_1() {
		Frame.setLayout(null);														//�����M�I���]�w
		Frame.setTitle("½�P�C��");
		Bg=new JLabel(Background);
		Bg.setBounds(0,0, Background.getIconWidth(), Background.getIconHeight());	
		P=(JPanel) Frame.getContentPane();
		P.setOpaque(false);															
		Frame.getLayeredPane().add(Bg, new Integer(Integer.MIN_VALUE));	
																					//�U�����O�����]�w
		Board.setLayout(new GridBagLayout());	Board.setOpaque(false);	
		Board.setPreferredSize(new Dimension(1560, 936));	Board.setBounds(0, 0, 1560, 936);
		Picture.setLayout(null);	Picture.setOpaque(false);
		Picture.setPreferredSize(new Dimension(1310, 936));	Picture.setBounds(250, 0, 1310, 936);
		Other.setLayout(new GridBagLayout());	Other.setOpaque(false);
		Other.setPreferredSize(new Dimension(250, 936));	Other.setBounds(0, 0, 250, 936);					
		c.gridx = 0; c.gridy = 0; c.gridheight=1;
		c.fill = GridBagConstraints.NONE; c.anchor = GridBagConstraints.CENTER; 	
		/*	setLayout:�ƪ��覡		setOpaque:�O�_�z��	setPreferredSize:�]�w�j�p	setBounds:�]�w�T�w��l
			GridBagLayout���]�w:	x.grid:xy�y�Ц�l 	x.gridheight:���׳]�w	x.fill:�O�_��	x.anchor:�\���l*/

		new Main();																	//����� 	��83��

		Frame.add(Board);															//�s�W����i�J����
		Frame.add(Picture);
		Frame.add(Other);

		Frame.setSize(1560, 936);													//��������L�]�w
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class Main{	
		public Main() {
			Bt.addActionListener(new Bt());											//���s���ƥ󱱨�	 	��111��
			Board.add(Bt,c);
			Text.setFont(new Font("�з���", Font.BOLD, 32));	Text.setVisible(false);	//��r�]�w
			Board.add(Text,c);
																					//�]�w�Ϥ������e
			image0.setImage(image0.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
			for(int i=0;i<image.length;i++) {
				image[i].setImage(image[i].getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	
				L[i].addMouseListener(new Change());								//�]�w�ƹ��ƥ�		��142��
				int j=i%6;															//�H�U�O�]�w�Ϥ����T�w��l
				if(i<6) {
					L[i].setBounds(20+(20+width)*i,10,width,height);
				}
				else if(i<12) {
					L[i].setBounds(20+(20+width)*j,10+(20+height),width,height);
				}
				else if(i<18) {
					L[i].setBounds(20+(20+width)*j,10+(20+height)*2,width,height);
				}
				L[i].setVisible(false);												//�����ùϤ�
				Picture.add(L[i]);
			}	
		}
	}

	public class Bt implements ActionListener {										//���U���s���]�w
		public void actionPerformed(ActionEvent e) {
			Bt.setVisible(false);													//���s����
			for(int i=0; i<L.length ;i++)
			{
				L[i].setVisible(true);												//�{�b��ܹϤ�
				L[i].setIcon(image0);												//�N�Ҧ��Ϥ��ܦ��ݸ���
			}
			image = RandomArray(image);												//�Ϥ��}�C���H���\��	��125��
			new timerr();															//�p�ɰ�			��202��
		}  
	}

	private ImageIcon[] RandomArray(ImageIcon[] image)								//�Ϥ��}�C�H���]�w
	{      
		int imageLength = image.length;												//���]�w�Ϥ��ƶq
		int image_1;																
		ImageIcon image_2;															//�B�~�]�w�������Ϥ��Ȧs��l

		for(int i = 0; i < imageLength; i++) 
		{      
			image_1 = (int)(Math.random() * imageLength);							//�H�������X
			image_2 = image[i];														//�Ĥ@�i�ϩ��Ȧs��l
			image[i] = image[image_1];												//�Ĥ@�i�ϲ{�b�O�H�����X
			image[image_1] = image_2;												//�H�������X�{�b�O�Ĥ@�i��
		}
		return image;																//�Ǧ^���ê��}�C
	}


	public class Change implements MouseListener{									//�ƹ��ƥ��
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
		public void mousePressed(MouseEvent e) {									//���U�h��|Ĳ�o
			if(W==2)																//�P�_�ɶ��T���I��
			{
				return;
			}
			for(int i=0; i<L.length;i++)
			{
				if(e.getSource()==L[i] &(e.getSource()!=Li1 | W==0))				//������?�i��
				{
					L[i].setIcon(image[i]);											//��?�i����ܭ쥻���ˤl
					new Judge(I[i],L[i]);											//�N��?�i�ϩM�쥻���ˤl�ǤJ�P�_��
				}
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public class Judge{																//�P�_��
		Timer timer=new Timer();
		public Judge(int I,JLabel Li) {
			W++;																	//�I���P�w+1
			if(W==1) {																//�Ĥ@���I���|���檺�a��
				I1=I;																//�Ȧs��?�i��
				Li1=Li;																//�Ȧs�Ϥ��쥻���ˤl
			}
			if(W==2) {
				timer.schedule(new TimerTask(){ 									//����@�q�ɶ����� ��K�ϥΪ̤���i��
					public void run(){
						if(image[I] ==image[I1])									//����i�Ϥ��쥻���ˤl
						{
							Li.setVisible(false);									//���\�N��i�Ϯ���
							Li1.setVisible(false);		
							new end();												//������	��237��
						}
						else														//���Ѩ�i���ܦ^�ݸ���
						{
							Li.setIcon(image0);
							Li1.setIcon(image0);
						}
						I1=-1;														//���]�Ȧs��
						W=0;														//���]�I������
					}
				},500);																//����0.5s
			}
		}
	}

	public class timerr extends TimerTask{											//�p�ɰ�
		int s=0;																	//��
		int m=0;																	//��
		Timer timerr=new Timer();
		public timerr() {		
			Other.add(Time,c);
			timerr.schedule(this, 0, 1000);											//�C�@�����U���@��
		}
		public void run() {															//�U���O��ܮɶ����]�w
			m=s%60;
			if(s<=59)																//�p��1��������ܤ覡
			{
				Time.setText("�i��F:"+s+"��");
			}
			else																	//1�����H�W����ܤ覡
			{
				Time.setText("�i��F:"+(s/60)+"��"+m+"��");
			}
			if(Correct==9) {														//���⪺��ܳ]�w
				timerr.cancel();													//��208�檺���浲��
				if(s<=59)
				{
					Time.setText("�A�`�@��F:"+s+"��");
				}
				else
				{
					Time.setText("�A�`�@��F:"+(s/60)+"��"+m+"��");
				}
				s=0;																//����k�s
			}
			s++;																	//�C����@��+1��
		}
	}

	public class end {																//������
		public end() {
			Correct++;																//���T��+1
			if(Correct==9) {														//���T�Ƶ���E����U��
				Text.setVisible(true);												//���X�T��
				try {																//�Ȱ��T��
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				Text.setVisible(false);												//���ðT��
				Bt.setText("�A�Ӥ@��");												//���s��W�í��s�}�l
				Bt.setVisible(true);												//���s�A�����
				Correct=0;															//���T���k�s
			}
		}
	}
	public static void main(String args[]) {										//�D����
		new �������v1_1();
	}
}

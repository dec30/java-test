

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class �������v1_0 {
	JFrame Frame=new JFrame(); 														//����
	JPanel P =new JPanel();		
	JLabel Bg=new JLabel();		
	ImageIcon Background=new ImageIcon("Error.png");								//�I����

	ImageIcon image0=new ImageIcon("seal.png");										//�ݸ���
	ImageIcon image1=new ImageIcon("1.jpg");										//�H�U�q����
	ImageIcon image2=new ImageIcon("2.jpg");
	ImageIcon image3=new ImageIcon("3.jpg");
	ImageIcon image4=new ImageIcon("4.jpg");
	ImageIcon image5=new ImageIcon("5.jpg");
	ImageIcon image6=new ImageIcon("6.jpg");
	ImageIcon image7=new ImageIcon("7.jpg");
	ImageIcon image8=new ImageIcon("8.jpg");
	ImageIcon image9=new ImageIcon("9.jpg");										//�U���@��q���ϰ}�C
	ImageIcon[] image= {image1,image1,image2,image2,image3,image3,image4,image4,
			image5,image5,image6,image6,image7,image7,image8,image8,image9,image9};	
	int width=188;	int height=282;													//�T�w�Ϥ��j�p

	GridBagConstraints c = new GridBagConstraints();								//�ƪ�
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

	JButton Bt=new JButton("�}�l�C��");													//��ª����s
	JLabel Text=new JLabel("���ߦ��\");													//��ª���r
	int Correct=0;																	//�p�⦨�\����
	Timer timer=new Timer();														//�ɶ�

	public �������v1_0() {
		Frame.setLayout(new GridBagLayout());										//�����M�I���]�w
		Frame.setTitle("½�P�C��");
		Bg=new JLabel(Background);
		Bg.setBounds(0,0, Background.getIconWidth(), Background.getIconHeight());	
		P=(JPanel) Frame.getContentPane();
		P.setOpaque(false);															
		Frame.getLayeredPane().add(Bg, new Integer(Integer.MIN_VALUE));				

		c.gridx = 0; c.gridy = 0; c.weightx = 0; c.weighty = 1;
		c.fill = GridBagConstraints.NONE; c.anchor = GridBagConstraints.CENTER; 	//�]�w�ƪ�

		Bt.addActionListener(new Bt());												//���s���ƥ󱱨� 			84��
		Frame.add(Bt,c);

		image0.setImage(image0.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	//�]�w�Ϥ������e
		for(int i=0;i<image.length;i++) {
			image[i].setImage(image[i].getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));	
			L[i].addMouseListener(new Change());									//�]�w�C�@�i�Ϫ��ƹ��ƥ�	115��
			if(i%6 !=0) {
				c.gridx += 1;														//�P�@�Ƥ��i��
			}
			else {
				c.gridx = 1;														//�����i�ϫ᩹�U�@�h
				c.gridy += 1;
			}			
			L[i].setVisible(false);													//�����ùϤ�
			Frame.add(L[i],c);														//����J�Ϥ�
		}	

		Frame.setSize(1560, 936);													//��������L�]�w
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class Bt implements ActionListener {										//���U���s���]�w
		public void actionPerformed(ActionEvent e) {
			Bt.setVisible(false);													//���s����
			Text.setVisible(false);													//�̫�q����r����
			for(int i=0; i<L.length ;i++)
			{
				L[i].setVisible(true);												//�{�b��ܹϤ�
				L[i].setIcon(image0);												//�N�Ҧ��Ϥ��ܦ��ݸ���
			}
			image = RandomArray(image);												//�Ϥ��}�C���H���\��		97��
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
			for(int i=0; i<L.length;i++)
			{
				if(e.getSource()==L[i])												//������?�i��
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
		public Judge(int I,JLabel Li) {
			timer.schedule(new TimerTask(){ 										//����@�q�ɶ����� ��K�ϥΪ̤���i��
				public void run(){ 							
					if(I!=I1)														//�ĤG�i�ϩM�Ĥ@�i�Ϥ��P�����p���U���� �T�O���୫���I��
					{
						W++;														//�I���P�w+1
						if(W==1) {													//�Ĥ@���I���|���檺�a��
							I1=I;													//�Ȧs��?�i��
							Li1=Li;													//�Ȧs�Ϥ��쥻���ˤl
						}
						if(W==2) {													//�ĤG���I���|���檺�a��
							if(image[I] ==image[I1])								//����i�Ϥ��쥻���ˤl
							{
								Li.setIcon(null);									//���\�N��i�Ϯ���
								Li1.setIcon(null);
								new end();											//������					172��
							}
							else													//���Ѩ�i���ܦ^�ݸ���
							{
								Li.setIcon(image0);
								Li1.setIcon(image0);
							}
							I1=-1;													//���]�Ȧs��
							W=0;													//���]�I������
						}
					}
				}},350);															//����0.35s
		}
	}

	public class end {																//������
		public end() {
			Correct++;																//���T��+1

			if(Correct==9) {														//���T�Ƶ���E����U��
				Text.setVisible(true);												//���X�����T��
				Frame.add(Text);
				Bt.setText("�A�Ӥ@��");													//���s��W�í��s�}�l
				Bt.setVisible(true);
				Correct=0;															//���T���k�s
			}
		}
	}
	public static void main(String args[]) {										//�D����
		new �������v1_0();
	}
}

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class erlang extends JFrame
{
	//���ְ�ť
	private JButton ok,clear,paint;
	private JRadioButton count_b,count_a,count_s;
	private ButtonGroup choose;
	private JTextField text_b,text_a,text_s;
	private JComboBox lbk;
	private JLabel label;
	private JPanel pok,pclear,pb,pa,ps,ptb,pta,pts,plbk,plabel,ppaint;
	private String number[]={"1","2","3","4","5"};
	
	//���췽�� 
	public erlang()
	{
		//�����
		super("erlang������");
		setBounds(400,150,390,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����ButtonGroup�Ͱ�ť��text��ComboBox
		ok=new JButton("ȷ��");
		clear=new JButton("���");
		paint=new JButton("��ͼ");
		choose=new ButtonGroup();
		count_b=new JRadioButton("����B(a,s)");
		count_a=new JRadioButton("����a");
		count_s=new JRadioButton("����s");
		count_b.setFont(new Font("Serif",Font.PLAIN,14));
		count_a.setFont(new Font("Serif",Font.PLAIN,14));
		count_s.setFont(new Font("Serif",Font.PLAIN,14));
		choose.add(count_b);
		choose.add(count_a);
		choose.add(count_s);
		count_b.setSelected(true);
		text_b=new JTextField("",15);
		text_b.setFont(new Font("Serif",Font.PLAIN,10));
		text_b.setEditable(false);
		text_a=new JTextField("",15);
		text_a.setFont(new Font("Serif",Font.PLAIN,10));
		text_s=new JTextField("",15);
		text_s.setFont(new Font("Serif",Font.PLAIN,10));
		label=new JLabel("С�����辫��");
		lbk=new JComboBox(number);
		lbk.setMaximumRowCount(3);
		lbk.setSelectedIndex(2);
		lbk.setFont(new Font("Serif",Font.PLAIN,14));
		//����ϵͳ����
		Container c=getContentPane();
		c.setLayout(null);//����
		ppaint=new JPanel();
		ppaint.setLayout(new BorderLayout());
		c.add(ppaint);
		ppaint.add(paint);
		ppaint.setBounds(180, 85, 60, 25);//��ťpaint
		pok=new JPanel();
		pok.setLayout(new BorderLayout());
		c.add(pok);
		pok.add(ok);
		pok.setBounds(310, 85, 60, 25);//��ťok
		pclear=new JPanel();
		pclear.setLayout(new BorderLayout());
		c.add(pclear);
		pclear.add(clear);
		pclear.setBounds(245, 85, 60, 25);//��ťclear
		plabel=new JPanel();
		plabel.setLayout(new BorderLayout());
		c.add(plabel);
		plabel.add(label);
		plabel.setBounds(5, 90, 78, 20);//��ǩ��
		plbk=new JPanel();
		plbk.setLayout(new BorderLayout());
		c.add(plbk);
		plbk.add(lbk);
		plbk.setBounds(85, 90, 35, 20);//���ȿ�
		pb=new JPanel();
		pb.setLayout(new BorderLayout());
		c.add(pb);
		pb.add(count_b);
		pb.setBounds(30, 5, 90, 30);//ѡ��B
		pa=new JPanel();
		pa.setLayout(new BorderLayout());
		c.add(pa);
		pa.add(count_a);
		pa.setBounds(140, 5, 90, 30);//ѡ��a	
		ps=new JPanel();
		ps.setLayout(new BorderLayout());
		c.add(ps);
		ps.add(count_s);
		ps.setBounds(260, 5, 90, 30);//ѡ��s
		ptb=new JPanel();
		ptb.setLayout(new BorderLayout());
		c.add(ptb);
		ptb.add(text_b);
		ptb.setBounds(30, 40, 80, 25);//�ı���B
		pta=new JPanel();
		pta.setLayout(new BorderLayout());
		c.add(pta);
		pta.add(text_a);
		pta.setBounds(140, 40, 80, 25);//�ı���a
		pts=new JPanel();
		pts.setLayout(new BorderLayout());
		c.add(pts);
		pts.add(text_s);
		pts.setBounds(260, 40, 80, 25);//�ı���B
		setVisible(true);
		//���ü�����
		Itemhander hh=new Itemhander();
		count_b.addItemListener(hh);
		count_a.addItemListener(hh);
		count_s.addItemListener(hh);
		Actionhander aa=new Actionhander();
		ok.addActionListener(aa);
		clear.addActionListener(aa);
		paint.addActionListener(aa);
		
	}
	
	public static void main(String[] arguments)
	{
		//������
		erlang Erlang=new erlang();
	}
	
	public class Itemhander implements ItemListener
	{
		//ѡ�������
		public void itemStateChanged(ItemEvent e) 
		{
			if(count_b.isSelected())
			{
			    text_b.setEditable(false);
			    text_a.setEditable(true);
			    text_s.setEditable(true);
				lbk.setVisible(true);
				label.setText("С�����辫��");
			}
			else if(count_a.isSelected())
			{
				text_b.setEditable(true);
				text_a.setEditable(false);
				text_s.setEditable(true);
				lbk.setVisible(true);
				label.setText("С�����辫��");
			}
			else if(count_s.isSelected())
			{
				text_b.setEditable(true);
				text_a.setEditable(true);
				text_s.setEditable(false);
				lbk.setVisible(false);
				label.setText("���Ϊ����");
			}
		}
	}
	
	public class Actionhander implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			if(a.getSource()==clear)
			{   //�����������
				text_b.setText("");
				text_a.setText("");
				text_s.setText("");
			}
			else if(a.getSource()==ok)
			{
				calculate();
			}
			else if(a.getSource()==paint)
			{
				paint();
			}
			
		}
		
		
		/******************�м亯��****************/
		//����B��s��a����ֵ
		public double B(int s,double a)
		{
			double count = 1;
			//���sΪ0
			if(s==0)
			return 1;
			//���s��Ϊ0	
			for(int i=1;i<=s;i++)
			count = (a*count)/(i+a*count);
			return count;
		}
		
		//��������
		public double Adjust(double num)
		{
			double intermediate;
			intermediate=num;
			
			for(;num>=1;)
			num=num-1;
			
			if(num>=0.5)
			intermediate=intermediate+1;
			
			return intermediate;
		}
		/***************************************/
		
		//���㺯��
		private void calculate()

		{
			//��֪a,s����b
			if(count_b.isSelected())
			{
				try
				{
					//��������
					int precise=Integer.parseInt((String)lbk.getSelectedItem())+1;//��ȡ����
					String sa = text_a.getText();
					String ss = text_s.getText();
					double a = Double.parseDouble(sa);
					int s = Integer.parseInt(ss);
					//����a��s����ͬʱΪ0
					if(!(s==0&&a==0))
					{
						Double b = B(s,a);
						text_b.setText(""+((int)(Adjust(b*Math.pow(10,precise-1)))/Math.pow(10,precise-1)));
					}
					else
					{
						JOptionPane.showMessageDialog(erlang.this, "a,s������ͬʱΪ0!");
						text_a.setText("");
						text_s.setText("");
					}
				}
				catch(Exception e)
				{
					//�Ƿ�����
					JOptionPane.showMessageDialog(erlang.this, "����Ƿ�!����������!");
					text_a.setText("");
					text_s.setText("");
				}

			}
			//��֪b��s����a
			else if(count_a.isSelected())
			{
				try
				{
					//��������
					int precise=Integer.parseInt((String)lbk.getSelectedItem())+1;//��ȡ����
					String sb = text_b.getText();
					String ss = text_s.getText();
					double b = Double.parseDouble(sb);
					int s = Integer.parseInt(ss);
					double a1=0,a2=1;
					double a=0;
					double point=1;
					int i;
					//�ж�b��s�Ƿ���Ϲ淶
					if(b<1&&b>0&&s!=0)
					{
						for(i=0;i<=precise;i++)
						{
							while(!(B(s,a1)<=b&&B(s,a2)>=b))
							{
								a1=a1+point;a2=a2+point;	
							}
							a=a1;
							point=point/10;
							a1=a1;a2=a1+point;
						}
						text_a.setText(""+(int)(Adjust(a*Math.pow(10,precise-1)))/Math.pow(10,precise-1));
						
					}
					else
					{
						if(!(b<1&&b>0))
						{
							JOptionPane.showMessageDialog(erlang.this, "B����Ϊ0~1(������0��1)֮�����!");
							text_b.setText("");
						}
						if(s==0)
						{
							JOptionPane.showMessageDialog(erlang.this, "s������Ϊ0!");
							text_s.setText("");
						}

					}
				}
				catch(Exception e)
				{
					//�Ƿ�����
					JOptionPane.showMessageDialog(erlang.this, "����Ƿ�!����������!");
					text_b.setText("");
					text_s.setText("");
				}
				
			}	
			//��֪a��b����s
			else if(count_s.isSelected())
			{
				try
				{
					//��������
					String sa = text_a.getText(); 
					String sb = text_b.getText();
					double a = Double.parseDouble(sa);
					double b = Double.parseDouble(sb);
					//�ж�b�Ƿ���Ϲ淶
					if(b<1&&b>0)
					{
						int s = 1;
						while(B(s,a)>b) s++;
						text_s.setText(""+s);
					}
					else
					{
						JOptionPane.showMessageDialog(erlang.this, "B����Ϊ0~1(������0��1)֮�����!");
						text_b.setText("");
					}
				}
				catch(Exception e)
				{
					//�Ƿ�����
					JOptionPane.showMessageDialog(erlang.this, "����Ƿ�!����������!");
					text_a.setText("");
					text_b.setText("");
				}

		    }	
	    }

		//��ͼ����
		private void paint()
		{
			PaintFunction pp=new PaintFunction();
		}
	}

	//��ͼ���ؽ�
	public class PaintFunction extends JFrame
	{
		//���ð�ť
		private JButton confirm;
		private JRadioButton choose_b,choose_a,choose_s;
		private ButtonGroup chos;
		private JTextField tt_b,tt_a,tt_s;
		private JPanel pconfirm,pcb,pca,pcs,area,pttb,ptta,ptts;
		Container cc;
		
		public PaintFunction()
		{
			//��������
			//add(new PaintFunctionPanel());
			setSize(400,400);
			setTitle("���ƺ�������");
			setLocationRelativeTo(null);//center
			setVisible(true);
			//��ʼ�������齨
			confirm=new JButton("ȷ��");
			chos=new ButtonGroup();
			choose_b=new JRadioButton("����B");
			choose_a=new JRadioButton("����a");
			choose_s=new JRadioButton("����s");
			choose_b.setFont(new Font("Serif",Font.PLAIN,14));
			choose_a.setFont(new Font("Serif",Font.PLAIN,14));
		    choose_s.setFont(new Font("Serif",Font.PLAIN,14));
			chos.add(choose_b);
			chos.add(choose_a);
			chos.add(choose_s);
			choose_s.setSelected(true);
			tt_b=new JTextField("",15);
			tt_b.setFont(new Font("Serif",Font.PLAIN,10));
			tt_b.setEditable(false);
			tt_a=new JTextField("",15);
			tt_a.setFont(new Font("Serif",Font.PLAIN,10));
			tt_a.setEditable(false);
			tt_s=new JTextField("",15);
			tt_s.setFont(new Font("Serif",Font.PLAIN,10));
			//��������
			cc=getContentPane();
			cc.setLayout(null);//����
			pcb=new JPanel();
			pcb.setLayout(new BorderLayout());
			cc.add(pcb);
			pcb.add(choose_b);
			pcb.setBounds(20, 5, 90, 30);//ѡ��B
			pca=new JPanel();
			pca.setLayout(new BorderLayout());
			cc.add(pca);
			pca.add(choose_a);
			pca.setBounds(120, 5, 90, 30);//ѡ��a	
			pcs=new JPanel();
			pcs.setLayout(new BorderLayout());
			cc.add(pcs);
			pcs.add(choose_s);
			pcs.setBounds(220, 5, 90, 30);//ѡ��s
			pttb=new JPanel();
			pttb.setLayout(new BorderLayout());
			cc.add(pttb);
			pttb.add(tt_b);
			pttb.setBounds(20, 40, 80, 25);//�ı���B
			ptta=new JPanel();
			ptta.setLayout(new BorderLayout());
			cc.add(ptta);
			ptta.add(tt_a);
			ptta.setBounds(120, 40, 80, 25);//�ı���a
			ptts=new JPanel();
			ptts.setLayout(new BorderLayout());
			cc.add(ptts);
			ptts.add(tt_s);
			ptts.setBounds(220, 40, 80, 25);//�ı���B
			pconfirm=new JPanel();
			pconfirm.setLayout(new BorderLayout());
			cc.add(pconfirm);
			pconfirm.add(confirm);
			pconfirm.setBounds(310, 15, 60, 50);//��ť
			area=new JPanel();
			setVisible(true);
			//ע�������
			Itemhhander hhh=new Itemhhander();
			choose_a.addItemListener(hhh);
			choose_b.addItemListener(hhh);
			choose_s.addItemListener(hhh);
			Actionhhander aaa=new Actionhhander();
			confirm.addActionListener(aaa);
			//˵��
			JOptionPane.showMessageDialog(PaintFunction.this, "��������ʦ�����̣����������ǲ��õĴ����Ч�����⣬\n��ʵ�ʲ���" +
				         "����B��ͼ�Ĺ������׵��»��������������������ֻ�����������ͼ��\n�ò������������ǵĸĽ��У����ڸ���B��ͼ����Բμ���" +
				         "��ʹ��matlab������ͼ��\n����a�͸���s����ͼ�������ÿ��á���л����ʹ�á�");
		}
		
		public class Itemhhander implements ItemListener
		{
			//ѡ�������
			public void itemStateChanged(ItemEvent e) 
			{
				if(choose_b.isSelected())
				{
				    tt_b.setEditable(true);
				    tt_a.setEditable(false);
				    tt_s.setEditable(false);
				}
				else if(choose_a.isSelected())
				{
					tt_b.setEditable(false);
					tt_a.setEditable(true);
					tt_s.setEditable(false);
				}
				else if(choose_s.isSelected())
				{
					tt_b.setEditable(false);
					tt_a.setEditable(false);
					tt_s.setEditable(true);
				}
			}
		}
		
		public class Actionhhander implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0)
			{	
				if(choose_a.isSelected())
				{
					try
					{
						String sa=tt_a.getText();
						final double a=Double.parseDouble(sa);
						tt_a.setEditable(false);
						if(a>0)
						{	
							//����ͼ��
							area=new JPanel()
							{
								protected void paintComponent(Graphics g)
								{
									Actionhander use=new Actionhander();
									super.paintComponent(g);

									//��x��
									g.drawLine(20,270,20,20);
									g.drawString("s",325,280);
									//��y��
									g.drawLine(20,270,320,270);
									g.drawString("B",12,20);
									//������ͼ��
									for(int s=1;s<=30;s++)
									{
										double B=use.B(s,a);
										g.drawString(".",20+10*s,(int)(270-250*B));
										g.drawLine(20+10*s, (int)(270-250*B), 20+10*s, 270);
									}
								}
							};
							area.setLayout(new BorderLayout());
							cc.add(area);
							area.setBounds(10, 70, 365, 285);
						}
						else
						{
							JOptionPane.showMessageDialog(PaintFunction.this, "a�������0!");
							tt_a.setText("");
						}
					}
					catch(Exception e)
					{
						//�Ƿ�����
						JOptionPane.showMessageDialog(PaintFunction.this, "����Ƿ�!����������!");
						tt_a.setText("");
					}
				}
				else if(choose_b.isSelected())
				{
					try
					{
						String sb=tt_b.getText();
						final double b=Double.parseDouble(sb);
						tt_b.setEditable(false);
						if(b>0&&b<1)
						{	
							//����ͼ��
							area=new JPanel()
							{
								double a1=0,a2=1;
								double a=0;
								double point=1;
								
								protected void paintComponent(Graphics g)
								{
									Actionhander use=new Actionhander();
									super.paintComponent(g);
									//��x��
									g.drawLine(20,270,20,20);
									g.drawString("a",325,280);
									//��y��
									g.drawLine(20,270,320,270);
									g.drawString("s",12,20);
									//������ͼ��
									for(int s=1;s<=2;s++)
									{
										for(int i=0;i<=4;i++)
										{
											while(!(use.B(s,a1)<=b&&use.B(s,a2)>=b))
											{
												a1=a1+point;a2=a2+point;	
											}
											a=a1;
											point=point/10;
											a1=a1;a2=a1+point;
										}
										g.drawString(".",20+10*s,(int)(270-a));
										g.drawLine(20+10*s, (int)(270-a), 20+10*s, 270);
									}
								}
							};
							area.setLayout(new BorderLayout());
							cc.add(area);
							area.setBounds(10, 70, 365, 285);
						}
						else
						{
							JOptionPane.showMessageDialog(PaintFunction.this, "B����Ϊ0~1(������0��1)֮�������");
							tt_b.setText("");
						}
					}
					catch(Exception e)
					{
						//�Ƿ�����
						JOptionPane.showMessageDialog(PaintFunction.this, "����Ƿ�!����������!");
						tt_b.setText("");
					}
				}
				else if(choose_s.isSelected())
				{
					try
					{					
						String ss=tt_s.getText();
						final int s=Integer.parseInt(ss);
						tt_s.setEditable(false);
						if(s>0)
						{	
							//����ͼ��
							area=new JPanel()
							{
								protected void paintComponent(Graphics g)
								{
									Actionhander use=new Actionhander();
									super.paintComponent(g);
									//��x��
									g.drawLine(20,270,20,20);
									g.drawString("a",325,280);
									//��y��
									g.drawLine(20,270,320,270);
									g.drawString("B",12,20);
									//������ͼ��
									for(double a=0.1;a<=30;a=a+0.1)
									{
										double B=use.B(s,a);
										g.drawString(".",(int) (20+10*a),(int)(270-250*B));
									}
								}
							};
							area.setLayout(new BorderLayout());
							cc.add(area);
							area.setBounds(10, 70, 365, 285);
						}
						else
						{
							JOptionPane.showMessageDialog(PaintFunction.this, "s����Ϊ�����������!");
							tt_s.setText("");
						}
					}
					catch(Exception e)
					{
						//�Ƿ�����
						JOptionPane.showMessageDialog(PaintFunction.this, "����Ƿ�!����������!");
						tt_s.setText("");
					}

				}
			}
		}

	}

}


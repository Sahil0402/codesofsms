import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class MyFrame extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l5,l6;
	JButton g;
	JTextField txt1,txt2;
	ImageIcon img1 = new ImageIcon("stones.png");
	ImageIcon img2 = new ImageIcon("scissor.png");
	ImageIcon img3 = new ImageIcon("paper.png");
	int Round=0;
	int pl1_p = 0;
	int pl2_p = 0;
	public MyFrame()
	{
		super("Rock.Paper.Scissor");
		l1 = new JLabel("There will be three rounds only");
		
		l2 = new JLabel("Player-1 points");
		l2.setBounds(70,40,90,20);
		this.add(l2);
		
		l2 = new JLabel("Player-2 points");
		l2.setBounds(230,40,90,20);
		this.add(l2);
		
		l3 = new JLabel("Player-1");
		l3.setFont(new Font("Verdana",Font.PLAIN,15));
		l3.setBounds(80,220,120,20);
		this.add(l3);

		l3 = new JLabel("Player-2");
		l3.setFont(new Font("Verdana",Font.PLAIN,15));
		l3.setBounds(240,220,120,20);
		this.add(l3);

		
		//For points
		txt1 = new JTextField(10);
		txt2 = new JTextField(10);
		txt1.setBounds(90,70,50,30);
		txt2.setBounds(250,70,50,30);

		l5 = new JLabel(img1);
		l6 = new JLabel(img2);
		
		g = new JButton("Play");
		g.setBounds(150,260,90,20);
		g.setFont(new Font("Verdana",Font.PLAIN,15));
		this.add(g);
		g.addActionListener(this);
		
		g = new JButton("Play again");
		g.setBounds(135,300,120,20);
		g.setFont(new Font("Verdana",Font.PLAIN,15));
		this.add(g);
		g.addActionListener(this);

		l1.setFont(new Font("Verdana",Font.PLAIN,15));
		l1.setBounds(70,10,1000,20);
		l5.setBounds(80,150,64,64);		//Stone    
		l6.setBounds(240,150,64,64);	//Scissor


		this.add(l1);
		this.add(l5);
		this.add(l6);
		this.add(txt1);
		this.add(txt2);

		g.setFocusPainted(false);

		this.setLayout(null);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		l5.setVisible(false);
		l6.setVisible(false);
		txt1.setText("0");
		txt2.setText("0");
		txt1.setEditable(false);
		txt2.setEditable(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Play"))
		{
			Round+=1;
			if(Round < 4)
			{
				Random r = new Random();
				int p1 = r.nextInt(3) + 1;
				int p2 = r.nextInt(3) + 1;

				if(p1==1 && p2 == 1)
				{ l5.setIcon(img1); l6.setIcon(img1); l5.setVisible(true); l6.setVisible(true);}
				else if(p1==1 && p2==2)
				{ l5.setIcon(img1); l6.setIcon(img2); l5.setVisible(true); l6.setVisible(true); pl1_p+=10; txt1.setText(String.valueOf(pl1_p));}
				else if(p1==1 && p2==3)
				{ l5.setIcon(img1); l6.setIcon(img3); l5.setVisible(true); l6.setVisible(true); pl2_p+=10; txt2.setText(String.valueOf(pl2_p));}
				else if(p1==2 && p2==1)
				{ l5.setIcon(img2); l6.setIcon(img1); l5.setVisible(true); l6.setVisible(true); pl2_p+=10; txt2.setText(String.valueOf(pl2_p));}
				else if(p1==2 && p2==2)
				{ l5.setIcon(img2); l6.setIcon(img2); l5.setVisible(true); l6.setVisible(true);}
				else if(p1==2 && p2==3)
				{ l5.setIcon(img2); l6.setIcon(img3); l5.setVisible(true); l6.setVisible(true); pl1_p+=10; txt1.setText(String.valueOf(pl1_p));}
				else if(p1==3 && p2==1)
				{ l5.setIcon(img3); l6.setIcon(img1); l5.setVisible(true); l6.setVisible(true); pl1_p+=10; txt1.setText(String.valueOf(pl1_p));}
				else if(p1==3 && p2==2)
				{ l5.setIcon(img3); l6.setIcon(img2); l5.setVisible(true); l6.setVisible(true); pl2_p+=10; txt2.setText(String.valueOf(pl2_p));}
				else if(p1==3 && p2==3)
				{ l5.setIcon(img3); l6.setIcon(img3); l5.setVisible(true); l6.setVisible(true); }
			}	
			else
			{

				if(txt1.getText() == " " && txt2.getText() == " ")
				{
					JOptionPane.showMessageDialog(this,"No wins");
				}
				else if(pl1_p > pl2_p)
				{
					JOptionPane.showMessageDialog(this,"Player-1 wins");
				}
				else if(pl1_p == pl2_p )
				{
					JOptionPane.showMessageDialog(this,"Draw");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Player-2 wins");
				}
			}
		}
		else if(e.getActionCommand().equals("Play again"))
		{
			Round = 0;
			pl1_p=0;
			pl2_p=0;
			txt1.setText("0");
			txt2.setText("0");
		}
	}	
}		 
public class RPS 
{
	public static void main(String args[])
	{
		new MyFrame();
	}
}
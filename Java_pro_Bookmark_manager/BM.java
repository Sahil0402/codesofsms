import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Vector;
public class BM
{
	public static void main(String[] args) 
	{
		new MYscreen();
		System.gc();
	}
}
class MYscreen extends JFrame
{
	/////////Colour COmbination

	 static Color dark  = new Color(46, 134, 222);//0, 148, 50 - Dark Green; 72, 52, 212 - dark blue
	 //dark colour of theme
	 static Color light = new Color(209,216,224);//163, 203, 56 - Light Green; 104, 109, 224
	 //Light colour of theme
	 static Color mid = new Color(6, 82, 221); //196, 229, 56 - more light green;162, 155, 254
	 //To change the colour of bookmarks when hover
	 static Color darker = new Color(6, 82, 221); //52, 31, 151 - darker blue; 46, 134, 222
	 //To make left side panel foreground darker when hover
	//////////200,214,229

	JPanel rightSidePanel=new JPanel(),titlePanel = new JPanel(),buttonPanel = new JPanel(); 
	
	/////////bookmarks
	Vector<MarkButton>bookmarks = new Vector<MarkButton>();


Desktop d1 = Desktop.getDesktop();

	String operation = "HOME";
	////////Left Side Panel
	JPanel leftSidePanel = new JPanel();
	int a=0,b=0,c=0,d=0;
	ImageIcon home = new ImageIcon("home.png");
	ImageIcon edit = new ImageIcon("edit.png");
	ImageIcon delete = new ImageIcon("delete.png");
	ImageIcon about = new ImageIcon("exit.png");

	JLabel con_1 = new JLabel("HOME",home,JLabel.CENTER);
	JLabel con_2 = new JLabel("EDIT",edit, JLabel.CENTER);
	JLabel con_3 = new JLabel("DELETE",delete,JLabel.CENTER);
	JLabel con_4 = new JLabel("EXIT",about,JLabel.CENTER);



	
	
	public MYscreen()
	{
		
		setSize(700, 725);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
/////////////////////////////////////////////
//TitlePanel
////////////////////////////////////////////

		////////////////

		titlePanel.setBackground(dark);
		titlePanel.setPreferredSize(new Dimension(525,75));
		buttonPanel.setBackground(light);
     

		//titlepanel containing Title Label
		Font t1 = new Font("Comic Sans MS",Font.BOLD,35);
		JLabel Title = new JLabel("HOME",JLabel.CENTER);
		Title.setFont(t1);
		titlePanel.setLayout(new BorderLayout());
		Title.setForeground(Color.WHITE);
		titlePanel.add(Title);

		///////////////Right SIDE panel
		add(rightSidePanel,BorderLayout.CENTER);

		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.add(buttonPanel,BorderLayout.CENTER);
		rightSidePanel.add(titlePanel,BorderLayout.NORTH);
		

		///////////////////
		//Button Panel
		 
		 try{
		 bookmarks = VectorFile.readVectorFile();
			}
			catch (Exception e){}
		
		
		buttonPanel.setLayout(null);//null
		 addButtonListeners();
		setButtons(bookmarks,buttonPanel);
		JButton addbookmark = new JButton();

		//addbookmark.setBounds(430,575,50,50);
		addbookmark.setBorderPainted(false);
		addbookmark.setFocusPainted(false);
		addbookmark.setContentAreaFilled(false);
		addbookmark.setIcon(new ImageIcon("addb.png"));
		addbookmark.setBounds(435,560,70,64);//445
		buttonPanel.add(addbookmark);
		addbookmark.addActionListener(e->
			{
				if(getBookmarksSize() == 30)
				{
					JOptionPane.showMessageDialog(null,"Bookmarks limit reached");
				}
				else 
				{	
					InputFrame input = new InputFrame()
					{
						@Override
						 public void okListener()
							{
								ok_button.addActionListener(ex->
									{
										try{
												//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
												UIManager.put("OptionPane.background",dark);
												UIManager.put("Panel.background",dark);
												UIManager.put("Button.background",darker);
												UIManager.put("Button.foreground",Color.WHITE);
												UIManager.put("Button.focus",new Color(0,0,0,0));

    										}catch(Exception ed){}
    										//String LINK = "https://"+getLink();
										if(getName().equals(""))
										 JOptionPane.showMessageDialog(this,"Please enter the name of bookmark");
										else if(!URLValidator.check(getLink()))
										 JOptionPane.showMessageDialog(this,"Invalid link");
										else {
											addButton(getName(),getLink());
											dispose();
											}
										
									});
							}
					};
							input.setLocationRelativeTo(this);
											
				}
			});////end of addButton actionListener
		
				 

		/////////////////

//////////////////////////////////////////////////
//LeftSidePanel
////////////////////////////////////

		{
				con_1.setOpaque(true);
				con_2.setOpaque(true);
				con_3.setOpaque(true);
				con_4.setOpaque(true);
		
				leftSidePanel.setBackground(dark);//128,0,128
				leftSidePanel.setPreferredSize(new Dimension(175,750));
		
				leftSidePanel.setLayout(null);
				// Font f1 = new Font("Verdana",Font.PLAIN,25);
				Font f1 = new Font("Comic Sans MS",Font.BOLD,30);
		        con_1.setFont(f1);
		        con_2.setFont(f1);
		        con_3.setFont(f1);
		        con_4.setFont(f1);
		       
				con_1.setBounds(0,200,175,40);
				con_1.setForeground(Color.WHITE);
				con_2.setBounds(0,300,175,40);
				con_2.setForeground(Color.WHITE);
				con_3.setBounds(0,400,175,40);
				con_3.setForeground(Color.WHITE);
				con_4.setBounds(0,500,175,40);
				con_4.setForeground(Color.WHITE);
		
				leftSidePanel.add(con_1);
				leftSidePanel.add(con_2);
				leftSidePanel.add(con_3);
				leftSidePanel.add(con_4);
				
				con_1.setBackground(dark);
				con_2.setBackground(dark);
				con_3.setBackground(dark);
				con_4.setBackground(dark);
		
				add(leftSidePanel,BorderLayout.WEST);		
			
				con_1.addMouseListener(new MouseAdapter()
				{		 
					public void mouseEntered(MouseEvent e)
					{
						
						con_1.setBackground(light);
						con_1.setForeground(darker);
							
					}
					public void mouseExited(MouseEvent e)
					{
						if(a!=1)
							{
						con_1.setForeground(Color.WHITE);
						con_1.setBackground(dark);
						}
					}
					public void mousePressed(MouseEvent e)
					{
						Title.setText("HOME");
						operation = "HOME";
						con_1.setBackground(light);
						con_1.setForeground(darker);
						setA();
						resetB();//b=0;
						resetC();//c=0;
						resetD();//d=0;
						con_2.setForeground(Color.WHITE);
						con_2.setBackground(dark);
						con_3.setForeground(Color.WHITE);
						con_3.setBackground(dark);
						con_4.setForeground(Color.WHITE);
						con_4.setBackground(dark);

					}
				});
					con_2.addMouseListener(new MouseAdapter()
					{
						
					public void mouseEntered(MouseEvent e)
					{
						con_2.setForeground(darker);
						con_2.setBackground(light);
		
					}
					public void mouseExited(MouseEvent e)
					{
						if(b!=1){
						con_2.setForeground(Color.WHITE);
						con_2.setBackground(dark);
							}
					}
					public void mousePressed(MouseEvent e)
					{
						Title.setText("EDIT");
						operation = "EDIT";
						con_2.setForeground(darker);
						con_2.setBackground(light);
						setB();
						resetA();//a=0;
						resetC();//c=0;
						resetD();//d=0;
						con_1.setForeground(Color.WHITE);
						con_1.setBackground(dark);
						con_3.setForeground(Color.WHITE);
						con_3.setBackground(dark);
						con_4.setForeground(Color.WHITE);
						con_4.setBackground(dark);
					}
		
				});
					con_3.addMouseListener(new MouseAdapter()
					{
						
					public void mouseEntered(MouseEvent e)
					{
						con_3.setForeground(darker);
						con_3.setBackground(light);
		
					}
					public void mouseExited(MouseEvent e)
					{
						if(c!=1){
						con_3.setForeground(Color.WHITE);
						con_3.setBackground(dark);
					}
		
					}
					public void mousePressed(MouseEvent e)
					{
						Title.setText("DELETE");
						operation = "DELETE";
						con_3.setForeground(darker);
						con_3.setBackground(light);
						setC();
						resetB();//b=0;
						resetA();//a=0;
						resetD();//d=0;
						con_2.setForeground(Color.WHITE);
						con_2.setBackground(dark);
						con_1.setForeground(Color.WHITE);
						con_1.setBackground(dark);
						con_4.setForeground(Color.WHITE);
						con_4.setBackground(dark);
					}
		
				});
					con_4.addMouseListener(new MouseAdapter()
					{
						
					public void mouseEntered(MouseEvent e)
					{
						con_4.setForeground(darker);
						con_4.setBackground(light);
		
					}
					public void mouseExited(MouseEvent e)
					{
						if(d!=1)
						{
							con_4.setForeground(Color.WHITE);
							con_4.setBackground(dark);
						}
		
					}
					public void mousePressed(MouseEvent e)
					{						
						if(confirmExit()==0)
						{
							dispose();
							System.exit(0);	
						}
					}
		
				});	
		
		}
		setVisible(true);
		// setVisible(false);
		// setVisible(true);

	}///EnD of constructor
	public int confirmExit()
	{

		try{
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("OptionPane.background",dark);
			UIManager.put("Panel.background",dark);
			UIManager.put("Button.background",darker);
			UIManager.put("Button.foreground",Color.WHITE);
			UIManager.put("Button.focus",new Color(0,0,0,0));
			
    			}catch(Exception ed){}
		int res = JOptionPane.showConfirmDialog(this,new JLabel("Are you sure, you want to exit?"),"Are You Sure?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		return res;
	}
	// public int getA(){return a;};
	// public int getB(){return a;};
	// public int getC(){return a;};
	// public int getD(){return a;};
	public void setA(){a=1;}
	public void setB(){b=1;}
	public void setC(){c=1;}
	public void setD(){d=1;}
	public void resetA(){a=0;}
	public void resetB(){b=0;}
	public void resetC(){c=0;}
	public void resetD(){d=0;}
	 public void addButton(String n,String l)
	{
		MarkButton b = new MarkButton(n,l);
		addListeners(b);
		b.setFont(new Font("Verdana", Font.BOLD, 20));
		b.setSize(155,50);
		b.setBackground(dark);/*new Color(173, 219, 176)*/
		b.setForeground(Color.WHITE);
		b.setBorderPainted(false);//74, 174, 255
		b.setFocusPainted(false);
		bookmarks.add(b);
		removeAllButtons();
		setButtons(bookmarks,buttonPanel);
		try{
			VectorFile.writeVectorFile(bookmarks);
			}
			catch(Exception x) {}		
	}

	public int getBookmarksSize()
	{return bookmarks.size();}
	public void addListeners(MarkButton b)
	{
		b.addActionListener(
				e->{
					if(operation.equalsIgnoreCase("HOME"))
								{
									
									try
									{
									d1.browse(new URI(b.getLink()));
									}
									catch (Exception ex){}
								}
					else if(operation.equalsIgnoreCase("EDIT"))
					{
						//EDIT
						
						for(int i=0;i<bookmarks.size();i++)
						{
							if(b.getText() == bookmarks.get(i).getText() && b.getLink() == bookmarks.get(i).getLink())
								{
									loc = i;
									System.out.println(b.getText());
								}
						}
						InputFrame edit = new InputFrame(b.getText(),b.getLink())
						{
							@Override
							public void okListener()
								{
									ok_button.addActionListener(e->
										{
											if(!getName().equals(""))
											b.setText(getName());
											if(!getLink().equals(""))
											b.setLink(getLink());
											bookmarks.setElementAt(b,getLoc());
											try{
											VectorFile.writeVectorFile(bookmarks);
												}catch(Exception ex){}
											dispose();
										});
								}
						};
						edit.setLocationRelativeTo(this);
						//operation = "HOME";


					}
					else if(operation.equalsIgnoreCase("DELETE"))
					{
						try{
												//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
												UIManager.put("OptionPane.background",dark);
												UIManager.put("Panel.background",dark);
												UIManager.put("Button.background",darker);
												UIManager.put("Button.foreground",Color.WHITE);
												UIManager.put("Button.focus",new Color(0,0,0,0));
												

    										}catch(Exception ed){}
						int res = JOptionPane.showConfirmDialog(this,new JLabel("Do you want to delete the button: "+b.getText()+" ?"),"Are You Sure?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(res == 0)
						removeButton(b);						
						//   operation = "HOME";
					}
				}		
				);
		b.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					b.setBackground(mid);
					//b.setForeground(darker);
				}
				public void mouseExited(MouseEvent me)
				{
					b.setBackground(dark);
					b.setForeground(Color.WHITE);
				}
			});
	}
	public int loc=0;
	public int getLoc()
	{return(loc);}
	public void addButtonListeners()
	{
		for(int i=0;i<bookmarks.size();i++)
		{
			addListeners(bookmarks.get(i));
		}

	}

	public void setButtons(Vector<MarkButton>bookmarks,JPanel buttonPanel)
	{
		
		//addButtonListeners();
		if(!bookmarks.isEmpty())
						{
							int x = 15,y = 10,c=1;
							for(MarkButton btn:bookmarks)
							
							{
								
								btn.setLocation(x,y);
								
								buttonPanel.add(btn);
								x+= 160 + 5;
								if(c==3)
								{
									x=15;
									y+= 50 + 5;
									c=0;
								}
								c++;
							}
						}
						setVisible(false);
						setVisible(true);
	}

public void removeButton(MarkButton btn)
{
	removeAllButtons();
	for(int i=0;i<bookmarks.size();i++)
	{
		if(btn.getText() == bookmarks.get(i).getText() && btn.getLink() == bookmarks.get(i).getLink())
			bookmarks.remove(i);
	}	
	try{
	VectorFile.writeVectorFile(bookmarks);
	}catch(Exception e){}
	setButtons(bookmarks,buttonPanel);

}
public void removeAllButtons()
{
	for(int i = 0;i<bookmarks.size();i++)
		{
			buttonPanel.remove(bookmarks.get(i));
		}
}
public void printList()
{
	System.out.println(bookmarks.size());
	for(MarkButton b:bookmarks)
		{
			System.out.print(b.getText()+"  ");
		}
}
}//////////////END OF CLASS
class InputFrame extends JFrame
{
	
	public String link="";
	public String name="";
	JButton ok_button =new JButton("Ok");
	JTextField name_field = new JTextField(), link_field = new JTextField();
	public InputFrame(String n,String l)
	{
		this();
		name_field.setText(n);
		link_field.setText(l);

	}
	public InputFrame()
	{
		setSize(350,200);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		
		setResizable(false);
		JPanel p = new JPanel();
		ImageIcon icon = new ImageIcon("book3.png");
        setIconImage (icon.getImage());
		p.setLayout(null);
		p.setBackground(MYscreen.dark);
		JLabel name_label=new JLabel("Name:"),link_label=new JLabel("Link:");
		JButton cancel_button = new JButton("Cancel");
		ok_button.setForeground(Color.WHITE);
		cancel_button.setForeground(Color.WHITE);
		ok_button.setBackground(MYscreen.darker);
		cancel_button.setBackground(MYscreen.darker);
		Font font = new Font("",Font.BOLD,18);
		name_label.setFont(font);
		link_label.setFont(font);
		name_label.setForeground(Color.WHITE);
		link_label.setForeground(Color.WHITE);
		name_label.setBounds(20,20,70,25);
		name_field.setBounds(100,20,200,25);
		link_label.setBounds(20,60,70,25);
		link_field.setBounds(100,60,200,25);
		ok_button.setBounds(125,130,75,25);
		cancel_button.setBounds(225,130,75,25);

		okListener();
		cancel_button.addActionListener(e->{dispose();});

		p.add(name_label);
		p.add(name_field);
		p.add(link_label);
		p.add(link_field);
		p.add(ok_button);		
		p.add(cancel_button);
		add(p);

		setVisible(true);
		setVisible(false);
		setVisible(true);

	}
	public String getLink(){return link_field.getText();}
	public String getName(){return name_field.getText();}
	public void okListener(){}
	
}
class MarkButton extends JButton
{
	MarkButton() {
		super();
	}
	MarkButton(String text,String url) {
		super(text);
		URL = url;
	}

	String URL;

	public void setLink(String s) {
		URL = s;
	}

	public String getLink() {
		return URL;
	}
}

class URLValidator
{
	public static boolean check(String url)  
	{
		try
		{
			new URL(url).toURI();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
}
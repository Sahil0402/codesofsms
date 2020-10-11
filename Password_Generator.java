import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class MyFrame extends JFrame implements ActionListener
{
	JTextField txt1;
	JButton btn1,btn2;
	JLabel lbl;
	public MyFrame()
	{
		//this.setLayout(new GridLayout(3,0));
		this.setLayout(null);
		ImageIcon icon = new ImageIcon("key.png");
		this.setIconImage(icon.getImage());
		
		txt1 = new JTextField(20);
		btn1 = new JButton("Generate Password");
		btn2 = new JButton("Copy to clipboard");
		lbl = new JLabel("Password");

		txt1.setFont(new Font("Verdana",Font.PLAIN,20));
		btn1.setFont(new Font("Verdana",Font.PLAIN,20));
		btn2.setFont(new Font("Verdana",Font.PLAIN,20));
		lbl.setFont(new Font("Verdana",Font.PLAIN,20));


		this.add(lbl);
		this.add(txt1);
		this.add(btn1);
		this.add(btn2);

		lbl.setBounds(10,10,250,30);
		txt1.setBounds(10,50,250,25);
		btn1.setBounds(10,100,250,25);
		btn2.setBounds(10,140,250,25);


		this.setVisible(true);
		this.setSize(300,230);	
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Generate Password")
		{  
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[10];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< 10 ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      String pass = new String(password);
	      txt1.setText(pass);
	  	}
	  	else if(e.getActionCommand() == "Copy to clipboard")
	  	{
	  		txt1.copy();
	  	}
	}
}			 
public class Password_Generator 
{
	public static void main(String args[])
	{
		new MyFrame();
	}
}
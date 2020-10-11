// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.text.*;
// import java.sql.*;
// import oracle.jdbc.driver.*;
// import javax.swing.event.*;

// class W extends JFrame implements ActionListener, KeyListener
// {
// 	JLabel l;
// 	JButton btn,dis,del,upd;
// 	JTextField tf1,tf2,tf3,tf4,tf5;
// 	Connection con;
// 	OracleDriver dr;
		
// 	public W()
// 	{
		
// 		super("Record Management System");
// 		this.setLayout(new GridLayout(7,2));
// 		this.getContentPane().setBackground(Color.LIGHT_GRAY);

// 		try
// 		{
// 			dr = new OracleDriver();
// 			DriverManager.registerDriver(dr);
// 			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");
// 		}
// 		catch(Exception ex){ System.out.println(ex.getMessage());}

// 		l = new JLabel("ID: ");
// 		this.add(l);
// 		l.setFont(new Font("Verdana",Font.PLAIN,18));
		
// 		tf1 = new JTextField(10);
// 		this.add(tf1);
// 		tf1.setFont(new Font("Verdana",Font.PLAIN,18));

// 		l = new JLabel("NAME: ");
// 		this.add(l);
// 		l.setFont(new Font("Verdana",Font.PLAIN,18));

// 		tf2 = new JTextField(10);
// 		this.add(tf2);
// 		tf2.setFont(new Font("Verdana",Font.PLAIN,18));

// 		l = new JLabel("DEPT: ");
// 		this.add(l);
// 		l.setFont(new Font("Verdana",Font.PLAIN,18));

// 		tf3 = new JTextField(10);
// 		this.add(tf3);
// 		tf3.setFont(new Font("Verdana",Font.PLAIN,18));

// 		l = new JLabel("AGE: ");
// 		this.add(l);
// 		l.setFont(new Font("Verdana",Font.PLAIN,18));

// 		tf5 = new JTextField(10);
// 		this.add(tf5);
// 		tf5.setFont(new Font("Verdana",Font.PLAIN,18));

// 		l = new JLabel("DOB(eg. 01-JAN-2020) :");
// 		this.add(l);
// 		l.setFont(new Font("Verdana",Font.PLAIN,18));

// 		tf4 = new JTextField(10);
// 		this.add(tf4);
// 		tf4.setFont(new Font("Verdana",Font.PLAIN,18));

// 		dis = new JButton("Display Records");
// 		this.add(dis);
// 		dis.addActionListener(this);
		
// 		btn = new JButton("Submit");
// 		this.add(btn);
// 		btn.addActionListener(this);

// 		del = new JButton("Delete");
// 		this.add(del);
// 		del.addActionListener(this);

// 		upd = new JButton("Update record");
// 		this.add(upd);
// 		upd.addActionListener(this);

// 		tf1.addKeyListener(this);
// 		tf2.addKeyListener(this);
// 		tf3.addKeyListener(this);
// 		tf5.addKeyListener(this);
 		
//  		btn.setFocusPainted(false);
// 		dis.setFocusPainted(false);
// 		del.setFocusPainted(false);
// 		upd.setFocusPainted(false);

//  		this.setVisible(true);
// 		this.setSize(500,250);
// 		this.setLocationRelativeTo(null);
		
				
// 	}
// 	public void actionPerformed(ActionEvent e)
// 	{
			
// 		if(e.getActionCommand().equals("Submit"))
// 		{
// 			String name = tf2.getText();
// 			String dept = tf3.getText();
// 			String dob = tf4.getText();
// 			int age = Integer.parseInt(tf5.getText());
// 			int id = Integer.parseInt(tf1.getText());
// 			try 
// 			{
// 				PreparedStatement st = con.prepareStatement("insert into data values(?,?,?,?,?)");
// 				st.setInt(1,id);
// 				st.setString(2,name);
// 				st.setString(3,dept);
// 				st.setString(4,dob);
// 				st.setInt(5,age);
// 				int n = st.executeUpdate();
// 				if(n!=0)
// 					JOptionPane.showMessageDialog(this,"Record inserted");
// 				else
// 					JOptionPane.showMessageDialog(this,"Fail in insertion");

// 			}
// 			catch(Exception ex1){ System.out.println(ex1.getMessage());}
// 		}
// 		else if(e.getActionCommand().equals("Display Records")) {
			
// 			System.out.println();
// 			System.out.println("ID"+"              "+"NAME"+"        "+" DEPARTMENT "+"     "+"AGE");
// 			System.out.println("------------------------------------------------------------------------");
// 			try
// 			{
// 				Statement s = con.createStatement();
// 				ResultSet rs = s.executeQuery("select * from data");
// 				while(rs.next())
// 				{
// 					// System.out.println(rs.getString(1)+"		"+rs.getString(2)+"				"+rs.getString(3));
// 					System.out.printf("%-16s%-10s%10s%12s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5));
// 				}
// 				System.out.println("------------------------------------------------------------------------");
// 				System.out.println();
// 			}
// 			catch(Exception ex2){ System.out.println(ex2.getMessage()); }
// 		}
// 		else if(e.getActionCommand().equals("Delete"))
// 		{
// 			String n = JOptionPane.showInputDialog(this,"Enter the record name u want to delete: ","Enter the name");
// 			int del_c = 0;
// 			try
// 			{
// 				PreparedStatement dls = con.prepareStatement("delete from data where name=?");
// 				dls.setString(1,n);
// 				del_c = dls.executeUpdate();
// 			}
// 			catch(Exception exc){System.out.println(exc.getMessage());}
			
// 			if (del_c!=0) {
// 				JOptionPane.showMessageDialog(this,"Record deleted");
// 			}
// 			else
// 			{
// 				JOptionPane.showMessageDialog(this,"Unable to delete");
// 			}
// 		}
// 		// else if(e.getActionCommand().equals("Update record"))
// 		// {
// 		// 	String up = JOptionPane.showInputDialog(this,"Enter the record name u want to update: ","Enter the name");
// 		// 	int up_c = 0;
// 		// 	try
// 		// 	{
// 		// 		PreparedStatement up_s = con.prepareStatement("update data set ");
// 		// 		up_s.setString(1,up);
// 		// 		int up_s =  
// 		// 	}
// 		// 	catch(Exception xc){System.out.println(xc.getMessage());}

// 		// 	if (up_c!=0) {
// 		// 		JOptionPane.showMessageDialog(this,"Record update");
// 		// 	}
// 		// 	else
// 		// 	{
// 		// 		JOptionPane.showMessageDialog(this,"Error in updation");
// 		// 	}
// 		// }
// 	}
// 	public void keyPressed(KeyEvent ke)
// 	{
// 		char tc = ke.getKeyChar();
// 		if (ke.getSource() == tf1) {
// 			if(Character.isDigit(tc) || Character.isWhitespace(tc) || Character.isISOControl(tc)){  tf1.setEditable(true); }
// 			else {tf1.setEditable(false);}
// 		}
// 		if (ke.getSource() == tf2) {
		
// 			if(Character.isLetter(tc) || Character.isWhitespace(tc) || Character.isISOControl(tc)){  tf2.setEditable(true); }
// 			else {tf2.setEditable(false);}
			
// 		}
// 		if (ke.getSource() == tf3) {
// 			if(Character.isLetter(tc) || Character.isWhitespace(tc) || Character.isISOControl(tc)){  tf3.setEditable(true); }
// 			else {tf3.setEditable(false);}
			
// 		}
// 		if(ke.getSource() == tf5)
// 		{
// 			if(Character.isDigit(tc) || Character.isWhitespace(tc) || Character.isISOControl(tc)){  tf5.setEditable(true); }
// 				else {tf5.setEditable(false);}
			
// 		}
		
// 	}
// 	public void keyTyped(KeyEvent ke){}
// 	public void keyReleased(KeyEvent ke){}
// }

// public class STU_MAN_SYS
// {
// 	public static void main(String[] args) {
		
// 		new W();

// 	}
// }
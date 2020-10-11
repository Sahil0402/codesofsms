import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.Vector;
import javax.swing.event.*;
public class STMS
{

	public static void main(String args[])

	{

		new Main_w();

	}

}

class InsertFrame extends JInternalFrame implements ActionListener

{

	JLabel l;

	JButton b[];

	JTextField txt[];

	Connection con;

	public InsertFrame()

	{

		super("Insert Data",false,true,false,false);

		this.setLayout(new GridLayout(5,2));

		

		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");

		}

		catch(Exception t){System.out.println(t.getMessage());}	

		String la[] = {"Enter the ID: ","Enter the name: ","Enter the age: ","Enter the Dept.: "}; 

		String bl[] = {"Insert","Clear"};

		b = new JButton[2];

		txt = new JTextField[4];

		for (int i=0;i<la.length;i++) {

			

			l = new JLabel(la[i]);	

			this.add(l);

			l.setFont(new Font("Verdana",Font.PLAIN,20));

			txt[i] = new JTextField();

			txt[i].setFont(new Font("Verdana",Font.PLAIN,20));

			this.add(txt[i]);

		}



		for (int i=0;i<bl.length;i++ ) {



			b[i] = new JButton(bl[i]);

			this.add(b[i]);

			b[i].setFont(new Font("Verdana",Font.PLAIN,20));

			b[i].addActionListener(this);

		}

		//250,200,500,250

		this.setBounds(50,200,950,250);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)

	{

		Object obj = ae.getSource();

		if(obj==b[0])

		{

			int id = Integer.parseInt(txt[0].getText());

			String n = txt[1].getText();

			int a = Integer.parseInt(txt[2].getText());

			String d = txt[3].getText();

			try

			{

				PreparedStatement st = con.prepareStatement("insert into data values(?,?,?,?)");

				st.setInt(1,id);

				st.setString(2,n);

				st.setInt(3,a);

				st.setString(4,d);

				int u = st.executeUpdate();

				if(u!=0)

					JOptionPane.showMessageDialog(this,"Record inserted!!!");

				else

					JOptionPane.showMessageDialog(this,"Error in insertion");

			}

			catch(Exception ex){System.out.println(ex.getMessage());}

		}

		else if (obj == b[1]) 

		{

			txt[0].setText("");

			txt[1].setText("");

			txt[2].setText("");

			txt[3].setText("");



		}

	}

}

class SUDFrame extends JInternalFrame implements KeyListener, ActionListener, ListSelectionListener

{

	JSplitPane jsp;

	JPanel p1,p2;

	JLabel l1;

	JTextField txt[],search;

	JButton btn[];

	JList list;

	JScrollPane l_S;

	Vector <String> v = new Vector <String>();

	Connection con;

	public SUDFrame()

	{



		super("STMS",false,true,false,false);

		connect();

		//Panel1

		p1 = new JPanel();

		p1.setLayout(null);



		l1 = new JLabel("Search for an student:");

		l1.setBounds(10,30,300,20);

		l1.setFont(new Font("Verdana",Font.ITALIC,15));

		p1.add(l1);



		search = new JTextField(15);

		p1.add(search);

		search.setBounds(10,60,300,25);

		search.setFont(new Font("Verdana",Font.ITALIC,16));

		search.setBorder(BorderFactory.createRaisedBevelBorder());

		search.addKeyListener(this);



		list = new JList(v);

		l_S = new JScrollPane(list);

		l_S.setBounds(10,100,300,250);

		list.setFont(new Font("Verdana",Font.ITALIC,16));

		list.addListSelectionListener(this);

		l_S.setBorder(BorderFactory.createRaisedBevelBorder());

		p1.add(l_S);

		getTableData();



		//Panel2

		p2 = new JPanel();

		p2.setLayout(new GridLayout(5,2));

		String la[] = {"Enter the ID: ","Enter the name: ","Enter the age: ","Enter the Dept.: "}; 

		String bl[] = {"Update","Delete"};

		txt = new JTextField[4];

		btn = new JButton[2];

		for (int i=0;i<la.length;i++) {

			

			l1 = new JLabel(la[i]);

			p2.add(l1);

			l1.setFont(new Font("Verdana",Font.PLAIN,19));

			txt[i] = new JTextField();

			txt[i].setFont(new Font("Verdana",Font.PLAIN,19));

			p2.add(txt[i]);



		}

		for (int i=0;i<bl.length;i++) {



			btn[i] = new JButton(bl[i]);

			p2.add(btn[i]);

			btn[i].addActionListener(this);

			btn[i].setBorder(BorderFactory.createRaisedBevelBorder());

			btn[i].setFocusPainted(false);

			btn[i].setFont(new Font("Verdana",Font.PLAIN,19));

		}





		jsp = new JSplitPane(SwingConstants.VERTICAL,p1,p2);

		this.add(jsp);

		jsp.setDividerLocation(375);

		this.setVisible(true);

		this.setBounds(50,150,950,400);

	}

	public void connect()

	{

		try

		{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");

		}

		catch(Exception lol){System.out.println(lol.getMessage());}	

	}

	public void getTableData()

	{

		try 

		{

			PreparedStatement st = con.prepareStatement("select name from data");

			ResultSet rs = st.executeQuery();

			while(rs.next())

			{

				String name = rs.getString(1);

				v.add(name);

			}

			list.setListData(v);

		}

		catch(Exception se){System.out.println(se.getMessage());}

	}

	public void valueChanged(ListSelectionEvent lse)

	{

		String se_name = (String)list.getSelectedValue();



		try

		{

			PreparedStatement st = con.prepareStatement("select * from data where name=?");

			st.setString(1,se_name); 

			ResultSet rs = st.executeQuery();

			while(rs.next())

			{

				int i = rs.getInt(1);

				String n = rs.getString(2);

				int a = rs.getInt(3);

				String s = rs.getString(4);



				txt[0].setText(i+"");

				txt[1].setText(n);

				txt[2].setText(a+"");

				txt[3].setText(s);

			}



		}

		catch(Exception axe){System.out.println(axe.getMessage());}

	}

	public void actionPerformed(ActionEvent ee)

	{

		Object obj = ee.getSource();

		String n = (String)list.getSelectedValue();



		int no = Integer.parseInt(txt[0].getText());

		String sn = txt[1].getText();

		int sa = Integer.parseInt(txt[2].getText());

		String sd = txt[3].getText();

		if(obj==btn[0])

		{

			try 

			{

				PreparedStatement st = con.prepareStatement("update data set id=?, name=?, age=?, dept=? where name=?");



				st.setString(5,n);

				st.setInt(1,no);

				st.setString(2,sn);

				st.setInt(3,sa);

				st.setString(4,sd);



				int t = st.executeUpdate();



				if(t!=0)

				{

					v.clear();

					getTableData();

					JOptionPane.showMessageDialog(this,"Record updated");

				}

				else

				{

					JOptionPane.showMessageDialog(this,"Error in Updating record.");

				}

			}

			catch(Exception on){System.out.println(on.getMessage());}

		}

		else if(obj==btn[1])

		{

			String na = (String)list.getSelectedValue();



			try

			{

				PreparedStatement st = con.prepareStatement("delete from data where name=?");

				st.setString(1,na);

				int t = st.executeUpdate();

				if(t!=0)

				{

					v.clear();

					getTableData();

					JOptionPane.showMessageDialog(this,"Record deleted");

					txt[0].setText("");

					txt[1].setText("");

					txt[2].setText("");

					txt[3].setText("");

				}

				else

				{

					JOptionPane.showMessageDialog(this,"Error in delettion");

				}

			}

			catch(Exception er){System.out.println(er.getMessage());}

		}

	}

	public void keyPressed(KeyEvent ke)

	{

		char ch = ke.getKeyChar();

		if(ke.getSource() == search)

		{

			if(Character.isLetter(ch) || Character.isWhitespace(ch) || Character.isISOControl(ch))

			{  

				search.setEditable(true); 

				try

				{

					PreparedStatement st = con.prepareStatement("select name from data where name like '"+search.getText()+"%'");

					ResultSet rs = st.executeQuery();

					Vector <String> v = new Vector <String>();

					while(rs.next())

					{

						String name = rs.getString(1);

						v.add(name);

					}

					list.setListData(v);

				}

				catch(Exception la)

				{System.out.println(la.getMessage());}

			

			}

			else {search.setEditable(false);}

		}

	}

	public void keyTyped(KeyEvent ke){}

	public void keyReleased(KeyEvent ke){}

}

class DisplayFrame extends JInternalFrame

{

	JTable table;

	JTableHeader head;

	Vector <String> cols;

	Vector <Vector> rows;

	Connection con;

	public DisplayFrame()

	{

		super("All Students Record",false,true,false,false);		



		try

		{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");

		}

		catch(Exception dl){System.out.println(dl.getMessage());}



		cols = new Vector <String>();

		cols.add("Student Id");

		cols.add("Student name");

		cols.add("Student age");

		cols.add("Student dept");



		rows = new Vector <Vector>();



		table = new JTable(rows,cols);

		JScrollPane jscroll = JTable.createScrollPaneForTable(table);

		head = table.getTableHeader();

		head.setBackground(Color.GRAY);

		head.setForeground(Color.WHITE);

		head.setFont(new Font("Verdana",Font.PLAIN,19));

		table.setFont(new Font("Verdana",Font.PLAIN,19));

		table.setShowGrid(true);

		table.setGridColor(Color.BLACK);

		table.setRowHeight(30);

		this.add(jscroll,BorderLayout.CENTER);



		try

		{

			PreparedStatement st = con.prepareStatement("select * from data");

			ResultSet rs = st.executeQuery();

			while(rs.next())

			{

				int v1 = rs.getInt("id");

				String v2 = rs.getString("name");

				int v3 = rs.getInt("age");

				String v4 = rs.getString("dept");



				Vector <String> s  = new Vector <String>();



				s.add(v1+"");

				s.add(v2);

				s.add(v3+"");

				s.add(v4);



				rows.add(s);

			}

			rs.close();

			st.close();

			con.close();

		}	

		catch(Exception de){System.out.println(de.getMessage());}



		this.setVisible(true);

		this.setBounds(50,200,950,250);

	}

}

class Main_w extends JFrame implements ActionListener

{

	JDesktopPane dpane;

	JSplitPane split;

	JPanel p1,p2;

	JButton btn[];

	InsertFrame f1;

	DisplayFrame f3;

	JLabel t[];

	SUDFrame f2;

	CardLayout crd = new CardLayout();

	public Main_w()

	{

		super("Student Managment System");	

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p1 = new JPanel();

		// p1.setPreferredSize(new Dimension(280,200));

		p1.setBackground(Color.LIGHT_GRAY);

		p1.setLayout(null);

		

		t = new JLabel[3];

		t[0] = new JLabel("Goverment");

		t[0].setBounds(0,0,200,200);

		t[0].setFont(new Font("Consolas",Font.BOLD,20));

		t[0].setForeground(Color.WHITE);

		p1.add(t[0]);





		t[1] = new JLabel("Polytechnic");

		t[1].setBounds(30,15,200,200);

		t[1].setFont(new Font("Consolas",Font.BOLD,20));

		t[1].setForeground(Color.WHITE);

		p1.add(t[1]);

		



		t[2] = new JLabel("Amravati");

		t[2].setBounds(0,30,200,200);

		t[2].setForeground(Color.WHITE);

		p1.add(t[2]);

		t[2].setFont(new Font("Consolas",Font.BOLD,20));





		btn = new JButton[3];

		int x=0;

		int y=0;

		String l[] = {"Insert","Search Update Delete","Display All Records"};

		for (int i=0;i<btn.length;i++) {

			

			btn[i] = new JButton(l[i]);

			p1.add(btn[i]);

			

			btn[i].setBounds(10,y+=150,280,30);

			btn[i].setFocusPainted(false);

			btn[i].setFont(new Font("Verdana",Font.PLAIN,20));

			btn[i].addActionListener(this);

			btn[i].setBorder(BorderFactory.createRaisedBevelBorder());

		}



		dpane = new JDesktopPane();

		dpane.setLayout(crd);

		

		f1 = new InsertFrame();

		

		dpane.add(f1,"Insert");





		f2 = new SUDFrame();

		

		dpane.add(f2,"SUD");





		f3 = new DisplayFrame();

		

		dpane.add(f3,"Display");



		

	 	crd.first(dpane);

		

		split = new JSplitPane(SwingConstants.VERTICAL,p1,dpane);

		split.setDividerLocation(305);

		this.add(split);



		this.setVisible(true);



	}

	int var = 0;

	public void actionPerformed(ActionEvent thak)

	{

		Object obj = thak.getSource();

		if(obj == btn[0])

	 	{

	 		crd.show(dpane, "Insert");

	 	}

	 	else if (obj==btn[1]) 

	 	{		

	 		crd.show(dpane, "SUD");

	 	}

	 	else if (obj==btn[2]) 

	 	{

	 		crd.show(dpane, "Display");

	 	}

	}

}
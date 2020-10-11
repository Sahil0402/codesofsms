import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*; 
import oracle.jdbc.driver.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.event.*;

class Frame1 extends JInternalFrame implements ActionListener
{
	JTextField f[];
	JButton btn;
	JLabel l; 
	Connection con;
	OracleDriver dr;
	
	public Frame1()
	{

		super("Employee",false,true,false,false);
		
		try
		{
			dr = new OracleDriver();
			DriverManager.registerDriver(dr);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");
		}
		catch(Exception ex){System.out.println(ex.getMessage());}

		this.setLayout(new GridLayout(6,2));
		String labels[] = {"Employee ID: ","Employee name: ","Job: ","Salary: "};
		f = new JTextField[4];
		for (int i=0;i<4;i++ ) {
			
			l = new JLabel(labels[i]);
			l.setFont(new Font("Verdana",Font.PLAIN,19));
			this.add(l);

			f[i] = new JTextField();
			f[i].setFont(new Font("Verdana",Font.PLAIN,19));
			this.add(f[i]);

		}
		btn = new JButton("Insert data");
		this.add(btn);
		btn.setFont(new Font("Verdana",Font.PLAIN,19));
		btn.addActionListener(this);

		btn = new JButton("Clear");
		this.add(btn);
		btn.setFont(new Font("Verdana",Font.PLAIN,19));
		btn.addActionListener(this);

		l = new JLabel("");
		this.add(l);

		this.setVisible(true);
		this.setBounds(10,10,350,200);

	}
	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getActionCommand().equals("Insert data"))
		{
			int id = Integer.parseInt(f[0].getText());
			String name = f[1].getText();
			String job = f[2].getText();
			double s = Double.parseDouble(f[3].getText());	

			try
			{
				PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?)");
				st.setInt(1,id);
				st.setString(2,name);
				st.setString(3,job);
				st.setDouble(4,s);
				int a_r = st.executeUpdate();
				if(a_r!=0)
					l.setText("Record inserted");
				else
					l.setText("Fail in insertion");
			}
			catch(Exception er){System.out.println(er.getMessage());}

		}
		else if(ae.getActionCommand().equals("Clear"))
		{
			f[0].setText("");
			f[1].setText("");
			f[2].setText("");
			f[3].setText("");
			l.setText("");
		}

	}
}
class Frame2 extends JInternalFrame implements KeyListener,ListSelectionListener,ActionListener
{
	JSplitPane jsp;
	JPanel p1,p2;
	JList list;
	JLabel l1;
	JLabel arr[];
	JTextField txt[];
	Vector <String> v = new Vector <String>();
	JTextField search;
	JScrollPane jpane;
	JButton b[];
	OracleDriver dr;
	Connection con;
	public Frame2()
	{
		super("Search Update Delete",false,true,false,false);
		//Panel1
		p1 = new JPanel();
		p1.setLayout(null);

		l1 = new JLabel("Search for a Record: ");
		l1.setFont(new Font("Verdana",Font.BOLD,15));
		l1.setBounds(10,10,180,20);
		p1.add(l1);

		search = new JTextField();
		search.setBounds(10,30,180,22);
		search.setFont(new Font("Verdana",Font.PLAIN,19));
		search.addKeyListener(this);
		list = new JList(v);
		list.setFont(new Font("Verdana",Font.PLAIN,19));
		list.addListSelectionListener(this);
		getTableData();

		jpane = new JScrollPane(list);
		jpane.setBounds(10,60,180,200);
		p1.add(jpane);
		p1.add(search);

		//Panel2
		p2 = new JPanel();
		p2.setLayout(new GridLayout(6,2));
		arr= new JLabel[4];
		txt = new JTextField[4];

		String labels[] = {"ID","ENAME","JOB","SALARY"};
		for (int i=0;i<arr.length;i++) {
			arr[i] = new JLabel(labels[i]);
			arr[i].setFont(new Font("Verdana",Font.PLAIN,19));
			txt[i] = new JTextField();
			txt[i].setFont(new Font("Verdana",Font.PLAIN,19));
			p2.add(arr[i]);
			p2.add(txt[i]);
		}

		String b_l[] = {"Update","Delete"};
		b = new JButton[2];
		for (int i=0;i<b.length;i++) {
			b[i] = new JButton(b_l[i]);
			b[i].setFont(new Font("Verdana",Font.PLAIN,19));
			b[i].addActionListener(this);
			b[i].setFocusPainted(false);
			b[i].setBorderPainted(false);
			p2.add(b[i]);
		}


		jsp = new JSplitPane(SwingConstants.VERTICAL,p1,p2);
		jsp.setDividerLocation(200);
		this.add(jsp);
		

		this.setSize(200,200);
		this.setBounds(370,10,530,300);
		this.setVisible(true);
	}
	public void getTableData()
	{
		try
		{	
			connect();
			PreparedStatement st = con.prepareStatement("select ename from employee");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				v.add(name);
			}
			list.setListData(v);
		}
		catch(Exception la){System.out.println(la.getMessage());}
	}
	public void connect()
	{
		try
		{
			dr = new OracleDriver();
			DriverManager.registerDriver(dr);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
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
					PreparedStatement st = con.prepareStatement("select ename from employee where ename like '"+search.getText()+"%'");
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
	public void valueChanged(ListSelectionEvent ls)
	{
		connect();
		txt[0].setEditable(false);
		txt[1].setEditable(false);
		txt[2].setEditable(false);
		txt[3].setEditable(false);
		String f = (String)list.getSelectedValue();
		try 
		{
			PreparedStatement st = con.prepareStatement("select * from employee where ename=?");
			st.setString(1,f);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				int i = rs.getInt(1);
				String n = rs.getString(2);
				String j = rs.getString(3);
				double s = rs.getDouble(4);

				txt[0].setText(i+"");
				txt[1].setText(n);
				txt[2].setText(j);
				txt[3].setText(s+"");
				txt[0].setEditable(true);	txt[1].setEditable(true);	txt[2].setEditable(true);	txt[3].setEditable(true);
			}

		}
		catch(Exception mm){System.out.println(mm.getMessage());}

	}
	public void actionPerformed(ActionEvent lol)
	{
		Object obj = lol.getSource();
		connect();
		if(obj==b[0])
		{
			int eno = Integer.parseInt(txt[0].getText());
			String en = txt[1].getText();
			String jo = txt[2].getText();
			double s = Double.parseDouble(txt[3].getText());
			try
			{
				PreparedStatement st = con.prepareStatement("update employee set id=?,ename=?,job=?,sal=? where id=?");
				st.setInt(1,eno);
				st.setString(2,en);
				st.setString(3,jo);
				st.setDouble(4,s);
				st.setInt(5,eno);
				int n = st.executeUpdate();
				if(n!=0)
				{
					v.clear();
					getTableData();
					JOptionPane.showMessageDialog(this,"Record updated");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error in updation");
				}
			}
			catch(Exception mc){System.out.println(mc.getMessage());}
			
		}
		else if(obj==b[1])
		{
			int o = Integer.parseInt(txt[0].getText());
			try
			{
				PreparedStatement st = con.prepareStatement("delete from employee where id=?");
				st.setInt(1,o);
				int n = st.executeUpdate();
				txt[0].setText("");
				txt[1].setText("");
				txt[2].setText("");
				txt[3].setText("");
				if(n!=0)
				{
					v.clear();
					getTableData();
					JOptionPane.showMessageDialog(this,"Record deleted");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error in deletion");
				}
			}
			catch(Exception oye){System.out.println(oye.getMessage());}
		}
	}
	public void keyTyped(KeyEvent ke){}
	public void keyReleased(KeyEvent ke){}


}
class Frame3 extends JInternalFrame 
{
	OracleDriver dr;
	Connection con;
	JTable table;
	Vector <Vector> rows;
	Vector <String> cols;


	public Frame3()
	{


		super("All Employees",false,true,false,false);
		
		try
		{
			dr = new OracleDriver();
			DriverManager.registerDriver(dr);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Sahil1234");
		}
		catch(Exception ex){System.out.println(ex.getMessage());}


		cols = new Vector <String>();
		cols.add("Employee no.");
		cols.add("Employee name");
		cols.add("Employee job");
		cols.add("Employee salary");

		rows = new Vector <Vector>();

		table = new JTable(rows,cols);
		JScrollPane jsp = JTable.createScrollPaneForTable(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.GRAY);
		head.setForeground(Color.WHITE);
		head.setFont(new Font("Verdana",Font.PLAIN,19));
		table.setFont(new Font("Verdana",Font.PLAIN,19));
		this.add(jsp,BorderLayout.CENTER);

		try
		{
			PreparedStatement st = con.prepareStatement("select * from employee");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				
				int id = rs.getInt("id");
				String name = rs.getString("ename");
				String j = rs.getString("job");
				double s = rs.getDouble("sal");

				Vector <String> sr = new Vector <String>();
				
				sr.add(id+"");
				sr.add(name);
				sr.add(j);
				sr.add(s+"");

				rows.add(sr);

			}
				rs.close();
				st.close();
				con.close();	
		}
		catch(Exception ee){System.out.println(ee.getMessage());}

		this.setBounds(20,320,850,200);
		this.setVisible(true);

	}
		

} 
class MyFrame extends JFrame implements ActionListener
{

	JDesktopPane dpane;
	JToolBar toolb;
	JButton b;
	Frame1 f1;
	Frame2 f2;
	Frame3 f3;
	JTable l;
	JMenuBar bar;
	JMenu Themes;
	JMenuItem t1,t2,t3;
	public MyFrame()
	{


		super("Employee Management System");
		this.setUndecorated(true);
		
		bar = new JMenuBar();
		this.setJMenuBar(bar);

		Themes = new JMenu("Options");
		bar.add(Themes);

		t1 = new JMenuItem("Exit");
		t1.setFont(new Font("Verdana",Font.PLAIN,16));
		t1.addActionListener(this);
		Themes.add(t1);

		toolb = new JToolBar(JToolBar.HORIZONTAL);
		toolb.setLayout(new GridLayout(1,4));
		toolb.setFloatable(false);
		
		String str[] = {"Insert new Record","Search Update Delete","Display all data"};
		for (int i=0;i<str.length;i++ ) {
			
			b = new JButton(str[i]);
			b.setFont(new Font("Verdana",Font.PLAIN,19));
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			if(i==1 && i==2)
				toolb.addSeparator();
			b.addActionListener(this);
			toolb.add(b);			
		}
		this.add(toolb,BorderLayout.NORTH);

		dpane = new JDesktopPane();
		this.add(dpane);
		dpane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		
		this.setVisible(true);	
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e)
	{
		byte cnt=0;
		String c = e.getActionCommand();
		if(c.equals("Insert new Record"))
		{	
			int k=0;	
			JInternalFrame arr[] = dpane.getAllFrames();
			dpane.setBackground(Color.LIGHT_GRAY);
			for (int i=0;i<arr.length;i++) {
				if (f1==arr[i]) {
					k++;
					break;
				}
			}
			
			if(k==0)			//for start check here as there are no JInternalFrames the value of k=0 and f1=null;
					f1=null;

			if(f1 == null)
			{
				f1 = new Frame1();
			 	dpane.add(f1);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"This frame is already open.","Warning",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(c.equals("Search Update Delete"))
		{
			int k=0;
			JInternalFrame arr[] = dpane.getAllFrames();
			for (int i=0;i<arr.length;i++) {
				if(f2==arr[i])
				{
					k++;
					break;
				}
			}
			if(k==0)
				f2=null;

			if(f2==null)
			{
				f2 = new Frame2();
			 	dpane.add(f2);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"This frame is already open.","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(c.equals("Display all data"))
		{
			int k=0;	
			JInternalFrame arr[] = dpane.getAllFrames();

			for (int i=0;i<arr.length;i++) {
				if (f3==arr[i]) {
					k++;
					break;
				}
			}
			
			if(k==0)			//for start check here as there are no JInternalFrames the value of k=0 and f1=null;
					f3=null;

			if(f3 == null)
			{
				f3 = new Frame3();
			 	dpane.add(f3);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"This frame is already open.","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (c.equals("Exit")) {
			this.dispose();
		}
	}
}			  
public class EMP_MAN_SYS
{
	public static void main(String[] args) {
		new MyFrame();
	}
}
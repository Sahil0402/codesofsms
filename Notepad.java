import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
class MyFrame extends JFrame implements ActionListener
{
	JMenuBar jbar;
	JMenu file,edit;
	JMenuItem item;
	JTextArea ta;
	JScrollPane jsp;
	JFileChooser jfc;
	public MyFrame()
	{
		
		jbar = new JMenuBar();
		this.setJMenuBar(jbar);
		//Menu's
		file = new JMenu("File");
		edit = new JMenu("Edit");
		jbar.add(file);
		jbar.add(edit);
		file.setFont(new Font("Times New Roman",Font.PLAIN,18));
		edit.setFont(new Font("Times New Roman",Font.PLAIN,18));
		//Items of Menu	
		String items[] = {"New","Save","Open","Exit"};
		for(int i=0;i<items.length;i++)
		{
			item = new JMenuItem(items[i]);
			if(i == 3)
				file.addSeparator();
			file.add(item);
			item.addActionListener(this);
			item.setFont(new Font("Verdana",Font.PLAIN,15));
			
		}	
		String list_edit[] = {"Cut","Copy","Paste"};
		for(int i=0;i<list_edit.length;i++)
		{
			item = new JMenuItem(list_edit[i]);
			edit.add(item);
			if(i<=1)
			edit.addSeparator();
			item.addActionListener(this);
			item.setFont(new Font("Lucida Console",Font.PLAIN,15));
			
		}	
		ta = new JTextArea();
		jsp = new JScrollPane(ta);
		this.add(jsp,BorderLayout.CENTER);
		ta.setFont(new Font("Lucida Console",Font.PLAIN,25));

		jfc = new JFileChooser("C:\\Users\\lenovo\\Desktop\\JAVA(AJP Programs)");
		
		String file_d[] = {"C files","Cpp files","Java files","Python files"};
		String file_e[] = {"c","cpp","java","py"};

		for(int i=0;i<file_e.length;i++){
			FileNameExtensionFilter filter = new FileNameExtensionFilter(file_d[i],file_e[i]);
			jfc.setFileFilter(filter);
		}

		this.setVisible(true);
		this.setSize(800,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
	public void actionPerformed(ActionEvent e)
	{
		String caption = e.getActionCommand();
		if(caption.equals("New")){ ta.setText("");}
		else if (caption.equals("Save")) 
		{ 
			try
			{
				int res = jfc.showSaveDialog(this);
				if(res == JFileChooser.APPROVE_OPTION)
				{
					String data = ta.getText();			
					byte arr[] = data.getBytes();
					File f = jfc.getSelectedFile();
					FileOutputStream fout = new FileOutputStream(f);
					fout.write(arr);
					fout.close();
					JOptionPane.showMessageDialog(this,"File Saved");				
				} 
			}
			catch(Exception ex)
			{ex.printStackTrace();}
			
		}
		else if (caption.equals("Open")) 
		{ 
			try
			{
				int res = jfc.showSaveDialog(this);
				if(res == JFileChooser.APPROVE_OPTION)
				{
					File fr = jfc.getSelectedFile();
					FileInputStream fin = new FileInputStream(fr);
					byte arr[] = new byte[fin.available()];
					fin.read(arr);
					fin.close();
					String file_data = new String(arr);
					ta.setText(file_data); 

				}
			}
			catch(Exception ex)
			{ex.printStackTrace();}
		}
		
		else if (caption.equals("Exit")) {	this.dispose();}
		else if (caption.equals("Cut"))  {	ta.cut();}
		else if (caption.equals("Copy")) {	ta.copy();}
		else if (caption.equals("Paste")) {	ta.paste();}

	}
}
public class Notepad
{
	public static void main(String[] args) {
		new MyFrame();
	}
}
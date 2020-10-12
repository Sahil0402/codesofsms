import java.io.*;
import java.util.Vector;

class VectorFile
{
	public static Vector readVectorFile() throws Exception
	{
		Vector v = new Vector();
		File list = new File("MyList.txt");
		if(list.exists())
		{
			FileInputStream fin = new FileInputStream(list);
			ObjectInputStream streamIn = new ObjectInputStream(fin);
			////
			v = (Vector)streamIn.readObject();
			////
			fin.close();
			streamIn.close();
		}
		return(v);
	}
	public static void writeVectorFile(Vector v) throws Exception
	{
		File list = new File("MyList.txt");
		if(!list.exists())
				list.createNewFile();
		
			FileOutputStream fout = new FileOutputStream(list);
			ObjectOutputStream streamOut = new ObjectOutputStream(fout);
			////
			streamOut.writeObject(v);
			////
			fout.close();
			streamOut.close();
		
	}
}
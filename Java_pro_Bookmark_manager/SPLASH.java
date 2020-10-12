import javax.swing.*;
import java.awt.*;

public class SPLASH
{
    public static void main(String[] args) {
        new mysplash();
    }
}
class mysplash
{
    JFrame frame = new JFrame();
    Color back = new Color(69, 170, 242);
    public mysplash()
    {
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Container c = frame.getContentPane();
        c.setBackground(back);

        // IMAGE
        ImageIcon icon = new ImageIcon("book3.png");
        frame.setIconImage (icon.getImage());

        ImageIcon ic = new ImageIcon("book.png");
        JLabel label = new JLabel(" ",ic,JLabel.CENTER);
        frame.add(label);
        label.setBounds(230,50,ic.getIconWidth(),ic.getIconHeight());
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.WHITE));//new Color(6, 82, 221)

        //TITLE
        JLabel title = new JLabel("BOOKMARK   MANAGER",JLabel.CENTER);
        Font f = new Font("Verdana",Font.BOLD,40);
        title.setFont(f);
        frame.add(title);
        title.setBounds(0,130,600,200);
        title.setForeground(Color.BLACK);





        JProgressBar Bar    = new JProgressBar(0,100);
        Bar.setBackground(back);
        Bar.setForeground(Color.BLACK);
        Bar.setBorderPainted(false);
        Bar.setBounds(0,260,600,5);
        frame.add(Bar);
        int i = 0;

        //PROGRESSBAR THREAD
        while(i<=100)
        {
            Bar.setValue(i);

            try
            {
                Thread.sleep(9);
                i++;
            }
            catch(Exception ex){}
        }


        new MYscreen();
        frame.dispose();


    }
}
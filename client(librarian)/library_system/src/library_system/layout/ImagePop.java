package library_system.layout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import API.load_Image;
public class ImagePop extends JFrame {
	 
	 JLabel imgLabel = new JLabel();
	 
	 public ImagePop(int bookid) {
		 load_Image li = new load_Image(bookid,300);
		 ImageIcon image = li.getXyimg();
		 imgLabel.setIcon(image);
		 imgLabel.setHorizontalAlignment(JLabel.CENTER);
		 getContentPane().add(imgLabel);
		 
		 setSize(350, 550);
		 setLocationRelativeTo(null);
		 setVisible(true);
	 }
	
}

package API;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

import org.json.simple.JSONObject;

public class load_Image {
	ImageIcon xyimg;
	
	public load_Image(int BookId,int widthSize){
		Call_API api = new Call_API();
		JSONObject obj;
		try {
			obj = api.GET("/book/"+ Integer.toString(BookId));
			JSONObject data = (JSONObject) obj.get("data");
			String url = (String)data.get("imageURL");
			URL imgURL = new URL(url);
			
			ImageIcon icon = new ImageIcon(imgURL);
		    Image ximg = icon.getImage();
		    Image yimg = ximg.getScaledInstance(widthSize, (int)(widthSize * 1.4285), java.awt.Image.SCALE_SMOOTH);
		    xyimg = new ImageIcon(yimg); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ImageIcon getXyimg(){
		return xyimg;
	}
}

package library_system.layout;
import java.awt.*;
import javax.swing.*;

public class GUIContainer {

}

class GTPanel extends JPanel{
	int width = 0;
	int height = 0;
	
	public GTPanel(int width, int height) {
		// 패털의 크기가 지정될 경우
		setBackground(null);
		this.width = width;
		this.height = height;
		setSize(new Dimension(width, height));		// 패널 크기 설정
	}
	public GTPanel() {
		// 패널의 크기를 지정하지 않을 경우 -> 부모 패널의 크기 알아내기
		setBackground(null);
		
		try {
			this.width = getParent().getWidth();
			this.height = getParent().getHeight();
		} catch(NullPointerException e) {
			this.width = 0;
			this.height = 0;
		}
		setSize(new Dimension(width, height));	
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
}
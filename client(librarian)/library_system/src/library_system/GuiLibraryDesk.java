package library_system;
import java.awt.*;
import javax.swing.*;

public class GuiLibraryDesk {
	String libraryName;
	
	public GuiLibraryDesk(String libraryName) {
		this.libraryName = libraryName;
	}
	
	// GUI test
	public static void main(String[] args) {
		new GuiLibraryDesk("cse Library");
	}
}

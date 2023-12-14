package sikuli;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExecution {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Screen scr = new Screen();
		Pattern pattern = new Pattern("C:\\Users\\anush\\OneDrive\\Desktop\\searchtext.png");
		scr.click(pattern);
		
		
		Pattern pattern1 = new Pattern("C:\\Users\\anush\\OneDrive\\Desktop\\searchbar.png");
		scr.click(pattern1);
		scr.type("Paint");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

}

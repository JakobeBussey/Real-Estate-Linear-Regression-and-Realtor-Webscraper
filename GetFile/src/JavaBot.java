import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class JavaBot {
	public Robot rob = null;
	public JavaBot() throws AWTException
	{
		rob = new Robot();
	}
	
	public void getCordsOfCursor()
	{
		boolean flip = false;
		while(flip == false)
		{
			System.out.println("("+MouseInfo.getPointerInfo().getLocation().getX()+","+MouseInfo.getPointerInfo().getLocation().getY()+")");
		}
	}
	
}

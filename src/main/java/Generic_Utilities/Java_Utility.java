package Generic_Utilities;

import java.util.Random;
/**
 * This method is used to avoid duplicates
 * 
 * @author anusha
 */
public class Java_Utility {
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt();
		return ranNum;
		
	}
}

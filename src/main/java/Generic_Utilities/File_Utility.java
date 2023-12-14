package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This method is used to fetch common data in application
 * @param key
 * @return
 * @throws Throwable
 */

public class File_Utility {
	public String getkeyandValueData(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\advsele.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}
}

package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataToProperties {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Properties pro = new Properties();
		pro.setProperty("username", "standard_user");
		pro.setProperty("password","secret_sauce");
		pro.setProperty("url","https://www.saucedemo.com/v1/");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/propertiesfile.properties.txt");
		pro.store(fos,"propertiesfile.properties.txt");
		System.out.println("data written successfull");
	}

}

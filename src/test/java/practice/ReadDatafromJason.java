package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDatafromJason {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		File fs = new File("./src\\test\\resources\\Jason.json");
		ObjectMapper object = new ObjectMapper();
		JsonNode jsonData = object.readTree(fs);
		String URL = jsonData.get("url").asText();
		String USERNAME = jsonData.get("username").asText();
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
	}

}

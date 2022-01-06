package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohan.palekar\\Downloads\\chromedriver_win32_v96\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
	}

}

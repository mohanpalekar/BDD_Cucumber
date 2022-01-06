package utilities;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class BaseClass{

	private FileReader reader = null;
	private Properties properties = null;
	private static WebDriver driver;
	private WebDriverWait wait;

	public void setupBrowser() {
		try {

			reader = new FileReader("src/test/java/properties/bdd.properties");
			properties = new Properties();
			properties.load(reader);

			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver_path"));		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout"))));

		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void captureScreenshot(String Filename) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			FileUtils.copyFile(screenshot, new File(properties.getProperty("screenshots") + Filename +" "+timestamp+".jpeg"));
			System.out.println("An Exception has occured at time: "+timestamp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void launchURI() {
		driver.get(properties.getProperty("url"));
	}

	public void launchURI_2() {
		driver.get(properties.getProperty("url2"));
	}

	public void launchURI_3() {
		driver.get(properties.getProperty("url3"));
	}

	public void navigateToURI() {
		driver.navigate().to(properties.getProperty("url3"));
	}

	public void elementClickEvent(By element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void enterInput(By element, String input) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(input);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void pressEnterButton(By element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.ENTER);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void closeDriver() {
		try {
			driver.close();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			driver.quit();
		}
	}


	public void assertIntegers(int expected, int actual, String filename) {
		try {
			AssertJUnit.assertEquals(expected, actual);
		}
		catch(AssertionError ex) {
			captureScreenshot(filename);
			throw new AssertionError();
		}
	}

}

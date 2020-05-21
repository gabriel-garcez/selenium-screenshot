package screenshots;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generator.NameGenerator;

public class page {
	
	@Test
	public void main() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	WebDriver driver  = new ChromeDriver();	

    	driver.get("http://automationpractice.com/index.php");
    	driver.manage().window().maximize();
    	
    	TakesScreenshot screenshot =((TakesScreenshot)driver);
    
    	File file = screenshot.getScreenshotAs(OutputType.FILE);

    	FileUtils.copyFile(file, new File("prints//"+NameGenerator.generate()+".png"));

  }
}
